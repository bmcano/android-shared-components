package com.brandoncano.m3components.ui.screens.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.m3components.R
import com.brandoncano.m3components.navigation.Component
import com.brandoncano.m3components.ui.theme.M3ComponentsTheme
import com.brandoncano.sharedcomponents.composables.AppLongScreenPreview
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.m3.FullHeightVerticalDivider
import com.brandoncano.sharedcomponents.m3.FullWidthDivider
import com.brandoncano.sharedcomponents.m3.M3Divider
import com.brandoncano.sharedcomponents.m3.M3VerticalDivider
import com.brandoncano.sharedcomponents.text.onSurfaceVariant

@Composable
fun DividerContent() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Text(
            text = stringResource(R.string.dividers_overview_title),
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.dividers_overview_body1),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(R.string.dividers_overview_body2),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(R.string.dividers_overview_body3),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(R.string.dividers_full_width),
            style = MaterialTheme.typography.titleMedium,
        )
        FullWidthDivider()
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(R.string.dividers_inset),
            style = MaterialTheme.typography.titleMedium,
        )
        M3Divider(insetPadding = 32.dp)
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.dividers_full_height_vertical),
                style = MaterialTheme.typography.titleMedium
            )
            FullHeightVerticalDivider()
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .border(border = BorderStroke(width = 4.dp, color = MaterialTheme.colorScheme.surfaceVariant)),
                contentAlignment = Alignment.Center
            ) {}
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.dividers_inset_vertical),
                style = MaterialTheme.typography.titleMedium
            )
            M3VerticalDivider(insetPadding = 16.dp)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .border(border = BorderStroke(width = 4.dp, color = MaterialTheme.colorScheme.surfaceVariant)),
                contentAlignment = Alignment.Center
            ) {}
        }
    }
}

@AppScreenPreviews
@AppLongScreenPreview
@Composable
private fun ButtonContentPreview() {
    M3ComponentsTheme {
        ComponentScreen(
            component = Component.DIVIDERS,
            onNavigateBack = {},
            onExampleTapped = {},
        )
    }
}
