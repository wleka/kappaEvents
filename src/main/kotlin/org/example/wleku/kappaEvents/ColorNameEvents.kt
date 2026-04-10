package org.example.wleku.kappaEvents

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerEvent

class ColorNameEvents: Listener {

    @EventHandler
    fun onColorName(event: PlayerEvent) {
        val player = event.player
    }
}