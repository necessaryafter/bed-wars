package com.bedwars.common.spigot.event.impl.match

import com.bedwars.common.spigot.event.CancellableEventWrapper
import com.bedwars.common.spigot.model.match.BedWarsMatch
import com.bedwars.common.spigot.model.user.BedWarsUser

class MatchUserJoinEvent(
    val bedWarsUser: BedWarsUser,
    val bedWarsMatch: BedWarsMatch
) : CancellableEventWrapper() {

}