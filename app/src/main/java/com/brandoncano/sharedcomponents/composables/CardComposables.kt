package com.brandoncano.sharedcomponents.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.data.ArrowCardButtonContents
import com.brandoncano.sharedcomponents.text.textStyleCallout

@Composable
fun AppDivider(
    modifier: Modifier = Modifier,
    onCard: Boolean = true
) {
    HorizontalDivider(
        modifier = modifier,
        thickness = 1.dp,
        color = if (onCard && isSystemInDarkTheme()) {
            MaterialTheme.colorScheme.outline
        } else {
            MaterialTheme.colorScheme.outlineVariant
        }
    )
}

@Composable
fun AppStandardCard(content: @Composable (ColumnScope.() -> Unit)) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .fillMaxWidth(),
        content = content,
    )
}

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Card(
        modifier = modifier,
        content = content,
    )
}

@Composable
fun AppArrowCardButton(vararg arrowCardButtonContents: ArrowCardButtonContents) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .fillMaxWidth()
    ) {
        arrowCardButtonContents.forEachIndexed { index, it ->
            AppCardRowView(it.imageVector, it.text, it.onClick)
            if (arrowCardButtonContents.size - 1 != index) {
                AppDivider(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
            }
        }
    }
}

@Composable
private fun AppCardRowView(
    imageVector: ImageVector,
    text: String,
    onClick: (() -> Unit),
) {
    Row(
        modifier = Modifier.clickable(role = Role.Button, onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier.padding(16.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant)
        )
        Text(
            text = text,
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
                .align(Alignment.CenterVertically),
            style = textStyleCallout(),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
        Image(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            modifier = Modifier.padding(16.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
        )
    }
}

@Preview
@Composable
private fun AppStandardCardPreview() {
    AppStandardCard {
        Text(text = "Text1", modifier = Modifier.padding(16.dp))
        AppDivider(onCard = true)
        Text(text = "Text2", modifier = Modifier.padding(16.dp))
        AppDivider(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
        Text(text = "Text3", modifier = Modifier.padding(16.dp))
    }
}

@Preview
@Composable
private fun AppCardPreview() {
    AppCard {
        Text(text = "Text1extended", modifier = Modifier.padding(16.dp))
    }
}

@Preview
@Composable
private fun ArrowCardButtonPreview() {
    Column {
        val item1 = ArrowCardButtonContents(Icons.Outlined.Search, "Single Card") {}
        val item2 = ArrowCardButtonContents(Icons.Outlined.Search, "Multiple Items") {}
        val item3 = ArrowCardButtonContents(Icons.Outlined.Search, "Multiple Items") {}
        val item4 = ArrowCardButtonContents(Icons.Outlined.Search, "Multiple Items") {}
        AppArrowCardButton(item1)
        Spacer(modifier = Modifier.height(16.dp))
        AppArrowCardButton(item2, item3, item4)
    }
}