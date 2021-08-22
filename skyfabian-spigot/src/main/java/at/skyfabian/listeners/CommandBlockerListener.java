package at.skyfabian.listeners;

import at.skyfabian.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandBlockerListener implements Listener {

    @EventHandler
    public void CommandBlocker(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();

        String[] cmd = event.getMessage().substring(1).split(" ");

        if (cmd[0].startsWith("bukkit")) {
            if (!player.hasPermission("commandblocker")) {
                player.sendMessage(Main.getPrefix() + Main.noPerm());
                event.setCancelled(true);
            }
        }
        if (cmd[0].startsWith("spigot")) {
            if (!player.hasPermission("commandblocker")) {
                player.sendMessage(Main.getPrefix() + Main.noPerm());
                event.setCancelled(true);
            }
        }
        if (cmd[0].startsWith("permissionsex")) {
            if (!player.hasPermission("commandblocker")) {
                player.sendMessage(Main.getPrefix() + Main.noPerm());
                event.setCancelled(true);
            }
        }
        if (cmd[0].equalsIgnoreCase("plugin") || cmd[0].equalsIgnoreCase("pl") || cmd[0].equalsIgnoreCase("plugins") ||
                cmd[0].equalsIgnoreCase("?") || cmd[0].equalsIgnoreCase("help") || cmd[0].equalsIgnoreCase("about") ||
                cmd[0].equalsIgnoreCase("ver") || cmd[0].equalsIgnoreCase("version")|| cmd[0].equalsIgnoreCase("me")) {
            if (!player.hasPermission("commandblocker")) {
                player.sendMessage(Main.getPrefix() + Main.noPerm());
                event.setCancelled(true);
            }
        }
        if (cmd[0].equalsIgnoreCase("op")){
            if (!player.hasPermission("commandblocker")) {
                player.sendMessage(Main.getPrefix() + Main.noPerm());
                event.setCancelled(true);
            }
        }
        if (cmd[0].equalsIgnoreCase("server")){
            if (!player.hasPermission("commandblocker")) {
                player.sendMessage(Main.getPrefix() + Main.noPerm());
                event.setCancelled(true);
            }
        }
        if (cmd[0].equalsIgnoreCase("deop")){
            if (!player.hasPermission("commandblocker")) {
                player.sendMessage(Main.getPrefix() + Main.noPerm());
                event.setCancelled(true);
            }
        }
        if (cmd[0].equalsIgnoreCase("gm") || cmd[0].equalsIgnoreCase("gamemode")){
            if (!player.hasPermission("commandblocker")) {
                player.sendMessage(Main.getPrefix() + Main.noPerm());
                event.setCancelled(true);
            }
        }
        if (cmd[0].equalsIgnoreCase("pex")){
            if (!player.hasPermission("commandblocker")) {
                player.sendMessage(Main.getPrefix() + Main.noPerm());
                event.setCancelled(true);
            }
        }
        if (cmd[0].equalsIgnoreCase("whitelist")){
            if (!player.hasPermission("commandblocker")) {
                player.sendMessage(Main.getPrefix() + Main.noPerm());
                event.setCancelled(true);
            }
        }
    }
}
