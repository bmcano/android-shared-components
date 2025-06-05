package com.brandoncano.m3components.ui.screens.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.m3components.R
import com.brandoncano.m3components.navigation.Component
import com.brandoncano.sharedcomponents.m3.BottomScreenSpacer
import com.brandoncano.sharedcomponents.m3.M3TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentScreen(
    component: Component,
    onNavigateBack: () -> Unit,
    onExampleTapped: () -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            M3TopAppBar(
                titleText = stringResource(R.string.component_screen_title),
                navigationIcon = Icons.Default.Close,
                onNavigateBack = onNavigateBack,
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = "About",
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
        contentWindowInsets = WindowInsets.safeDrawing,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues),
            horizontalAlignment = Alignment.Start,
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            when (component) {
                Component.BADGE -> BadgeContent()
                Component.BOTTOM_APP_BAR -> { }
                Component.BOTTOM_SHEET -> { }
                Component.BUTTONS -> ButtonContent(onExampleTapped)
                Component.CARDS -> { }
                Component.CHECKBOX -> { }
                Component.CHIPS -> { }
                Component.DATE_PICKER -> { }
                Component.DIALOGS -> { }
                Component.DIVIDERS -> DividerContent()
                Component.EXTENDED_FAB -> { }
                Component.FAB -> { }
                Component.ICON_BUTTONS -> { }
                Component.LISTS -> { }
                Component.MENUS -> { }
                Component.NAVIGATION_BAR -> { }
                Component.NAVIGATION_DRAWER -> { }
                Component.NAVIGATION_RAIL -> { }
                Component.PROGRESS_INDICATORS -> { }
                Component.RADIO_BUTTON -> { }
                Component.SEARCH_BAR -> { }
                Component.SEGMENTED_BUTTON -> { }
                Component.SLIDERS -> { }
                Component.SNACKBARS -> { }
                Component.SWITCH -> { }
                Component.TABS -> { }
                Component.TEXT_FIELDS -> { }
                Component.TIME_PICKER -> { }
                Component.TOP_APP_BAR -> { }
            }
            BottomScreenSpacer()
        }
    }
}
