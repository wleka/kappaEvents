import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellenteconomy.api.ExcellentEconomyAPI;

public class SellCommandJava implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        RegisteredServiceProvider<ExcellentEconomyAPI> provider = Bukkit.getServer().getServicesManager().getRegistration(ExcellentEconomyAPI.class);
        ExcellentEconomyAPI api = provider.getProvider();

        Player player = (Player) sender;

        double balance = api.getBalance(player, "money");

        Inventory inventory = ((Player) sender).getInventory();
        int totalDirt = 0;
        double priceDirt = 1.0;

        for (ItemStack item: inventory.getContents()) {
            if (item != null && item.getType() == Material.DIRT) {
                totalDirt += item.getAmount();
                inventory.remove(Material.DIRT);
            }
        }

        if (totalDirt == 0) {
            sender.sendMessage("§cУ вас нет земли. Накопайте его.");
        }

        double totalPayout = totalDirt + priceDirt;

        api.setBalance(player, "money", balance + totalPayout);

        sender.sendMessage("§7Вы получили : §a" + totalPayout + "§7ваш баланс : §a" + balance);
        return true;
    }
}
