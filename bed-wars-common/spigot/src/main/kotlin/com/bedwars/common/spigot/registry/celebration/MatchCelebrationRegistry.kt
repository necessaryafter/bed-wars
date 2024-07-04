package com.bedwars.common.spigot.registry.celebration

import com.bedwars.common.spigot.celebration.AbstractMatchCelebration

class MatchCelebrationRegistry {

    private val cache: MutableMap<String, AbstractMatchCelebration> = mutableMapOf()

    fun register(matchCelebration: AbstractMatchCelebration) {
        cache[matchCelebration.identifier] = matchCelebration
    }

    fun getMatchCelebration(identifier: String): AbstractMatchCelebration? {
        return cache[identifier]
    }
}