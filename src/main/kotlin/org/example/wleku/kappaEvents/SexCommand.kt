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
            sender.sendMessage("§cНапиши ник игрока §8: §f/sex {player}")
            return true
        }

        if (sender is Player) {
            val player = Bukkit.getPlayer(args[0])

            if (player == null) {
                sender.sendMessage("§cИгрока нет в сети.")
            } else {
                sender.sendActionBar(Component.text("§7Вы занялись сексом с §f${args[0]}"))

                if (player.name == sender.name) {
                    Bukkit.broadcastMessage("§f${sender.name} §7занялся самоотсосом")
                } else {
                    Bukkit.broadcastMessage("§f${sender.name} §7занялся сексом с §f${args[0]}")
                }
            }
        }

        return true
    }
}