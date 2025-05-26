package com.brandoncano.sharedcomponents.screen

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.composables.AppDesktopScreenPreview
import com.brandoncano.sharedcomponents.composables.AppDivider
import com.brandoncano.sharedcomponents.composables.AppLongScreenPreview
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppTopAppBar
import com.brandoncano.sharedcomponents.composables.BottomScreenSpacer
import com.brandoncano.sharedcomponents.data.Apps
import com.brandoncano.sharedcomponents.text.textStyleHeadline

@Composable
fun ViewOurAppsScreen(
    app: Apps,
    appImageRes: Int,
    onNavigateBack: () -> Unit,
    onFeatureCardTapped: () -> Unit,
    onMobileAppCardTapped: (String) -> Unit,
    onViewMoreAppsTapped: () -> Unit,
) {
    Scaffold(
        topBar = {
            AppTopAppBar(
                titleText = stringResource(id = R.string.view_our_apps_title),
                navigationIcon = Icons.Filled.Close,
                onNavigateBack = onNavigateBack,
            )
        },
        contentWindowInsets = WindowInsets.safeDrawing,
    ) { paddingValues ->
        ViewOurAppsScreenContent(
            paddingValues = paddingValues,
            app = app,
            appImageRes = appImageRes,
            onFeatureCardTapped = onFeatureCardTapped,
            onMobileAppCardTapped = onMobileAppCardTapped,
            onViewMoreAppsTapped = onViewMoreAppsTapped,
        )
    }
}

@Composable
private fun ViewOurAppsScreenContent(
    paddingValues: PaddingValues,
    app: Apps,
    appImageRes: Int,
    onFeatureCardTapped: () -> Unit,
    onMobileAppCardTapped: (String) -> Unit,
    onViewMoreAppsTapped: () -> Unit,
) {
    val sidePadding = dimensionResource(R.dimen.app_side_padding)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)
            .padding(horizontal = sidePadding),
        horizontalAlignment = Alignment.Start,
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        MobileAppFeatureCard(
            appImageRes = appImageRes,
            onClick = onFeatureCardTapped,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.view_our_apps_header),
            style = textStyleHeadline(),
        )
        if (app !is Apps.Capacitor) {
            MobileAppCard(
                appName = stringResource(id = R.string.view_our_apps_capacitor),
                appImageRes = R.drawable.capacitor_playstore,
                app = Apps.Capacitor,
                onClick = onMobileAppCardTapped,
            )
        }
        if (app !is Apps.Inductor) {
            MobileAppCard(
                appName = stringResource(id = R.string.view_our_apps_inductor),
                appImageRes = R.drawable.inductor_playstore,
                app = Apps.Inductor,
                onClick = onMobileAppCardTapped,
            )
        }
        if (app !is Apps.OhmsLaw) {
            MobileAppCard(
                appName = stringResource(id = R.string.view_our_apps_ohms_law),
                appImageRes = R.drawable.ohms_law_playstore,
                app = Apps.OhmsLaw,
                onClick = onMobileAppCardTapped,
            )
        }
        if (app !is Apps.Resistor) {
            MobileAppCard(
                appName = stringResource(id = R.string.view_our_apps_resistor),
                appImageRes = R.drawable.resistor_playstore,
                app = Apps.Resistor,
                onClick = onMobileAppCardTapped,
            )
        }
        AppDivider(modifier = Modifier.padding(vertical = 16.dp))
        ViewDeveloperProfileCard(onClick = onViewMoreAppsTapped)
        BottomScreenSpacer()
    }
}

@AppScreenPreviews
@AppDesktopScreenPreview
@AppLongScreenPreview
@Composable
private fun ViewOurAppsScreenPreview() {
    ViewOurAppsScreen(
        app = Apps.Resistor,
        appImageRes = R.drawable.resistor_feature_graphic,
        onNavigateBack = {},
        onFeatureCardTapped = {},
        onMobileAppCardTapped = {},
        onViewMoreAppsTapped = {},
    )
}
