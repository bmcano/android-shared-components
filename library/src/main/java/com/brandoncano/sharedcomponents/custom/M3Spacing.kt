package com.brandoncano.sharedcomponents.custom

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Material 3–inspired spacing values in dp.
 *
 * These can be used for margins, paddings, and general layout spacing
 * to stay consistent with Material 3 design guidelines.
 */
object M3Spacing {
    /** 4 dp: extremely tight gap (e.g., icon ↔ icon spacing, very minor tweaks) */
    val ExtraSmall: Dp = 4.dp

    /** 8 dp: standard “small” gap (e.g., padding inside a button, gap between list items) */
    val Small: Dp = 8.dp

    /** 12 dp: intermediate spacing (e.g., between headline and subhead, inset Divider) */
    val SmallMedium: Dp = 12.dp

    /** 16 dp: default “medium” gap (e.g., card padding, default container margins) */
    val Medium: Dp = 16.dp

    /** 24 dp: grouping related sections or larger separations (e.g., between form groups) */
    val Large: Dp = 24.dp

    /** 32 dp: very prominent separation (e.g., top of a hero image, section breaks) */
    val ExtraLarge: Dp = 32.dp

    /** 40 dp: wide padding, often used in tablet/desktop layouts */
    val XXLarge: Dp = 40.dp

    /** 48 dp: maximum standard gap (e.g., very spacious hero sections) */
    val XXXLarge: Dp = 48.dp
}