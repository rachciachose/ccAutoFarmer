// 
// Decompiled by Procyon v0.5.30
// 

package pl.best241.ccautofarmer.blockbuilder;

import org.bukkit.plugin.Plugin;
import pl.best241.ccautofarmer.CcAutoFarmer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Location;

public class BlockBuilder
{
    public static void build(final Location startBlock, final Material blockMaterial, final int sleepTime, final boolean passBlocks) {
        final BlockBuilderData data = new BlockBuilderData(startBlock, blockMaterial, sleepTime, passBlocks);
        runBuilder(data);
    }
    
    private static void runBuilder(final BlockBuilderData data) {
        Bukkit.getScheduler().runTaskLater((Plugin)CcAutoFarmer.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                final Location currentLoc = data.getCurrentLoc();
                if (currentLoc.getY() <= 4.0) {
                    return;
                }
                if (currentLoc.getBlock().getType() == Material.BEDROCK) {
                    return;
                }
                if (data.getPassBlocks()) {
                    currentLoc.getBlock().setType(data.getBuildMaterial());
                }
                else {
                    if (currentLoc.getBlock().getType() != Material.AIR && currentLoc.getBlock().getType() != data.getBuildMaterial()) {
                        return;
                    }
                    currentLoc.getBlock().setType(data.getBuildMaterial());
                }
                currentLoc.add(0.0, -1.0, 0.0);
                data.setCurrentLoc(currentLoc);
                runBuilder(data);
            }
        }, (long)data.getSleepTime());
    }
}
