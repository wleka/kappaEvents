package org.example.wleku.kappaEvents

import org.bukkit.Bukkit
import org.bukkit.event.player.PlayerEvent
import org.bukkit.plugin.java.JavaPlugin

class KappaEvents : JavaPlugin() {

    companion object{
        lateinit var instance: KappaEvents
            private set
    }

    override fun onEnable() {
        // Plugin startup logic
        getCommand("fart")?.setExecutor(FartCommand())
        getCommand("sex")?.setExecutor(SexCommand())

        Bukkit.getPluginManager().registerEvents(BorderEvent(), this)
        Bukkit.getPluginManager().registerEvents(TeleportBackroomsEvent(), this)
        Bukkit.getPluginManager().registerEvents(BorderEvent(), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
