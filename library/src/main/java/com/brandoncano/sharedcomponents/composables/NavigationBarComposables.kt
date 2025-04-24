package com.brandoncano.sharedcomponents.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Looks
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.data.NavigationBarOptions
import com.brandoncano.sharedcomponents.text.textStyleCaption

/**
 * This composable displays a bottom navigation bar with a list of selectable items, each with an icon and label.
 *
 * @param selection The initially selected item index. Defaults to 0.
 * @param onClick Callback function that gets triggered when an item is clicked.
 * @param options The list of [NavigationBarOptions] representing each item in the navigation bar, including the icon and label.
 */
@Composable
fun AppNavigationBar(
    selection: Int = 0,
    onClick: (Int) -> Unit,
    options: List<NavigationBarOptions>,
) {
    var selectedItem by remember { mutableIntStateOf(selection) }

    NavigationBar {
        options.forEachIndexed { index, it ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    onClick(selectedItem)
                },
                icon = {
                    Image(
                        imageVector = it.imageVector,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
                    )
                },
                label = {
                    Text(
                        text = it.label,
                        style = textStyleCaption(),
                    )
                },
            )
        }
    }
}

@AppComponentPreviews
@Composable
private fun NavigationBarPreview() {
    AppNavigationBar(
        selection = 0,
        onClick = {},
        options = listOf(
            NavigationBarOptions("Option1", Icons.Outlined.Looks),
            NavigationBarOptions("Option2", Icons.Outlined.Looks),
            NavigationBarOptions("Option3", Icons.Outlined.Looks),
        )
    )
}
