// 
// Decompiled by Procyon v0.5.30
// 

package pl.best241.ccautofarmer;

import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import pl.best241.ccautofarmer.listeners.BlockPlaceListener;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.Plugin;
import pl.best241.ccautofarmer.configs.MessagesData;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class CcAutoFarmer extends JavaPlugin
{
    private static CcAutoFarmer plugin;
    private static ShapelessRecipe autoFarmerRecipe;
    
    public void onEnable() {
        MessagesData.loadMessages((Plugin)(CcAutoFarmer.plugin = this));
        getAutoFarmerRecipe();
        this.getServer().addRecipe((Recipe)CcAutoFarmer.autoFarmerRecipe);
        this.getServer().getPluginManager().registerEvents((Listener)new BlockPlaceListener(), (Plugin)this);
    }
    
    public static CcAutoFarmer getPlugin() {
        return CcAutoFarmer.plugin;
    }
    
    public static ShapelessRecipe getAutoFarmerRecipe() {
        if (CcAutoFarmer.autoFarmerRecipe != null) {
            return CcAutoFarmer.autoFarmerRecipe;
        }
        final ItemStack autoFarmerItem = new ItemStack(Material.ENDER_PORTAL_FRAME);
        final ItemMeta meta = autoFarmerItem.getItemMeta();
        meta.setDisplayName(MessagesData.farmerName);
        final ArrayList<String> lore = new ArrayList<String>();
        final String[] split;
        final String[] loreData = split = MessagesData.farmerDescription.split("\n");
        for (final String loreField : split) {
            lore.add(loreField);
        }
        meta.setLore((List)lore);
        autoFarmerItem.setItemMeta(meta);
        final ShapelessRecipe recipe = new ShapelessRecipe(new ItemStack(autoFarmerItem));
        recipe.addIngredient(Material.SAND);
        recipe.addIngredient(Material.REDSTONE);
        recipe.addIngredient(Material.GOLD_BLOCK);
        return CcAutoFarmer.autoFarmerRecipe = recipe;
    }
    
    public static BlockFace getCardinalDirection(final Player player) {
        double rotation = (player.getLocation().getYaw() + 180.0f) % 360.0f;
        if (rotation < 0.0) {
            rotation += 360.0;
        }
        if (0.0 <= rotation && rotation < 22.5) {
            return BlockFace.NORTH;
        }
        if (22.5 <= rotation && rotation < 67.5) {
            return BlockFace.NORTH_EAST;
        }
        if (67.5 <= rotation && rotation < 112.5) {
            return BlockFace.EAST;
        }
        if (112.5 <= rotation && rotation < 157.5) {
            return BlockFace.SOUTH_EAST;
        }
        if (157.5 <= rotation && rotation < 202.5) {
            return BlockFace.SOUTH;
        }
        if (202.5 <= rotation && rotation < 247.5) {
            return BlockFace.SOUTH_WEST;
        }
        if (247.5 <= rotation && rotation < 292.5) {
            return BlockFace.WEST;
        }
        if (292.5 <= rotation && rotation < 337.5) {
            return BlockFace.NORTH_WEST;
        }
        if (337.5 <= rotation && rotation < 360.0) {
            return BlockFace.NORTH;
        }
        return null;
    }
}
