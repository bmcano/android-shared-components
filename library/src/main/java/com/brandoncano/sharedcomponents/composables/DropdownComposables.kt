package com.brandoncano.sharedcomponents.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.brandoncano.sharedcomponents.text.textStyleBody

/**
 * This composable displays a dropdown menu that allows the user to select an option from a list of items.
 * The selected option is displayed in an outlined text field, which the user can click to expand or collapse the menu.
 *
 * @param label The label to be displayed above the text field.
 * @param modifier The [Modifier] to be applied to the dropdown menu container. Defaults to [Modifier].
 * @param selectedOption The initially selected option. Defaults to an empty string (nothing selected).
 * @param items The list of options to be displayed in the dropdown menu.
 * @param reset If true, resets the selected option to an empty string.
 * @param onOptionSelected Callback function that gets triggered when an option is selected.
 */
@Composable
fun AppDropDownMenu(
    label: String,
    modifier: Modifier = Modifier,
    selectedOption: String = "",
    items: List<String>,
    reset: Boolean = false,
    onOptionSelected: (String) -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(selectedOption) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown
    val description = if (expanded) "Collapse $label" else "Expand $label"

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            if (interaction is PressInteraction.Release) {
                expanded = !expanded
            }
        }
    }

    LaunchedEffect(reset) {
        if (reset) {
            selectedText = ""
        }
    }

    Column(modifier = modifier) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates -> textFieldSize = coordinates.size.toSize() }
                .clickable(interactionSource, null, enabled = true) { expanded = !expanded },
            readOnly = true,
            label = { Text(label) },
            trailingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = description,
                    modifier = Modifier.clickable { expanded = !expanded }
                )
            },
            interactionSource = interactionSource,
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                .clickable(interactionSource, null, enabled = true) { expanded = !expanded },
        ) {
            items.forEach {
                TextDropDownItemView(it) {
                    selectedText = it
                    expanded = false
                    onOptionSelected(it)
                }
            }
        }
    }
}

@Composable
private fun TextDropDownItemView(item: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable { onClick() },
    ) {
        Column {
            Text(
                text = item,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp),
                style = textStyleBody(),
            )
        }
    }
}

@AppComponentPreviews
@Composable
private fun TextDropdownRowPreview() {
    Column {
        TextDropDownItemView("Dropdown item row") {}
    }
}

@AppComponentPreviews
@Composable
private fun TextDropdownPreview() {
    Column {
        AppDropDownMenu("Text dropdown menu", Modifier, "", listOf()) { }
        AppDropDownMenu("Text dropdown menu", Modifier, "Red", listOf()) { }
    }
}
