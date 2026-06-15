
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellenteconomy.api.ExcellentEconomyAPI;
import su.nightexpress.excellenteconomy.api.currency.ExcellentCurrency;


import java.util.UUID;

public class BuyCommandJava implements CommandExecutor{

    String successed = "§aВы приобрели товар, §7ваш текущий баланс : ";
    String nomoney = "§cНедостаточно средств";

    // shovels
    Double goldPrice = 10.0;
    Double woodenPrice = 67.0;
    Double stonePrice = 150.0;
    Double ironPrice = 500.0;
    Double diaPrice = 2500.0;
    Double netherPrice = 5000.0;
    Double superLowPrice = 8000.0;
    Double superMidPrice = 10000.0;
    Double superPrice = 25000.0;

    // kits
    Double elytraPrice = 50000.0;
    Double superElytraPrice = 100000.0;
    Double rocketPrice = 500.0;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        RegisteredServiceProvider<ExcellentEconomyAPI> provider = Bukkit.getServer().getServicesManager().getRegistration(ExcellentEconomyAPI.class);
        ExcellentEconomyAPI api = provider.getProvider();

        Player player = (Player) sender;
        double balance = api.getBalance(player, "money");
        Inventory inventory = ((Player) sender).getInventory();

        if (args.length < 0 && args[0] == null) {
            sender.sendMessage("§cДля приобритение /buy {тип} или /buy list, для списков товаров.");
        }

        switch (args[0]) {
            case "golden" -> {
                if (balance > woodenPrice) {
                    double result = balance - goldPrice;
                    sender.sendMessage(successed + result);
                    api.setBalance(player, "money", result);

                    ItemStack item = ItemStack.of(Material.GOLDEN_SHOVEL);

                    ItemMeta meta = item.getItemMeta();

                    if (meta != null) {
                        // meta.addEnchant(Enchantment.EFFICIENCY, 5, true);
                        // meta.addEnchant(Enchantment.UNBREAKING, 3, true);
                        meta.setDisplayName("§7Начинающая лопата");
                        item.setItemMeta(meta);
                    }

                    inventory.addItem(item);

                } else {
                    sender.sendMessage(nomoney + balance);
                }
            }

            case "wooden" -> {
                if (balance > woodenPrice) {
                    double result = balance - woodenPrice;
                    sender.sendMessage(successed + result);
                    api.setBalance(player, "money", result);

                    ItemStack item = ItemStack.of(Material.WOODEN_SHOVEL);

                    ItemMeta meta = item.getItemMeta();

                    if (meta != null) {
                        // meta.addEnchant(Enchantment.EFFICIENCY, 5, true);
                        // meta.addEnchant(Enchantment.UNBREAKING, 3, true);
                        meta.setDisplayName("§7Деревянная лопата");
                        item.setItemMeta(meta);
                    }

                    inventory.addItem(item);

                } else {
                    sender.sendMessage(nomoney + balance);
                }
            }

            case "stone" -> {
                if (balance > stonePrice) {
                    double result = balance - stonePrice;
                    sender.sendMessage(successed + result);
                    api.setBalance(player, "money", result);

                    ItemStack item = ItemStack.of(Material.STONE_SHOVEL);

                    ItemMeta meta = item.getItemMeta();

                    if (meta != null) {
                        // meta.addEnchant(Enchantment.EFFICIENCY, 5, true);
                        // meta.addEnchant(Enchantment.UNBREAKING, 3, true);
                        meta.setDisplayName("§7Каменная лопата");
                        item.setItemMeta(meta);
                    }

                    inventory.addItem(item);

                } else {
                    sender.sendMessage(nomoney + balance);
                }
            }

            case "iron" -> {
                if (balance > ironPrice) {
                    double result = balance - ironPrice;
                    sender.sendMessage(successed + result);
                    api.setBalance(player, "money", result);

                    ItemStack item = ItemStack.of(Material.IRON_SHOVEL);

                    ItemMeta meta = item.getItemMeta();

                    if (meta != null) {
                        // meta.addEnchant(Enchantment.EFFICIENCY, 5, true);
                        // meta.addEnchant(Enchantment.UNBREAKING, 3, true);
                        meta.setDisplayName("§fЖелезная лопата");
                        item.setItemMeta(meta);
                    }

                    inventory.addItem(item);

                } else {
                    sender.sendMessage(nomoney + balance);
                }
            }

            case "diamond" -> {
                if (balance > diaPrice) {
                    double result = balance - diaPrice;
                    sender.sendMessage(successed + result);
                    api.setBalance(player, "money", result);

                    ItemStack item = ItemStack.of(Material.DIAMOND_SHOVEL);

                    ItemMeta meta = item.getItemMeta();

                    if (meta != null) {
                        // meta.addEnchant(Enchantment.EFFICIENCY, 5, true);
                        // meta.addEnchant(Enchantment.UNBREAKING, 3, true);
                        meta.setDisplayName("§9Алмазная лопата");
                        item.setItemMeta(meta);
                    }

                    inventory.addItem(item);

                } else {
                    sender.sendMessage(nomoney + balance);
                }
            }

            case "netherite" -> {
                if (balance > netherPrice) {
                    double result = balance - netherPrice;
                    sender.sendMessage(successed + result);
                    api.setBalance(player, "money", result);

                    ItemStack item = ItemStack.of(Material.NETHERITE_SHOVEL);

                    ItemMeta meta = item.getItemMeta();

                    if (meta != null) {
                        // meta.addEnchant(Enchantment.EFFICIENCY, 5, true);
                        // meta.addEnchant(Enchantment.UNBREAKING, 3, true);
                        meta.setDisplayName("§4Незеритовая лопата");
                        item.setItemMeta(meta);
                    }

                    inventory.addItem(item);

                } else {
                    sender.sendMessage(nomoney + balance);
                }
            }

            case "superlow" -> {
                if (balance > superLowPrice) {
                    double result = balance - superLowPrice;
                    sender.sendMessage(successed + result);
                    api.setBalance(player, "money", result);

                    ItemStack item = ItemStack.of(Material.IRON_SHOVEL);

                    ItemMeta meta = item.getItemMeta();

                    if (meta != null) {
                        meta.addEnchant(Enchantment.EFFICIENCY, 2, true);
                        meta.addEnchant(Enchantment.UNBREAKING, 1, true);
                        meta.setDisplayName("§4Супер-низкая лопата");
                        item.setItemMeta(meta);
                    }

                    inventory.addItem(item);

                } else {
                    sender.sendMessage(nomoney + balance);
                }
            }

            case "supermid" -> {
                if (balance > superMidPrice) {
                    double result = balance - superMidPrice;
                    sender.sendMessage(successed + result);
                    api.setBalance(player, "money", result);

                    ItemStack item = ItemStack.of(Material.DIAMOND_SHOVEL);

                    ItemMeta meta = item.getItemMeta();

                    if (meta != null) {
                        meta.addEnchant(Enchantment.UNBREAKING, 2, true);
                        meta.setDisplayName("§4Супер-средняя лопата");
                        item.setItemMeta(meta);
                    }

                    inventory.addItem(item);

                } else {
                    sender.sendMessage(nomoney + balance);
                }
            }

            case "super" -> {
                if (balance > superPrice) {
                    double result = balance - superPrice;
                    sender.sendMessage(successed + result);
                    api.setBalance(player, "money", result);

                    ItemStack item = ItemStack.of(Material.DIAMOND_SHOVEL);

                    ItemMeta meta = item.getItemMeta();

                    if (meta != null) {
                        meta.addEnchant(Enchantment.EFFICIENCY, 3, true);
                        meta.addEnchant(Enchantment.UNBREAKING, 2, true);
                        meta.setDisplayName("§eСупер лопата");
                        item.setItemMeta(meta);
                    }

                    inventory.addItem(item);

                } else {
                    sender.sendMessage(nomoney + balance);
                }
            }

            // ОСТАЛЬНЫЕ ВЕЩИ

            case "elytra" -> {
                if (balance > elytraPrice) {
                    double result = balance - elytraPrice;
                    sender.sendMessage(successed + result);
                    api.setBalance(player, "money", result);

                    ItemStack item = ItemStack.of(Material.ELYTRA);

                    ItemMeta meta = item.getItemMeta();

                    if (meta != null) {
                        meta.setDisplayName("§eОбычные элитры");
                        item.setItemMeta(meta);
                    }

                    inventory.addItem(item);

                } else {
                    sender.sendMessage(nomoney + balance);
                }
            }

            case "superelytra" -> {
                if (balance > superElytraPrice) {
                    double result = balance - superElytraPrice;
                    sender.sendMessage(successed + result);
                    api.setBalance(player, "money", result);

                    ItemStack item = ItemStack.of(Material.ELYTRA);

                    ItemMeta meta = item.getItemMeta();

                    if (meta != null) {
                        meta.addEnchant(Enchantment.UNBREAKING, 3, true);
                        meta.setDisplayName("§5СУПЕР элитры");
                        item.setItemMeta(meta);
                    }

                    inventory.addItem(item);

                } else {
                    sender.sendMessage(nomoney + balance);
                }
            }

            case "rocket" -> {
                if (balance > rocketPrice) {
                    double result = balance - rocketPrice;
                    sender.sendMessage(successed + result);
                    api.setBalance(player, "money", result);

                    ItemStack item = ItemStack.of(Material.FIREWORK_ROCKET, 16);

                    ItemMeta meta = item.getItemMeta();

                    if (meta != null) {
                        meta.setDisplayName("§7Фейрверки");
                        item.setItemMeta(meta);
                    }

                    inventory.addItem(item);

                } else {
                    sender.sendMessage(nomoney + balance);
                }
            }

            default -> {
                sender.sendMessage("Данного товара нет, введите /price");
            }

        }

        return true;
    }
}
