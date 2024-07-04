package com.bedwars.common.spigot.model.match.team.arena

import com.bedwars.common.spigot.model.match.team.color.TeamColorType
import org.bukkit.Location

data class BedwarsTeamArena(
    val teamColorType: TeamColorType,
    val bedLocation: Location,
    val generatorLocation: Location,
    val spawnLocation: Location
)