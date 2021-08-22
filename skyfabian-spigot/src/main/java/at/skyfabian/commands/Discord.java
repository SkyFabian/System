package at.skyfabian.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Discord implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Discord dc = new Discord();
        sender.sendMessage("§7§m--------------- §9§lNetzwerk§7§l.§9§lat §r§7§m---------------");
        sender.sendMessage("§7 ");
        sender.sendMessage("§a§l⋙ §9Discord§7-§9Link§7.");
        sender.sendMessage("§1 ");
        sender.sendMessage("§7§m--------------- §9§lNetzwerk§7§l.§9§lat §r§7§m---------------§4");
        return false;
    }
}
