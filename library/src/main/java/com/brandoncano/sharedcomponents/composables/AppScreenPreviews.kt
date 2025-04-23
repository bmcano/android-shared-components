package com.brandoncano.sharedcomponents.composables

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview("1_Standard", showBackground = true)
@Preview("2_Standard_Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
annotation class AppComponentPreviews

@AppComponentPreviews
@Preview("3_Standard_Landscape", showBackground = true, widthDp = 720, heightDp = 360)
@Preview("4_Large_Font", showBackground = true, fontScale = 2.0f)
@Preview("5_Tablet", showBackground = true, device = Devices.PIXEL_TABLET, group = "Tablet")
@Preview("6_Tablet_Portrait", showBackground = true, device = "spec:width=800dp,height=1200dp,dpi=240", group = "Tablet")
@Preview("7_Foldable", showBackground = true, device = Devices.PIXEL_FOLD)
annotation class AppScreenPreviews

@Preview("8_Tall_Phone", showBackground = true, heightDp = 2000)
annotation class AppLongScreenPreview

@Preview("9_Desktop", showBackground = true, device = "spec:width=1920dp,height=1080dp,dpi=160")
annotation class AppDesktopScreenPreview
