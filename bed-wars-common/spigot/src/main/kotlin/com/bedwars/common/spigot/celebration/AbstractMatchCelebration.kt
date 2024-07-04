package com.bedwars.common.spigot.celebration

import com.bedwars.common.spigot.model.user.BedWarsUser
import org.bukkit.inventory.ItemStack

abstract class AbstractMatchCelebration(
    val identifier: String
) {

    abstract fun getIcon(): ItemStack
    abstract fun runAnimation(bedWarsUser: BedWarsUser)
}