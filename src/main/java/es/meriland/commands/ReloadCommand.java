package es.meriland.commands;

import es.meriland.MeriScoreboard;
import es.meriland.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.isOp()) {
            sender.sendMessage(Utils.colorize("&c¡No tienes permiso!"));
            return false;
        }
        MeriScoreboard.getPlugin().reloadConfig();
        MeriScoreboard.untranslated = MeriScoreboard.getPlugin().getConfig().getStringList("scoreboard.lines");
        MeriScoreboard.title = MeriScoreboard.getPlugin().getConfig().getString("scoreboard.title");
        sender.sendMessage(Utils.colorize("&a¡Reload completado!"));
        return false;
    }
}
