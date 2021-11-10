package es.meriland;

import es.meriland.commands.ReloadCommand;
import es.meriland.commands.ToggleScoreboardCommand;
import es.meriland.listeners.ChallengeListener;
import es.meriland.listeners.PlayerJoinListener;
import es.meriland.listeners.PlayerQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.*;

public final class MeriScoreboard extends JavaPlugin {

    private static MeriScoreboard plugin;
    public static String title;
    public static List<String> untranslated;
    private File playersDataFile;
    private FileConfiguration playersData;


    @Override
    public void onEnable() {
        plugin = this;
        untranslated = getConfig().getStringList("scoreboard.lines");
        title = getConfig().getString("scoreboard.title");
        Bukkit.getPluginCommand("scoreboardreload").setExecutor(new ReloadCommand());
        Bukkit.getPluginCommand("togglescoreboard").setExecutor(new ToggleScoreboardCommand());
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new ChallengeListener(), this);
        createPlayersFile();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
    }

    public static MeriScoreboard getPlugin() {
        return plugin;
    }

    public FileConfiguration getPlayersData() {
        return playersData;
    }

    public File getPlayersDataFile() { return playersDataFile; }

    public void setPlayerData(String uuid, boolean toggled) {
        try {
            getPlayersData().set(uuid, toggled);
            getPlayersData().save(getPlayersDataFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createPlayersFile() {
        playersDataFile = new File(getDataFolder(), "players.yml");
        if (!playersDataFile.exists()) {
            saveResource("players.yml", false);
        }
        playersData = YamlConfiguration.loadConfiguration(playersDataFile);
    }

}
