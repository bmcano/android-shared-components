package com.brandoncano.m3components.navigation

import kotlinx.serialization.Serializable

@Serializable // needed for type-sage navigation
sealed class Screen(val route: String) {

    data object About: Screen("about")

    // Will show list of Components
    // OnClick will navigate with the Enum type of the container
    data object Home: Screen("home")

    // Will contain brief overview of component, then display various options to click on
    @Serializable
    data class M3Component(
        val type: Component
    ) : Screen("m3component")

    // Depending on option from a component page, we will show examples of the component and the general guidelines for it.
    @Serializable
    data class M3ComponentDetails(
        val type: String // Can convert to Enum of options
    ) : Screen("m3component/details")
}
