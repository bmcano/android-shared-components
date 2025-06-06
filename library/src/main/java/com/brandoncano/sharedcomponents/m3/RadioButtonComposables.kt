package com.brandoncano.sharedcomponents.m3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.composables.AppComponentPreviews

// https://m3.material.io/components/radio-button/overview
// https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#RadioButton(kotlin.Boolean,kotlin.Function0,androidx.compose.ui.Modifier,kotlin.Boolean,androidx.compose.material3.RadioButtonColors,androidx.compose.foundation.interaction.MutableInteractionSource)

/**
 * Renders a vertical group of radio buttons for selecting one option.
 *
 * @param options A list of labels for each radio button; at least two items required.
 * @param verticalSpaceBetweenItems Space between rows (default 8.dp).
 */
@Composable
fun M3RadioButtonGroup(
    options: List<String>,
    horizontalInsetPadding: Dp = 16.dp,
    verticalSpaceBetweenItems: Dp = 8.dp,
) {
    if (options.size < 2) return
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(options[0]) }
    Column(
        modifier = Modifier.selectableGroup(),
        verticalArrangement = Arrangement.spacedBy(verticalSpaceBetweenItems),
    ) {
        options.forEach { option ->
            val selected = (option == selectedOption)
            Row(
               modifier = Modifier
                   .fillMaxWidth()
                   .selectable(
                       selected = selected,
                       onClick = { onOptionSelected(option) },
                       role = Role.RadioButton,
                   )
                   .padding(
                       horizontal = horizontalInsetPadding,
                       vertical = 4.dp,
                   ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = null,
                )
                Text(
                    text = option,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp),
                )
            }
        }
    }
}

@AppComponentPreviews
@Composable
private fun RadioButtonPreview() {
    M3RadioButtonGroup(
        options = listOf("Light", "Dark", "System default")
    )
}
