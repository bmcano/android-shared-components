package com.brandoncano.sharedcomponents.m3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.composables.AppComponentPreviews

// https://m3.material.io/components/lists/overview
// https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#ListItem(kotlin.Function0,androidx.compose.ui.Modifier,kotlin.Function0,kotlin.Function0,kotlin.Function0,kotlin.Function0,androidx.compose.material3.ListItemColors,androidx.compose.ui.unit.Dp,androidx.compose.ui.unit.Dp)

/**
 * A single-line list item.
 *
 * @param headlineText The primary text, truncated to one line.
 * @param modifier Modifier for styling and layout.
 * @param leadingContent Optional composable shown at the start (e.g., an icon).
 * @param trailingImage Optional icon displayed at the end.
 * @param containerColor Background color of the list item.
 *
 * Note: MaterialTheme.colorScheme.surfaceContainerHighest is the color for a [androidx.compose.material3.Card].
 */
@Composable
fun M3SingleLineListItem(
    headlineText: String,
    modifier: Modifier = Modifier,
    leadingContent:  @Composable (() -> Unit)? = null,
    trailingImage: ImageVector? = null,
    containerColor: Color = MaterialTheme.colorScheme.surface,
) {
    ListItem(
        headlineContent = {
            Text(
                text = headlineText,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        },
        modifier = modifier,
        overlineContent = null, // Default parameter
        supportingContent = null, // Default parameter
        leadingContent = leadingContent,
        trailingContent = {
            trailingImage?.let {
                Icon(
                    imageVector = trailingImage,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                )
            }
        },
        colors = ListItemDefaults.colors(containerColor = containerColor),
        tonalElevation = ListItemDefaults.Elevation, // Default parameter
        shadowElevation = ListItemDefaults.Elevation, // Default parameter
    )
}

/**
 * A multi-line list item with optional overline and supporting text.
 *
 * @param headlineText The primary title text, truncated to one line.
 * @param modifier Modifier for styling and layout.
 * @param overlineText Optional small text displayed above the headline.
 * @param supportingText Optional secondary text, up to two lines.
 * @param leadingContent Optional composable shown at the start (e.g., an avatar).
 * @param trailingContent Optional icon displayed at the end.
 * @param containerColor Background color of the list item.
 *
 * Note: MaterialTheme.colorScheme.surfaceContainerHighest is the color for a [androidx.compose.material3.Card].
 */
@Composable
fun M3ListItem(
    headlineText: String,
    modifier: Modifier = Modifier,
    overlineText: String? = null,
    supportingText: String? = null,
    leadingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null,
    containerColor: Color = MaterialTheme.colorScheme.surface,
) {
    ListItem(
        headlineContent = {
            Text(
                text = headlineText,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        },
        modifier = modifier,
        overlineContent = {
            overlineText?.let {
                Text(
                    text = overlineText,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
            }
         },
        supportingContent = {
            supportingText?.let {
                Text(
                    text = supportingText,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = if (overlineText == null) 2 else 1,
                )
            }
        },
        leadingContent = leadingContent,
        trailingContent = trailingContent,
        colors = ListItemDefaults.colors(containerColor = containerColor),
        tonalElevation = ListItemDefaults.Elevation, // Default parameter
        shadowElevation = ListItemDefaults.Elevation, // Default parameter
    )
}

@AppComponentPreviews
@Composable
private fun SingleListItemPreview() {
    Column(modifier = Modifier.padding(16.dp)) {
        M3OutlinedCard {
            M3SingleLineListItem(
                headlineText = "Headline",
                leadingContent = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                    )
                },
                trailingImage = Icons.AutoMirrored.Filled.ArrowForwardIos
            )
            M3Divider()
            M3ListItem(
                headlineText = "Headline",
                supportingText = "Supporting text",
                leadingContent = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                    )
                },
                trailingContent = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = null,
                    )
                },
            )
            M3Divider()
            M3ListItem(
                headlineText = "Headline",
                supportingText = "Supporting text that spans multiple lines and will be ellipsis",
                leadingContent = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                    )
                },
                trailingContent = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = null,
                    )
                },
            )
            M3Divider()
            M3ListItem(
                headlineText = "Headline",
                overlineText = "Overline text",
                supportingText = "Supporting text",
                leadingContent = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                    )
                },
                trailingContent = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = null,
                    )
                },
            )
            M3Divider()
            M3ListItem(
                headlineText = "Headline",
                overlineText = "Overline text",
                supportingText = "Supporting text that spans multiple lines and will be ellipsis",
                leadingContent = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                    )
                },
                trailingContent = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = null,
                    )
                },
            )
        }
    }
}
