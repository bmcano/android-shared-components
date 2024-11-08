package com.brandoncano.sharedcomponents.data

enum class ThemeMode(val value: Int, val displayText: String) {

    SYSTEM_DEFAULT(0, "System default"),
    LIGHT(1, "Light theme"),
    DARK(2, "Dark theme");

    @Suppress("unused") // unused in library files, but used in apps
    companion object {
        fun fromValue(value: Int): ThemeMode {
            return entries.find { it.value == value } ?: SYSTEM_DEFAULT
        }
    }
}