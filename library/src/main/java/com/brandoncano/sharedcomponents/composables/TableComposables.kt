package com.brandoncano.sharedcomponents.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleHeadline
import com.brandoncano.sharedcomponents.text.textStyleSubhead

/**
 * A reusable table composable supporting dynamic columns and rows.
 *
 * @param modifier Modifier to apply to the table container.
 * @param columnTitles List of column header strings.
 * @param rows List of rows, each row is a list of cell strings matching columnTitles size.
 * @param headerTextStyle TextStyle for header cells; defaults to headline style.
 * @param cellTextStyle TextStyle for body cells; defaults to subhead style on surfaceVariant.
 * @param showDividers Whether to show dividers between header and rows and between rows; default true.
 */
@Composable
fun AppTable(
    modifier: Modifier = Modifier,
    columnTitles: List<String>,
    rows: List<List<String>>,
    horizontalPadding: Dp = 16.dp,
    verticalPadding: Dp = 8.dp,
    headerTextStyle: TextStyle = textStyleHeadline().onSurfaceVariant(),
    cellTextStyle: TextStyle = textStyleSubhead().onSurfaceVariant(),
    showDividers: Boolean = true,
) {
    val numColumns = columnTitles.size
    val weights = List(numColumns) { 1f / numColumns }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding, vertical = verticalPadding),
    ) {
        Row {
            columnTitles.forEachIndexed { index, title ->
                TableCell(
                    text = title,
                    weight = weights.getOrElse(index) { 1f / numColumns },
                    style = headerTextStyle,
                    isHeader = true,
                )
            }
        }
        AppDivider(modifier = Modifier.padding(vertical = 4.dp))
        rows.forEachIndexed { rowIndex, row ->
            Row(modifier = Modifier.fillMaxWidth()) {
                row.forEachIndexed { colIndex, cellText ->
                    TableCell(
                        text = cellText,
                        weight = weights.getOrElse(colIndex) { 1f / numColumns },
                        style = cellTextStyle,
                    )
                }
            }
            if (showDividers && rowIndex < rows.lastIndex) {
                AppDivider(modifier = Modifier.padding(vertical = 4.dp))
            }
        }
    }
}

@Composable
private fun RowScope.TableCell(
    text: String,
    weight: Float,
    style: TextStyle,
    isHeader: Boolean = false,
) {
    Text(
        text = text,
        modifier = Modifier
            .weight(weight)
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = if (isHeader) 8.dp else 4.dp,
                bottom = if (isHeader) 8.dp else 4.dp,
            ),
        style = style,
        textAlign = TextAlign.Center,
    )
}

@AppComponentPreviews
@Composable
private fun AppTablePreviews() {
    val headers = listOf("Column1", "Column2", "Column3", "Column4")
    val rows = listOf(
        listOf("11", "12", "13", "14"),
        listOf("21", "22", "23", "24"),
        listOf("31", "32", "33", "34"),
        listOf("41", "42", "43", "44"),
    )
    Column {
        AppCard {
            AppTable(
                columnTitles = headers,
                rows = rows,
                showDividers = true,
            )
        }
        AppCard(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            AppTable(
                columnTitles = headers.take(3),
                rows = rows.map { row -> row.take(3) },
                horizontalPadding = 8.dp,
                showDividers = false,
            )
        }
        AppCard {
            AppTable(
                columnTitles = headers.take(2),
                rows = rows.map { row -> row.take(2) },
                showDividers = false,
            )
        }
    }
}
