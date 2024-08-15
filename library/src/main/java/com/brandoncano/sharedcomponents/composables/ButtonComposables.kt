package com.brandoncano.sharedcomponents.composables

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.text.textStyleCallout

@Composable
fun AppButton(
    label: String,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier.defaultMinSize(minHeight = 56.dp),
        enabled = true,
        shape = RoundedCornerShape(16.dp),
    ) {
        Text(
            text = label,
            style = textStyleCallout(),
        )
    }
}

@AppComponentPreviews
@Composable
private fun AppButtonPreview() {
    AppButton(label = "Button", modifier = Modifier.fillMaxWidth()) { }
}
