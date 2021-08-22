package at.skyfabian.util;

import com.connorlinfoot.titleapi.TitleAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

public class TablistUtils implements Listener {
    public static Scoreboard sb;

    //HEADER AND FOOTER
    @EventHandler
    public void tablist(PlayerJoinEvent event){
        Player player = (Player) event.getPlayer();
        TitleAPI.sendTitle(player, 5, 5, 5, "Willkommen");
        TitleAPI.sendTabTitle(player, "\n§r §b§lNetzwerk§8§l.§b§lat §7Netzwerk §8» §c§l§nBETA§r \n §3Server §8» §b§lLobby \n"
                                    , "\n §7Twitter §8» @§3NetzwerkAT \n §7Discord §8» §3discord.gg/link" );
    }
}
