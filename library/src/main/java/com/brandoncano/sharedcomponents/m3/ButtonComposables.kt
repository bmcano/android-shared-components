package com.brandoncano.sharedcomponents.m3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// https://m3.material.io/components/buttons/guidelines

// https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#Button(kotlin.Function0,androidx.compose.material3.ButtonShapes,androidx.compose.ui.Modifier,kotlin.Boolean,androidx.compose.material3.ButtonColors,androidx.compose.material3.ButtonElevation,androidx.compose.foundation.BorderStroke,androidx.compose.foundation.layout.PaddingValues,androidx.compose.foundation.interaction.MutableInteractionSource,kotlin.Function1)
// https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#ElevatedButton(kotlin.Function0,androidx.compose.material3.ButtonShapes,androidx.compose.ui.Modifier,kotlin.Boolean,androidx.compose.material3.ButtonColors,androidx.compose.material3.ButtonElevation,androidx.compose.foundation.BorderStroke,androidx.compose.foundation.layout.PaddingValues,androidx.compose.foundation.interaction.MutableInteractionSource,kotlin.Function1)
// https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#FilledTonalButton(kotlin.Function0,androidx.compose.material3.ButtonShapes,androidx.compose.ui.Modifier,kotlin.Boolean,androidx.compose.material3.ButtonColors,androidx.compose.material3.ButtonElevation,androidx.compose.foundation.BorderStroke,androidx.compose.foundation.layout.PaddingValues,androidx.compose.foundation.interaction.MutableInteractionSource,kotlin.Function1)
// https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#OutlinedButton(kotlin.Function0,androidx.compose.material3.ButtonShapes,androidx.compose.ui.Modifier,kotlin.Boolean,androidx.compose.material3.ButtonColors,androidx.compose.material3.ButtonElevation,androidx.compose.foundation.BorderStroke,androidx.compose.foundation.layout.PaddingValues,androidx.compose.foundation.interaction.MutableInteractionSource,kotlin.Function1)
// https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#TextButton(kotlin.Function0,androidx.compose.material3.ButtonShapes,androidx.compose.ui.Modifier,kotlin.Boolean,androidx.compose.material3.ButtonColors,androidx.compose.material3.ButtonElevation,androidx.compose.foundation.BorderStroke,androidx.compose.foundation.layout.PaddingValues,androidx.compose.foundation.interaction.MutableInteractionSource,kotlin.Function1)

/**
 * Private helper composable that arranges an optional leading icon and single-line text.
 */
@Composable
private fun ButtonContent(
    icon: ImageVector?,
    iconContentDescription: String?,
    buttonLabel: String,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = iconContentDescription,
                modifier = Modifier.width(18.dp).align(Alignment.CenterVertically),
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = buttonLabel,
            style = MaterialTheme.typography.labelLarge,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
    }
}

/**
 * An elevated button that appears raised above the surface, providing high emphasis.
 */
@Composable
fun M3ElevatedButton(
    buttonLabel: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    useSquareShape: Boolean = false,
    minHeight: Dp = 56.dp,
    icon: ImageVector? = null,
    iconContentDescription: String? = null
) {
    val shape = if (useSquareShape) MaterialTheme.shapes.medium else ButtonDefaults.elevatedShape
    ElevatedButton(
        onClick = onClick,
        modifier = modifier.defaultMinSize(minHeight = minHeight),
        enabled = enabled,
        shape = shape,
    ) {
        ButtonContent(icon, iconContentDescription, buttonLabel)
    }
}

/**
 * A filled (contained) button that appears on a solid background, offering high emphasis.
 */
@Composable
fun M3FilledButton(
    buttonLabel: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    useSquareShape: Boolean = false,
    minHeight: Dp = 56.dp,
    icon: ImageVector? = null,
    iconContentDescription: String? = null
) {
    val shape = if (useSquareShape) MaterialTheme.shapes.medium else ButtonDefaults.shape
    Button(
        onClick = onClick,
        modifier = modifier.defaultMinSize(minHeight = minHeight),
        enabled = enabled,
        shape = shape,
    ) {
        ButtonContent(icon, iconContentDescription, buttonLabel)
    }
}

/**
 * A filled tonal button that appears on a muted container, providing medium emphasis.
 */
@Composable
fun M3FilledTonalButton(
    buttonLabel: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    useSquareShape: Boolean = false,
    minHeight: Dp = 56.dp,
    icon: ImageVector? = null,
    iconContentDescription: String? = null
) {
    val shape = if (useSquareShape) MaterialTheme.shapes.medium else ButtonDefaults.filledTonalShape
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier.defaultMinSize(minHeight = minHeight),
        enabled = enabled,
        shape = shape,
    ) {
        ButtonContent(icon, iconContentDescription, buttonLabel)
    }
}

/**
 * An outlined button that appears on a transparent background with a border, offering medium emphasis.
 */
@Composable
fun M3OutlinedButton(
    buttonLabel: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    useSquareShape: Boolean = false,
    minHeight: Dp = 56.dp,
    icon: ImageVector? = null,
    iconContentDescription: String? = null
) {
    val shape = if (useSquareShape) MaterialTheme.shapes.medium else ButtonDefaults.outlinedShape
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.defaultMinSize(minHeight = minHeight),
        enabled = enabled,
        shape = shape,
    ) {
        ButtonContent(icon, iconContentDescription, buttonLabel)
    }
}

/**
 * A text button that appears as flat text on a transparent background, offering low emphasis.
 */
@Composable
fun M3TextButton(
    buttonLabel: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    minHeight: Dp = 56.dp,
    icon: ImageVector? = null,
    iconContentDescription: String? = null
) {
    TextButton(
        onClick = onClick,
        modifier = modifier.defaultMinSize(minHeight = minHeight),
        enabled = enabled,
    ) {
        ButtonContent(icon, iconContentDescription, buttonLabel)
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 1200)
@Composable
private fun ButtonsPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            M3ElevatedButton(
                buttonLabel = "Elevated",
                onClick = { /*noop*/ },
                icon = Icons.Default.Favorite,
                iconContentDescription = "Favorite"
            )
            M3ElevatedButton(
                buttonLabel = "Elevated Square",
                onClick = { /*noop*/ },
                useSquareShape = true,
                icon = Icons.Default.Favorite,
                iconContentDescription = "Favorite"
            )

            M3FilledButton(
                buttonLabel = "Filled",
                onClick = { /*noop*/ },
                icon = Icons.Default.Favorite,
                iconContentDescription = "Favorite"
            )
            M3FilledButton(
                buttonLabel = "Filled Square",
                onClick = { /*noop*/ },
                useSquareShape = true,
                icon = Icons.Default.Favorite,
                iconContentDescription = "Favorite"
            )

            M3FilledTonalButton(
                buttonLabel = "Tonal",
                onClick = { /*noop*/ },
                icon = Icons.Default.Favorite,
                iconContentDescription = "Favorite"
            )
            M3FilledTonalButton(
                buttonLabel = "Tonal Square",
                onClick = { /*noop*/ },
                useSquareShape = true,
                icon = Icons.Default.Favorite,
                iconContentDescription = "Favorite"
            )

            M3OutlinedButton(
                buttonLabel = "Outlined",
                onClick = { /*noop*/ },
                icon = Icons.Default.Favorite,
                iconContentDescription = "Favorite"
            )
            M3OutlinedButton(
                buttonLabel = "Outlined Square",
                onClick = { /*noop*/ },
                useSquareShape = true,
                icon = Icons.Default.Favorite,
                iconContentDescription = "Favorite"
            )

            M3TextButton(
                buttonLabel = "Text Button",
                onClick = { /*noop*/ },
                icon = Icons.Default.Favorite,
                iconContentDescription = "Favorite"
            )

            M3ElevatedButton(
                buttonLabel = "Elevated Disabled",
                onClick = { /*noop*/ },
                enabled = false,
            )
            M3FilledButton(
                buttonLabel = "Filled Disabled",
                onClick = { /*noop*/ },
                enabled = false,
            )
            M3FilledTonalButton(
                buttonLabel = "Tonal Disabled",
                onClick = { /*noop*/ },
                enabled = false,
            )
            M3OutlinedButton(
                buttonLabel = "Outlined Disabled",
                onClick = { /*noop*/ },
                enabled = false,
            )
            M3TextButton(
                buttonLabel = "Text Disabled",
                onClick = { /*noop*/ },
                enabled = false,
            )
        }
    }
}
