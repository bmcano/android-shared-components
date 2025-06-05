package com.brandoncano.sharedcomponents.m3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
