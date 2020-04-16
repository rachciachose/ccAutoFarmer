// 
// Decompiled by Procyon v0.5.30
// 

package pl.best241.ccautofarmer.blockbuilder;

import org.bukkit.Material;
import org.bukkit.Location;

class BlockBuilderData
{
    private Location startLoc;
    private Material buildMaterial;
    private int sleepTime;
    private boolean passBlocks;
    
    public BlockBuilderData(final Location startLoc, final Material blockMaterial, final int sleepTime, final boolean passBlocks) {
        this.startLoc = startLoc;
        this.buildMaterial = blockMaterial;
        this.sleepTime = sleepTime;
        this.passBlocks = passBlocks;
    }
    
    public int getSleepTime() {
        return this.sleepTime;
    }
    
    public Location getCurrentLoc() {
        return this.startLoc;
    }
    
    public void setCurrentLoc(final Location loc) {
        this.startLoc = loc;
    }
    
    public boolean getPassBlocks() {
        return this.passBlocks;
    }
    
    public Material getBuildMaterial() {
        return this.buildMaterial;
    }
}
