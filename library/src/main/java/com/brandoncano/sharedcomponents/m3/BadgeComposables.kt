package com.brandoncano.sharedcomponents.m3

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.brandoncano.sharedcomponents.R
import com.brandoncano.sharedcomponents.composables.AppComponentPreviews

// https://m3.material.io/components/badges/overview
// https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#Badge(androidx.compose.ui.Modifier,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,kotlin.Function1)

/**
 * A minimal "dot" badge indicating a notification or status without a number.
 *
 * This should be placed in a [BadgedBox] for proper usage.
 */
@Composable
fun M3SmallBadge() {
    val cd = stringResource(R.string.badge_cd)
    Badge(
        modifier = Modifier.semantics { contentDescription = cd },
    )
}

/**
 * A badge that displays a numeric count up to a specified value.
 *
 * This should be placed in a [BadgedBox] for proper usage.
 *
 * @param number The count to display; if less than 1, no badge is shown.
 * @param plusValue The maximum value before displaying "num+"; clamped between 1 and 999.
 * For example, if number = 150 and plusValue = 99, the badge shows "99+".
 */
@Composable
fun M3LargeBadge(
    number: Int = 1,
    plusValue: Int = 999,
) {
    if (number <= 0) return
    val safeThreshold = plusValue.coerceIn(1, 999)
    val displayString = if (number > safeThreshold) "${safeThreshold}+" else number.toString()
    val cd = stringResource(R.string.badge_cd)
    Badge(
        modifier = Modifier.semantics { contentDescription = cd },
    ) {
        Text(
            text = displayString,
        )
    }
}

@AppComponentPreviews
@Composable
private fun BadgePreview() {
    NavigationBar {
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
            selected = false,
            onClick = {},
        )
        NavigationBarItem(
            icon = {
                BadgedBox(
                    badge = { M3LargeBadge(999, 99) },
                    content = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null,
                        )
                    }
                )
            },
            selected = false,
            onClick = {},
        )
    }
}
