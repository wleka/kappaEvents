package org.example.wleku.kappaEvents

import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryType

class EndedSeasone: Listener {

    val plugin = KappaEvents.instance
    val warning = "\n§cВы не можете сделать ЭТО! Данный сезон закончился, поэтому ждите следующий сезон для игры.\n"
    val endSeasone = plugin.config.getBoolean("endSeasone")

    @EventHandler
    fun onDisableBroke(event: BlockBreakEvent) {
        if (endSeasone == true) {

            if (!event.player.isOp) {
                event.isCancelled = true

                event.player.sendMessage(warning)
            } else {
                event.isCancelled = false
            }
        }
    }

    @EventHandler
    fun onDisablePlacement(event: BlockPlaceEvent) {
        if (endSeasone == true) {
            if (!event.player.isOp) {
                event.isCancelled = true
                event.player.sendMessage(warning)
            } else {
                event.isCancelled = false
            }
        }
    }

    @EventHandler
    fun onDisablePVP(event: EntityDamageEvent) {

        if (endSeasone == true) {

            if (event.entity is Player) {
                if (!event.entity.isOp) {
                    event.isCancelled = true
                    // event.entity.sendMessage(warning)
                } else {
                    event.isCancelled = false
                }
            }
        }
    }

    @EventHandler
    fun onDisableTaking (event: InventoryClickEvent) {

        val blocksList = arrayListOf<InventoryType>(
            InventoryType.CHEST,
            InventoryType.BARREL,
            InventoryType.SHULKER_BOX,
            InventoryType.BEACON,
            InventoryType.HOPPER,
            InventoryType.FURNACE,
            InventoryType.BREWING,
            InventoryType.BLAST_FURNACE
        )

        if (endSeasone == true) {
            for (disableChests in blocksList) {
                if (event.clickedInventory?.type == disableChests) {
                    if (!event.whoClicked.isOp) {
                        event.isCancelled = true
                    } else {
                        event.isCancelled = false
                    }
                }
            }
        }
    }
}