package com.brandoncano.sharedcomponents.data

import android.content.Context
import androidx.core.content.edit

enum class ThemePreferences(private val _name: String, private val _key: String) {

    THEME_PREFERENCE("app_settings", "theme_preference");

    fun saveIntData(context: Context, input: Int) {
        val sharedPreferences = context.getSharedPreferences(_name, Context.MODE_PRIVATE)
        sharedPreferences.edit {
            putInt(_key, input)
        }
    }

    fun loadIntData(context: Context): Int {
        val sharedPreferences = context.getSharedPreferences(_name, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(_key, 0) // Default to 0 (SYSTEM_DEFAULT)
    }
}
