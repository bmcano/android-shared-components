package com.brandoncano.sharedcomponents.navigation

import android.app.Activity
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.data.BillingManager
import com.brandoncano.sharedcomponents.screen.DonateScreen
import kotlinx.coroutines.launch

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

        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }
        val billingManager = remember { BillingManager(context) }

        billingManager.startConnection(
            onError = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = context.getString(R.string.donate_error_text)
                    )
                }
            }
        )

        DonateScreen(
            onNavigateBack = { navHostController.popBackStack() },
            onContinueToPaymentTapped = { productId ->
                billingManager.launchPurchaseFlow(activity, productId)
            },
            snackbarHostState = snackbarHostState,
        )
    }
}
