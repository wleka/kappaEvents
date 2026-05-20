package org.example.wleku.kappaEvents

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class KappaEvents : JavaPlugin() {

    companion object{
        lateinit var instance: KappaEvents
            private set
    }

    override fun onEnable() {
        // Plugin startup logic

        saveDefaultConfig()
        instance = this

        getCommand("fart")?.setExecutor(FartCommand())
        getCommand("sex")?.setExecutor(SexCommand())

        Bukkit.getPluginManager().registerEvents(EndedSeasone(), this)

        Bukkit.getPluginManager().registerEvents(BorderEvent(), this)
        Bukkit.getPluginManager().registerEvents(TeleportBackroomsEvent(), this)
        Bukkit.getPluginManager().registerEvents(BorderEvent(), this)

        Bukkit.getPluginManager().registerEvents(DuelsEvents(), this)

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
