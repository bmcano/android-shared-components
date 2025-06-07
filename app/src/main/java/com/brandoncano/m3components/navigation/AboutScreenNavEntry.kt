package com.brandoncano.m3components.navigation

import android.content.Context
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.brandoncano.m3components.ui.screens.about.AboutScreen
import com.brandoncano.m3components.util.MakeToast
import com.brandoncano.sharedcomponents.utils.OpenLink

fun NavGraphBuilder.aboutScreen(
    navHostController: NavHostController,
) {
    composable(
        route = Screen.About.route,
        enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) },
    ) {
        val context = LocalContext.current
        AboutScreen(
            onNavigateBack = { navHostController.popBackStack() },
            onViewPrivacyPolicyTapped = { navigateToPrivacyPolicy(context) },
            onRateThisAppTapped = { MakeToast.execute(context, "Coming soon") },
            onViewOurAppsTapped = { MakeToast.execute(context, "Coming soon") },
            onDonateTapped = { MakeToast.execute(context, "Coming soon") },
        )
    }
}

private fun navigateToPrivacyPolicy(context: Context) {
    MakeToast.execute(context, "Coming soon")
//    OpenLink.execute(context, "Add link")
}
