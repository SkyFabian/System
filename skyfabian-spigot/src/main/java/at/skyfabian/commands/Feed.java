package at.skyfabian.commands;

import at.skyfabian.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("heal")) {
                player.setFoodLevel(20);
                player.sendMessage(Main.getPrefix() + "§7Du wurdest §ageheilt§7.");
            }else {
                player.sendMessage(Main.getPrefix() + Main.noPerm());
            }
        }else {
            sender.sendMessage(Main.onlyPlayer());
        }

        return false;
    }
}
