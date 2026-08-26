package org.example.wleku.kappaEvents

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.World
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class FirstTimeEvent: Listener {

    @EventHandler
    fun onFirstTimeEvent(event: PlayerJoinEvent) {
        val player = event.player
        val plugin = KappaEvents.instance

        if (!player.hasPlayedBefore()) {
            player.teleport(Location(player.world, 0.0, 70.0, 0.0))

            Bukkit.getOnlinePlayers().forEach {
                online -> online.playSound(online.location, Sound.ENTITY_CAT_PURREOW, 1.0f, 1.0f)
            }

            Bukkit.broadcastMessage("§e${player.name} JOINED IN FIRST TIME!!!")
        }
    }
}