package nl.mtworld.mtwcore.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemUtils {

    public static ItemStack getAdminTool(){
        return itemBuilder(Material.NETHER_STAR, 1, "§cAdmin§4Tool", Arrays.asList("Verboden te bezitten voor spelers!"));
    }

    public static ItemStack itemBuilder(Material material, int amount, String displayName, List<String> lore){
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
