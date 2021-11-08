package es.meriland;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreboardData {

    private static Map<Player, List<String>> dataMap = new HashMap<>();

    public static void setData(Player player, List<String> data) {
        dataMap.put(player, data);
    }

    public static boolean canUpdate(Player player, List<String> newData) {
        return !dataMap.get(player).equals(newData);
    }
}
