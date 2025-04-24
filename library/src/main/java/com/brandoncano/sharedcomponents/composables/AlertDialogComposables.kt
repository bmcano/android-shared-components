package com.brandoncano.sharedcomponents.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.data.ThemeMode
import com.brandoncano.sharedcomponents.text.textStyleBody
import com.brandoncano.sharedcomponents.text.textStyleCallout
import com.brandoncano.sharedcomponents.text.textStyleHeadline

/**
 * A dialog to select the app theme mode.
 *
 * This composable displays an alert dialog that allows the user to select a theme mode for the app.
 * It presents a list of available theme modes, each with a radio button, allowing users to choose
 * between different themes (system default, light, dark).
 *
 * @param currentThemeMode The currently selected [ThemeMode].
 * @param onThemeSelected Callback function that gets triggered when a new theme mode is selected.
 * @param onDismissRequest Callback function that handles a dismissed dialog.
 */
@Composable
fun AppThemeDialog(
    currentThemeMode: ThemeMode,
    onThemeSelected: (ThemeMode) -> Unit,
    onDismissRequest: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Text(
                text = stringResource(R.string.dialog_app_appearance),
                style = textStyleHeadline(),
            )
        },
        text = {
            Column {
                ThemeMode.entries.forEach { themeMode ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (themeMode == currentThemeMode),
                                onClick = { onThemeSelected(themeMode) }
                            )
                    ) {
                        RadioButton(
                            selected = (themeMode == currentThemeMode),
                            onClick = { onThemeSelected(themeMode) }
                        )
                        Text(
                            text = themeMode.displayText,
                            style = textStyleBody(),
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismissRequest) {
                Text(
                    text = stringResource(R.string.dialog_confirm_button),
                    style = textStyleCallout(),
                )
            }
        }
    )
}

@AppComponentPreviews
@Composable
private fun AppThemeDialogPreview() {
    AppThemeDialog(
        currentThemeMode = ThemeMode.SYSTEM_DEFAULT,
        onThemeSelected = {},
        onDismissRequest = {},
    )
}
