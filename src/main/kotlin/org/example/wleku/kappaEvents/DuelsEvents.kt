package org.example.wleku.kappaEvents

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent

class DuelsEvents: Listener {

    var breakMessage = "§cВы не можете ломать блоки!"
    var placeMessage = "§cВы не можете ставить блоки!"

    val plugin = KappaEvents.instance
    val enabling = plugin.config.getBoolean("DuelsEvent")

    @EventHandler
    fun onDisableBreak(event: BlockBreakEvent) {
        if (enabling == true) {
            var player = event.player
            val world = player.world

            when (world.name) {
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
    fun onDisablePlace(event: BlockPlaceEvent) {
        if (enabling == true) {
            var player = event.player
            val world = player.world

            when (world.name) {
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