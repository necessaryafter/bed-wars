package com.bedwars.common.spigot.event.impl.match

import com.bedwars.common.spigot.event.CancellableEventWrapper
import com.bedwars.common.spigot.event.impl.match.type.MatchUserQuitType
import com.bedwars.common.spigot.model.match.BedWarsMatch
import com.bedwars.common.spigot.model.user.BedWarsUser

class MatchUserLeaveEvent(
    val bedWarsUser: BedWarsUser,
    val matchUserQuitType: MatchUserQuitType,
    val bedWarsMatch: BedWarsMatch
) : CancellableEventWrapper() {

}