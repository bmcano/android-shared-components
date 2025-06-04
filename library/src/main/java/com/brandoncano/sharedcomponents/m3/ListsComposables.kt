package com.brandoncano.sharedcomponents.m3


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.composables.AppComponentPreviews

@Composable
fun M3OneLineListItem(
    headlineText: String,
    leadingImage: ImageVector? = null,
    trailingImage: ImageVector? = null,
) {


    ListItem(
        headlineContent = {
            Text(
                text = headlineText,
                style = MaterialTheme.typography.titleMedium
            )
        },
        modifier = Modifier,
        overlineContent = null,
        supportingContent = null,
        leadingContent = {
            leadingImage?.let {
                Icon(
                    imageVector = leadingImage,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                )
            }
        },
        trailingContent = {
            trailingImage?.let {
                Icon(
                    imageVector = trailingImage,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                )
            }
        },
        colors = ListItemDefaults.colors(),
        tonalElevation = ListItemDefaults.Elevation,
        shadowElevation = ListItemDefaults.Elevation,
    )
}

@AppComponentPreviews
@Composable
private fun ListItemPreview() {
    Column {
        M3OneLineListItem(
            headlineText = "Headline",
            leadingImage = Icons.Default.Favorite,
            trailingImage = Icons.AutoMirrored.Filled.ArrowForwardIos
        )
    }
}
