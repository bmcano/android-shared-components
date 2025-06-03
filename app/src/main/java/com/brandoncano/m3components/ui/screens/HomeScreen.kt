package com.brandoncano.m3components.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brandoncano.m3components.navigation.Component
import com.brandoncano.m3components.to.ComponentCardPO
import com.brandoncano.m3components.ui.theme.M3ComponentsTheme
import com.brandoncano.m3components.util.ComponentCardPOsDeriver
import com.brandoncano.sharedcomponents.composables.AppLongScreenPreview
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.m3.BottomScreenSpacer
import com.brandoncano.sharedcomponents.m3.M3OutlinedCard

@Composable
fun HomeScreen(
    componentCardPOs: List<ComponentCardPO>,
    onComponentTapped: (Component) -> Unit,
) {
    Scaffold(
        topBar = {
            // TODO - TopAppBar Composables
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
        componentCardPOs.forEach {
            M3OutlinedCard(
                modifier = Modifier.padding(horizontal = 16.dp),
            ) {
                ComponentOverviewCardContent(
                    componentCardPO = it,
                    onComponentTapped = onComponentTapped,
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
        BottomScreenSpacer(height = 12.dp)
    }
}

@AppScreenPreviews
@AppLongScreenPreview
@Composable
private fun HomeScreenPreview() {
    M3ComponentsTheme {
        HomeScreen(
            componentCardPOs = ComponentCardPOsDeriver.execute(),
            onComponentTapped = {},
        )
    }
}
