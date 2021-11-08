package es.meriland;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import java.util.List;

public class BoardManager {


    public static void showBoard(Player player, List<String> translated) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("meriScoreboard", "dummy");
        String title = Utils.colorize(Utils.cutString(MeriScoreboard.title, 32));

        for(int i = 0; i < translated.size(); i++) {
            String line = Utils.cutString(translated.get(i), 40);
            line = Utils.colorize(line);
            Score score = objective.getScore(line);
            score.setScore(translated.size() - i);
        }

        ScoreboardData.setData(player, translated);
        objective.setDisplayName(title);
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        player.setScoreboard(scoreboard);
    }

    public static void hideBoard(Player player) {
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }
}
