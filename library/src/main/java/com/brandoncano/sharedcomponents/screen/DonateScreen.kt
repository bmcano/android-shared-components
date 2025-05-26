package com.brandoncano.sharedcomponents.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.composables.AppButton
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppTopAppBar
import com.brandoncano.sharedcomponents.composables.BottomScreenSpacer
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleBody
import com.brandoncano.sharedcomponents.text.textStyleHeadline
import com.brandoncano.sharedcomponents.text.textStyleSubhead

@Composable
fun DonateScreen(
    onNavigateBack: () -> Unit,
    onContinueToPaymentTapped: (Int) -> Unit,
    snackbarHostState: SnackbarHostState,
) {
    var selectedAmount by remember { mutableStateOf<Int?>(null) }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        topBar = {
            AppTopAppBar(
                titleText = stringResource(R.string.donate_title),
                navigationIcon = Icons.Filled.Close,
                onNavigateBack = onNavigateBack,
            )
        },
        contentWindowInsets = WindowInsets.safeDrawing,
    ) { paddingValues ->
        DonateScreenContent(
            paddingValues = paddingValues,
            selectedAmount = selectedAmount,
            onAmountSelected = { amount -> selectedAmount = amount },
            onContinueToPaymentTapped = onContinueToPaymentTapped
        )
    }
}

@Composable
private fun DonateScreenContent(
    paddingValues: PaddingValues,
    selectedAmount: Int?,
    onAmountSelected: (Int) -> Unit,
    onContinueToPaymentTapped: (Int) -> Unit,
) {
    val sidePadding = dimensionResource(R.dimen.app_side_padding)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)
            .padding(horizontal = sidePadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        DonationHeroImage()
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(R.string.donate_body_text),
            modifier = Modifier.align(Alignment.Start),
            style = textStyleBody().onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(R.string.donate_headline_text),
            modifier = Modifier.align(Alignment.Start),
            style = textStyleHeadline().onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(12.dp))
        DonationChipGroup(
            selectedAmount = selectedAmount,
            onAmountSelected = onAmountSelected,
        )
        AppButton(
            label = stringResource(R.string.donate_purchase_button),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            enabled = selectedAmount != null,
            onClick = { onContinueToPaymentTapped(selectedAmount ?: 0) }
        )
        Text(
            text = stringResource(R.string.donate_footer_text),
            modifier = Modifier.align(Alignment.Start),
            style = textStyleSubhead().onSurfaceVariant(),
        )
        BottomScreenSpacer()
    }
}

@AppScreenPreviews
@Composable
private fun DonateScreenPreview() {
    DonateScreen(
        onNavigateBack = {},
        onContinueToPaymentTapped = {},
        snackbarHostState = SnackbarHostState(),
    )
}
