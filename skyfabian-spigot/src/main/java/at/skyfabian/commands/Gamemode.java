package at.skyfabian.commands;

import at.skyfabian.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(Main.getPrefix() + Main.onlyPlayer());
        }else{
            final Player player = ((Player)sender);

            if(player.hasPermission("gm")){
                if(args.length == 1){

                    if(args[0].equalsIgnoreCase("0")){
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(Main.getPrefix() + "§7Du bist nun im §cÜberlebens-Modus§7.");

                    }else if(args[0].equalsIgnoreCase("1")){
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(Main.getPrefix() + "§7Du bist nun im §cKreativ-Modus§7.");

                    }else if(args[0].equalsIgnoreCase("2")){
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(Main.getPrefix() + "§7Du bist nun im §cAbenteuer-Modus§7.");

                    } else if (args[0].equalsIgnoreCase("3")){
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(Main.getPrefix() + "§7Du bist nun im §cZuschauer-Modus§7.");
                    }

                }else if(args.length == 2){
                    if(player.hasPermission("gm.others")){

                        final Player target = Bukkit.getPlayer(args[0]);

                        if(args[1].equalsIgnoreCase("0")){
                            target.setGameMode(GameMode.SURVIVAL);
                            target.sendMessage(Main.getPrefix() + "§7Du bist nun im §cÜberlebens-Modus§7.");
                            player.sendMessage(Main.getPrefix() + "§7Der Spieler §e" + target.getName() +  " §7Ist nun im §cÜberlebens-Modus§7.");

                        }else if(args[1].equalsIgnoreCase("1")){
                            target.setGameMode(GameMode.CREATIVE);
                            target.sendMessage(Main.getPrefix() + "§7Du bist nun im §cKreativ-Modus§7.");
                            player.sendMessage(Main.getPrefix() + "§7Der Spieler §e" + target.getName() + "§7 Ist nun im §cKreativ-Modus§7.");

                        }else if(args[1].equalsIgnoreCase("2")){
                            target.setGameMode(GameMode.ADVENTURE);
                            target.sendMessage(Main.getPrefix() + "§7Du bist nun im §cAbenteuer-Modus§7.");
                            player.sendMessage(Main.getPrefix() + "§7Der Spieler §e" + target.getName() + "§7 Ist nun im §cAbenteuer-Modus§7.");

                        }else if(args[1].equalsIgnoreCase("3")){
                            target.setGameMode(GameMode.SPECTATOR);
                            target.sendMessage(Main.getPrefix() + "§7Du bist nun im §cZuschauer-Modus§7.");
                            player.sendMessage(Main.getPrefix() + "§7Der Spieler §e" + target.getName() + "§7 Ist nun im §cZuschauer-Modus§7.");

                        }

                    }else{
                        player.sendMessage(Main.getPrefix() + Main.noPerm());
                    }
                }else{
                    player.sendMessage("§7Verwende §8» §7/gm §7<§c0§7-§c3§7> §7[<§9Spieler§7>]");
                }
            }else{
                player.sendMessage(Main.getPrefix() + Main.noPerm());
            }

        }

        return false;
    }
}