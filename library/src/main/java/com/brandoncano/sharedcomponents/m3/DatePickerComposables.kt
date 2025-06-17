package com.brandoncano.sharedcomponents.m3

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

// https://m3.material.io/components/date-pickers/overview
// https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#DatePicker(androidx.compose.material3.DatePickerState,androidx.compose.ui.Modifier,androidx.compose.material3.DatePickerFormatter,androidx.compose.material3.DatePickerColors,kotlin.Function0,kotlin.Function0,kotlin.Boolean,kotlin.Boolean)
// https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#DatePickerDialog(kotlin.Function0,kotlin.Function0,androidx.compose.ui.Modifier,kotlin.Function0,androidx.compose.ui.graphics.Shape,androidx.compose.ui.unit.Dp,androidx.compose.material3.DatePickerColors,androidx.compose.ui.window.DialogProperties,kotlin.Function1)
// https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#DateRangePicker(androidx.compose.material3.DateRangePickerState,androidx.compose.ui.Modifier,androidx.compose.material3.DatePickerFormatter,androidx.compose.material3.DatePickerColors,kotlin.Function0,kotlin.Function0,kotlin.Boolean,kotlin.Boolean)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun M3DatePicker(
    modifier: Modifier = Modifier,
    selectedDateMillis: Long? = null,
    onDateChange: (Long?) -> Unit,
    showModeToggle: Boolean = false,
) {
    val state = rememberDatePickerState(initialSelectedDateMillis = selectedDateMillis)
    LaunchedEffect(state.selectedDateMillis) {
        onDateChange(state.selectedDateMillis)
    }
    DatePicker(
        state = state,
        modifier = modifier,
        showModeToggle = showModeToggle,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun M3DatePickerDialog(
    showDialog: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    initialDateMillis: Long? = null,
    onDateChange: (Long) -> Unit,
    confirmText: String = stringResource(android.R.string.ok),
    dismissText: String = stringResource(android.R.string.cancel)
) {
    if (!showDialog) return

    val state = rememberDatePickerState(initialSelectedDateMillis = initialDateMillis)
    DatePickerDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(onClick = {
                state.selectedDateMillis
                    ?.let(onDateChange)
                onDismissRequest()
            }) {
                Text(confirmText)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text(dismissText)
            }
        },
        modifier = modifier
    ) {
        DatePicker(state = state)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun M3DateRangePicker(
    modifier: Modifier = Modifier,
    startDateMillis: Long? = null,
    endDateMillis: Long? = null,
    onRangeChange: (Long?, Long?) -> Unit
) {
    val state = rememberDateRangePickerState(
        initialSelectedStartDateMillis = startDateMillis,
        initialSelectedEndDateMillis = endDateMillis,
    )
    LaunchedEffect(state.selectedStartDateMillis, state.selectedEndDateMillis) {
        onRangeChange(state.selectedStartDateMillis, state.selectedEndDateMillis)
    }
    DateRangePicker(
        state = state,
        modifier = modifier,
    )
}
