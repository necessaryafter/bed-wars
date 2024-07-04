package com.bedwars.common.spigot.model.match.type

enum class BedwarsMatchType(
    val displayName: String,
    val maximumPlayers: Int,
) {

    SOLO("Solo", 8),
    DUO("Dupla", 16),
    TRIPLE("Trio", 12),
    SQUAD("Quarteto", 16)
}