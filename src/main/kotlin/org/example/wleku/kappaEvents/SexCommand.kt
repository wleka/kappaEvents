package org.example.wleku.kappaEvents

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SexCommand: CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        string: String,
        args: Array<out String>
    ): Boolean {

        if (args.isEmpty()) {
            sender.sendMessage("§cPlease write player name §8: §f/sex {player}")
            return true
        }

        if (sender is Player) {
            val player = Bukkit.getPlayer(args[0])

            if (player == null) {
                sender.sendMessage("§cPlayer's not online")
            } else {
                sender.sendActionBar(Component.text("§7You make sex with §f${args[0]}"))

                if (player.name == sender.name) {
                    Bukkit.broadcastMessage("§f${sender.name} §7make self-sucks")
                } else {
                    Bukkit.broadcastMessage("§f${sender.name} §7maked sex with §f${args[0]}")
                }
            }
        }

        return true
    }
}