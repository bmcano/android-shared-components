package com.brandoncano.sharedcomponents.screen

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.composables.AppCard
import com.brandoncano.sharedcomponents.data.Apps
import com.brandoncano.sharedcomponents.text.textStyleHeadline
import com.brandoncano.sharedcomponents.utils.OpenLink

@Composable
fun MobileAppCard(appName: String, appImage: Int, context: Context, app: Apps) {
    AppCard(
        modifier = Modifier
            .padding(top = 12.dp)
            .clickable {
                OpenLink.execute(context, app.playstore)
            }
    ) {
        Image(
            painter = painterResource(id = appImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = appName,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                style = textStyleHeadline(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Image(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = null,
                modifier = Modifier.padding(16.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
            )
        }
    }
}

@Preview
@Composable
fun MobileAppPreview() {
    Column {
        MobileAppCard(
            "Resistor Color Code Calculator",
            R.drawable.resistor_feature_graphic,
            LocalContext.current,
            Apps.Resistor
        )
    }
}
