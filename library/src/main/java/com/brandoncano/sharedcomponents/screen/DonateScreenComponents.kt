package com.brandoncano.sharedcomponents.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.text.textStyleSubhead

@Composable
fun DonationChipGroup(
    selectedAmount: Int?,
    onAmountSelected: (Int) -> Unit
) {
    val donationAmounts = listOf(10, 5, 3, 2, 1)
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            donationAmounts.take(2).forEach { amount ->
                DonationChip(selectedAmount, onAmountSelected, amount)
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            donationAmounts.drop(2).forEach { amount ->
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
                style = textStyleSubhead()
            )
        },
        modifier = Modifier.padding(horizontal = 8.dp),
        shape = MaterialTheme.shapes.extraLarge,
        colors = AssistChipDefaults.assistChipColors(
            containerColor = if (selectedAmount == amount) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.surface
        )
    )
}
