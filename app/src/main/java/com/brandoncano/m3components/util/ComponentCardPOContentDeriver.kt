package com.brandoncano.m3components.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Label
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.ViewSidebar
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LineWeight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tab
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.ViewWeek
import com.brandoncano.m3components.R
import com.brandoncano.m3components.navigation.Component
import com.brandoncano.m3components.to.ComponentCardPO

/**
 * Job: Defines the attributes for each component card.
 *
 * Reference: https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary
 */
object ComponentCardPOContentDeriver {

    fun execute(component: Component): ComponentCardPO {
        return when (component) {
            Component.BADGE -> ComponentCardPO(
                component = Component.BADGE,
                icon = Icons.Default.Badge,
                titleRes = R.string.component_badge_title,
                descRes = R.string.component_badge_desc
            )
            Component.BOTTOM_APP_BAR -> ComponentCardPO(
                component = Component.BOTTOM_APP_BAR,
                icon = Icons.Default.Menu,
                titleRes = R.string.component_bottom_app_bar_title,
                descRes = R.string.component_bottom_app_bar_desc
            )
            Component.BOTTOM_SHEET -> ComponentCardPO(
                component = Component.BOTTOM_SHEET,
                icon = Icons.Default.ExpandLess,
                titleRes = R.string.component_bottom_sheet_title,
                descRes = R.string.component_bottom_sheet_desc
            )
            Component.BUTTONS -> ComponentCardPO(
                component = Component.BUTTONS,
                icon = Icons.Default.TouchApp,
                titleRes = R.string.component_buttons_title,
                descRes = R.string.component_buttons_desc
            )
            Component.CARDS -> ComponentCardPO(
                component = Component.CARDS,
                icon = Icons.Default.CreditCard,
                titleRes = R.string.component_cards_title,
                descRes = R.string.component_cards_desc
            )
            Component.CHECKBOX -> ComponentCardPO(
                component = Component.CHECKBOX,
                icon = Icons.Default.CheckBox,
                titleRes = R.string.component_checkbox_title,
                descRes = R.string.component_checkbox_desc
            )
            Component.CHIPS -> ComponentCardPO(
                component = Component.CHIPS,
                icon = Icons.AutoMirrored.Filled.Label,
                titleRes = R.string.component_chips_title,
                descRes = R.string.component_chips_desc
            )
            Component.DATE_PICKER -> ComponentCardPO(
                component = Component.DATE_PICKER,
                icon = Icons.Default.DateRange,
                titleRes = R.string.component_date_picker_title,
                descRes = R.string.component_date_picker_desc
            )
            Component.DIALOGS -> ComponentCardPO(
                component = Component.DIALOGS,
                icon = Icons.Default.Info,
                titleRes = R.string.component_dialogs_title,
                descRes = R.string.component_dialogs_desc
            )
            Component.DIVIDERS -> ComponentCardPO(
                component = Component.DIVIDERS,
                icon = Icons.Default.LineWeight,
                titleRes = R.string.component_dividers_title,
                descRes = R.string.component_dividers_desc
            )
            Component.EXTENDED_FAB -> ComponentCardPO(
                component = Component.EXTENDED_FAB,
                icon = Icons.Default.AddCircle,
                titleRes = R.string.component_extended_fab_title,
                descRes = R.string.component_extended_fab_desc
            )
            Component.FAB -> ComponentCardPO(
                component = Component.FAB,
                icon = Icons.Default.Add,
                titleRes = R.string.component_fab_title,
                descRes = R.string.component_fab_desc
            )
            Component.ICON_BUTTONS -> ComponentCardPO(
                component = Component.ICON_BUTTONS,
                icon = Icons.Default.TouchApp,
                titleRes = R.string.component_icon_buttons_title,
                descRes = R.string.component_icon_buttons_desc
            )
            Component.LISTS -> ComponentCardPO(
                component = Component.LISTS,
                icon = Icons.AutoMirrored.Filled.List,
                titleRes = R.string.component_lists_title,
                descRes = R.string.component_lists_desc
            )
            Component.MENUS -> ComponentCardPO(
                component = Component.MENUS,
                icon = Icons.Default.MoreVert,
                titleRes = R.string.component_menus_title,
                descRes = R.string.component_menus_desc
            )
            Component.NAVIGATION_BAR -> ComponentCardPO(
                component = Component.NAVIGATION_BAR,
                icon = Icons.Default.Navigation,
                titleRes = R.string.component_navigation_bar_title,
                descRes = R.string.component_navigation_bar_desc
            )
            Component.NAVIGATION_DRAWER -> ComponentCardPO(
                component = Component.NAVIGATION_DRAWER,
                icon = Icons.Default.Menu,
                titleRes = R.string.component_navigation_drawer_title,
                descRes = R.string.component_navigation_drawer_desc
            )
            Component.NAVIGATION_RAIL -> ComponentCardPO(
                component = Component.NAVIGATION_RAIL,
                icon = Icons.AutoMirrored.Filled.ViewSidebar,
                titleRes = R.string.component_navigation_rail_title,
                descRes = R.string.component_navigation_rail_desc
            )
            Component.PROGRESS_INDICATORS -> ComponentCardPO(
                component = Component.PROGRESS_INDICATORS,
                icon = Icons.Default.Autorenew,
                titleRes = R.string.component_progress_indicators_title,
                descRes = R.string.component_progress_indicators_desc
            )
            Component.RADIO_BUTTON -> ComponentCardPO(
                component = Component.RADIO_BUTTON,
                icon = Icons.Default.RadioButtonChecked,
                titleRes = R.string.component_radio_button_title,
                descRes = R.string.component_radio_button_desc
            )
            Component.SEARCH_BAR -> ComponentCardPO(
                component = Component.SEARCH_BAR,
                icon = Icons.Default.Search,
                titleRes = R.string.component_search_bar_title,
                descRes = R.string.component_search_bar_desc
            )
            Component.SEGMENTED_BUTTON -> ComponentCardPO(
                component = Component.SEGMENTED_BUTTON,
                icon = Icons.Default.ViewWeek,
                titleRes = R.string.component_segmented_button_title,
                descRes = R.string.component_segmented_button_desc
            )
            Component.SLIDERS -> ComponentCardPO(
                component = Component.SLIDERS,
                icon = Icons.Default.Tune,
                titleRes = R.string.component_sliders_title,
                descRes = R.string.component_sliders_desc
            )
            Component.SNACKBARS -> ComponentCardPO(
                component = Component.SNACKBARS,
                icon = Icons.Default.Info,
                titleRes = R.string.component_snackbars_title,
                descRes = R.string.component_snackbars_desc
            )
            Component.SWITCH -> ComponentCardPO(
                component = Component.SWITCH,
                icon = Icons.Default.ToggleOn,
                titleRes = R.string.component_switch_title,
                descRes = R.string.component_switch_desc
            )
            Component.TABS -> ComponentCardPO(
                component = Component.TABS,
                icon = Icons.Default.Tab,
                titleRes = R.string.component_tabs_title,
                descRes = R.string.component_tabs_desc
            )
            Component.TEXT_FIELDS -> ComponentCardPO(
                component = Component.TEXT_FIELDS,
                icon = Icons.Default.Edit,
                titleRes = R.string.component_text_fields_title,
                descRes = R.string.component_text_fields_desc
            )
            Component.TIME_PICKER -> ComponentCardPO(
                component = Component.TIME_PICKER,
                icon = Icons.Default.AccessTime,
                titleRes = R.string.component_time_picker_title,
                descRes = R.string.component_time_picker_desc
            )
            Component.TOP_APP_BAR -> ComponentCardPO(
                component = Component.TOP_APP_BAR,
                icon = Icons.Default.Menu,
                titleRes = R.string.component_top_app_bar_title,
                descRes = R.string.component_top_app_bar_desc
            )
        }
    }
}
