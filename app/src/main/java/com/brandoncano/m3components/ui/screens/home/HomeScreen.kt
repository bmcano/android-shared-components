package com.brandoncano.m3components.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Feedback
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.brandoncano.m3components.R
import com.brandoncano.m3components.navigation.Component
import com.brandoncano.m3components.to.ComponentCardPO
import com.brandoncano.m3components.ui.theme.M3ComponentsTheme
import com.brandoncano.m3components.util.ComponentCardPOsDeriver
import com.brandoncano.sharedcomponents.composables.AppLongScreenPreview
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.m3.M3OutlinedCard
import com.brandoncano.sharedcomponents.m3.M3TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    componentCardPOs: List<ComponentCardPO>,
    onAboutTapped: () -> Unit,
    onComponentTapped: (Component) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            M3TopAppBar(
                titleText = stringResource(R.string.home_title),
                subTitleText = stringResource(R.string.home_subtitle),
                actions = {
                    // TODO - Figure out actions and menu options
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Outlined.Palette,
                            contentDescription = "App theme",
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Outlined.Feedback,
                            contentDescription = "Feedback",
                        )
                    }
                    IconButton(onClick = onAboutTapped) {
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
        HomeScreenContent(
            paddingValues = paddingValues,
            componentCardPOs = componentCardPOs,
            onComponentTapped = onComponentTapped,
        )
    }
}

@Composable
private fun HomeScreenContent(
    paddingValues: PaddingValues,
    componentCardPOs: List<ComponentCardPO>,
    onComponentTapped: (Component) -> Unit,
) {
    val sidePadding = dimensionResource(R.dimen.screen_side_padding)
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 160.dp),
        modifier = Modifier
            .consumeWindowInsets(paddingValues)
            .padding(horizontal = sidePadding),
        contentPadding = PaddingValues(
            top = paddingValues.calculateTopPadding(),
            start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
            end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
            bottom = paddingValues.calculateBottomPadding() + 24.dp,
        ),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(componentCardPOs) { componentCardPO ->
            M3OutlinedCard {
                ComponentOverviewCardContent(
                    componentCardPO = componentCardPO,
                    onComponentTapped = onComponentTapped,
                )
            }
        }
    }
}

@AppScreenPreviews
@AppLongScreenPreview
@Composable
private fun HomeScreenPreview() {
    M3ComponentsTheme {
        HomeScreen(
            componentCardPOs = ComponentCardPOsDeriver.execute(),
            onAboutTapped = {},
            onComponentTapped = {},
        )
    }
}
