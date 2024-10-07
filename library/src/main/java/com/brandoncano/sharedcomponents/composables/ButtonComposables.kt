package com.brandoncano.sharedcomponents.composables

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.text.textStyleCallout

/**
 * This composable displays a button with a specified label and click action, providing a consistent
 * style across the app. The button supports customization via the provided [modifier].
 *
 * @param label The text to be displayed on the button.
 * @param modifier The [Modifier] to be applied to the button.
 * @param onClick Callback function that gets triggered on button click.
 */
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
        shape = MaterialTheme.shapes.large,
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
