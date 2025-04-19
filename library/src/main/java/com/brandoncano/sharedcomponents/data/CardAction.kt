package com.brandoncano.sharedcomponents.data

data class CardAction(
    val buttonLabel: String,
    val onClick: () -> Unit
)
