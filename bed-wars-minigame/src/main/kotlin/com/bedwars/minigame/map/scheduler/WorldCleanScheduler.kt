package com.bedwars.minigame.map.scheduler

import com.bedwars.common.spigot.model.match.state.BedwarsMatchState
import com.bedwars.common.spigot.registry.match.BedwarsMatchRegistry
import com.bedwars.minigame.map.BedwarsMapManager

class WorldCleanScheduler(
    private val matchRegistry: BedwarsMatchRegistry,
    private val mapManager: BedwarsMapManager
) : Runnable {

    override fun run() {
        matchRegistry.values
            .filter { it.matchState == BedwarsMatchState.ENDED }
            .forEach { mapManager.deleteMap(it) }
    }

}