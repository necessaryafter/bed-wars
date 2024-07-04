package com.bedwars.common.spigot.model.match

import com.bedwars.common.spigot.map.BedwarsMap
import com.bedwars.common.spigot.model.match.state.BedwarsMatchState
import org.apache.commons.lang.RandomStringUtils

data class BedwarsMatch(
    val matchId: String = RandomStringUtils.randomAlphabetic(5),

    val bedwarsMap: BedwarsMap,
    val matchState: BedwarsMatchState
)