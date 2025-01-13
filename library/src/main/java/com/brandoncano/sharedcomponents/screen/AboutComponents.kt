package com.brandoncano.sharedcomponents.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Grade
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.composables.AppArrowCardButton
import com.brandoncano.sharedcomponents.composables.AppCard
import com.brandoncano.sharedcomponents.composables.AppComponentPreviews
import com.brandoncano.sharedcomponents.composables.AppStandardDivider
import com.brandoncano.sharedcomponents.data.ArrowCardButtonContents
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleBody
import com.brandoncano.sharedcomponents.text.textStyleHeadline

@AppComponentPreviews
@Composable
fun AuthorCard() {
    AppCard {
        Row {
            Image(
                imageVector = Icons.Outlined.Person,
                contentDescription = null,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant)
            )
            HeadlineBodyStack(
                label = R.string.about_created_by,
                body = R.string.about_author,
            )
        }
    }
}

@Composable
fun AppInfoCard(@StringRes version: Int, @StringRes lastUpdated: Int) {
    AppCard {
        Row {
            Image(
                imageVector = Icons.Outlined.Info,
                contentDescription = null,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant)
            )
            HeadlineBodyStack(
                label = R.string.about_app_version,
                body = version,
            )
        }
        AppStandardDivider()
        Row {
            Image(
                imageVector = Icons.Outlined.History,
                contentDescription = null,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant)
            )
            HeadlineBodyStack(
                label = R.string.about_last_updated_on,
                body = lastUpdated,
            )
        }
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
            text = stringResource(id = R.string.support_us_header_text),
            modifier = Modifier.align(Alignment.Start),
            style = textStyleHeadline(),
        )
        Spacer(modifier = Modifier.height(12.dp))
        AppArrowCardButton(
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Grade,
                text = stringResource(id = R.string.support_us_rate_us),
                onClick = onRateThisAppTapped,
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.Apps,
                text = stringResource(id = R.string.support_us_view_apps),
                onClick = onViewOurAppsTapped,
            ),
            ArrowCardButtonContents(
                imageVector = Icons.Outlined.FavoriteBorder,
                text = stringResource(R.string.support_us_donate),
                onClick = onDonateTapped,
            ),
        )
    }
}

@Composable
private fun HeadlineBodyStack(@StringRes label: Int, @StringRes body: Int) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = stringResource(id = label),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
            style = textStyleHeadline().onSurfaceVariant(),
        )
        Text(
            text = stringResource(id = body),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp),
            style = textStyleBody().onSurfaceVariant(),
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@AppComponentPreviews
@Composable
private fun AppInfoCardPreview() {
    Column {
        AppInfoCard(version = R.string.view_our_apps_title, lastUpdated = R.string.view_our_apps_title)
    }
}

@AppComponentPreviews
@Composable
private fun OurAppsButtonsPreview() {
    OurAppsButtons(
        onRateThisAppTapped = {},
        onViewOurAppsTapped = {},
        onDonateTapped = {},
    )
}
