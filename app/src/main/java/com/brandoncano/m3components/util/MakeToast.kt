package com.brandoncano.m3components.util

import android.content.Context
import android.widget.Toast

/**
 * Job: Toast element for showing a result from any clickable item.
 */
object MakeToast {

    fun execute(context: Context, text: String) {
        Toast
            .makeText(context, text, Toast.LENGTH_SHORT)
            .show()
    }
}
