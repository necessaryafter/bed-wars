package com.bedwars.common.spigot.kit.impl

import com.bedwars.common.spigot.event.impl.match.MatchUserJoinEvent
import com.bedwars.common.spigot.kit.ItemBedwarsKit
import com.bedwars.common.spigot.model.match.BedWarsMatchType
import com.bedwars.common.spigot.util.itemStackBuilder
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.greenrobot.eventbus.Subscribe

class SoldierBedwarsKit : ItemBedwarsKit("soldier") {

    override fun getIcon(): ItemStack {
        return itemStackBuilder(Material.IRON_SWORD) {
            displayName(Component.text("§bMae do after"))
            lore(
                arrayOf(
                    Component.text("§7Esse kit vai te dar uma"),
                    Component.text("§7espada de ferro e 8 maças.")
                ), false
            )
        }
    }

    override fun getMatchType(): List<BedWarsMatchType> {
        return listOf(BedWarsMatchType.SOLO, BedWarsMatchType.DUO, BedWarsMatchType.TRIPLE, BedWarsMatchType.SQUAD)
    }

    override fun getItems(): List<ItemStack> {
        return listOf(ItemStack(Material.IRON_SWORD), ItemStack(Material.GOLDEN_APPLE, 8))
    }

    @Subscribe
    private fun onMatchJoin(event: MatchUserJoinEvent) {
        val bedWarsUser = event.bedWarsUser

        giveItems(bedWarsUser)
    }
}