package com.brandoncano.m3components.ui.screens.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.m3components.R
import com.brandoncano.m3components.navigation.Component
import com.brandoncano.m3components.ui.theme.M3ComponentsTheme
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.m3.M3Divider
import com.brandoncano.sharedcomponents.m3.M3Switch
import com.brandoncano.sharedcomponents.text.onSurfaceVariant

@Composable
fun SwitchContent(
    onExampleTapped: (String) -> Unit,
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Text(
            text = stringResource(R.string.switch_overview_title),
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.switch_description1),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.switch_description2),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        M3Divider(modifier = Modifier.padding(vertical = 16.dp))
        M3Switch(
            labelText = stringResource(R.string.switch_example1),
            checked = true,
            onCheckedChange = { onExampleTapped(it.toString()) },
            enabled = true,
            horizontalInsetPadding = 0.dp,
        )
        M3Switch(
            labelText = stringResource(R.string.switch_example2),
            checked = false,
            onCheckedChange = { onExampleTapped(it.toString()) },
            enabled = false,
            horizontalInsetPadding = 0.dp,
        )
        M3Switch(
            labelText = stringResource(R.string.switch_example3),
            checked = true,
            onCheckedChange = { onExampleTapped(it.toString()) },
            enabled = true,
            checkedIcon = Icons.Default.Check,
            horizontalInsetPadding = 0.dp,
        )
        M3Switch(
            labelText = stringResource(R.string.switch_example4),
            checked = false,
            onCheckedChange = { onExampleTapped(it.toString()) },
            enabled = true,
            checkedIcon = Icons.Default.Check,
            uncheckedIcon = Icons.Default.Close,
            horizontalInsetPadding = 0.dp,
        )
    }
}

@AppScreenPreviews
@Composable
private fun SwitchPreview() {
    M3ComponentsTheme {
        ComponentScreen(
            component = Component.SWITCH,
            onNavigateBack = {},
            onExampleTapped = {},
        )
    }
}
