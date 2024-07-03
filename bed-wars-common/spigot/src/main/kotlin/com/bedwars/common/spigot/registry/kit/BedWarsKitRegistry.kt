package com.bedwars.common.spigot.registry.kit

import com.bedwars.common.spigot.kit.BedWarsKit
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class BedWarsKitRegistry(
    private val javaPlugin: JavaPlugin
) {

    private val cache: MutableMap<String, BedWarsKit> = mutableMapOf()

    fun registerKit(vararg bedWarsKits: BedWarsKit) {
        for (bedWarsKit in bedWarsKits) {
            if (bedWarsKit is Listener) {
                javaPlugin.server.pluginManager.registerEvents(bedWarsKit, javaPlugin)
            }

            cache[bedWarsKit.identifier] = bedWarsKit
        }
    }

    fun getBedWarsKit(identifier: String): BedWarsKit? {
        return cache[identifier]
    }
}