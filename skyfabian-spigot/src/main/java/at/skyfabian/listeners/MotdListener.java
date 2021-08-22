package at.skyfabian.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MotdListener implements Listener {
    @EventHandler

    public void onMotd(ServerListPingEvent event) {
        event.setMotd("                       §7•§8● §9Netzwerk§8.§9at §8●§7•" + "\n" + "                     §8× §7§nWir suchen dich§7! §8×");
    }
}
