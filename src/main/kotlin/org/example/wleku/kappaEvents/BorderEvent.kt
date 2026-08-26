package org.example.wleku.kappaEvents

import org.bukkit.Location
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

class BorderEvent: Listener {

    val maxBlock = 5000
    val warningActionBar = maxBlock - 25

    val plugin = KappaEvents.instance
    val enabling = plugin.config.getBoolean("borderEvent")

    @EventHandler
    fun onBorder(event: PlayerMoveEvent) {
        if (enabling == true) {

            val player = event.player
            val xBlock = player.location.blockX
            val yBlock = player.location.blockY
            val zBlock = player.location.blockZ
            val world = event.player.world

            if (world.name == "world") {
                if (xBlock >= warningActionBar || xBlock <= -warningActionBar || zBlock <= -warningActionBar || zBlock >= warningActionBar) {
                    player.sendActionBar("You're located around border")

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
}