package com.bedwars.common.spigot.model.match.team.color

import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Material

enum class TeamColorType(
    val teamName: String,
    val teamPrefix: String,
    val textColor: NamedTextColor
) {

    RED("Vermelho", "V", NamedTextColor.RED),
    BLUE("Azul", "A", NamedTextColor.BLUE),
    GREEN("Verde", "V", NamedTextColor.GREEN),
    YELLOW("Amarelo", "A", NamedTextColor.YELLOW),
    AQUA("Ciano", "C", NamedTextColor.AQUA),
    WHITE("Branco", "B", NamedTextColor.WHITE),
    PINK("Rosa", "R", NamedTextColor.LIGHT_PURPLE),
    GRAY("Cinza", "C", NamedTextColor.GRAY);

    fun getBed() : Material = when(this) {
        RED -> Material.RED_BED
        BLUE -> Material.BLUE_BED
        GREEN -> Material.GREEN_BED
        YELLOW -> Material.YELLOW_BED
        AQUA -> Material.CYAN_BED
        WHITE -> Material.WHITE_BED
        PINK -> Material.PINK_BED
        GRAY -> Material.GRAY_BED
    }

    fun getWool() : Material = when(this) {
        RED -> Material.RED_WOOL
        BLUE -> Material.BLUE_WOOL
        GREEN -> Material.GREEN_WOOL
        YELLOW -> Material.YELLOW_WOOL
        WHITE -> Material.WHITE_WOOL
        PINK -> Material.PINK_WOOL
        GRAY -> Material.GRAY_WOOL
        AQUA -> Material.CYAN_WOOL
    }

}