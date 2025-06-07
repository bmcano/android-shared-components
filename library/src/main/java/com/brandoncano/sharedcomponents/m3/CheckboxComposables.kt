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
 * A single checkbox with an inline label.
 *
 * @param option The text label shown next to the checkbox.
 * @param checked Current checked state.
 * @param onCheckChanged Callback invoked with the new checked state.
 * @param enabled Whether the checkbox is enabled.
 * @param horizontalInsetPadding Horizontal padding around the row (default 16.dp).
 * @param verticalPadding Vertical padding around the row (default 8.dp).
 */
@Composable
fun M3Checkbox(
    option: String,
    checked: Boolean,
    onCheckChanged: (Boolean) -> Unit,
    enabled: Boolean = true,
    horizontalInsetPadding: Dp = 16.dp,
    verticalPadding: Dp = 8.dp,
) {
    val (checkedState, onStateChange) = remember { mutableStateOf(checked) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .toggleable(
                value = checkedState,
                onValueChange = {
                    onStateChange(!checkedState)
                    onCheckChanged(!checkedState)
                },
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
            enabled = enabled,
        )
        Text(
            text = option,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 16.dp),
        )
    }
}

/**
 * A tri-state parent checkbox that reflects and controls a list of child checkboxes.
 *
 * @param parentOption Label for the parent tri-state checkbox.
 * @param options List of child labels.
 * @param checkedStates List of child checked states; must match options.size.
 * @param onParentCheckedChange Called when the parent is toggled, passing the new boolean value.
 * @param onChildCheckedChange Called with (index, newValue) when a child checkbox is toggled.
 * @param enabled Whether all checkboxes in the group are enabled.
 * @param horizontalInsetPadding Horizontal padding for rows (default 16.dp).
 * @param verticalPadding Vertical padding for rows (default 8.dp).
 */
@Composable
fun M3TriStateCheckboxGroup(
    parentOption: String,
    options: List<String>,
    checkedStates: List<Boolean>,
    onParentCheckedChange: (Boolean) -> Unit,
    onChildCheckedChange: (index: Int, newValue: Boolean) -> Unit,
    enabled: Boolean = true,
    horizontalInsetPadding: Dp = 16.dp,
    verticalPadding: Dp = 8.dp,
) {
    if (options.size != checkedStates.size) return
    val childStates = remember { options.mapIndexed { it, _ -> mutableStateOf(checkedStates[it]) }.toMutableStateList() }
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
                        onParentCheckedChange(newValue)
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
                enabled = enabled,
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
                        onValueChange = {
                            childChecked.value = it
                            onChildCheckedChange(index, it)
                        },
                    )
                    .padding(
                        horizontal = horizontalInsetPadding + 40.dp,
                        vertical = verticalPadding,
                    ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Checkbox(
                    checked = childChecked.value,
                    onCheckedChange = null,
                    enabled = enabled,
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
            checked = true,
            onCheckChanged = {},
        )
        M3TriStateCheckboxGroup(
            parentOption = "Receive emails",
            options = listOf("Daily", "Weekly", "Monthly"),
            checkedStates = listOf(false, true, true),
            onParentCheckedChange = {},
            onChildCheckedChange = { _, _ -> },
        )
    }
}
