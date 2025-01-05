package com.brandoncano.sharedcomponents.utils

/**
 * Job: Get the productID for the play console in-app purchase
 */
object GetProductIdForAmount {

    fun execute(amount: Int): String {
        return when (amount) {
            1 -> "donation_1_usd"
            2 -> "donation_2_usd"
            3 -> "donation_3_usd"
            5 -> "donation_5_usd"
            10 -> "donation_10_usd"
            else -> "unknown_donation"
        }
    }
}
