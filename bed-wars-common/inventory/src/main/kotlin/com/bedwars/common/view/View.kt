package com.bedwars.common.view

import com.bedwars.common.view.context.ViewContext
import com.bedwars.common.view.util.itemStackBuilder
import org.bukkit.Material

open class View(
    title: String,
    size: Int
) {

    private val DEFAULT_NEXT_PAGE_ITEM = itemStackBuilder(Material.ARROW)
    private val DEFAULT_BACK_ITEM = itemStackBuilder(Material.ARROW) { displayName("§aVoltar") }

    open fun onClose(context: ViewContext) {}

}