package at.skyfabian;

import at.skyfabian.commands.*;
import at.skyfabian.listeners.*;
import at.skyfabian.util.TablistUtils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        System.out.println(server()+ "Plugin wird geladen.");

        instance = this;
        commandRegistration();
        listenerRegistration();

        new BroadcastListener(this).startBroadcast();

        Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, () -> {
            for (Player all : Bukkit.getOnlinePlayers()) {
                new PlayerJoinListener().updateScoreboard(all);
            }
        }, 0 , 20 );
    }

    private void commandRegistration() {
        getCommand("feed").setExecutor(new Feed());
        getCommand("heal").setExecutor(new Heal());
        getCommand("gamemode").setExecutor(new Gamemode());
        getCommand("youtube").setExecutor(new YouTube());
        getCommand("bewerben").setExecutor(new Bewerben());
        getCommand("discord").setExecutor(new Discord());
        getCommand("build").setExecutor(new Build());
    }

    private void listenerRegistration() {
        PluginManager pluginmanager = Bukkit.getPluginManager();
        pluginmanager.registerEvents(new SignChangeListener(), this);
        pluginmanager.registerEvents(new DeathListener(), this);
        pluginmanager.registerEvents(new CommandBlockerListener(), this);
        pluginmanager.registerEvents(new MotdListener(), this);
        pluginmanager.registerEvents(new PlayerJoinListener(), this);
        pluginmanager.registerEvents(new TablistUtils(), this);
    }

    @Override
    public void onDisable() {
    }

    public static String server() {
        return "§9Netzwerk§8.§9at";
    }

    public static String getPrefix() {
        return "§8« §9§nLobby§r §8» " ;
    }

    public static String noPerm() {
        return ChatColor.GRAY + "Dafür hast du " + ChatColor.RED + "keine" + ChatColor.GRAY + " Berechtigung.";
    }

    public static String onlyPlayer() {
        return ChatColor.GRAY + "Nur Spieler dürfen dies.";
    }

    public static String use() {
        return ChatColor.GRAY + "Verwende » ";
    }

    public static Main getInstance() {
        return instance;
    }
}