package com.brandoncano.m3components.util

import android.content.Context
import android.widget.Toast

/**
 * Job: Toast element for showing a result from any clickable item.
 */
object MakeToast {

    private var currentToast: Toast? = null

    fun execute(context: Context, text: String) {
        currentToast?.cancel()
        currentToast = Toast
            .makeText(context, text, Toast.LENGTH_SHORT)
            .apply { show() }
    }
}
