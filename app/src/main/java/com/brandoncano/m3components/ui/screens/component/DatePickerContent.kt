package com.brandoncano.m3components.ui.screens.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.m3components.R
import com.brandoncano.sharedcomponents.m3.M3DatePicker
import com.brandoncano.sharedcomponents.m3.M3DatePickerDialog
import com.brandoncano.sharedcomponents.text.onSurfaceVariant

@Composable
fun DatePickerContent() {
    val (date, setDate) = remember { mutableStateOf<Long?>(null) }

    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Text(
            text = stringResource(R.string.date_overview_title),
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
//        Text(
//            text = stringResource(R.string.badges_description1),
//            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(
//            text = stringResource(R.string.badges_description2),
//            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
//        )
        Spacer(modifier = Modifier.height(24.dp))
        M3DatePicker(
            onDateChange = {
                setDate(it)
            },
            showModeToggle = true,
        )
        Text(
            text = date.toString()
        )
        Spacer(modifier = Modifier.height(24.dp))

        M3DatePickerDialog(
            showDialog = true,
            onDismissRequest = {},
            onDateChange = {
                setDate(it)
            }
        )
    }
}