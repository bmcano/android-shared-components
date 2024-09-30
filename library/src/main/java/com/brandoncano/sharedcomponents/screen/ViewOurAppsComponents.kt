package com.brandoncano.sharedcomponents.screen

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.composables.AppCard
import com.brandoncano.sharedcomponents.data.Apps
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleHeadline
import com.brandoncano.sharedcomponents.text.textStyleSubhead
import com.brandoncano.sharedcomponents.utils.OpenLink

@Composable
fun MobileAppFeatureCard(appImage: Int, context: Context, app: Apps) {
    AppCard(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .clickable {
                OpenLink.execute(context, app.playstore)
            }
    ) {
        Image(
            painter = painterResource(id = appImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 172.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(id = R.string.view_our_apps_rate_this_app),
                modifier = Modifier.padding(start = 16.dp),
                style = textStyleHeadline().onSurfaceVariant(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Image(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
            )
        }
    }
}

@Composable
fun MobileAppCard(appName: String, subtext: String, appImage: Int, context: Context, app: Apps) {
    AppCard(
        modifier = Modifier
            .padding(top = 12.dp)
            .clickable { OpenLink.execute(context, app.playstore) }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Image(
                painter = painterResource(id = appImage),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(16.dp)),
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = appName,
                    modifier = Modifier.padding(top = 12.dp),
                    style = textStyleHeadline().onSurfaceVariant(),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = subtext,
                    modifier = Modifier.padding(top = 4.dp),
                    style = textStyleSubhead().onSurfaceVariant(),
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = TextUnit(16.0f, TextUnitType.Sp),
                    maxLines = 2,
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 12.dp, end = 16.dp)
                    .size(24.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
            )
        }
    }
}

@Preview
@Composable
fun MobileAppPreview() {
    Column {
        MobileAppFeatureCard(
            R.drawable.resistor_feature_graphic,
            LocalContext.current,
            Apps.Resistor
        )
        MobileAppCard(
            "Resistor Color Code Calculator",
            "Released June 19th, 2022",
            R.drawable.resistor_playstore,
            LocalContext.current,
            Apps.Resistor
        )
    }
}
