package com.brandoncano.sharedcomponents.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleCallout

/**
 * A standard divider with horizontal padding.
 *
 * This composable displays a divider with a standard horizontal padding of 16dp.
 */
@Composable
fun AppStandardDivider() {
    AppDivider(modifier = Modifier.padding(horizontal = 16.dp))
}

/**
 * A customizable divider.
 *
 * This composable provides a horizontal divider, allowing you to specify a [modifier]
 * to customize its behavior and styling.
 *
 * @param modifier The [Modifier] to be applied to the divider.
 */
@Composable
fun AppDivider(
    modifier: Modifier,
) {
    HorizontalDivider(
        modifier = modifier,
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
    )
}

/**
 * A standard card with a specific padding and full-width layout.
 *
 * This composable provides a card with standard horizontal padding and takes up the full width
 * of its container, allowing you to provide composable content within the card.
 *
 * @param content The composable content that will be displayed inside the card.
 */
@Composable
fun AppStandardCard(content: @Composable (ColumnScope.() -> Unit)) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        content = content,
    )
}

/**
 * A customizable card.
 *
 * This composable provides a card that allows you to specify a [modifier] to customize its behavior
 * and styling, as well as provide composable content within the card.
 *
 * @param modifier The [Modifier] to be applied to the card.
 * @param content The composable content that will be displayed inside the card.
 */
@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        content = content,
    )
}

/**
 * Card button(s), each represented by an icon, a label, and an arrow.
 *
 * This composable displays a card containing multiple rows, each with an arrow icon and label,
 * as well as an optional click handler for each button. Dividers are placed between the rows
 * for visual separation.
 *
 * @param arrowCardButtonContents Vararg parameter of [ArrowCardButtonContents], each representing
 * a button with an image vector, text, and an onClick action.
 */
@Composable
fun AppArrowCardButton(vararg arrowCardButtonContents: ArrowCardButtonContents) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        arrowCardButtonContents.forEachIndexed { index, it ->
            AppCardRowView(it.imageVector, it.text, it.onClick)
            if (arrowCardButtonContents.size - 1 != index) {
                AppStandardDivider()
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
        modifier = Modifier
            .clickable(role = Role.Button, onClick = onClick)
            .padding(vertical = 4.dp),
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
            style = textStyleCallout().onSurfaceVariant(),
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
