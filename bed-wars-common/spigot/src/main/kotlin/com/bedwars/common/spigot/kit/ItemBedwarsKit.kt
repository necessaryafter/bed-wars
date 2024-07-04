package com.bedwars.common.spigot.kit

import com.bedwars.common.spigot.model.user.BedWarsUser
import net.kyori.adventure.text.Component
import org.bukkit.inventory.ItemStack

abstract class ItemBedwarsKit(
    identifier: String
) : BedwarsKit(identifier) {

    abstract fun getItems(): List<ItemStack>

    fun giveItems(bedWarsUser: BedWarsUser) {
        val player = bedWarsUser.player ?: return
        player.sendActionBar(Component.text("§aOs itens do kit §f$identifier §aforam entregues!"))

        getItems().forEach {
            player.inventory.addItem(it)
        }
    }
}