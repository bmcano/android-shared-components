package com.brandoncano.m3components.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.brandoncano.m3components.R
import com.brandoncano.m3components.navigation.Component
import com.brandoncano.m3components.to.ComponentCardPO
import com.brandoncano.m3components.ui.theme.M3ComponentsTheme
import com.brandoncano.sharedcomponents.composables.AppComponentPreviews
import com.brandoncano.sharedcomponents.m3.M3OutlinedCard
import com.brandoncano.sharedcomponents.text.onSurfaceVariant

@Composable
fun ComponentOverviewCardContent(
    componentCardPO: ComponentCardPO,
    onComponentTapped: (Component) -> Unit,
) {
    Column(
        modifier = Modifier.clickable(
            role = Role.Button,
            onClick = { onComponentTapped(componentCardPO.component) },
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.05f))
                .padding(vertical = 48.dp),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = componentCardPO.icon,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = stringResource(id = componentCardPO.titleRes),
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(id = componentCardPO.descRes),
                style = MaterialTheme.typography.bodySmall.onSurfaceVariant(),
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@AppComponentPreviews
@Composable
private fun ComponentOverviewCardPreview() {
    M3ComponentsTheme {
        M3OutlinedCard(
            modifier = Modifier.padding(24.dp),
        ) {
            ComponentOverviewCardContent(
                componentCardPO = ComponentCardPO(
                    component = Component.CHECKBOX,
                    icon = Icons.Default.CheckBox,
                    titleRes = R.string.component_checkbox_title,
                    descRes = R.string.component_checkbox_desc,
                ),
                onComponentTapped = {},
            )
        }
    }
}
