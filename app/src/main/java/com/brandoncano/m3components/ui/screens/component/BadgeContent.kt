package com.brandoncano.m3components.ui.screens.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.m3components.R
import com.brandoncano.m3components.navigation.Component
import com.brandoncano.m3components.ui.theme.M3ComponentsTheme
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.m3.M3LargeBadge
import com.brandoncano.sharedcomponents.m3.M3SmallBadge
import com.brandoncano.sharedcomponents.text.onSurfaceVariant

@Composable
fun BadgeContent() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Text(
            text = stringResource(R.string.badges_overview_title),
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.badges_description1),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.badges_description2),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(24.dp))
        BadgeExample()
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.badges_footnote),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
private fun BadgeExample() {
    NavigationBar(windowInsets = WindowInsets(0)) {
        NavigationBarItem(
            icon = {
                BadgedBox(
                    badge = { M3SmallBadge() },
                    content = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null,
                        )
                    },
                )
            },
            label = { Text(text = stringResource(R.string.badges_small)) },
            selected = false,
            onClick = {},
        )
        NavigationBarItem(
            icon = {
                BadgedBox(
                    badge = { M3LargeBadge(1) },
                    content = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null,
                        )
                    }
                )
            },
            label = { Text(text = stringResource(R.string.badges_large)) },
            selected = false,
            onClick = {},
        )
        NavigationBarItem(
            icon = {
                BadgedBox(
                    badge = { M3LargeBadge(1000) },
                    content = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null,
                        )
                    }
                )
            },
            label = { Text(text = stringResource(R.string.badges_large)) },
            selected = false,
            onClick = {},
        )
    }
}

@AppScreenPreviews
@Composable
private fun BadgePreview() {
    M3ComponentsTheme {
        ComponentScreen(
            component = Component.BADGE,
            onNavigateBack = {},
            onExampleTapped = {},
        )
    }
}
