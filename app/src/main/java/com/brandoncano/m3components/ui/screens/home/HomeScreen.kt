package com.brandoncano.m3components.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.m3components.R
import com.brandoncano.m3components.navigation.Component
import com.brandoncano.m3components.to.ComponentCardPO
import com.brandoncano.m3components.ui.theme.M3ComponentsTheme
import com.brandoncano.m3components.util.ComponentCardPOsDeriver
import com.brandoncano.sharedcomponents.composables.AppLongScreenPreview
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.m3.BottomScreenSpacer
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(paddingValues),
        horizontalAlignment = Alignment.Start,
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            itemVerticalAlignment = Alignment.Top,
            maxItemsInEachRow = 4,
        ) {
            componentCardPOs.forEach { componentCardPO ->
                M3OutlinedCard(
                    modifier = Modifier.widthIn(max = 192.dp)
                ) {
                    ComponentOverviewCardContent(
                        componentCardPO = componentCardPO,
                        onComponentTapped = onComponentTapped,
                    )
                }
            }
        }
        BottomScreenSpacer()
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
