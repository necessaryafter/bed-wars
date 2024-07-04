package com.bedwars.common.spigot.event

import org.bukkit.Bukkit
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

abstract class EventWrapper : Event {

    private val HANDLER_LIST: HandlerList = HandlerList()

    constructor(isAsync: Boolean) : super(isAsync)
    constructor() : super(false)

    fun call(): Boolean {
        Bukkit.getPluginManager().callEvent(this)
        if (this is Cancellable) return !(this as Cancellable).isCancelled

        return true
    }

    override fun getHandlers(): HandlerList {
        return HANDLER_LIST
    }
}
