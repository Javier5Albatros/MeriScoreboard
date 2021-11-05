package es.meriland.listeners;

import es.meriland.BoardManager;
import es.meriland.MeriScoreboard;
import es.meriland.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        BoardManager.showBoard(event.getPlayer(), Utils.translate(event.getPlayer(), MeriScoreboard.untranslated));
    }
}
