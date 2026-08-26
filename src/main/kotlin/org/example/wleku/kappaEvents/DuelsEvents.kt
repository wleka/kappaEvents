package org.example.wleku.kappaEvents

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

class DuelsEvents: Listener {

    var doingThis = "§cYou're can't do that!"

    val plugin = KappaEvents.instance
    val enabling = plugin.config.getBoolean("DuelsEvent")

    @EventHandler
    fun onDisableBlockBreak(event: BlockBreakEvent) {
        if (enabling == true) {
            var player = Bukkit.getPlayer(Bukkit.getName())
            val world = player?.world

            when (world?.name) {
                "duel_default" -> {
                    event.isCancelled = true
                }

                "duel_pvz" -> {
                    event.isCancelled = true
                }

                "duel_front" -> {
                    event.isCancelled = true
                }
            }
        }
    }

    @EventHandler
    fun onDisableBlockPlace(event: BlockBreakEvent) {
        if (enabling == true) {
            var player = event.player
            val world = player?.world

            when (world?.name) {
                "duel_default" -> {
                    event.isCancelled = true
                }

                "duel_pvz" -> {
                    event.isCancelled = true
                }

                "duel_front" -> {
                    event.isCancelled = true
                }
            }
        }
    }
}