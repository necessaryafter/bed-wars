package com.bedwars.common.spigot.model.user

import com.bedwars.common.spigot.kit.BedWarsKit
import com.bedwars.common.spigot.model.match.type.BedwarsMatchType
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class BedWarsUser(
    val playerName: String,
    val purchasedBedwarsKits: MutableMap<BedwarsMatchType, BedWarsKit> = mutableMapOf(),
    val selectionedBedWarsKits: MutableMap<BedwarsMatchType, BedWarsKit> = mutableMapOf()
) {

    fun getPlayer(): Player? = Bukkit.getPlayerExact(playerName)

    fun isPurchasedKit(bedWarsMatchType: BedwarsMatchType, bedWarsKit: BedWarsKit): Boolean {
        return purchasedBedwarsKits.contains(bedWarsMatchType) && purchasedBedwarsKits[bedWarsMatchType] == bedWarsKit
    }

    fun getSelectionedKit(bedWarsMatchType: BedwarsMatchType): BedWarsKit? = selectionedBedWarsKits[bedWarsMatchType]
    fun isSelectionedKit(bedWarsMatchType: BedwarsMatchType, bedWarsKit: BedWarsKit): Boolean {
        return selectionedBedWarsKits.contains(bedWarsMatchType) && selectionedBedWarsKits[bedWarsMatchType] == bedWarsKit
    }
}