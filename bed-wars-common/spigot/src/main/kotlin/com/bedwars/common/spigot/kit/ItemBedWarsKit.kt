package com.bedwars.common.spigot.kit

import com.bedwars.common.spigot.model.user.BedWarsUser
import net.kyori.adventure.text.Component
import org.bukkit.inventory.ItemStack

abstract class ItemBedWarsKit(
    identifier: String
) : BedWarsKit(identifier) {

    abstract fun getItems(): List<ItemStack>

    fun giveItems(bedWarsUser: BedWarsUser) {
        val player = bedWarsUser.getPlayer() ?: return
        player.sendActionBar(Component.text("§aOs itens do kit §f$identifier §aforam entregues!"))

        getItems().forEach {
            player.inventory.addItem(it)
        }
    }
}