package com.brandoncano.sharedcomponents.navigation

import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.brandoncano.sharedcomponents.data.Apps
import com.brandoncano.sharedcomponents.screen.ViewOurAppsScreen

@Suppress("unused") // used in apps
fun NavGraphBuilder.viewOurAppsScreen(
    navHostController: NavHostController,
    app: Apps,
) {
    composable(
        route = SharedScreens.ViewOurApps.route,
        enterTransition = { slideInVertically(initialOffsetY = { it }) },
        exitTransition = { slideOutVertically(targetOffsetY = { it }) },
    ) {
        ViewOurAppsScreen(
            app = app,
            onNavigateBack = { navHostController.popBackStack() },
        )
    }
}
