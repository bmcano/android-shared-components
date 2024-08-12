package com.brandoncano.sharedcomponents.utils

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

/**
 * Job: Open a web link based on a given URL
 */
object OpenLink {

    fun execute(context: Context, url: String) {
        try {
            val builder = CustomTabsIntent.Builder()
            val customTabsIntent = builder.build()
            customTabsIntent.launchUrl(context, Uri.parse(url))
        } catch (e: Exception) {
            e.printStackTrace()
            ErrorDialog.build(context, "A problem occurred while trying to open the link.")
        }
    }
}
