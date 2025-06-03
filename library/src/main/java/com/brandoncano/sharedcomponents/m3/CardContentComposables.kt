package com.brandoncano.sharedcomponents.m3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Card contents will be where we define a bunch of predefined structures.
// Either from our common examples or from the guidelines.
// This is still a WIP

/**
 * Displays a minimal card content with a primary title and secondary description.
 *
 * Use this for simple informational cards such as summaries or notifications.
 * According to M3 guidelines, a card should have 16 dp padding around content
 * and present title + supporting text in a vertical arrangement.
 */
@Composable
fun SimpleCardContent(
    title: String,
    description: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun M3CardContent(
    modifier: Modifier = Modifier,
    topContent: (@Composable () -> Unit)? = null,
    headline: String,
    subhead: String,
    bodyText: String,
    primaryButtonText: String? = null,
    onPrimaryClick: (() -> Unit)? = null,
    onSecondaryClick: (() -> Unit)? = null,
    secondaryButtonText: String? = null,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        topContent?.let {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
            ) {
                it()
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            // Headline
            Text(
                text = headline,
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(modifier = Modifier.height(4.dp))
            // Subhead
            Text(
                text = subhead,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Supporting body text
            Text(
                text = bodyText,
                style = MaterialTheme.typography.bodyMedium,
            )
            Spacer(modifier = Modifier.height(16.dp))

            // 5) Action buttons row (0, 1, or 2 buttons aligned to end)
            if (secondaryButtonText != null || primaryButtonText != null) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    // Secondary (Outlined) Button if provided
                    if (secondaryButtonText != null && onSecondaryClick != null) {
                        M3OutlinedButton(
                            buttonLabel = secondaryButtonText,
                            onClick = onSecondaryClick,
                            minHeight = 40.dp,
                        )
                    }

                    if (
                        secondaryButtonText != null && onSecondaryClick != null &&
                        primaryButtonText != null && onPrimaryClick != null
                    ) {
                        Spacer(modifier = Modifier.width(8.dp))
                    }

                    if (primaryButtonText != null && onPrimaryClick != null) {
                        M3FilledButton(
                            buttonLabel = primaryButtonText,
                            onClick = onPrimaryClick,
                            minHeight = 40.dp,
                        )
                    }
                }
            }
        }
    }
}

/**
 * Displays card content with a leading avatar icon, title, subtitle, and a trailing overflow action icon.
 *
 * Use this for list‐style cards or user-centric items where you want to show an avatar,
 * a primary and secondary text line, plus an optional “more” action. Aligns with M3’s
 * “Leading AV • Primary • Secondary • Trailing Action” pattern.
 *
 * @param avatarPainter A [Painter] for the leading avatar (e.g., user photo). If null, falls back to a default icon.
 * @param title The main text (e.g., user name, item title).
 * @param subtitle The supporting text (e.g., user role, item subheading).
 * @param onOverflowClick Lambda invoked when the overflow (three‐dot) icon is tapped.
 */
@Composable
fun AvatarCardContent(
    avatarPainter: Painter?,
    title: String,
    subtitle: String,
    onOverflowClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Leading avatar
        if (avatarPainter != null) {
            Image(
                painter = avatarPainter,
                contentDescription = "$title avatar",
                modifier = Modifier
                    .size(40.dp)
                    .aspectRatio(1f)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        } else {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Default avatar",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        // Title + subtitle
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        IconButton(onClick = onOverflowClick) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More actions"
            )
        }
    }
}

@Preview
@Composable
fun ExampleCardUsage() {
    M3Card(
        modifier = Modifier.padding(16.dp),
    ) {
        M3CardContent(
            topContent = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.primaryContainer),
                )
            },
            headline = "Headline",
            subhead = "Subhead",
            bodyText = "Explain more about the topic shown in the medium display and subhead through supporting text here.",
            primaryButtonText = "Primary action",
            onPrimaryClick = { /* handle */ },
            secondaryButtonText = "Action",
            onSecondaryClick = { /* handle */ },
        )
    }
}