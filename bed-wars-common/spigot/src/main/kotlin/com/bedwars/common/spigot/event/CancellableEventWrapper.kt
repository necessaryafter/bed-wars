package com.bedwars.common.spigot.event

import org.bukkit.event.Cancellable

abstract class CancellableEventWrapper : EventWrapper, Cancellable {

    private var cancelled = false

    constructor(isAsync: Boolean) : super(isAsync)
    constructor() : super(false)

    override fun isCancelled(): Boolean = cancelled

    override fun setCancelled(value: Boolean) {
        cancelled = value
    }
}
