package com.brandoncano.sharedcomponents.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.VolunteerActivism
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.composables.AppButton
import com.brandoncano.sharedcomponents.composables.PurchaseResultDialog
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.composables.AppTopAppBar
import com.brandoncano.sharedcomponents.data.PurchaseStatus
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleBody
import com.brandoncano.sharedcomponents.text.textStyleHeadline
import com.brandoncano.sharedcomponents.utils.GetProductIdForAmount

@Composable
fun DonateScreen(
    onNavigateBack: () -> Unit,
    onContinueToPaymentTapped: (String) -> Unit,
    purchaseStatus: PurchaseStatus,
) {
    var selectedAmount by remember { mutableStateOf<Int?>(null) }
    var showThankYouDialog by remember { mutableStateOf(purchaseStatus == PurchaseStatus.SUCCESS) }
    if (showThankYouDialog) {
        PurchaseResultDialog{
            showThankYouDialog = false
            selectedAmount = null
        }
    }

    Scaffold(
        topBar = {
            AppTopAppBar(
                titleText = stringResource(R.string.donate_title),
                navigationIcon = Icons.Filled.Close,
                onNavigateBack = onNavigateBack,
            )
        },
        bottomBar = {
            val sidePadding = dimensionResource(R.dimen.app_side_padding)
            AppButton(
                label = stringResource(R.string.donate_purchase_button),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = sidePadding)
                    .padding(vertical = 24.dp),
                enabled = selectedAmount != null,
            ) {
                val productId = GetProductIdForAmount.execute(selectedAmount ?: 0)
                onContinueToPaymentTapped(productId)
                showThankYouDialog = true
            }
        }
    ) { paddingValues ->
        DonateScreenContent(
            paddingValues = paddingValues,
            selectedAmount = selectedAmount,
            onAmountSelected = { amount -> selectedAmount = amount }
        )
    }
}

@Composable
private fun DonateScreenContent(
    paddingValues: PaddingValues,
    selectedAmount: Int?,
    onAmountSelected: (Int) -> Unit
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
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(128.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(Color(0xFFFFC1C1), Color(0xFFFFCDD2), Color(0xFFE57373))
                    ),
                    shape = CircleShape
                ),
        ) {
            Icon(
                imageVector = Icons.Rounded.VolunteerActivism,
                contentDescription = stringResource(R.string.donate_title),
                tint = Color(0xFFFEFEFA),
                modifier = Modifier.size(80.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(R.string.donate_body_text),
            style = textStyleBody().onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(R.string.donate_headline_text),
            style = textStyleHeadline().onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(12.dp))
        DonationChipGroup(
            selectedAmount = selectedAmount,
            onAmountSelected = onAmountSelected
        )
    }
}

@AppScreenPreviews
@Composable
private fun DonateScreenPreview() {
    DonateScreen(
        onNavigateBack = {},
        onContinueToPaymentTapped = {},
        purchaseStatus = PurchaseStatus.PENDING,
    )
}