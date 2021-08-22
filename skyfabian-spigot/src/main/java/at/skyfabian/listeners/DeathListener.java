package at.skyfabian.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if (event.getEntity() != null) {
            Player player = event.getEntity();
        } else {
            event.setDeathMessage("");
        }
        event.setDeathMessage("");
    }
}