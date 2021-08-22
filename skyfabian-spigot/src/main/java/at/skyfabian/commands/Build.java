package at.skyfabian.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;

public class Build implements Listener, CommandExecutor {

    public static ArrayList<Player> allowedPlayer = new ArrayList<Player>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("build")){
            Player p = (Player) sender;
            if(p.hasPermission("build.setup")) {
                if (args.length == 0) {
                    if (p instanceof Player) {
                        if (p.getWorld().getName().equals("world")) {
                            if (allowedPlayer.contains(p)) {
                                allowedPlayer.remove(p);
                                p.sendMessage("§eDu hast den Baumodus §cverlassen!");
                            } else {
                                allowedPlayer.add(p);
                                p.sendMessage("§eDu hast den Baumodus §abetreten!");
                            }
                        }else{
                            p.sendMessage("§cDieser Command ist auf dieser Welt nicht gestattet!");
                            return true;
                        }
                    }
                } else {
                    p.sendMessage("§c/Build");
                }
            }else{
                p.sendMessage("§cDu hast keine Rechte um dies zu tun!");
            }
        }
        return false;
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(p.getWorld().getName().equals("world")){
            if(!allowedPlayer.contains(p)){
                e.setCancelled(true);
                p.sendMessage("§cDu darfst nichts abbauen!");
                return;
            }
        }else{
            return;
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(p.getWorld().getName().equals("world")){
            if(!allowedPlayer.contains(p)){
                e.setCancelled(true);
                p.sendMessage("§cDu darfst nichts abbauen!");
                return;
            }
        }else{
            return;
        }
    }
}
