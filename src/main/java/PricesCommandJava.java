import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class PricesCommandJava implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        sender.sendMessage(
                "§7-----------------------\n" +
                "§6Список товаров 1/3 : \n" +
                "§7Деревянная лопата (/buy wooden) - 50$\n" +
                "§7Каменная лопата (/buy stone) - 150$\n" +
                "§7Железная лопата (/buy iron) - 500$\n" +
                "§7Алмазная лопата (/buy diamond) - 2500$\n" +
                "§6Следующая страница /price 2"
        );

        switch (args[0]) {
            case "1" -> {
                sender.sendMessage(
                "§7-----------------------\n" +
                "§6Список товаров 1/3 : \n" +
                "§7Золотая лопата (/buy golden) - 10$\n" +
                "§7Деревянная лопата (/buy wooden) - 67$\n" +
                "§7Каменная лопата (/buy stone) - 150$\n" +
                "§7Железная лопата (/buy iron) - 500$\n" +
                "§7Алмазная лопата (/buy diamond) - 2500$\n" +
                "§6Следующая страница /price 2"
                );
            }
            case "2" -> {
                sender.sendMessage(
                "§7-----------------------\n" +
                "§6Список товаров 2/3 : \n" +
                "§7Незеритовая лопата (/buy netherite) - 5000$\n" +
                "§4Супер-низкая лопата (/buy superlow) - 10.000$\n" +
                "§4Супер-средняя лопата (/buy supermid) - 15.000$\n" +
                "§eСУПЕР ЛОПАТА (/buy super) - 25.000$\n" +
                "§6Предыдущая /price 1, Следующая /price 2"
                );
            }
            case "3" -> {
                sender.sendMessage(
                "§7-----------------------\n" +
                "§6Список товаров 3/3 §8: \n" +
                "§eОбычные элитры (/buy elytra) - 50.000$\n" +
                "§5СУПЕР ЭЛИТРЫ (/buy superelytra) - 100.000$\n" +
                "§7Фейрверки (/buy rocket) - 500$\n" +
                "§6Предыдущая /price 3"
                );
            }
        }

        return true;
    }
}
