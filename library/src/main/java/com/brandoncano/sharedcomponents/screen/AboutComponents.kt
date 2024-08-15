package com.brandoncano.sharedcomponents.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.composables.AppComponentPreviews
import com.brandoncano.sharedcomponents.composables.AppDivider
import com.brandoncano.sharedcomponents.composables.AppStandardCard
import com.brandoncano.sharedcomponents.text.textStyleBody
import com.brandoncano.sharedcomponents.text.textStyleHeadline

@Composable
fun AuthorCard() {
    AppStandardCard {
        HeadlineBodyStack(
            label = R.string.about_created_by,
            body = R.string.about_author,
        )
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
fun AppInfoCard(@StringRes version: Int, @StringRes lastUpdated: Int) {
    AppStandardCard {
        HeadlineBodyStack(
            label = R.string.about_app_version,
            body = version,
        )
        AppDivider(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp))
        HeadlineBodyStack(
            label = R.string.about_last_updated_on,
            body = lastUpdated,
        )
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
private fun HeadlineBodyStack(@StringRes label: Int, @StringRes body: Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(id = label),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp),
            style = textStyleHeadline(),
        )
        Text(
            text = stringResource(id = body),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp),
            style = textStyleBody(),
        )
    }
}

@AppComponentPreviews
@Composable
private fun HeadlineBodyStackPreview() {
    Column(modifier = Modifier.height(64.dp)) {
        HeadlineBodyStack(
            label = R.string.about_created_by,
            body = R.string.about_author,
        )
    }
}

@AppComponentPreviews
@Composable
private fun AuthorCardPreview() {
    Column(modifier = Modifier.height(84.dp)) {
        AuthorCard()
    }
}

