package com.brandoncano.sharedcomponents.m3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.PushPin
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import com.brandoncano.sharedcomponents.composables.AppComponentPreviews
import com.brandoncano.sharedcomponents.text.onSurfaceVariant

// TopAppBar	M3 small top app bar
//CenterAlignedTopAppBar	M3 center-aligned top app bar
//MediumTopAppBar	M3 medium top app bar
//LargeTopAppBar	M3 large top app bar


// All of these can be aligned to the leading edge or centered
// search app bar - ignore for now
// small
// medium flexible
// large flexible


// Leading icon (navigation back or open nav drawer)
// title text (headline)
// subtitle text (optional)
// trailing elements (up to 2?)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun M3TopAppBar(
    titleText: String,
    subTitleText: String? = null,
    navigationIcon: ImageVector? = null,
    onNavigateBack: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    val subtitleLineHeightDp = with(LocalDensity.current) {
        MaterialTheme.typography.labelLarge.lineHeight.toDp()
    }
    val expandedHeight = if (subTitleText != null) {
        TopAppBarDefaults.TopAppBarExpandedHeight + subtitleLineHeightDp
    } else {
        TopAppBarDefaults.TopAppBarExpandedHeight
    }
    TopAppBar(
        title = {
            Column {
                Text(
                    text = titleText,
                    style = MaterialTheme.typography.titleLarge,
                )
                subTitleText?.let {
                    Text(
                        text = subTitleText,
                        style = MaterialTheme.typography.labelMedium.onSurfaceVariant(),
                    )
                }
            }
        },
        navigationIcon = {
            if (navigationIcon != null) {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = navigationIcon,
                        contentDescription = "Back",
                    )
                }
            }
        },
        actions = actions,
        expandedHeight = expandedHeight,
        scrollBehavior = scrollBehavior,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@AppComponentPreviews
@Composable
private fun TopAppBarPreviews() {
    Column {
        M3TopAppBar(
            titleText = "Title",
            navigationIcon = Icons.AutoMirrored.Filled.ArrowBack,
            onNavigateBack = {},
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.PushPin,
                        contentDescription = "Back",
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Palette,
                        contentDescription = "Back",
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Palette,
                        contentDescription = "Back",
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Back",
                    )
                }
            }
        )
        FullWidthDivider()
        M3TopAppBar(
            titleText = "Title",
            subTitleText = "Subtitle",
            navigationIcon = Icons.AutoMirrored.Filled.ArrowBack,
            onNavigateBack = {},
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Back",
                    )
                }
            }
        )
    }
}


///**
// * A Material 3 “Center-Aligned Top App Bar” with optional nav icon, actions, and scroll behavior.
// *
// * @param titleText            The centered title.
// * @param modifier             Optional [Modifier].
// * @param navigationIcon       Optional slot for a navigation icon composable.
// * @param actions              Optional slot for action icons.
// * @param colors               Customizable colors; defaults to [TopAppBarDefaults.centerAlignedTopAppBarColors].
// * @param scrollBehavior       Optional [TopAppBarScrollBehavior] for scroll effects.
// */
//@Composable
//fun AppCenterAlignedTopAppBar(
//    titleText: String,
//    modifier: Modifier = Modifier,
//    navigationIcon: @Composable (() -> Unit)? = null,
//    actions: @Composable RowScope.() -> Unit = {},
//    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
//    scrollBehavior: TopAppBarScrollBehavior? = null
//) {
//    CenterAlignedTopAppBar(
//        title = { Text(text = titleText) },
//        modifier = modifier,
//        navigationIcon = navigationIcon?.let {
//            { IconButton(onClick = {}) { it() } }
//        } ?: {},
//        actions = actions,
//        colors = colors,
//        scrollBehavior = scrollBehavior
//    )
//}

///**
// * A Material 3 “Medium Top App Bar” with optional nav icon, actions, and scroll behavior.
// *
// * @param titleText            The title displayed in the app bar.
// * @param modifier             Optional [Modifier].
// * @param navigationIcon       Optional slot for a navigation icon composable.
// * @param actions              Optional slot for action icons.
// * @param colors               Customizable colors; defaults to [TopAppBarDefaults.mediumTopAppBarColors].
// * @param scrollBehavior       Optional [TopAppBarScrollBehavior] (e.g., exitUntilCollapsed).
// */
//@Composable
//fun AppMediumTopAppBar(
//    titleText: String,
//    modifier: Modifier = Modifier,
//    navigationIcon: @Composable (() -> Unit)? = null,
//    actions: @Composable RowScope.() -> Unit = {},
//    colors: TopAppBarColors = TopAppBarDefaults.mediumTopAppBarColors(),
//    scrollBehavior: TopAppBarScrollBehavior? = null
//) {
//    MediumTopAppBar(
//        title = { Text(text = titleText) },
//        modifier = modifier,
//        navigationIcon = navigationIcon?.let {
//            { IconButton(onClick = {}) { it() } }
//        } ?: {},
//        actions = actions,
//        colors = colors,
//        scrollBehavior = scrollBehavior
//    )
//}
//
///**
// * A Material 3 “Large Top App Bar” with optional nav icon, actions, and scroll behavior.
// *
// * @param titleText            The title shown in the larger app bar.
// * @param modifier             Optional [Modifier].
// * @param navigationIcon       Optional slot for a navigation icon composable.
// * @param actions              Optional slot for action icons.
// * @param colors               Customizable colors; defaults to [TopAppBarDefaults.largeTopAppBarColors].
// * @param scrollBehavior       Optional [TopAppBarScrollBehavior] for collapse/expand effects.
// */
//@Composable
//fun AppLargeTopAppBar(
//    titleText: String,
//    modifier: Modifier = Modifier,
//    navigationIcon: @Composable (() -> Unit)? = null,
//    actions: @Composable RowScope.() -> Unit = {},
//    colors: TopAppBarColors = TopAppBarDefaults.largeTopAppBarColors(),
//    scrollBehavior: TopAppBarScrollBehavior? = null
//) {
//    LargeTopAppBar(
//        title = { Text(text = titleText) },
//        modifier = modifier,
//        navigationIcon = navigationIcon?.let {
//            { IconButton(onClick = {}) { it() } }
//        } ?: {},
//        actions = actions,
//        colors = colors,
//        scrollBehavior = scrollBehavior
//    )
//}