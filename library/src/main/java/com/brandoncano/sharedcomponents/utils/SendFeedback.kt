package com.brandoncano.sharedcomponents.utils

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

/**
 * Job: Takes the user to compose an email with a predefined subject and empty body.
 */
object SendFeedback {

    fun execute(context: Context, app: String) {
        val emailLink = "mailto:brandoncano.development@gmail.com?subject=[Feedback] - $app"
        val intent = Intent(Intent.ACTION_SENDTO, emailLink.toUri())
        try {
            val title = "Send email"
            context.startActivity(Intent.createChooser(intent, title))
        } catch (ex: Exception) {
            ex.printStackTrace()
            ErrorDialog.build(context, "A problem occurred when trying to send an email.")
        }
    }
}
