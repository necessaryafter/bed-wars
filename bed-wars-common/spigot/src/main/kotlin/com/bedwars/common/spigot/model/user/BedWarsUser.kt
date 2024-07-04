package com.bedwars.common.spigot.model.user

import com.bedwars.common.spigot.model.match.type.BedwarsMatchType
import com.bedwars.common.spigot.celebration.AbstractMatchCelebration
import com.bedwars.common.spigot.kit.BedwarsKit

import org.bukkit.Bukkit

data class BedWarsUser(
    val playerName: String,
    val purchasedBedwarsKits: MutableMap<BedwarsMatchType, BedwarsKit> = mutableMapOf(),
    val selectedBedwarsKits: MutableMap<BedwarsMatchType, BedwarsKit> = mutableMapOf(),
    val selectedMatchCelebration: AbstractMatchCelebration? = null,
    val purchasedMatchCelebrations: MutableList<AbstractMatchCelebration> = mutableListOf()
) {

    val player by lazy { Bukkit.getPlayerExact(playerName) }

    fun isPurchasedKit(bedWarsMatchType: BedWarsMatchType, bedWarsKit: BedwarsKit): Boolean {
        return purchasedBedwarsKits.contains(bedWarsMatchType) && purchasedBedwarsKits[bedWarsMatchType] == bedWarsKit
    }

    fun isPurchasedCelebration(matchCelebration: AbstractMatchCelebration): Boolean {
        return purchasedMatchCelebrations.contains(matchCelebration)
    }

    fun getSelectedKit(bedWarsMatchType: BedWarsMatchType): BedwarsKit? = selectedBedwarsKits[bedWarsMatchType]
    fun isSelectedKit(bedWarsMatchType: BedWarsMatchType, bedWarsKit: BedwarsKit): Boolean {
        return selectedBedwarsKits.contains(bedWarsMatchType) && selectedBedwarsKits[bedWarsMatchType] == bedWarsKit
    }
}