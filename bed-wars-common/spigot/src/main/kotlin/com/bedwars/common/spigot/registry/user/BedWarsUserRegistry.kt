package com.bedwars.common.spigot.registry.user

import com.bedwars.common.spigot.model.user.BedWarsUser

class BedWarsUserRegistry {

    private val cache: MutableMap<String, BedWarsUser> = mutableMapOf()

    fun register(bedWarsUser: BedWarsUser) {
        cache[bedWarsUser.playerName] = bedWarsUser
    }

    fun getBedWarsUser(playerName: String): BedWarsUser? {
        return cache[playerName]
    }
}