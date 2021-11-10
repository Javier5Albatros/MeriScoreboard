package es.meriland.listeners;

import es.meriland.BoardManager;
import es.meriland.MeriScoreboard;
import es.meriland.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import su.nexmedia.goldenchallenges.api.events.custom.PlayerChallengeCompleteEvent;
import su.nexmedia.goldenchallenges.api.events.custom.PlayerChallengeObjectiveEvent;

public class ChallengeListener implements Listener {

    @EventHandler
    public void onChallengeComplete(PlayerChallengeCompleteEvent event) {
        Player player = event.getPlayer().getPlayer();
        String uuid = player.getUniqueId().toString();
        double progress = event.getUser().getChallengeData(event.getType()).getProgressPercent();
        if(progress == 100.0) {
            BoardManager.hideBoard(player);
        } else {
            if(MeriScoreboard.getPlugin().getPlayersData().getBoolean(uuid)) {
                BoardManager.showBoard(player, Utils.getTranslated(player));
            }
        }
    }

    @EventHandler
    public void onChallengeObjective(PlayerChallengeObjectiveEvent event) {
        Player player = event.getPlayer().getPlayer();
        String uuid = player.getUniqueId().toString();
        if(MeriScoreboard.getPlugin().getPlayersData().getBoolean(uuid)) {
            BoardManager.showBoard(player, Utils.getTranslated(player));
        }
    }
}
