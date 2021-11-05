package es.meriland;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class Utils {

    public static String cutString(String s, int maxLength) {
        if (s.length() > maxLength) {
            s = s.substring(0, maxLength);
        }
        return s;
    }

    public static List<String> translate(Player player, List<String> untranslated) {
        return PlaceholderAPI.setPlaceholders(player, untranslated);
    }

    public static String colorize(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
