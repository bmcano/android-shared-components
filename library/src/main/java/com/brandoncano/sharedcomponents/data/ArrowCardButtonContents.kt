package com.brandoncano.sharedcomponents.data

import androidx.compose.ui.graphics.vector.ImageVector

data class ArrowCardButtonContents(
    val imageVector: ImageVector,
    val text: String,
    val onClick: () -> Unit
)
