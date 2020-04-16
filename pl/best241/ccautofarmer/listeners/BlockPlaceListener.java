// 
// Decompiled by Procyon v0.5.30
// 

package pl.best241.ccautofarmer.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.block.Block;
import pl.best241.ccguilds.data.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.best241.ccautofarmer.blockbuilder.BlockBuilder;
import org.bukkit.Material;
import pl.best241.ccsectors.api.TeleportLocation;
import pl.best241.ccautofarmer.configs.MessagesData;
import pl.best241.ccguilds.manager.DataManager;
import pl.best241.ccautofarmer.CcAutoFarmer;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.Listener;

public class BlockPlaceListener implements Listener
{
    @EventHandler
    public static void onBlockPlace(final BlockPlaceEvent event) {
        if (event.isCancelled()) {
            return;
        }
        final Player player = event.getPlayer();
        if (player.getItemInHand().isSimilar(CcAutoFarmer.getAutoFarmerRecipe().getResult())) {
            final PlayerData data = DataManager.getPlayerData(player.getUniqueId());
            if (data.getGuildData() == null) {
                player.sendMessage(MessagesData.youAreNotInAGuild);
                event.setCancelled(true);
                return;
            }
            final Block block = event.getBlock();
            if (data.getGuildData().getCuboid().isOnCuboid(new TeleportLocation(block.getLocation()))) {
                if (block.getY() <= 80) {
                    BlockBuilder.build(block.getLocation(), Material.OBSIDIAN, 8, false);
                    final ItemStack itemToRemove = player.getItemInHand().clone();
                    itemToRemove.setAmount(1);
                    player.getInventory().removeItem(new ItemStack[] { itemToRemove });
                }
                else {
                    player.sendMessage(MessagesData.fromYLocOnly);
                }
            }
            else {
                player.sendMessage(MessagesData.youAreNotInTerrainYourGuild);
            }
            event.setCancelled(true);
        }
    }
}
