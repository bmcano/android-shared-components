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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.data.ArrowCardButtonContents
import com.brandoncano.sharedcomponents.data.CardAction
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleCallout
import com.brandoncano.sharedcomponents.text.textStyleHeadline
import com.brandoncano.sharedcomponents.text.textStyleSubhead

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
fun AppDivider(modifier: Modifier) {
    HorizontalDivider(
        modifier = modifier,
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
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
 * A reusable card component that displays an icon, title, body text, and up to two action buttons.
 *
 * This card is laid out with:
 * 1. A leading [icon] tinted with [iconTint].
 * 2. A headline ([cardTitle]) and subhead ([cardBody]) stacked vertically.
 * 3. An optional row of one or two buttons, supplied via [leftActionButton] and [rightActionButton].
 *
 * If [leftActionButton] is null, no buttons are shown. If [rightActionButton] is null, the left button
 * stretches to the full card width.
 *
 * @param icon The vector icon to display at the start of the card.
 * @param iconTint The tint color to apply to [icon].
 * @param cardTitle The headline text shown next to the icon. Marked as a semantic heading.
 * @param cardBody The body or subhead text shown below the title.
 * @param leftActionButton Optional primary action; supplies its label and click handler. If null, no buttons appear.
 * @param rightActionButton Optional secondary action; only shown when [leftActionButton] is non-null.
 */
@Composable
fun AppActionCard(
    icon: ImageVector,
    iconTint: Color,
    cardTitle: String,
    cardBody: String,
    leftActionButton: CardAction? = null,
    rightActionButton: CardAction? = null,
) {
    AppCard {
        Column(
            modifier = Modifier.padding(start = 24.dp, top = 24.dp, end = 24.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Image(
                    modifier = Modifier.size(48.dp),
                    contentDescription = null,
                    imageVector = icon,
                    colorFilter = ColorFilter.tint(iconTint),
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        text = cardTitle,
                        modifier = Modifier.semantics { heading() },
                        style = textStyleHeadline(),
                    )
                    Text(
                        text = cardBody,
                        modifier = Modifier.padding(top = 8.dp),
                        style = textStyleSubhead().onSurfaceVariant(),
                    )
                }
            }
            if (leftActionButton == null) return@AppCard
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                TextButton(
                    onClick = leftActionButton.onClick,
                    modifier = if (rightActionButton == null) Modifier.fillMaxWidth() else Modifier,
                ) {
                    Text(
                        text = leftActionButton.buttonLabel,
                        style = textStyleCallout(),
                    )
                }
                if (rightActionButton == null) return@Row
                TextButton(
                    onClick = rightActionButton.onClick,
                    modifier = Modifier.padding(start = 24.dp),
                ) {
                    Text(
                        text = rightActionButton.buttonLabel,
                        style = textStyleCallout(),
                    )
                }
            }
        }
    }
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
    Card(modifier = Modifier.fillMaxWidth()) {
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
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
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
private fun AppActionCardPreview() {
    Column {
        AppActionCard(
            icon = Icons.Outlined.Search,
            iconTint = MaterialTheme.colorScheme.primary,
            cardTitle = "Card Title",
            cardBody = "Action card with no action buttons",
        )
        AppActionCard(
            icon = Icons.Outlined.Search,
            iconTint = MaterialTheme.colorScheme.primary,
            cardTitle = "Card Title",
            cardBody = "Action card with one action button",
            leftActionButton = CardAction(
                buttonLabel = "Text Button",
                onClick = {},
            )
        )
        AppActionCard(
            icon = Icons.Outlined.Search,
            iconTint = MaterialTheme.colorScheme.primary,
            cardTitle = "Card Title",
            cardBody = "Action card with both action buttons",
            leftActionButton = CardAction(
                buttonLabel = "Left Button",
                onClick = {},
            ),
            rightActionButton = CardAction(
                buttonLabel = "Right Button",
                onClick = {},
            )
        )
    }
}

@Preview
@Composable
private fun ArrowCardButtonPreview() {
    Column {
        val item1 = ArrowCardButtonContents(Icons.Outlined.Search, "Single Card") {}
        val item2 = ArrowCardButtonContents(Icons.Outlined.Search, "Multiple Items") {}
        AppArrowCardButton(item1)
        Spacer(modifier = Modifier.height(16.dp))
        AppArrowCardButton(item2, item2, item2)
    }
}
