package com.bedwars.common.spigot.util

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.Damageable
import org.bukkit.inventory.meta.components.ToolComponent
import org.bukkit.persistence.PersistentDataContainer

class ItemStackBuilder(private var itemStack: ItemStack) {

    constructor(material: Material) : this(ItemStack(material))

    constructor(customSkull: CustomSkull) : this(customSkull.get())

    fun displayName(component: Component) : ItemStackBuilder {
        itemStack.editMeta {
            it.displayName(component)
        }

        return this
    }

    fun displayName(name: String) = displayName(Component.text(name))

    fun lore(component: Array<Component>, override: Boolean = false) : ItemStackBuilder {
        itemStack.editMeta {
            if (override && it.hasLore()) {
                it.lore()!!.clear()
            }

            val components = if (it.hasLore()) {
                it.lore()!!
            } else ArrayList<Component>()


            components.addAll(component)
            it.lore(components)
        }

        return this
    }

    fun durability(durability: Int) : ItemStackBuilder {
        itemStack.editMeta(Damageable::class.java) {
            it.damage = durability
        }

        return this
    }

    fun customModelData(modelData: Int) : ItemStackBuilder {
        itemStack.editMeta {
            it.setCustomModelData(modelData)
        }

        return this
    }

    fun persistent(block: PersistentDataContainer.() -> Unit) : ItemStackBuilder {
        itemStack.editMeta {
            val persistentDataContainer = it.persistentDataContainer
            block.invoke(persistentDataContainer)
        }

        return this
    }

    fun addEnchantment(enchament: Enchantment, level: Int = 0) : ItemStackBuilder {
        itemStack.editMeta {
            it.addEnchant(enchament, level, true)
        }

        return this
    }

    fun itemFlag(vararg flag: ItemFlag) : ItemStackBuilder {
        itemStack.editMeta {
            it.addItemFlags(*flag)
        }

        return this
    }

    fun allFlags() : ItemStackBuilder {
        return itemFlag(*ItemFlag.entries.toTypedArray())
    }

    fun glow() : ItemStackBuilder {
        return itemFlag(ItemFlag.HIDE_ENCHANTS).addEnchantment(Enchantment.FIRE_PROTECTION, 1)
    }

    fun unbreakable() : ItemStackBuilder {
        itemStack.editMeta {
            it.isUnbreakable = true
        }

        return this
    }

    fun toolComponent(block: ToolComponent.() -> Unit) : ItemStackBuilder {
        itemStack.editMeta {
            block.invoke(it.tool)
        }

        return this
    }

    fun build() : ItemStack {
        return itemStack
    }
}