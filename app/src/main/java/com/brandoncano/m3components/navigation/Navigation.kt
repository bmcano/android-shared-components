package com.brandoncano.m3components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        homeScreen(navController)
    }
}

fun navigateToComponent(navHostController: NavHostController, component: Component) {

}