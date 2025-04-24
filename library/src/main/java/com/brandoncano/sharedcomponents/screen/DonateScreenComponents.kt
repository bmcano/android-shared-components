package com.brandoncano.sharedcomponents.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.VolunteerActivism
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.composables.AppComponentPreviews
import com.brandoncano.sharedcomponents.text.textStyleSubhead

@AppComponentPreviews
@Composable
fun DonationHeroImage() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(128.dp)
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(Color(0xFFFFC1C1), Color(0xFFFFCDD2), Color(0xFFE57373))
                ),
                shape = CircleShape,
            ),
    ) {
        Icon(
            imageVector = Icons.Rounded.VolunteerActivism,
            contentDescription = stringResource(R.string.donate_title),
            tint = Color(0xFFFEFEFA),
            modifier = Modifier.size(80.dp),
        )
    }
}

@Composable
fun DonationChipGroup(
    selectedAmount: Int?,
    onAmountSelected: (Int) -> Unit
) {
    val donationAmounts = listOf(1, 2, 3, 5, 10)
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            donationAmounts.forEach { amount ->
                DonationChip(selectedAmount, onAmountSelected, amount)
            }
        }
    }
}

@Composable
private fun DonationChip(
    selectedAmount: Int?,
    onAmountSelected: (Int) -> Unit,
    amount: Int,
) {
    AssistChip(
        onClick = { onAmountSelected(amount) },
        label = {
            Text(
                text = "$amount USD",
                modifier = Modifier.padding(horizontal = 4.dp),
                style = textStyleSubhead()
            )
        },
        modifier = Modifier.padding(horizontal = 0.dp),
        shape = MaterialTheme.shapes.extraLarge,
        colors = AssistChipDefaults.assistChipColors(
            containerColor = if (selectedAmount == amount) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.surface
        )
    )
}
