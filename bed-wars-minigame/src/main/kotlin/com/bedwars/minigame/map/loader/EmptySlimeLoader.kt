package com.bedwars.minigame.map.loader

import com.grinderwolf.swm.api.loaders.SlimeLoader

class EmptySlimeLoader : SlimeLoader {

    override fun loadWorld(p0: String?, p1: Boolean): ByteArray {
        return byteArrayOf()
    }

    override fun worldExists(p0: String?): Boolean {
        return false
    }

    override fun listWorlds(): MutableList<String> {
        return mutableListOf()
    }

    override fun saveWorld(p0: String?, p1: ByteArray?, p2: Boolean) {}

    override fun unlockWorld(p0: String?) {}

    override fun isWorldLocked(p0: String?): Boolean = false

    override fun deleteWorld(p0: String?) {}

}