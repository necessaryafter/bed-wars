package com.bedwars.common.spigot.kit

import com.bedwars.common.spigot.model.match.BedWarsMatchType
import net.minecraft.util.thread.NamedThreadFactory
import org.bukkit.inventory.ItemStack
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.Executors


abstract class BedWarsKit(
    val identifier: String,
    val eventBus: EventBus = EventBus.builder()
        .throwSubscriberException(true)
        .executorService(
            Executors.newCachedThreadPool(
                NamedThreadFactory("Custom item executor")
            )
        ).build()
) {

    abstract fun getIcon(): ItemStack
    abstract fun getMatchType(): List<BedWarsMatchType>
}