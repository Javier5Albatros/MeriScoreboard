package es.meriland.listeners;

import es.meriland.BoardManager;
import es.meriland.MeriScoreboard;
import es.meriland.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class PlayerJoinListener implements Listener {
    MeriScoreboard plugin = MeriScoreboard.getPlugin();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        String uuid = event.getPlayer().getUniqueId().toString();
        if(plugin.getPlayersData().contains(uuid)) {
            if(plugin.getPlayersData().getBoolean(uuid)) {
                BoardManager.showBoard(event.getPlayer(), Utils.translate(event.getPlayer(), MeriScoreboard.untranslated));
            }
        } else {
            plugin.setPlayerData(uuid, true);
            BoardManager.showBoard(event.getPlayer(), Utils.translate(event.getPlayer(), MeriScoreboard.untranslated));
        }
    }
}
