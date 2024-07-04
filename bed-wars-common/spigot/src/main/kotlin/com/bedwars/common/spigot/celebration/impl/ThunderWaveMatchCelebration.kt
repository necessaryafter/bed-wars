package com.bedwars.common.spigot.celebration.impl

import com.bedwars.common.spigot.celebration.AbstractMatchCelebration
import com.bedwars.common.spigot.model.user.BedWarsUser
import com.bedwars.common.spigot.util.itemStackBuilder
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ThunderWaveMatchCelebration() : AbstractMatchCelebration("thunder-wave") {

    override fun getIcon(): ItemStack {
        return itemStackBuilder(Material.BLAZE_ROD) {
            displayName(Component.text("§6Chuva de raios"))
            lore(
                arrayOf(
                    Component.text("§7Ao ganhar uma partida, uma chuva"),
                    Component.text("§7de raios começara.")
                )
            )
        }
    }

    override fun runAnimation(bedWarsUser: BedWarsUser) {
        val player = bedWarsUser.player ?: return

        val world = player.world
        world.strikeLightningEffect(player.location)
    }
}