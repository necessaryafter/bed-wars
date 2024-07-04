package com.bedwars.common.spigot.event.impl.match

import com.bedwars.common.spigot.event.EventWrapper
import com.bedwars.common.spigot.model.match.BedWarsMatch
import com.bedwars.common.spigot.model.user.BedWarsUser

class MatchUserKillEvent(
    val killer: BedWarsUser,
    val deather: BedWarsUser,
    val bedWarsMatch: BedWarsMatch
) : EventWrapper() {
}