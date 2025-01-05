package com.brandoncano.sharedcomponents.data

import android.app.Activity
import android.content.Context
import android.util.Log
import com.android.billingclient.api.AcknowledgePurchaseParams
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.ConsumeParams
import com.android.billingclient.api.PendingPurchasesParams
import com.android.billingclient.api.Purchase
import com.android.billingclient.api.PurchasesUpdatedListener
import com.android.billingclient.api.QueryProductDetailsParams

/**
 * Job: Handles the in-app purchases for the donation screen
 */
class BillingManager(
    context: Context,
    private val onPurchaseStatusChanged: (PurchaseStatus) -> Unit,
) {
    private companion object {
        const val TAG = "DonationBillingClient"
    }

    private val purchaseListener = PurchasesUpdatedListener { billingResult, purchases ->
        when (billingResult.responseCode) {
            BillingClient.BillingResponseCode.OK -> {
                purchases?.forEach { purchase ->
                    handlePurchase(purchase)
                }
            }
            BillingClient.BillingResponseCode.USER_CANCELED -> {
                Log.e(TAG, "User canceled the purchase")
                onPurchaseStatusChanged(PurchaseStatus.CANCELED)
            }
            BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED -> {
                // Note: This should never occur but will be here just in case
                Log.e(TAG, "ITEM_ALREADY_OWNED")
                onPurchaseStatusChanged(PurchaseStatus.FAILURE)
            }
            else -> {
                Log.e(TAG, "Error during purchase: ${billingResult.debugMessage}")
                onPurchaseStatusChanged(PurchaseStatus.FAILURE)
            }
        }
    }

    private val billingClient = BillingClient.newBuilder(context)
        .setListener(purchaseListener)
        .enablePendingPurchases(
            PendingPurchasesParams.newBuilder()
                .enableOneTimeProducts()  // Covers consumable one-time purchases (donations)
                .build()
        )
        .build()

    fun startConnection(
        onConnected: () -> Unit,
        onError: () -> Unit,
    ) {
        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                    Log.i(TAG, "Billing client connected successfully")
                    onConnected()
                } else {
                    Log.e(TAG, "Error connecting billing client: ${billingResult.debugMessage}")
                    onError()
                }
            }

            override fun onBillingServiceDisconnected() {
                Log.e(TAG, "Billing service disconnected. Retrying connection...")
                billingClient.startConnection(this)
            }
        })
    }

    fun launchPurchaseFlow(activity: Activity, productId: String) {
        billingClient.queryProductDetailsAsync(
            QueryProductDetailsParams.newBuilder()
                .setProductList(
                    listOf(
                        QueryProductDetailsParams.Product.newBuilder()
                            .setProductId(productId)
                            .setProductType(BillingClient.ProductType.INAPP)
                            .build()
                    )
                )
                .build()
        ) { billingResult, productDetailsList ->
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK && productDetailsList.isNotEmpty()) {
                val productDetails = productDetailsList[0]
                val billingFlowParams = BillingFlowParams.newBuilder()
                    .setProductDetailsParamsList(
                        listOf(
                            BillingFlowParams.ProductDetailsParams.newBuilder()
                                .setProductDetails(productDetails)
                                .build()
                        )
                    )
                    .build()

                billingClient.launchBillingFlow(activity, billingFlowParams)
            } else {
                Log.e(TAG, "Error launching purchase flow: ${billingResult.debugMessage}")
                onPurchaseStatusChanged(PurchaseStatus.FAILURE)
            }
        }
    }

    private fun handlePurchase(purchase: Purchase) {
        Log.i(TAG, "Processing purchase: ${purchase.orderId}")
        if (!purchase.isAcknowledged) {
            val acknowledgePurchaseParams =
                AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.purchaseToken).build()

            billingClient.acknowledgePurchase(acknowledgePurchaseParams) { billingResult ->
                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                    Log.i(TAG, "Purchase acknowledged successfully")
                    consumePurchase(purchase)
                } else {
                    Log.e(TAG, "Failed to acknowledge purchase: ${billingResult.debugMessage}")
                    onPurchaseStatusChanged(PurchaseStatus.FAILURE)
                }
            }
        }
    }

    private fun consumePurchase(purchase: Purchase) {
        val consumeParams = ConsumeParams.newBuilder()
            .setPurchaseToken(purchase.purchaseToken)
            .build()

        billingClient.consumeAsync(consumeParams) { billingResult, _ ->
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                Log.i(TAG, "Purchase consumed, donation available again.")
                onPurchaseStatusChanged(PurchaseStatus.SUCCESS)
            } else {
                Log.e(TAG, "Failed to consume purchase: ${billingResult.debugMessage}")
                onPurchaseStatusChanged(PurchaseStatus.FAILURE)
            }
        }
    }
}
