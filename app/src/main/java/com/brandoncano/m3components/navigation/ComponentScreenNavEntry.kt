package com.brandoncano.m3components.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.brandoncano.m3components.ui.screens.component.ComponentScreen
import com.brandoncano.m3components.util.MakeToast
import com.brandoncano.m3components.util.RelatedComponentPOsDeriver

fun NavGraphBuilder.componentScreen(
    navHostController: NavHostController,
) {
    composable<Screen.M3Component> (
        enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) },
    ) { navBackStackEntry ->
        val context = LocalContext.current
        // Retrieve the argument from the route
        val args = navBackStackEntry.toRoute<Screen.M3Component>()
        val component = args.type
        val relatedItemPOs = RelatedComponentPOsDeriver.execute(component)
        ComponentScreen(
            component = component,
            relatedItemPOs = relatedItemPOs,
            onNavigateBack = { navHostController.popBackStack() },
            onExampleTapped = { MakeToast.execute(context, it) },
            onComponentTapped = { navigateToComponent(navHostController, it) },
        )
    }
}
