package com.brandoncano.sharedcomponents.data

/**
 * Note: Keep in alphabetical order
 */
sealed class Apps(val playstore: String) {
    data object Capacitor: Apps(GooglePlayLinks.CAPACITOR_PLAYSTORE)
    data object Inductor: Apps(GooglePlayLinks.INDUCTOR_PLAYSTORE)
    // will add back when app is ready
    // data object LedResistor: Apps(GooglePlayLinks.LED_RESISTOR_PLAYSTORE)
    data object Resistor: Apps(GooglePlayLinks.RESISTOR_PLAYSTORE)
}
