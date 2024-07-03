package com.bedwars.common.spigot.model.user

import com.bedwars.common.spigot.kit.BedWarsKit
import com.bedwars.common.spigot.model.match.BedWarsMatchType
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class BedWarsUser(
    val playerName: String,
    val purchasedBedwarsKits: MutableMap<BedWarsMatchType, BedWarsKit> = mutableMapOf(),
    val selectionedBedWarsKits: MutableMap<BedWarsMatchType, BedWarsKit> = mutableMapOf()
) {

    fun getPlayer(): Player? = Bukkit.getPlayerExact(playerName)

    fun isPurchasedKit(bedWarsMatchType: BedWarsMatchType, bedWarsKit: BedWarsKit): Boolean {
        return purchasedBedwarsKits.contains(bedWarsMatchType) && purchasedBedwarsKits[bedWarsMatchType] == bedWarsKit
    }

    fun getSelectionedKit(bedWarsMatchType: BedWarsMatchType): BedWarsKit? = selectionedBedWarsKits[bedWarsMatchType]
    fun isSelectionedKit(bedWarsMatchType: BedWarsMatchType, bedWarsKit: BedWarsKit): Boolean {
        return selectionedBedWarsKits.contains(bedWarsMatchType) && selectionedBedWarsKits[bedWarsMatchType] == bedWarsKit
    }
}