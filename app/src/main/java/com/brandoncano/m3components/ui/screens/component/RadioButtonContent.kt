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
import com.brandoncano.sharedcomponents.m3.M3Divider
import com.brandoncano.sharedcomponents.m3.M3RadioButtonGroup
import com.brandoncano.sharedcomponents.text.onSurfaceVariant

@Composable
fun RadioButtonContent() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Text(
            text = stringResource(R.string.radio_overview_title),
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.radio_description1),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.radio_description2),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        M3Divider(modifier = Modifier.padding(vertical = 16.dp))
        M3RadioButtonGroup(
            options = listOf("Option 1", "Option 2", "Option 3"),
            verticalPadding = 12.dp,
        )
    }
}

@AppScreenPreviews
@Composable
private fun RadioButtonPreview() {
    M3ComponentsTheme {
        ComponentScreen(
            component = Component.RADIO_BUTTON,
            onNavigateBack = {},
            onExampleTapped = {},
        )
    }
}
