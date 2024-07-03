package com.bedwars.common.view.util

import com.mojang.authlib.GameProfile
import com.mojang.authlib.properties.Property
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.Skull
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import java.lang.reflect.Field
import java.net.URI
import java.net.URISyntaxException
import java.util.*

enum class CustomSkull(private val url: String) {
    BARRIER("3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025"),
    CHEST("d5c6dc2bbf51c36cfc7714585a6a5683ef2b14d47d8ff714654a893f5da622"),
    ACACIA_CRATE("f52d5148a107301c93e303e1f53b28635a319224a813eedc0a99cbafc0deb5c1"),
    CHEST_MINECART("4ced34211fed4010a8c85724a27fa5fb205d67684b3da517b6821279c6b65d3f"),
    COMMAND_BLOCK("1cba7277fc895bf3b673694159864b83351a4d14717e476ebda1c3bf38fcf37"),
    GOLD_BLOCK("54bf893fc6defad218f7836efefbe636f1c2cc1bb650c82fccd99f2c1ee6"),
    CACTUS("904f1a55943c594e7119e884c5da2a2bca8e7e6516a0649aa7e55658e0e9"),
    MELON("9636dee806ba47a2c40e95b57a12f37de6c2e677f2160132a07e24eeffa6"),
    NETHER_WART("111a3cec7aaf904212ccf93bb67a3caf3d649783ba90b8b60bb63c7687eb39f"),
    GREEN_CHECKMARK("a92e31ffb59c90ab08fc9dc1fe26802035a3a47c42fee63423bcdb4262ecb9b6"),
    BOOKSHELF("7dc985a7a68c574f683c0b859521feb3fc3d2ffa05fa09db0bae44b8ac29b385"),
    STONE_ARROW_LEFT("bb0f6e8af46ac6faf88914191ab66f261d6726a7999c637cf2e4159fe1fc477"),
    STONE_ARROW_RIGHT("f2f3a2dfce0c3dab7ee10db385e5229f1a39534a8ba2646178e37c4fa93b"),
    DISCORD("7873c12bffb5251a0b88d5ae75c7247cb39a75ff1a81cbe4c8a39b311ddeda"),
    MONEY_BAG("9e25dbe47667d0ce231baa223dee953bbfc9696097279d723703d2cc3397649e"),

    // COLORS
    RED_X("beb588b21a6f98ad1ff4e085c552dcb050efc9cab427f46048f18fc803475f7"),
    RED("5fde3bfce2d8cb724de8556e5ec21b7f15f584684ab785214add164be7624b"),
    RED_PLUS("ac731c3c723f67d2cfb1a1192b947086fba32aea472d347a5ed5d7642f73b"),
    RED_ARROW_UP("2d9287616343d833e9e7317159caa2cb3e59745113962c1379052ce478884fa"),
    RED_ARROW_DOWN("a3852bf616f31ed67c37de4b0baa2c5f8d8fca82e72dbcafcba66956a81c4"),
    MAGENTA_MINI_ARROW_RIGHT("a0f3103ebbcb34d73f1fe28b1fe8d8fac088aeb4e9e950bc37a132f17dc430"),
    MAGENTA_MINI_ARROW_LEFT("8f9994a477768d035e1b48dbbc0f6cddab16e8df9bd897ad353adead9226"),
    MAGENTA_ARROW_LEFT("9dbd8ec46192a955c6bd651ab4d86f9867e4d4bd99af21ca92ec9d26f86da91"),
    MAGENTA_ARROW_DOWN("7db9629cab72e021c8b561650c586b99bfdb3f6a9a962cc6e5611222d3558ef"),
    MAGENTA_ARROW_UP("cf114bec6a6fddea37d2b8767ace26b0d18283075ffd85d5687c55a7b4f1e8c"),
    MAGENTA_INFO("1fff26b2edb795d4794badd6b72f7b7cc71aa8c068768e77970dcf1daa401184"),
    YELLOW("c641682f43606c5c9ad26bc7ea8a30ee47547c9dfd3c6cda49e1c1a2816cf0ba"),
    YELLOW_INFO("d01afe973c5482fdc71e6aa10698833c79c437f21308ea9a1a095746ec274a0f"),
    YELLOW_PLUS("edfff1b3c5d85fe3cdd5656869baa0eade5e53aca9d561427648cc72f5e25a9"),
    GREEN("22d145c93e5eac48a661c6f27fdaff5922cf433dd627bf23eec378b9956197"),
    GREEN_ARROW_UP("b221da4418bd3bfb42eb64d2ab429c61decb8f4bf7d4cfb77a162be3dcb0b927"),
    GREEN_ARROW_DOWN("3b83bbccf4f0c86b12f6f79989d159454bf9281955d7e2411ce98c1b8aa38d8"),
    GREEN_PLUS("5ff31431d64587ff6ef98c0675810681f8c13bf96f51d9cb07ed7852b2ffd1"),
    GRAY("2a17e97037ce353f85f5c65df435d29449a88da4442e4361cf99abbe1f892fb"),
    DARK_GRAY_1("bf61269735f1e446becff25f9cb3c823679719a15f7f0fbc9a03911a692bdd"),
    DARK_GRAY_3("ceadaded81563f1c87769d6c04689dcdb9e8ca01da35281cd8fe251728d2d"),
    DARK_GRAY_5("1144c5193435199c135bd47d166ef1b4e2d3218383df9d34e3bb20d9f8e593"),
    DARK_GRAY_8("61c9c09d52debc465c32542c68be42bda6f6753fe1deba257327ac5a0c3ad"),
    DARK_GRAY_10("177a56ce415d7c30808706a94cc2bafa897cb7e486287c337a44af42b928c43"),

    // ENTITIES
    COW("5d6c6eda942f7f5f71c3161c7306f4aed307d82895f9d2b07ab4525718edc5"),
    PIG("621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4"),
    BAT("9e99deef919db66ac2bd28d6302756ccd57c7f8b12b9dca8f41c3e0a04ac1cc"),
    OCELOT("5657cd5c2989ff97570fec4ddcdc6926a68a3393250c1be1f0b114a1db1"),
    CHICKEN("1638469a599ceef7207537603248a9ab11ff591fd378bea4735b346a7fae893"),
    HORSE("7bb4b288991efb8ca0743beccef31258b31d39f24951efb1c9c18a417ba48f9"),
    MUSHROOM_COW("d0bc61b9757a7b83e03cd2507a2157913c2cf016e7c096a4d6cf1fe1b8db"),
    SHEEP("7eb4d01f1263eaa271db8faacb411c336baaeff2f01a30d446b2d908146f7c7"),
    VILLAGER("888bdb90be1a133e9f93aa28b6fdad222b432183d5d5fc54f2ea842cb25");

    private lateinit var field: Field

    private val textureValue: String

    init {
        val textureUrl = "http://textures.minecraft.net/texture/$url"
        textureValue = Base64.getEncoder().encodeToString("{textures:{SKIN:{url:\"$textureUrl\"}}}".toByteArray())
    }

    fun get(): ItemStack {
        return getItemStack()
    }

    fun applyToBlock(block: Block) {
        if (block.type == Material.PLAYER_HEAD || block.type == Material.PLAYER_WALL_HEAD) {
            val skull = block.state as Skull
            setProfile(skull)
            skull.update(true)
        }
    }

    private fun getItemStack(): ItemStack {
        val head = ItemStack(Material.PLAYER_HEAD, 1)
        val meta = head.itemMeta as SkullMeta
        setProfile(meta)
        head.itemMeta = meta
        return head
    }

    private fun setProfile(skull: Skull) {
        try {
            val profile = GameProfile(UUID.randomUUID(), null)
            profile.properties.put("textures", Property("textures", textureValue))
            val field = skull.javaClass.getDeclaredField("profile")
            field.isAccessible = true
            field.set(skull, profile)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun setProfile(meta: SkullMeta) {
        try {
            val profile = GameProfile(UUID.randomUUID(), null)
            profile.properties.put("textures", Property("textures", textureValue))
            val field = meta.javaClass.getDeclaredField("profile")
            field.isAccessible = true
            field.set(meta, profile)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
