package com.brandoncano.sharedcomponents.composables

import android.content.Context
import android.graphics.Picture
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.Feedback
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.text.onSurfaceVariant
import com.brandoncano.sharedcomponents.text.textStyleBody
import com.brandoncano.sharedcomponents.utils.ComposableToBitmap
import com.brandoncano.sharedcomponents.utils.SaveBitmap
import com.brandoncano.sharedcomponents.utils.SendFeedback
import com.brandoncano.sharedcomponents.utils.ShareImage
import com.brandoncano.sharedcomponents.utils.ShareText

/**
 * Note: Menu items are in alphabetical order
 */

@Composable
fun ClearSelectionsMenuItem(onClick: (() -> Unit)) {
    DropdownMenuItem(
        text = { MenuText(stringRes = R.string.menu_clear_selections) },
        onClick = onClick,
        leadingIcon = { MenuIcon(Icons.Outlined.Cancel) },
    )
}

@Composable
fun FeedbackMenuItem(context: Context, app: String, showMenu: MutableState<Boolean>) {
    DropdownMenuItem(
        text = { MenuText(stringRes = R.string.menu_feedback) },
        onClick = {
            showMenu.value = false
            SendFeedback.execute(context, app)
        },
        leadingIcon = { MenuIcon(Icons.Outlined.Feedback) },
    )
}

@Composable
fun ShareImageMenuItem(
    context: Context,
    applicationId: String,
    showMenu: MutableState<Boolean>,
    picture: Picture,
) {
    DropdownMenuItem(
        text = { MenuText(stringRes = R.string.menu_share_image) },
        onClick = {
            showMenu.value = false
            val bitmap = ComposableToBitmap.execute(picture)
            val uri = SaveBitmap.execute(bitmap, context, "$applicationId.provider") ?: return@DropdownMenuItem
            ShareImage.execute(uri, context)
        },
        leadingIcon = { MenuIcon(Icons.Outlined.Image) },
    )
}

@Composable
fun ShareTextMenuItem(context: Context, text: String, showMenu: MutableState<Boolean>) {
    DropdownMenuItem(
        text = { MenuText(stringRes = R.string.menu_share_text) },
        onClick = {
            showMenu.value = false
            ShareText.execute(context, text)
        },
        leadingIcon = { MenuIcon(Icons.Outlined.Share) },
    )
}

@Composable
fun MenuText(@StringRes stringRes: Int) {
    Text(
        text = stringResource(id = stringRes),
        style = textStyleBody().onSurfaceVariant(),
    )
}

@Composable
fun MenuIcon(imageVector: ImageVector) {
    Image(
        imageVector = imageVector,
        contentDescription = null,
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant)
    )
}

@AppComponentPreviews
@Composable
private fun MenuItemsPreview() {
    val showMenu = remember { mutableStateOf(false) }
    Column {
        ClearSelectionsMenuItem { }
        FeedbackMenuItem(LocalContext.current, "app", showMenu)
        ShareImageMenuItem(LocalContext.current, "applicationId", showMenu, Picture())
        ShareTextMenuItem(LocalContext.current, "text", showMenu)
    }
}
