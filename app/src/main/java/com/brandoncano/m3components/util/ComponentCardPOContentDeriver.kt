package com.brandoncano.m3components.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Label
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.automirrored.outlined.ViewSidebar
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.CheckBox
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.ExpandLess
import androidx.compose.material.icons.outlined.HorizontalRule
import androidx.compose.material.icons.outlined.IncompleteCircle
import androidx.compose.material.icons.outlined.MarkEmailUnread
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Navigation
import androidx.compose.material.icons.outlined.RadioButtonChecked
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Square
import androidx.compose.material.icons.outlined.Tab
import androidx.compose.material.icons.outlined.ToggleOn
import androidx.compose.material.icons.outlined.TouchApp
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material.icons.outlined.ViewWeek
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
                icon = Icons.Outlined.MarkEmailUnread,
                titleRes = R.string.component_badge_title,
                descRes = R.string.component_badge_desc
            )
            Component.BOTTOM_APP_BAR -> ComponentCardPO(
                component = Component.BOTTOM_APP_BAR,
                icon = Icons.Default.Menu, // Unsure
                titleRes = R.string.component_bottom_app_bar_title,
                descRes = R.string.component_bottom_app_bar_desc
            )
            Component.BOTTOM_SHEET -> ComponentCardPO(
                component = Component.BOTTOM_SHEET,
                icon = Icons.Outlined.ExpandLess,
                titleRes = R.string.component_bottom_sheet_title,
                descRes = R.string.component_bottom_sheet_desc
            )
            Component.BUTTONS -> ComponentCardPO(
                component = Component.BUTTONS,
                icon = Icons.Outlined.TouchApp,
                titleRes = R.string.component_buttons_title,
                descRes = R.string.component_buttons_desc,
                relatedItems = listOf(Component.EXTENDED_FAB, Component.FAB),
            )
            Component.CARDS -> ComponentCardPO(
                component = Component.CARDS,
                icon = Icons.Outlined.Square,
                titleRes = R.string.component_cards_title,
                descRes = R.string.component_cards_desc
            )
            Component.CHECKBOX -> ComponentCardPO(
                component = Component.CHECKBOX,
                icon = Icons.Outlined.CheckBox,
                titleRes = R.string.component_checkbox_title,
                descRes = R.string.component_checkbox_desc,
                relatedItems = listOf(Component.RADIO_BUTTON, Component.SWITCH),
            )
            Component.CHIPS -> ComponentCardPO(
                component = Component.CHIPS,
                icon = Icons.AutoMirrored.Outlined.Label,
                titleRes = R.string.component_chips_title,
                descRes = R.string.component_chips_desc
            )
            Component.DATE_PICKER -> ComponentCardPO(
                component = Component.DATE_PICKER,
                icon = Icons.Outlined.DateRange,
                titleRes = R.string.component_date_picker_title,
                descRes = R.string.component_date_picker_desc,
                relatedItems = listOf(Component.TIME_PICKER),
            )
            Component.DIALOGS -> ComponentCardPO(
                component = Component.DIALOGS,
                icon = Icons.Default.Info, // unsure
                titleRes = R.string.component_dialogs_title,
                descRes = R.string.component_dialogs_desc
            )
            Component.DIVIDERS -> ComponentCardPO(
                component = Component.DIVIDERS,
                icon = Icons.Outlined.HorizontalRule,
                titleRes = R.string.component_dividers_title,
                descRes = R.string.component_dividers_desc
            )
            Component.EXTENDED_FAB -> ComponentCardPO(
                component = Component.EXTENDED_FAB,
                icon = Icons.Outlined.AddCircle, // this but actually outlined?
                titleRes = R.string.component_extended_fab_title,
                descRes = R.string.component_extended_fab_desc,
                relatedItems = listOf(Component.BUTTONS, Component.FAB),
            )
            Component.FAB -> ComponentCardPO(
                component = Component.FAB,
                icon = Icons.Default.Add, // might be better option
                titleRes = R.string.component_fab_title,
                descRes = R.string.component_fab_desc,
                relatedItems = listOf(Component.EXTENDED_FAB, Component.ICON_BUTTONS),
            )
            Component.ICON_BUTTONS -> ComponentCardPO(
                component = Component.ICON_BUTTONS,
                icon = Icons.Outlined.TouchApp,
                titleRes = R.string.component_icon_buttons_title,
                descRes = R.string.component_icon_buttons_desc,
                relatedItems = listOf(Component.BUTTONS, Component.FAB),
            )
            Component.LISTS -> ComponentCardPO(
                component = Component.LISTS,
                icon = Icons.AutoMirrored.Outlined.List,
                titleRes = R.string.component_lists_title,
                descRes = R.string.component_lists_desc
            )
            Component.MENUS -> ComponentCardPO(
                component = Component.MENUS,
                icon = Icons.Outlined.MoreVert,
                titleRes = R.string.component_menus_title,
                descRes = R.string.component_menus_desc
            )
            Component.NAVIGATION_BAR -> ComponentCardPO(
                component = Component.NAVIGATION_BAR,
                icon = Icons.Outlined.Navigation,
                titleRes = R.string.component_navigation_bar_title,
                descRes = R.string.component_navigation_bar_desc,
                relatedItems = listOf(Component.NAVIGATION_DRAWER, Component.NAVIGATION_RAIL),
            )
            Component.NAVIGATION_DRAWER -> ComponentCardPO(
                component = Component.NAVIGATION_DRAWER,
                icon = Icons.Outlined.Menu,
                titleRes = R.string.component_navigation_drawer_title,
                descRes = R.string.component_navigation_drawer_desc,
                relatedItems = listOf(Component.NAVIGATION_BAR, Component.NAVIGATION_RAIL),
            )
            Component.NAVIGATION_RAIL -> ComponentCardPO(
                component = Component.NAVIGATION_RAIL,
                icon = Icons.AutoMirrored.Outlined.ViewSidebar,
                titleRes = R.string.component_navigation_rail_title,
                descRes = R.string.component_navigation_rail_desc,
                relatedItems = listOf(Component.NAVIGATION_BAR, Component.NAVIGATION_DRAWER),
            )
            Component.PROGRESS_INDICATORS -> ComponentCardPO(
                component = Component.PROGRESS_INDICATORS,
                icon = Icons.Outlined.IncompleteCircle,
                titleRes = R.string.component_progress_indicators_title,
                descRes = R.string.component_progress_indicators_desc
            )
            Component.RADIO_BUTTON -> ComponentCardPO(
                component = Component.RADIO_BUTTON,
                icon = Icons.Outlined.RadioButtonChecked,
                titleRes = R.string.component_radio_button_title,
                descRes = R.string.component_radio_button_desc,
                relatedItems = listOf(Component.CHECKBOX, Component.SWITCH),
            )
            Component.SEARCH_BAR -> ComponentCardPO(
                component = Component.SEARCH_BAR,
                icon = Icons.Outlined.Search,
                titleRes = R.string.component_search_bar_title,
                descRes = R.string.component_search_bar_desc,
                relatedItems = listOf(Component.BOTTOM_APP_BAR, Component.TOP_APP_BAR),
            )
            Component.SEGMENTED_BUTTON -> ComponentCardPO(
                component = Component.SEGMENTED_BUTTON,
                icon = Icons.Outlined.ViewWeek,
                titleRes = R.string.component_segmented_button_title,
                descRes = R.string.component_segmented_button_desc
            )
            Component.SLIDERS -> ComponentCardPO(
                component = Component.SLIDERS,
                icon = Icons.Outlined.Tune,
                titleRes = R.string.component_sliders_title,
                descRes = R.string.component_sliders_desc
            )
            Component.SNACKBARS -> ComponentCardPO(
                component = Component.SNACKBARS,
                icon = Icons.Default.Info, // unsure
                titleRes = R.string.component_snackbars_title,
                descRes = R.string.component_snackbars_desc
            )
            Component.SWITCH -> ComponentCardPO(
                component = Component.SWITCH,
                icon = Icons.Outlined.ToggleOn,
                titleRes = R.string.component_switch_title,
                descRes = R.string.component_switch_desc,
                relatedItems = listOf(Component.CHECKBOX, Component.RADIO_BUTTON),
            )
            Component.TABS -> ComponentCardPO(
                component = Component.TABS,
                icon = Icons.Outlined.Tab,
                titleRes = R.string.component_tabs_title,
                descRes = R.string.component_tabs_desc
            )
            Component.TEXT_FIELDS -> ComponentCardPO(
                component = Component.TEXT_FIELDS,
                icon = Icons.Outlined.Edit,
                titleRes = R.string.component_text_fields_title,
                descRes = R.string.component_text_fields_desc
            )
            Component.TIME_PICKER -> ComponentCardPO(
                component = Component.TIME_PICKER,
                icon = Icons.Outlined.AccessTime,
                titleRes = R.string.component_time_picker_title,
                descRes = R.string.component_time_picker_desc,
                relatedItems = listOf(Component.DATE_PICKER),
            )
            Component.TOP_APP_BAR -> ComponentCardPO(
                component = Component.TOP_APP_BAR,
                icon = Icons.Outlined.Menu,
                titleRes = R.string.component_top_app_bar_title,
                descRes = R.string.component_top_app_bar_desc,
                relatedItems = listOf(Component.BOTTOM_APP_BAR, Component.SEARCH_BAR),
            )
        }
    }
}
