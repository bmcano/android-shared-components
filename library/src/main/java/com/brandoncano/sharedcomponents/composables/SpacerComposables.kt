package com.brandoncano.sharedcomponents.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * A standardized bottom screen spacer that will account for edge-to-edge screens
 */
@Composable
fun BottomScreenSpacer() {
    Spacer(
        modifier = Modifier
            .height(24.dp)
            .navigationBarsPadding(),
    )
}
