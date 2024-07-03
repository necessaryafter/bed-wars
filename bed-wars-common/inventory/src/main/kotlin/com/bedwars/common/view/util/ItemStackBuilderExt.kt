package com.bedwars.common.view.util

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

fun itemStackBuilder(material: Material, block: ItemStackBuilder.() -> Unit) : ItemStack {
    val itemStackBuilder = ItemStackBuilder(material)
    block.invoke(itemStackBuilder)

    return itemStackBuilder.build()
}