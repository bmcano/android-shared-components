package com.brandoncano.sharedcomponents.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.data.Apps
import com.brandoncano.sharedcomponents.data.GooglePlayLinks
import com.brandoncano.sharedcomponents.screen.ViewOurAppsScreen
import com.brandoncano.sharedcomponents.utils.OpenLink

@Suppress("unused") // used in apps
fun NavGraphBuilder.viewOurAppsScreen(
    navHostController: NavHostController,
    app: Apps,
) {
    composable(
        route = SharedScreens.ViewOurApps.route,
        enterTransition = { slideInVertically(initialOffsetY = { it }) },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { slideOutVertically(targetOffsetY= { it }) },
    ) {
        val context = LocalContext.current
        val appImageRes = when (app) {
            Apps.Capacitor -> R.drawable.capacitor_feature_graphic
            Apps.Inductor -> R.drawable.inductor_feature_graphic
            Apps.OhmsLaw -> R.drawable.ohms_law_feature_graphic
            Apps.Resistor -> R.drawable.resistor_feature_graphic
        }

        ViewOurAppsScreen(
            app = app,
            appImageRes = appImageRes,
            onNavigateBack = { navHostController.popBackStack() },
            onFeatureCardTapped = { OpenLink.execute(context, app.playstore) },
            onMobileAppCardTapped = { OpenLink.execute(context, it) },
            onViewMoreAppsTapped = { OpenLink.execute(context, GooglePlayLinks.DEVELOPER_PROFILE) },
        )
    }
}
