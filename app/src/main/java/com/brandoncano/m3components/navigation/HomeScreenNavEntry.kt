package com.brandoncano.m3components.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.brandoncano.m3components.ui.screens.home.HomeScreen
import com.brandoncano.m3components.util.ComponentCardPOsDeriver

fun NavGraphBuilder.homeScreen(
    navHostController: NavHostController,
) {
    composable(
        route = Screen.Home.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        val componentCardPOs = ComponentCardPOsDeriver.execute()
        HomeScreen(
            componentCardPOs = componentCardPOs,
            onComponentTapped = { navigateToComponent(navHostController, it) },
        )
    }
}
