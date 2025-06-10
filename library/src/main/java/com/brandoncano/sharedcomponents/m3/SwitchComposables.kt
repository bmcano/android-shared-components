package com.brandoncano.sharedcomponents.m3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.composables.AppComponentPreviews
import com.brandoncano.sharedcomponents.text.onSurfaceVariant

// https://m3.material.io/components/switch/overview
// https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#Switch(kotlin.Boolean,kotlin.Function1,androidx.compose.ui.Modifier,kotlin.Function0,kotlin.Boolean,androidx.compose.material3.SwitchColors,androidx.compose.foundation.interaction.MutableInteractionSource)

@Composable
fun M3Switch(
    labelText: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    enabled: Boolean = true,
    checkedIcon: ImageVector? = null,
    uncheckedIcon: ImageVector? = null,
    horizontalInsetPadding: Dp = 16.dp,
    verticalPadding: Dp = 8.dp,
) {
    val (checkedState, onStateChange) = remember { mutableStateOf(checked) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = horizontalInsetPadding,
                vertical = verticalPadding,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = labelText,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge.onSurfaceVariant(),
        )
        Switch(
            checked = checkedState,
            onCheckedChange = {
                onStateChange(it)
                onCheckedChange(it)
            },
            modifier = Modifier.padding(start = 16.dp),
            thumbContent = {
                if (checkedState && checkedIcon != null) {
                    Icon(
                        imageVector = checkedIcon,
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize),
                    )
                }
                if (!checkedState && uncheckedIcon != null) {
                    Icon(
                        imageVector = uncheckedIcon,
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize),
                    )
                }
            },
            enabled = enabled,
            colors = SwitchDefaults.colors(), // Default parameter
            interactionSource = null, // Default parameter
        )
    }
}

@AppComponentPreviews
@Composable
private fun SwitchPreview() {
    Column {
        M3Switch(
            labelText = "Checked switch",
            checked = true,
            onCheckedChange = {},
        )
        M3Switch(
            labelText = "Unchecked switch",
            checked = false,
            onCheckedChange = {},
        )
        M3Switch(
            labelText = "Checked switch with icon",
            checked = true,
            onCheckedChange = {},
            checkedIcon = Icons.Default.Check,
        )
        M3Switch(
            labelText = "Unchecked switch with icon",
            checked = false,
            onCheckedChange = {},
            uncheckedIcon = Icons.Default.Close,
        )
    }
}
