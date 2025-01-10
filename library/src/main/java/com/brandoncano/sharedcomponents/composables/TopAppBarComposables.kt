package com.brandoncano.sharedcomponents.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.text.textStyleTitle

/**
 * A custom TopAppBar with a dropdown menu.
 * The menu is triggered by clicking an overflow icon (three vertical dots).
 *
 * @param titleText The text to display as the title of the TopAppBar.
 * @param interactionSource An [MutableInteractionSource] used to detect when the TopAppBar is pressed.
 * @param showMenu A [MutableState] that controls the visibility of the dropdown menu.
 * @param navigationIcon An optional [ImageVector] to display as the navigation icon.
 * @param onNavigateBack A callback function to be executed when the navigation icon is clicked.
 * @param content A composable function that defines the content of the dropdown menu.
 */
@Composable
fun AppMenuTopAppBar(
    titleText: String,
    interactionSource: MutableInteractionSource,
    showMenu: MutableState<Boolean>,
    navigationIcon: ImageVector? = null,
    onNavigateBack: () -> Unit = {},
    content: @Composable (ColumnScope.() -> Unit),
) {
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            if (interaction is PressInteraction.Release) {
                showMenu.value = false
            }
        }
    }
    AppTopAppBar(
        titleText = titleText,
        navigationIcon = navigationIcon,
        onNavigateBack = onNavigateBack,
    ) {
        IconButton(onClick = { showMenu.value = !showMenu.value }) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = stringResource(R.string.content_description_shared_menu_more),
            )
        }
        DropdownMenu(
            expanded = showMenu.value,
            onDismissRequest = { showMenu.value = false },
            content = content,
        )
    }
}

/**
 * A custom TopAppBar for the app's home screen.
 *
 * @param titleText The text to display as the title of the TopAppBar.
 * @param interactionSource An [MutableInteractionSource] used to detect when the TopAppBar is pressed.
 * @param showMenu A [MutableState] that controls the visibility of the dropdown menu.
 * @param appIcon The [Painter] to use for the app icon in the TopAppBar.
 * @param content A composable function that defines the content of the dropdown menu.
 */
@Composable
fun AppHomeTopAppBar(
    titleText: String,
    interactionSource: MutableInteractionSource,
    showMenu: MutableState<Boolean>,
    appIcon: Painter,
    content: @Composable (ColumnScope.() -> Unit),
) {
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            if (interaction is PressInteraction.Release) {
                showMenu.value = false
            }
        }
    }
    AppTopAppBar(
        titleText = titleText,
        appIcon = appIcon,
    ) {
        IconButton(onClick = { showMenu.value = !showMenu.value }) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = stringResource(R.string.content_description_shared_menu_more),
            )
        }
        DropdownMenu(
            expanded = showMenu.value,
            onDismissRequest = { showMenu.value = false },
            content = content,
        )
    }
}

/**
 * A custom Top App Bar for the application.
 *
 * @param titleText The text to display in the title of the TopAppBar.
 * @param navigationIcon An optional [ImageVector] to display as the navigation icon. If provided,
 * @param onNavigateBack A callback function that is invoked when the navigation icon is clicked.
 * @param actions A composable function that defines the actions to display on the right side of the TopAppBar.
 */
@OptIn(ExperimentalMaterial3Api::class) // CenterAlignedTopAppBar
@Composable
fun AppTopAppBar(
    titleText: String,
    navigationIcon: ImageVector? = null,
    onNavigateBack: () -> Unit = {},
    actions: @Composable (RowScope.() -> Unit) = { },
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = titleText,
                style = textStyleTitle(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        },
        navigationIcon = {
            if (navigationIcon != null) {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = navigationIcon,
                        contentDescription = "Back"
                    )
                }
            }
        },
        actions = actions,
        colors = centerAlignedTopAppBarColors(
            containerColor = colorScheme.primary,
            navigationIconContentColor = colorScheme.onPrimary,
            titleContentColor = colorScheme.onPrimary,
            actionIconContentColor = colorScheme.onPrimary,
        ),
    )
    BottomShadow()
}

@OptIn(ExperimentalMaterial3Api::class) // CenterAlignedTopAppBar
@Composable
private fun AppTopAppBar(
    titleText: String,
    appIcon: Painter,
    actions: @Composable (RowScope.() -> Unit) = { },
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = titleText,
                style = textStyleTitle(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        },
        navigationIcon = {
            Box(
                modifier = Modifier
                    .minimumInteractiveComponentSize()
                    .size(40.dp),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = appIcon,
                    contentDescription = null,
                )
            }
        },
        actions = actions,
        colors = centerAlignedTopAppBarColors(
            containerColor = colorScheme.primary,
            navigationIconContentColor = colorScheme.onPrimary,
            titleContentColor = colorScheme.onPrimary,
            actionIconContentColor = colorScheme.onPrimary,
        ),
    )
    BottomShadow()
}

@Composable
private fun BottomShadow(alpha: Float = 0.1f, height: Dp = 4.dp) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Black.copy(alpha), Color.Transparent)
                )
            )
    )
}

@Preview
@Composable
private fun MenuTopAppBarPreview() {
    val interactionSource = remember { MutableInteractionSource() }
    val showMenu = remember { mutableStateOf(false) }
    Column {
        AppTopAppBar("TopAppBar")
        AppTopAppBar("TopAppBar", Icons.Filled.Close)
        AppMenuTopAppBar("MenuTopAppBar", interactionSource, showMenu) {}
        AppMenuTopAppBar("MenuTopAppBar", interactionSource, showMenu, Icons.Filled.Close) {}
        AppHomeTopAppBar("HomeTopAppBar", interactionSource, showMenu, painterResource(R.drawable.resistor_playstore)) { }
    }
}
