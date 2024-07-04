package com.bedwars.common.spigot.kit

import com.bedwars.common.spigot.model.match.type.BedwarsMatchType
import net.minecraft.util.thread.NamedThreadFactory
import org.bukkit.inventory.ItemStack
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.Executors


abstract class BedwarsKit(
    val identifier: String,
    val eventBus: EventBus = EventBus.builder()
        .throwSubscriberException(true)
        .executorService(
            Executors.newCachedThreadPool(
                NamedThreadFactory("")
            )
        ).build()
) {

    abstract fun getIcon(): ItemStack
    abstract fun getMatchType(): List<BedwarsMatchType>
}