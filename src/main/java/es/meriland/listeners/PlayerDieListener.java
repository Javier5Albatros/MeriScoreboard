package es.meriland.listeners;

import es.meriland.MeriScoreboard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerDieListener implements Listener {

    @EventHandler
    public void onDie(PlayerRespawnEvent event) {
        System.out.println("a");
    }
}
