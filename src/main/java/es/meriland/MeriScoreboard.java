package es.meriland;

import es.meriland.commands.ReloadCommand;
import es.meriland.listeners.PlayerDieListener;
import es.meriland.listeners.PlayerJoinListener;
import es.meriland.listeners.PlayerQuitListener;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class MeriScoreboard extends JavaPlugin {

    private static MeriScoreboard plugin;
    public static List<UUID> toggledOff;
    public static List<String> untranslated;
    public static String title;


    @Override
    public void onEnable() {
        plugin = this;
        toggledOff = new ArrayList<UUID>();
        untranslated = getConfig().getStringList("scoreboard.lines");
        title = getConfig().getString("scoreboard.title");
        Bukkit.getPluginCommand("scoreboardreload").setExecutor(new ReloadCommand());
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDieListener(), this);
        saveDefaultConfig();

        Bukkit.getScheduler().runTaskTimer(this, () -> {
            if(Bukkit.getOnlinePlayers().isEmpty()) {
                return;
            }
            Bukkit.getOnlinePlayers().forEach(player -> BoardManager.showBoard(player, Utils.translate(player, MeriScoreboard.untranslated)));
        }, 5L, 5L);
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
    }

    public static void togglePlayer(final UUID player) {
        if (toggledOff.contains(player)) {
            toggledOff.remove(player);
        }
        else {
            toggledOff.add(player);
        }
    }


    public static MeriScoreboard getPlugin() {
        return plugin;
    }


}
