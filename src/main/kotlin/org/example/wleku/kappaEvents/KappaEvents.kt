package org.example.wleku.kappaEvents

import BuyCommandJava
import PricesCommandJava
import SellCommandJava
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

        val enablingFart = this.config.getBoolean("FartCommand")
        val enablingSex = this.config.getBoolean("SexCommand")

        if (enablingFart == true) {
            getCommand("fart")?.setExecutor(FartCommand())
        }

        if (enablingSex == true) {
            getCommand("sex")?.setExecutor(SexCommand())
        }

        getCommand("buy")?.setExecutor(BuyCommandJava())
        getCommand("sell")?.setExecutor(SellCommandJava())
        getCommand("price")?.setExecutor(PricesCommandJava())

        Bukkit.getPluginManager().registerEvents(FirstTimeEvent(), this)

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
