package nl.mtworld.mtwcore.city;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public enum City {

    WILDERNISS(ChatColor.DARK_RED, "Wilderniss", Material.BEDROCK),
    LEGER_BASIS(ChatColor.GREEN, "Leger Basis", Material.IRON_BLOCK),
    PRETPARK(ChatColor.LIGHT_PURPLE, "Pretpark", Material.COAL_BLOCK),
    CIRCUIT(ChatColor.RED, "Circuit", Material.GOLD_BLOCK),
    EASTTOWN(ChatColor.YELLOW, "Easttown", Material.EMERALD_BLOCK),
    HET_RODE_DORP(ChatColor.DARK_PURPLE, "Het Rode Dorp", Material.CLAY),
    OLDTOWN(ChatColor.DARK_GRAY, "Oldtown", Material.SOUL_SAND),
    VICE_CITY(ChatColor.BLUE, "Vice City", Material.QUARTZ_BLOCK),
    LAKESIDE(ChatColor.DARK_AQUA, "Lakeside", Material.PACKED_ICE),
    DOWNTOWN(ChatColor.AQUA, "Downtown", Material.REDSTONE_BLOCK),
    WESTSIDE(ChatColor.DARK_GREEN, "Westside", Material.BRICK),
    UPTOWN(ChatColor.GOLD, "Uptown", Material.DIAMOND_BLOCK),
    UNIQ(ChatColor.DARK_BLUE, "Uniq", Material.SANDSTONE);

    private ChatColor color;
    private String name;
    private Material material;
    City(ChatColor color, String name, Material material){
        this.color = color;
        this.name = name;
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public ChatColor getColor() {
        return color;
    }

    public Material getMaterial() {
        return material;
    }
}
