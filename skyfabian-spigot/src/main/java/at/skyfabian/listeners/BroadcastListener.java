package at.skyfabian.listeners;

import at.skyfabian.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BroadcastListener {

    private final long MESSAGE_DELAY = 5*900;
    private final String ROOT = "BroadcastMessages";

    private final Main plugin;
    private final FileConfiguration configuration;

    public BroadcastListener(Main plugin) {
        this.plugin = plugin;
        configuration = plugin.getConfig();

        createDefaults();
    }

    public void startBroadcast() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', pickMessage()));
            }
        }, 0, MESSAGE_DELAY);
    }

    private void createDefaults() {
        if (configuration.contains(ROOT)) return;
        List<String> defaults = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            defaults.add("&7Testnachricht Nr. \n test" + i);
        configuration.set(ROOT, defaults);
        plugin.saveConfig();
    }

    private String pickMessage() {
        List<String> message = configuration.getStringList(ROOT);
        int random = new Random().nextInt(message.size());
        return message.get(random);
    }

}
