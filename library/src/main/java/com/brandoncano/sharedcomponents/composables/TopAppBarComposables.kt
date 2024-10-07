package com.brandoncano.sharedcomponents.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.text.textStyleTitle

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
    }
}
