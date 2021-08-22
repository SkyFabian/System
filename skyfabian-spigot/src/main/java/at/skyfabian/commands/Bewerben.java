package at.skyfabian.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Bewerben implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Bewerben bewerben = new Bewerben();
        sender.sendMessage("§7§m---------------§r §9§lNetzwerk§7§l.§9§lat §r§7§m---------------");
        sender.sendMessage("§7 ");
        sender.sendMessage("§7Alle anforderungen für jeden Rang findest du auf unseren Discord.");
        sender.sendMessage("§a§l⋙ §7Verwende dafür /dc");
        sender.sendMessage("§a§l⋙ §7Es gilt für jeden Rang:");
        sender.sendMessage("§a§l⋙ §7Ein Alter von mindestens 14 Jahren");
        sender.sendMessage("§1 ");
        sender.sendMessage("§7§m---------------§r §9§lNetzwerk§7§l.§9§lat §r§7§m---------------§4");
        return false;
    }
}
