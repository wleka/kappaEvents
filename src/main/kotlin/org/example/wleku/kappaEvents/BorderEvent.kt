package org.example.wleku.kappaEvents

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

class BorderEvent: Listener {

    @EventHandler
    fun onBorder(event: PlayerMoveEvent) {
        val player = event.player
        val xBlock = player.location.blockX
        val yBlock = player.location.blockY
        val zBlock = player.location.blockZ
    }
}