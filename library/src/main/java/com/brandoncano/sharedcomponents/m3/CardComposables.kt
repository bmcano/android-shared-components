package com.brandoncano.sharedcomponents.m3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.composables.AppComponentPreviews

// Filled Card (Card)
// Elevated Card
// Outlined Card

// Example contents

@Composable
fun M3Card(
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit),
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        content = content,
    )
}

@Composable
fun M3ElevatedCard(
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit),
) {
    ElevatedCard(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        content = content,
    )
}

@Composable
fun M3OutlinedCard(
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit),
) {
    OutlinedCard(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        content = content,
    )
}

@AppComponentPreviews
@Composable
private fun CardContentsPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            M3Card {
                Text(
                    text = "Filled Card",
                    modifier = Modifier.padding(24.dp)
                )
            }
            M3ElevatedCard {
                Text(
                    text = "Elevated Card",
                    modifier = Modifier.padding(24.dp)
                )
            }
            M3OutlinedCard {
                Text(
                    text = "Outlined Card",
                    modifier = Modifier.padding(24.dp)
                )
            }
        }
    }
}
