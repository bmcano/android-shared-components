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

// Notes:
// - Leaving leadingContent as generic
// - headline, overline, and supporting contents will be string inputs default text styles
// - trailing content will make an imageVector
// might want options for colors since it overlaps card fill

// single line
// double line
//

/**
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
        overlineContent = null,
        supportingContent = null,
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
        tonalElevation = ListItemDefaults.Elevation,
        shadowElevation = ListItemDefaults.Elevation,
    )
}

@Composable
fun M3MultiLineListItem(
    headlineText: String,
    modifier: Modifier = Modifier,
    overlineText: String? = null,
    supportingText: String? = null,
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
                    maxLines = 2,
                )
            }
        },
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
        tonalElevation = ListItemDefaults.Elevation,
        shadowElevation = ListItemDefaults.Elevation,
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
            M3SingleLineListItem(
                headlineText = "No leading icon",
                trailingImage = Icons.AutoMirrored.Filled.ArrowForwardIos
            )
            M3Divider()
            M3MultiLineListItem(
                headlineText = "Headline",
                supportingText = "Supporting text",
                leadingContent = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                    )
                },
                trailingImage = Icons.AutoMirrored.Filled.ArrowForwardIos
            )
            M3Divider()
            M3MultiLineListItem(
                headlineText = "Headline",
                supportingText = "Supporting text that spans multiple lines and will be ellipsis",
                leadingContent = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                    )
                },
                trailingImage = Icons.AutoMirrored.Filled.ArrowForwardIos
            )
            M3Divider()
            M3MultiLineListItem(
                headlineText = "Headline",
                overlineText = "Overline text",
                supportingText = "Supporting text",
                leadingContent = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                    )
                },
                trailingImage = Icons.AutoMirrored.Filled.ArrowForwardIos
            )
            M3Divider()
            M3MultiLineListItem(
                headlineText = "Headline",
                overlineText = "Overline text",
                supportingText = "Supporting text that spans multiple lines and will be ellipsis",
                leadingContent = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                    )
                },
                trailingImage = Icons.AutoMirrored.Filled.ArrowForwardIos
            )
        }
    }
}
