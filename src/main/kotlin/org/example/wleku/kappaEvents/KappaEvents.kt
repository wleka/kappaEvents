package org.example.wleku.kappaEvents

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
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
