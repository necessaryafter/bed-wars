package com.bedwars.common.spigot.model.match.team

import com.bedwars.common.spigot.model.match.team.arena.BedwarsTeamArena
import com.bedwars.common.spigot.model.match.team.color.TeamColorType
import com.bedwars.common.spigot.model.user.BedWarsUser

data class BedwarsTeam(
    val teamColor: TeamColorType,
    val teamMembers: List<BedWarsUser>,
    val arena: BedwarsTeamArena
)