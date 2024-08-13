package com.brandoncano.sharedcomponents.screen

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppTopAppBar
import com.brandoncano.sharedcomponents.data.Apps
import com.brandoncano.sharedcomponents.text.textStyleHeadline

@AppScreenPreviews
@Composable
fun ViewOurAppsScreen(
    context: Context = LocalContext.current,
    app: Apps = Apps.LedResistor,
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start,
        ) {
            AppTopAppBar(titleText = stringResource(id = R.string.view_our_apps_title))
            Text(
                text = stringResource(id = R.string.view_our_apps_header),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp),
                style = textStyleHeadline(),
            )
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                if (app !is Apps.Resistor) {
                    MobileAppCard(
                        appName = stringResource(id = R.string.view_our_apps_resistor),
                        appImage = R.drawable.resistor_feature_graphic,
                        context = context,
                        app = app,
                    )
                }
                if (app !is Apps.Capacitor) {
                    MobileAppCard(
                        appName = stringResource(id = R.string.view_our_apps_capacitor),
                        appImage = R.drawable.capacitor_feature_graphic,
                        context = context,
                        app = app,
                    )
                }
                if (app !is Apps.Inductor) {
                    MobileAppCard(
                        appName = stringResource(id = R.string.view_our_apps_inductor),
                        appImage = R.drawable.inductor_feature_graphic,
                        context = context,
                        app = app,
                    )
                }
                if (app !is Apps.LedResistor) {
                    MobileAppCard(
                        appName = stringResource(id = R.string.view_our_apps_led_resistor),
                        appImage = R.drawable.resistor_feature_graphic,
                        context = context,
                        app = app,
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
