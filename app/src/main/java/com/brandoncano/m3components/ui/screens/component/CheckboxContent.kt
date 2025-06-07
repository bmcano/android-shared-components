package com.brandoncano.m3components.ui.screens.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.brandoncano.sharedcomponents.m3.M3Checkbox
import com.brandoncano.sharedcomponents.m3.M3Divider
import com.brandoncano.sharedcomponents.m3.M3TriStateCheckboxGroup
import com.brandoncano.sharedcomponents.text.onSurfaceVariant

@Composable
fun CheckboxContent(
    onExampleTapped: (String) -> Unit,
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Text(
            text = stringResource(R.string.checkbox_overview_title),
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.checkbox_description1),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.checkbox_description2),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        M3Divider(modifier = Modifier.padding(vertical = 16.dp))
        M3Checkbox(
            option = stringResource(R.string.checkbox_example1),
            checked = false,
            onCheckChanged = { onExampleTapped(it.toString()) },
        )
        M3Divider(modifier = Modifier.padding(vertical = 16.dp))
        M3TriStateCheckboxGroup(
            parentOption = stringResource(R.string.checkbox_example2),
            options = listOf(
                stringResource(R.string.checkbox_example3),
                stringResource(R.string.checkbox_example4),
                stringResource(R.string.checkbox_example5),
            ),
            checkedStates = listOf(true, false, false),
            onParentCheckedChange = { onExampleTapped("Parent: $it") },
            onChildCheckedChange = { index, checked -> onExampleTapped("Child $index - $checked") },
        )
    }
}

@AppScreenPreviews
@Composable
private fun CheckboxPreview() {
    M3ComponentsTheme {
        ComponentScreen(
            component = Component.CHECKBOX,
            onNavigateBack = {},
            onExampleTapped = {},
        )
    }
}
