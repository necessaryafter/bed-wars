package com.bedwars.common.spigot.registry.kit

import com.bedwars.common.spigot.kit.BedwarsKit
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class BedWarsKitRegistry(
    private val javaPlugin: JavaPlugin
) {

    private val cache: MutableMap<String, BedwarsKit> = mutableMapOf()

    fun registerKit(vararg bedwarsKits: BedwarsKit) {
        for (bedWarsKit in bedwarsKits) {
            if (bedWarsKit is Listener) {
                javaPlugin.server.pluginManager.registerEvents(bedWarsKit, javaPlugin)
            }

            cache[bedWarsKit.identifier] = bedWarsKit
        }
    }

    fun getBedWarsKit(identifier: String): BedwarsKit? {
        return cache[identifier]
    }
}