package at.skyfabian.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {

        final Player player = event.getPlayer();
        setScoreboard(event.getPlayer());
        Bukkit.getWorld("world").setMonsterSpawnLimit(0);
        Bukkit.getWorld("world").setDifficulty(Difficulty.PEACEFUL);
        event.getPlayer().setGameMode(GameMode.ADVENTURE);
        event.getPlayer().setFoodLevel(20);
        event.getPlayer().setHealth(20);
        event.getPlayer().getInventory().clear();
        event.setJoinMessage("§8[§a+§8] §7" + player.getName());

    }

    @EventHandler
    public void onQuit(final PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        event.setQuitMessage("§8[§c-§8] §7" + player.getName());
    }

    @EventHandler
    public void onChat(final AsyncPlayerChatEvent event) {

        final Player player = event.getPlayer();
        final  String message = event.getMessage().replace("%", "%%");

        if (player.hasPermission("owner")) {
            event.setFormat("§4§lOwner §8✕ §4" + player.getName() + " §8» §r" + message);
            return;
        } else if (player.hasPermission("admin")) {
            event.setFormat("§4Admin §8✕ §c" + player.getName() + " §8» §r" + message);
            return;
        }else if (player.hasPermission("srmoderator")) {
            event.setFormat("§cSrMod §8✕ §c" + player.getName() + " §8» §r" + message);
            return;
        }else if (player.hasPermission("moderator")) {
            event.setFormat("§9Mod §8✕ §9" + player.getName() + " §8» §r" + message);
            return;
        }else if (player.hasPermission("developer")) {
            event.setFormat("§bDev §8✕ §b" + player.getName() + " §8» §r" + message);
            return;
        }else if (player.hasPermission("content")) {
            event.setFormat("§eContent §8✕ §e" + player.getName() + " §8» §r" + message);
            return;
        }else if (player.hasPermission("supporter")) {
            event.setFormat("§aSup §8✕ §a" + player.getName() + " §8» §r" + message);
            return;
        }else if (player.hasPermission("builder")) {
            event.setFormat("§eBuilder §8✕ §e" + player.getName() + " §8» §r" + message);
            return;
        }else if (player.hasPermission("jrsupporter")) {
            event.setFormat("§dJrSup §8✕ " + player.getName() + " §8» §r" + message);
            return;
        }else if (player.hasPermission("jrbuilder")) {
            event.setFormat("§dJrBuilder §8✕ §d" + player.getName() + " §8» §r" + message);
            return;
        }else if (player.hasPermission("youtuber")) {
            event.setFormat("§5YouTuber §8✕ §5" + player.getName() + " §8» §r" + message);
            return;
        }else if (player.hasPermission("Sky")) {
            event.setFormat("§1§lS§9§lk§3§ly §8✕ §b" + player.getName() + " §8» §r" + message);
            return;
        }else if (player.hasPermission("premium")) {
            event.setFormat("§6Premium §8✕ §6" + player.getName() + " §8» §r" + message);
            return;
        }else if (player.hasPermission("default")){
           event.setFormat("§7Spieler §8✕ §7" + player.getName() + " §8» §r" + message);
        }else {
            event.setCancelled(true);
            event.getPlayer().sendMessage("§9Sky§7-§9Party §8» §7Du darfst in der Lobby nicht schreiben.");
        }

    }

    private void setScoreboard(final Player player) {

        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

        final Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective objective = scoreboard.registerNewObjective("aaa", "bbb");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§9Test§7.§9at");

        {
            Team team = scoreboard.registerNewTeam("x7");
            team.setPrefix("§7");
            team.addEntry("§7");
            objective.getScore("§7").setScore(7);
        }

        {
            Team team = scoreboard.registerNewTeam("x6");
            team.setPrefix("§7✕ ");
            team.setSuffix("§7Name§7:");
            team.addEntry("§6");
            objective.getScore("§6").setScore(6);
        }

        {
            Team team = scoreboard.registerNewTeam("x5");
            team.setPrefix(" §8»§3 " + player.getName());
            team.addEntry("§5");
            objective.getScore("§5").setScore(5);
        }

        {
            Team team = scoreboard.registerNewTeam("x4");
            team.setPrefix("§4");
            team.addEntry("§4");
            objective.getScore("§4").setScore(4);
        }

        {
            Team team = scoreboard.registerNewTeam("x3");
            team.setPrefix("§7✕ ");
            team.setSuffix("§7Online§7:");
            team.addEntry("§3");
            objective.getScore("§3").setScore(3);
        }

        {
            Team team = scoreboard.registerNewTeam("x1");
            team.setPrefix("§1");
            team.addEntry("§1");
            objective.getScore("§1").setScore(1);
        }

        {
            Team team = scoreboard.registerNewTeam("x0");
            team.setPrefix(" §8»§b " + Bukkit.getOnlinePlayers().size() + "§8/§b100");
            team.addEntry("§2");
            objective.getScore("§2").setScore(2);
        }

        player.setScoreboard(scoreboard);
    }
    public void updateScoreboard(final Player player) {

        if (player.getScoreboard() == null || player.getScoreboard().getObjective(DisplaySlot.SIDEBAR) == null)
            return;
        player.getScoreboard().getTeam("x0").setPrefix(" §8» §b" + Bukkit.getOnlinePlayers().size() + "§8/§b100");

    }
}
