package com.brandoncano.sharedcomponents.composables

import android.graphics.Picture
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.drawscope.draw
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas

/**
 * A composable that draws a picture of a composable layout for purposes of saving it as an image.
 *
 * @param picture The [Picture] to be drawn in the background.
 * @param content The composable content to be displayed within the [Column] on top of the picture.
 */
@Composable
fun DrawContent(picture: Picture, content: @Composable (ColumnScope.() -> Unit)) {
    Column(
        modifier = Modifier.drawWithCache {
            val width = this.size.width.toInt()
            val height = this.size.height.toInt()
            onDrawWithContent {
                val pictureCanvas = androidx.compose.ui.graphics.Canvas(
                    picture.beginRecording(width, height)
                )
                draw(this, this.layoutDirection, pictureCanvas, this.size) {
                    this@onDrawWithContent.drawContent()
                }
                picture.endRecording()
                drawIntoCanvas { canvas -> canvas.nativeCanvas.drawPicture(picture) }
            }
        },
        content = content
    )
}

@AppComponentPreviews
@Composable
private fun DrawContentPreview() {
    DrawContent(picture = Picture()) {
        Text(text = "Picture")
        Text(text = "Bottom Text")
    }
}
