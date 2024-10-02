package com.brandoncano.sharedcomponents.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Error
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.brandoncano.sharedcomponents.text.textStyleSubhead

@Composable
fun AppTextField(
    label: String,
    modifier: Modifier = Modifier,
    value: MutableState<String>,
    enabled: Boolean = true,
    reset: Boolean = false,
    isError: Boolean = false,
    errorMessage: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    onOptionSelected: (String) -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    LaunchedEffect(reset) {
        if (reset) {
            value.value = ""
        }
    }

    Column(modifier = modifier) {
        OutlinedTextField(
            value = value.value,
            onValueChange = {
                value.value = it
                onOptionSelected(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates -> textFieldSize = coordinates.size.toSize() },
            enabled = enabled,
            label = { Text(label) },
            trailingIcon = {
                if (isError) {
                    Image(
                        imageVector = Icons.Outlined.Error,
                        contentDescription = "Error",
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.error)
                    )
                }
            },
            supportingText = if (isError && errorMessage.isNotEmpty()) {
                { Text(text = errorMessage, style = textStyleSubhead()) }
            } else {
                null
            },
            isError = isError,
            keyboardOptions = keyboardOptions,
            singleLine = true,
            interactionSource = interactionSource,
        )
    }
}

@AppComponentPreviews
@Composable
private fun AppTextFieldPreview() {
    val empty = remember { mutableStateOf("") }
    val value = remember { mutableStateOf("Example") }
    Column {
        AppTextField(label = "Text field", value = empty, modifier = Modifier.padding(start = 32.dp, end = 32.dp)) { }
        AppTextField(label = "Text field with text", value = value) { }
        AppTextField(label = "Text field with error", value = empty, isError = true) { }
        AppTextField(label = "Text field with error", value = empty, isError = true, errorMessage = "error message") { }
    }
}
