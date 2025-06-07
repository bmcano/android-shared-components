package com.brandoncano.m3components.util

import com.brandoncano.m3components.navigation.Component
import com.brandoncano.m3components.to.ComponentCardPO

/**
 * Job: From a component get its related items to show on screen for display.
 */
object RelatedComponentPOsDeriver {

    fun execute(component: Component): List<ComponentCardPO> {
        val componentCardPO = ComponentCardPOContentDeriver.execute(component)
        return componentCardPO.relatedItems.map {
            ComponentCardPOContentDeriver.execute(it)
        }
    }
}
