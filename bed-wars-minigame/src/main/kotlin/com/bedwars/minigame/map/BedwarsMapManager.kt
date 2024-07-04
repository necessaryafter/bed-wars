package com.bedwars.minigame.map

import com.bedwars.common.spigot.map.BedwarsMap
import com.bedwars.common.spigot.model.match.BedwarsMatch
import com.bedwars.minigame.map.loader.EmptySlimeLoader
import com.google.common.base.Stopwatch
import com.grinderwolf.swm.api.SlimePlugin
import com.grinderwolf.swm.api.world.SlimeWorld
import com.grinderwolf.swm.api.world.properties.SlimePropertyMap
import org.bukkit.Bukkit
import java.util.concurrent.TimeUnit

class BedwarsMapManager(
    private val slimePlugin: SlimePlugin = Bukkit.getPluginManager().getPlugin("SlimeWorldManager") as SlimePlugin
) {

    private val emptySlimeLoader = EmptySlimeLoader()
    private val templateMap = mutableMapOf<String, SlimeWorld>()

    fun createMap(match: BedwarsMatch, block: SlimeWorld.() -> Unit) {
        val map = match.bedwarsMap
        val templateWorld: SlimeWorld = templateMap.getOrPut(map.name) {
            slimePlugin.loadWorld(emptySlimeLoader, map.name, true, getDefaultPropertyMap())
        }

        val slimeWorld = internalCreateMap(templateWorld, match, map)
        block.invoke(slimeWorld)
    }

    fun deleteMap(match: BedwarsMatch) {
        val world = Bukkit.getWorld("${match.bedwarsMap.name}-${match.matchId}") ?: return
        Bukkit.unloadWorld(world, false)
    }

    private fun internalCreateMap(templateSlimeWorld: SlimeWorld, match: BedwarsMatch, map: BedwarsMap) : SlimeWorld {
        val stopwatch = Stopwatch.createStarted()
        val slimeWorld = templateSlimeWorld.clone("${map.name}-${match.matchId}")

        stopwatch.stop()
        println("Bedwars map generated in ${stopwatch.elapsed(TimeUnit.NANOSECONDS)}ns")

        return slimeWorld
    }

    private fun getDefaultPropertyMap() : SlimePropertyMap {
        return SlimePropertyMap()
    }

}