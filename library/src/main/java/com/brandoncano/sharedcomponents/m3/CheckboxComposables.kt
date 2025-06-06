package com.brandoncano.sharedcomponents.m3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.composables.AppComponentPreviews

// https://m3.material.io/components/checkbox/overview
// https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#Checkbox(kotlin.Boolean,kotlin.Function1,androidx.compose.ui.Modifier,kotlin.Boolean,androidx.compose.material3.CheckboxColors,androidx.compose.foundation.interaction.MutableInteractionSource)
// https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#TriStateCheckbox(androidx.compose.ui.state.ToggleableState,kotlin.Function0,androidx.compose.ui.Modifier,kotlin.Boolean,androidx.compose.material3.CheckboxColors,androidx.compose.foundation.interaction.MutableInteractionSource)

/**
 * A single checkbox with a label.
 *
 * @param option The text label displayed next to the checkbox.
 * @param horizontalInsetPadding Horizontal padding around the row (default 16.dp).
 * @param verticalPadding Vertical padding around the row (default 8.dp).
 */
@Composable
fun M3Checkbox(
    option: String,
    horizontalInsetPadding: Dp = 16.dp,
    verticalPadding: Dp = 8.dp,
) {
    val (checkedState, onStateChange) = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .toggleable(
                value = checkedState,
                onValueChange = { onStateChange(!checkedState) },
                role = Role.Checkbox,
            )
            .padding(
                horizontal = horizontalInsetPadding,
                vertical = verticalPadding,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = null, // null recommended for screen readers
        )
        Text(
            text = option,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 16.dp),
        )
    }
}

/**
 * Renders a vertical list of Checkbox items for each provided option.
 *
 * @param options A list of strings to display as individual checkboxes.
 * @param horizontalInsetPadding Horizontal padding applied to each checkbox row.
 * @param verticalPadding Vertical padding applied to each checkbox row.
 */
@Composable
fun M3CheckBoxGroup(
    options: List<String>,
    horizontalInsetPadding: Dp = 16.dp,
    verticalPadding: Dp = 8.dp,
) {
    options.forEach {
        M3Checkbox(
            option = it,
            horizontalInsetPadding = horizontalInsetPadding,
            verticalPadding = verticalPadding,
        )
    }
}

/**
 * Renders a tri-state parent checkbox that controls multiple child checkboxes.
 *
 * @param parentOption The label for the parent tri-state checkbox.
 * @param options A list of child option labels displayed under the parent.
 * @param horizontalInsetPadding Horizontal padding for parent and child rows.
 * @param verticalPadding Vertical padding for parent and child rows.
 */
@Composable
fun M3TriStateCheckboxGroup(
    parentOption: String,
    options: List<String>,
    horizontalInsetPadding: Dp = 16.dp,
    verticalPadding: Dp = 8.dp,
) {
    val childStates = remember { options.map { mutableStateOf(false) }.toMutableStateList() }
    val allChecked = childStates.all { it.value }
    val noneChecked = childStates.all { !it.value }
    val parentState: ToggleableState = when {
        allChecked -> ToggleableState.On
        noneChecked -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .toggleable(
                    value = parentState != ToggleableState.Off,
                    role = Role.Checkbox,
                    onValueChange = {
                        val newValue = parentState != ToggleableState.On
                        childStates.forEach { it.value = newValue }
                    },
                )
                .padding(
                    horizontal = horizontalInsetPadding,
                    vertical = verticalPadding,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TriStateCheckbox(
                state = parentState,
                onClick = null,
            )
            Text(
                text = parentOption,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp),
            )
        }
        options.forEachIndexed { index, option ->
            val childChecked = childStates[index]
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .toggleable(
                        value = childChecked.value,
                        role = Role.Checkbox,
                        onValueChange = { childChecked.value = it },
                    )
                    .padding(
                        horizontal = horizontalInsetPadding + 32.dp,
                        vertical = verticalPadding,
                    ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Checkbox(
                    checked = childChecked.value,
                    onCheckedChange = null,
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
private fun CheckboxPreview() {
    Column {
        M3Checkbox(
            option = "Dark mode",
        )
        M3CheckBoxGroup(
            options = listOf("Option 1", "Option 2", "Option 3")
        )
        M3TriStateCheckboxGroup(
            parentOption = "Receive emails",
            options = listOf("Daily", "Weekly", "Monthly")
        )
    }
}
