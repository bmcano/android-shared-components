package com.brandoncano.sharedcomponents.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.text.textStyleBody

@Composable
fun AppBulletList(
    bulletStrings: List<String>,
    textStyle: TextStyle,
    bulletVerticalSpace: Dp = 8.dp,
    bulletEndPadding: Dp = 16.dp,
    bulletStartPadding: Dp = 16.dp,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = bulletStartPadding),
    ) {
       bulletStrings.forEachIndexed { index, bulletString ->
           Column {
                BulletRow(
                    text = bulletString,
                    textStyle = textStyle,
                    bulletEndPadding = bulletEndPadding,
                )
               if (index != bulletStrings.lastIndex) {
                   Spacer(modifier = Modifier.height(bulletVerticalSpace))
               }
           }
       }
    }
}

@Composable
private fun BulletRow(
    text: String,
    textStyle: TextStyle,
    bulletEndPadding: Dp,
) {
    val bulletPoint = stringResource(R.string.bullet_point)
    Row {
        Text(
            text = bulletPoint,
            modifier = Modifier.padding(end = bulletEndPadding),
            style = textStyle,
        )
        Text(
            text = text,
            style = textStyle,
        )
    }
}

@AppComponentPreviews
@Composable
private fun AppBulletListPreview() {
    Column {
        Text(
            text = "Placeholder text:",
            modifier = Modifier.padding(bottom = 16.dp),
            style = textStyleBody(),
        )
        AppBulletList(
            bulletStrings = listOf("First item", "Second item", "Third item"),
            textStyle = textStyleBody(),
        )
    }
}
