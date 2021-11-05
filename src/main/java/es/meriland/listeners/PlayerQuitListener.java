package es.meriland.listeners;

import es.meriland.MeriScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        MeriScoreboard.scoreboardDataMap.remove(event.getPlayer().getUniqueId());
    }
}
