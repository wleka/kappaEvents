package org.example.wleku.kappaEvents

import org.bukkit.Location
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class BorderEvent: Listener {

    val maxBlock = 5000
    val warningActionBar = maxBlock - 25

    @EventHandler
    fun onBorder(event: PlayerMoveEvent) {
        val player = event.player
        val xBlock = player.location.blockX
        val yBlock = player.location.blockY
        val zBlock = player.location.blockZ
        val world = event.player.world

        if (world.name == "world") {
            if (xBlock >= warningActionBar || xBlock <= -warningActionBar || zBlock <= -warningActionBar || zBlock >= warningActionBar) {
                player.sendActionBar("Вы находитесь рядом с границей мира.")

                if (xBlock >= maxBlock) {
                    player.sendActionBar("Вы переходите границу мира.")
                    player.teleport(
                        Location(
                            player.world,
                            xBlock.toDouble() - 1.0,
                            yBlock.toDouble(),
                            zBlock.toDouble()
                        )
                    )
                } else if (zBlock >= maxBlock) {
                    player.sendActionBar("Вы переходите границу мира.")
                    player.teleport(
                        Location(
                            player.world,
                            xBlock.toDouble(),
                            yBlock.toDouble(),
                            zBlock.toDouble() - 1.0
                        )
                    )
                } else if (xBlock <= -maxBlock) {
                    player.sendActionBar("Вы переходите границу мира.")
                    player.teleport(
                        Location(
                            player.world,
                            xBlock.toDouble() + 1.0,
                            yBlock.toDouble(),
                            zBlock.toDouble()
                        )
                    )
                } else if (zBlock <= -maxBlock) {
                    player.sendActionBar("Вы переходите границу мира.")
                    player.teleport(
                        Location(
                            player.world,
                            xBlock.toDouble(),
                            yBlock.toDouble(),
                            zBlock.toDouble() + 1.0
                        )
                    )
                }
            }
        }

    }
}