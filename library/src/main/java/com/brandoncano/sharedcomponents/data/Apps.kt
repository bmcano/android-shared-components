package com.brandoncano.sharedcomponents.data

sealed class Apps(val playstore: String) {
    data object Capacitor: Apps(GooglePlayLinks.CAPACITOR_PLAYSTORE)
    data object Inductor: Apps(GooglePlayLinks.INDUCTOR_PLAYSTORE)
    data object OhmsLaw: Apps(GooglePlayLinks.OHMS_LAW_PLAYSTORE)
    data object Resistor: Apps(GooglePlayLinks.RESISTOR_PLAYSTORE)
}
