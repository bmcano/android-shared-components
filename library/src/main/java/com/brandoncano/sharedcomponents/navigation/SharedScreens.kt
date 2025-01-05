package com.brandoncano.sharedcomponents.navigation

sealed class SharedScreens(val route: String) {
    data object Donate: SharedScreens("donate")
    data object ViewOurApps: SharedScreens("view_our_apps")
}
