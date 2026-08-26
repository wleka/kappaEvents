package org.example.wleku.kappaEvents

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class FartCommand: CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        p1: Command,
        p2: String,
        p3: Array<out String>
    ): Boolean {

        if (sender is Player) {
            sender.sendMessage("you're farted now.")
            sender.world.playSound(sender.location, org.bukkit.Sound.ENTITY_SHULKER_SHOOT, 1.5f, 1f)
        }

        return true
    }
}