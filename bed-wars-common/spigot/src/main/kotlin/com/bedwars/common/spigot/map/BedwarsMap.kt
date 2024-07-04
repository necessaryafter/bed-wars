package com.bedwars.common.spigot.map

import com.bedwars.common.spigot.model.match.team.arena.BedwarsTeamArena
import com.bedwars.common.spigot.model.match.type.BedwarsMatchType
import org.bukkit.Location


data class BedwarsMap(
    val name: String,
    val templateId: String,
    val matchType: BedwarsMatchType,
    val diamondGenerators: List<Location>,
    val emeraldGenerators: List<Location>,
    val teamArenas: List<BedwarsTeamArena>
)