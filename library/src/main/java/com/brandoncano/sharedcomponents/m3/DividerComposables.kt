package com.brandoncano.sharedcomponents.m3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// https://m3.material.io/components/divider/guidelines
// https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#HorizontalDivider(androidx.compose.ui.Modifier,androidx.compose.ui.unit.Dp,androidx.compose.ui.graphics.Color)
// https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#VerticalDivider(androidx.compose.ui.Modifier,androidx.compose.ui.unit.Dp,androidx.compose.ui.graphics.Color)

/**
 * A horizontal divider that spans the full width of its parent container.
 *
 * @param modifier Optional [Modifier] for styling.
 */
@Composable
fun FullWidthDivider(
    modifier: Modifier = Modifier
) {
    HorizontalDivider(modifier = modifier)
}


/**
 * A horizontal divider with optional inset padding on both sides.
 *
 * @param insetPadding Horizontal [Dp] inset to apply on the start and end.
 * @param modifier Optional [Modifier] for styling.
 */
@Composable
fun M3Divider(
    modifier: Modifier = Modifier,
    insetPadding: Dp = 0.dp,
) {
    HorizontalDivider(modifier = modifier.padding(horizontal = insetPadding))
}

/**
 * A vertical divider that spans the full height of its parent container.
 *
 * @param modifier Optional [Modifier] for styling.
 */
@Composable
fun FullHeightVerticalDivider(
    modifier: Modifier = Modifier,
) {
    VerticalDivider(modifier = modifier)
}

/**
 * A vertical divider with optional vertical inset padding.
 *
 * @param insetPadding Horizontal [Dp] inset to apply on the start and end.
 * @param modifier Optional [Modifier] for styling.
 */
@Composable
fun M3VerticalDivider(
    modifier: Modifier = Modifier,
    insetPadding: Dp = 0.dp,
) {
    VerticalDivider(modifier = modifier.padding(vertical = insetPadding))
}

@Preview(showBackground = true)
@Composable
private fun DividerPreview() {
    Column {
        FullWidthDivider(modifier = Modifier.padding(vertical = 8.dp))
        M3Divider(
            insetPadding = 16.dp,
            modifier = Modifier.padding(vertical = 8.dp),
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            FullHeightVerticalDivider(modifier = Modifier.padding(horizontal = 8.dp))
            M3VerticalDivider(
                insetPadding = 12.dp,
                modifier = Modifier.padding(horizontal = 8.dp),
            )
        }
    }
}
