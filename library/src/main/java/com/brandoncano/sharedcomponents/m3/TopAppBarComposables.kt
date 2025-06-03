package com.brandoncano.sharedcomponents.m3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.PushPin
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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

// scroll behavior

// TopAppBarDefaults.pinnedScrollBehavior() // TopAppBar or CenterAligned
// TopAppBarDefaults.enterAlwaysScrollBehavior() // MediumTopAppBar or LargeTopAppBar
// TopAppBarDefaults.exitUntilCollapsedScrollBehavior() // MediumTopAppBar or LargeTopAppBar

// M3 Guidelines allow for a max of 3 items for compact actions, and 5 max for large screens
// To make it adaptive we may need to make a custom AppBarRow element which accounts for this.

@Composable
private fun getSubtitleLineHeight(textStyle: TextStyle): Dp {
    val subtitleLineHeightDp = with(LocalDensity.current) {
        textStyle.lineHeight.toDp()
    }
    return subtitleLineHeightDp
}

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
    val subtitleLineHeightDp = getSubtitleLineHeight(MaterialTheme.typography.labelMedium)
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
        modifier = Modifier,
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
        windowInsets = TopAppBarDefaults.windowInsets,
        colors = TopAppBarDefaults.topAppBarColors(),
        scrollBehavior = scrollBehavior,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun M3CenterAlignedTopAppBar(
    titleText: String,
    subTitleText: String? = null,
    navigationIcon: ImageVector? = null,
    onNavigateBack: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    val subtitleLineHeightDp = getSubtitleLineHeight(MaterialTheme.typography.labelMedium)
    val expandedHeight = if (subTitleText != null) {
        TopAppBarDefaults.TopAppBarExpandedHeight + subtitleLineHeightDp
    } else {
        TopAppBarDefaults.TopAppBarExpandedHeight
    }
    CenterAlignedTopAppBar(
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
@Composable
fun M3MediumTopAppBar(
    titleText: String,
    subTitleText: String? = null,
    navigationIcon: ImageVector? = null,
    onNavigateBack: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    val subtitleLineHeightDp = getSubtitleLineHeight(MaterialTheme.typography.labelLarge)
    // 4dp gap between title and subtitle
    val gapDp = 4.dp

    // Total extra vertical required when a subtitle is present:
    val extraForSubtitle = if (subTitleText != null) subtitleLineHeightDp + gapDp else 0.dp
    // 2) Base collapsed/expanded heights from M3 defaults:
    val baseCollapsed = TopAppBarDefaults.MediumAppBarCollapsedHeight
    val baseExpanded  = TopAppBarDefaults.MediumAppBarExpandedHeight

    // 3) Add extra only if subTitleText != null:
    val collapsedHeight = baseCollapsed + extraForSubtitle
    val expandedHeight  = baseExpanded + extraForSubtitle + gapDp
    MediumTopAppBar(
        title = {
            Column {
                Text(
                    text = titleText,
                    style = MaterialTheme.typography.headlineMedium,
                )
                subTitleText?.let {
                    Text(
                        text = subTitleText,
                        style = MaterialTheme.typography.labelLarge.onSurfaceVariant(),
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
        scrollBehavior = scrollBehavior,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun M3LargeTopAppBar(
    titleText: String,
    subTitleText: String? = null,
    navigationIcon: ImageVector? = null,
    onNavigateBack: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    val subtitleLineHeightDp = getSubtitleLineHeight(MaterialTheme.typography.titleMedium)
    val expandedHeight = if (subTitleText != null) {
        TopAppBarDefaults.LargeAppBarExpandedHeight + subtitleLineHeightDp
    } else {
        TopAppBarDefaults.LargeAppBarExpandedHeight
    }
    LargeTopAppBar(
        title = {
            Column {
                Text(
                    text = titleText,
                    style = MaterialTheme.typography.displaySmall,
                )
                subTitleText?.let {
                    Text(
                        text = subTitleText,
                        style = MaterialTheme.typography.titleMedium.onSurfaceVariant(),
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
        collapsedHeight = TopAppBarDefaults.LargeAppBarCollapsedHeight,
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
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Back",
                    )
                }
            }
        )
        FullWidthDivider()
        M3CenterAlignedTopAppBar(
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
        FullWidthDivider()
        M3MediumTopAppBar(
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
        FullWidthDivider()
        M3LargeTopAppBar(
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
