package com.brandoncano.m3components.ui.screens.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.m3components.R
import com.brandoncano.m3components.navigation.Component
import com.brandoncano.m3components.ui.theme.M3ComponentsTheme
import com.brandoncano.sharedcomponents.composables.AppLongScreenPreview
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.m3.FullWidthDivider
import com.brandoncano.sharedcomponents.m3.M3ElevatedButton
import com.brandoncano.sharedcomponents.m3.M3FilledButton
import com.brandoncano.sharedcomponents.m3.M3FilledTonalButton
import com.brandoncano.sharedcomponents.m3.M3OutlinedButton
import com.brandoncano.sharedcomponents.m3.M3TextButton
import com.brandoncano.sharedcomponents.text.onSurfaceVariant

@Composable
fun ButtonContent(
    onExampleTapped: (String) -> Unit,
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Text(
            text = stringResource(R.string.buttons_overview_title),
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.buttons_overview_description),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        FullWidthDivider(modifier = Modifier.padding(vertical = 16.dp))
        Text(
            text = stringResource(R.string.button_elevated_guidelines),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            M3ElevatedButton(
                buttonLabel = stringResource(R.string.button_elevated_default),
                onClick = { onExampleTapped("Elevated button") },
            )
            M3ElevatedButton(
                buttonLabel = stringResource(R.string.button_elevated_with_icon),
                onClick = { onExampleTapped("Elevated button") },
                icon = Icons.Default.Add,
            )
            M3ElevatedButton(
                buttonLabel = stringResource(R.string.button_elevated_disabled),
                onClick = { onExampleTapped("Elevated button") },
                enabled = false,
            )
            M3ElevatedButton(
                buttonLabel = stringResource(R.string.button_elevated_square),
                onClick = { onExampleTapped("Elevated button") },
                useSquareShape = true,
            )
        }
        FullWidthDivider(modifier = Modifier.padding(vertical = 16.dp))
        Text(
            text = stringResource(R.string.button_filled_guidelines),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            M3FilledButton(
                buttonLabel = stringResource(R.string.button_filled_default),
                onClick = { onExampleTapped("Filled button") },
            )
            M3FilledButton(
                buttonLabel = stringResource(R.string.button_filled_with_icon),
                onClick = { onExampleTapped("Filled button") },
                icon = Icons.Default.Add,
            )
            M3FilledButton(
                buttonLabel = stringResource(R.string.button_filled_disabled),
                onClick = { onExampleTapped("Filled button") },
                enabled = false,
            )
            M3FilledButton(
                buttonLabel = stringResource(R.string.button_filled_square),
                onClick = { onExampleTapped("Filled button") },
                useSquareShape = true,
            )
        }
        FullWidthDivider(modifier = Modifier.padding(vertical = 16.dp))
        Text(
            text = stringResource(R.string.button_tonal_guidelines),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            M3FilledTonalButton(
                buttonLabel = stringResource(R.string.button_tonal_default),
                onClick = { onExampleTapped("Tonal button") },
            )
            M3FilledTonalButton(
                buttonLabel = stringResource(R.string.button_tonal_with_icon),
                onClick = { onExampleTapped("Tonal button") },
                icon = Icons.Default.Add,
            )
            M3FilledTonalButton(
                buttonLabel = stringResource(R.string.button_tonal_disabled),
                onClick = { onExampleTapped("Tonal button") },
                enabled = false,
            )
            M3FilledTonalButton(
                buttonLabel = stringResource(R.string.button_tonal_square),
                onClick = { onExampleTapped("Tonal button") },
                useSquareShape = true,
            )
        }
        FullWidthDivider(modifier = Modifier.padding(vertical = 16.dp))
        Text(
            text = stringResource(R.string.button_outlined_guidelines),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            M3OutlinedButton(
                buttonLabel = stringResource(R.string.button_outlined_default),
                onClick = { onExampleTapped("Outlined button") },
            )
            M3OutlinedButton(
                buttonLabel = stringResource(R.string.button_outlined_with_icon),
                onClick = { onExampleTapped("Outlined button") },
                icon = Icons.Default.Add,
            )
            M3OutlinedButton(
                buttonLabel = stringResource(R.string.button_outlined_disabled),
                onClick = { onExampleTapped("Outlined button") },
                enabled = false,
            )
            M3OutlinedButton(
                buttonLabel = stringResource(R.string.button_outlined_square),
                onClick = { onExampleTapped("Outlined button") },
                useSquareShape = true,
            )
        }
        FullWidthDivider(modifier = Modifier.padding(vertical = 16.dp))
        Text(
            text = stringResource(R.string.button_text_guidelines),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            M3TextButton(
                buttonLabel = stringResource(R.string.button_text_default),
                onClick = { onExampleTapped("Text button") },
            )
            M3TextButton(
                buttonLabel = stringResource(R.string.button_text_with_icon),
                onClick = { onExampleTapped("Text button") },
                icon = Icons.Default.Add,
            )
            M3TextButton(
                buttonLabel = stringResource(R.string.button_text_disabled),
                onClick = { onExampleTapped("Text button") },
                enabled = false,
            )
        }
    }
}

@AppScreenPreviews
@AppLongScreenPreview
@Composable
private fun ButtonContentPreview() {
    M3ComponentsTheme {
        ComponentScreen(
            component = Component.BUTTONS,
            onNavigateBack = {},
            onExampleTapped = {},
        )
    }
}
