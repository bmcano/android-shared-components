package com.brandoncano.m3components.to

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.brandoncano.m3components.navigation.Component

data class ComponentCardPO(
    val component: Component,
    val icon: ImageVector,
    @StringRes val titleRes: Int,
    @StringRes val descRes: Int,
    val relatedItems: List<Component> = emptyList<Component>(),
)
