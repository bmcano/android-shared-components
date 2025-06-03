package com.brandoncano.m3components.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.brandoncano.m3components.ui.screens.component.ComponentScreen

fun NavGraphBuilder.componentScreen(
    navHostController: NavHostController,
) {
    composable<Screen.M3Component> (
        enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) },
    ) { navBackStackEntry ->
        // Retrieve the argument from the route
        val args = navBackStackEntry.toRoute<Screen.M3Component>()
        ComponentScreen(
            component = args.type,
            onNavigateBack = { navHostController.popBackStack() },
        )
    }
}
