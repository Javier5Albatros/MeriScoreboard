package es.meriland.commands;

import es.meriland.BoardManager;
import es.meriland.MeriScoreboard;
import es.meriland.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class ToggleScoreboardCommand implements CommandExecutor {
    MeriScoreboard plugin = MeriScoreboard.getPlugin();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        String uuid = player.getUniqueId().toString();
        boolean toggled = MeriScoreboard.getPlugin().getPlayersData().getBoolean(uuid);

        if(toggled) {
            player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
            player.sendMessage(Utils.colorize("&c¡Ocultando scoreboard!"));
        } else {
            BoardManager.showBoard(player, Utils.translate(player, MeriScoreboard.untranslated));
            player.sendMessage(Utils.colorize("&a¡Mostrando scoreboard!"));
        }

        plugin.setPlayerData(uuid, !toggled);

        return false;
    }
}
