package com.brandoncano.m3components.util

import android.content.Context
import android.widget.Toast

/**
 * Job: Toast element for showing a result from any clickable item.
 */
object MakeToast {

    fun execute(context: Context) {
        Toast
            .makeText(context, "Material3", Toast.LENGTH_SHORT)
            .show()
    }
}
