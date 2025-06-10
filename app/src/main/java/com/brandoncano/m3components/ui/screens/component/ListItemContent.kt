package com.brandoncano.m3components.ui.screens.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.m3components.R
import com.brandoncano.m3components.navigation.Component
import com.brandoncano.m3components.ui.theme.M3ComponentsTheme
import com.brandoncano.sharedcomponents.composables.AppScreenPreviews
import com.brandoncano.sharedcomponents.m3.M3Divider
import com.brandoncano.sharedcomponents.m3.M3ListItem
import com.brandoncano.sharedcomponents.text.onSurfaceVariant

@Composable
fun ListItemContent() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Text(
            text = stringResource(R.string.list_overview_title),
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.list_description1),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.list_description2),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
        M3Divider(modifier = Modifier.padding(top = 16.dp))
        M3ListItem(
            headlineText = stringResource(R.string.list_example1),
            leadingContent = {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = null,
                )
            },
            trailingContent = {
                Text(text = stringResource(R.string.list_example7))
            },
        )
        M3Divider()
        M3ListItem(
            headlineText = stringResource(R.string.list_example2),
            supportingText = stringResource(R.string.list_example4),
            leadingContent = {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = null,
                )
            },
            trailingContent = {
                Text(text = stringResource(R.string.list_example7))
            },
        )
        M3Divider()
        M3ListItem(
            headlineText = stringResource(R.string.list_example3),
            supportingText = stringResource(R.string.list_example5),
            leadingContent = {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = null,
                )
            },
            trailingContent = {
                Text(text = stringResource(R.string.list_example7))
            },
        )
        M3Divider()
        M3ListItem(
            headlineText = stringResource(R.string.list_example3),
            overlineText = stringResource(R.string.list_example6),
            supportingText = stringResource(R.string.list_example4),
            leadingContent = {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = null,
                )
            },
            trailingContent = {
                Text(text = stringResource(R.string.list_example7))
            },
        )
        M3Divider(modifier = Modifier.padding(bottom = 16.dp))
        Text(
            text = stringResource(R.string.list_description3),
            style = MaterialTheme.typography.bodyMedium.onSurfaceVariant(),
        )
    }
}

@AppScreenPreviews
@Composable
private fun ListItemPreview() {
    M3ComponentsTheme {
        ComponentScreen(
            component = Component.LISTS,
            onNavigateBack = {},
            onExampleTapped = {},
        )
    }
}
