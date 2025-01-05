package com.brandoncano.sharedcomponents.navigation

import android.app.Activity
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.brandoncano.sharedcomponents.data.BillingManager
import com.brandoncano.sharedcomponents.data.PurchaseStatus
import com.brandoncano.sharedcomponents.screen.DonateScreen

@Suppress("unused") // used in apps
fun NavGraphBuilder.donateScreen(
    navHostController: NavHostController,
) {
    composable(
        route = SharedScreens.Donate.route,
        enterTransition = { slideInVertically(initialOffsetY = { it }) },
        exitTransition = { slideOutVertically(targetOffsetY = { it }) },
    ) {
        val context = LocalContext.current
        val activity = context as? Activity ?: return@composable
        var billingError by remember { mutableStateOf(false) }
        var purchaseStatus by remember { mutableStateOf<PurchaseStatus>(PurchaseStatus.PENDING) }
        val billingManager = remember {
            BillingManager(context) { status ->
                purchaseStatus = status
            }
        }

        billingManager.startConnection(
            onConnected = { billingError = false },
            onError = { billingError = true }
        )

        // TODO - deal with error case if connection fails
        DonateScreen(
            onNavigateBack = { navHostController.popBackStack() },
            onContinueToPaymentTapped = { productId ->
                billingManager.launchPurchaseFlow(activity, productId)
            },
            purchaseStatus = purchaseStatus,
        )
    }
}
