package com.brandoncano.m3components.ui.screens.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Grade
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.m3components.R
import com.brandoncano.sharedcomponents.composables.AppArrowCardButton
import com.brandoncano.sharedcomponents.data.ArrowCardButtonContents
import com.brandoncano.sharedcomponents.m3.M3Divider
import com.brandoncano.sharedcomponents.m3.M3OutlinedCard
import com.brandoncano.sharedcomponents.text.textStyleHeadline

@Composable
fun AppInformationCard(version: String, lastUpdated: String) {
    M3OutlinedCard {
        ListItem(
            headlineContent = {
                Text(
                    text = stringResource(R.string.about_created_by),
                )

            },
            supportingContent = {
                Text(
                    text = stringResource(R.string.about_author),
                )
            },
            leadingContent = {
                Image(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
                )
            }
        )
        M3Divider(insetPadding = 16.dp)
        ListItem(
            headlineContent = {
                Text(
                    text = stringResource(R.string.about_app_version),
                )
            },
            supportingContent = {
                Text(
                    text = version
                )
            },
            leadingContent = {
                Image(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
                )
            }
        )
        M3Divider(insetPadding = 16.dp)
        ListItem(
            headlineContent = {
                Text(
                    text = stringResource(R.string.about_last_updated_on),
                )
            },
            supportingContent = {
                Text(
                    text = lastUpdated
                )
            },
            leadingContent = {
                Image(
                    imageVector = Icons.Outlined.History,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
                )
            }
        )
    }
}

@Composable
fun OurAppsButtons(
    onRateThisAppTapped: () -> Unit,
    onViewOurAppsTapped: () -> Unit,
    onDonateTapped: () -> Unit,
) {
    Column {
        Text(
            text = stringResource(id = R.string.about_support_us_header),
            modifier = Modifier.align(Alignment.Start),
            style = textStyleHeadline(),
        )
        Spacer(modifier = Modifier.height(12.dp))
        // TODO - rewrite in M3 styles
        AppArrowCardButton(
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Grade,
                text = stringResource(id = R.string.about_rate_us),
                onClick = onRateThisAppTapped,
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Apps,
                text = stringResource(id = R.string.about_view_apps),
                onClick = onViewOurAppsTapped,
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.FavoriteBorder,
                text = stringResource(R.string.about_donate),
                onClick = onDonateTapped,
            ),
        )
    }
}
