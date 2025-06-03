package com.brandoncano.m3components.util

import com.brandoncano.m3components.navigation.Component
import com.brandoncano.m3components.to.ComponentCardPO

/**
 * Job: Derive the list of component cards to iterate for display on screen.
 */
object ComponentCardPOsDeriver {

    fun execute(): List<ComponentCardPO> {
        return Component.entries.map { ComponentCardPOContentDeriver.execute(it) }
    }
}
