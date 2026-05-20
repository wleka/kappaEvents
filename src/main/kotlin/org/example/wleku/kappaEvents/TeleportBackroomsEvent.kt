package org.example.wleku.kappaEvents

import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class TeleportBackroomsEvent: Listener {

    val nameWorld: String = "world_backrooms"

    val blocksList = arrayListOf<Material>(
        Material.SEA_LANTERN,
        Material.DARK_OAK_PLANKS,
        Material.STRIPPED_BIRCH_LOG,
        Material.POLISHED_ANDESITE,
        Material.SMOOTH_SANDSTONE,
        Material.DARK_OAK_STAIRS
    )

    val plugin = KappaEvents.instance
    val enabling = plugin.config.getBoolean("BackroomsTeleport")

    @EventHandler
    fun onTeleportBackroomsEvent(event: PlayerMoveEvent) {
        if (enabling == true) {
            val player = event.player
            val blockX = player.location.x
            val blockY = player.location.y
            val blockZ = player.location.z
            val world = player.world

            val gamemode = player.gameMode

            if (world.name == "world") {
                if (blockY <= -72) {
                    Bukkit.broadcastMessage("${player.name} выпал из мира.")
                    player.teleport(Location(Bukkit.getWorld(nameWorld), 0.0, -59.0, 0.0))

                    player.gameMode = gamemode

                    player.health = 20.0
                    player.addPotionEffect(PotionEffect(PotionEffectType.DARKNESS, Int.MAX_VALUE, 0))
                }
            } else if (world.name == nameWorld) {
                if (blockY >= -27) {
                    Bukkit.broadcastMessage("${player.name} вёрнулся в мир.")
                    player.teleport(Location(Bukkit.getWorld("world"), 0.0, 71.0, 0.0))

                    player.gameMode = gamemode

                    player.health = 20.0
                    player.removePotionEffect(PotionEffectType.DARKNESS)
                }
            }
        }
    }

    @EventHandler
    fun onDisableBreak(event: BlockBreakEvent) {
        if (enabling == true) {
            val player = event.player
            val world = player.world.name
            val block = event.block

            if (world == nameWorld) {
                for (blockDisaled in blocksList) {
                    if (block.type == blockDisaled) {
                        event.isCancelled = true
                    }
                }
            }
        }
    }

    @EventHandler
    fun onDisblePlace(event: BlockPlaceEvent) {
        if (enabling == true) {
            val player = event.player
            val world = player.world.name
            val block = event.block

            if (world == nameWorld) {
                for (blockDisaled in blocksList) {
                    if (block.type == blockDisaled) {
                        event.isCancelled = true
                    }
                }
            }
        }
    }
}