// 
// Decompiled by Procyon v0.5.30
// 

package pl.best241.ccautofarmer.configs;

import org.bukkit.plugin.Plugin;

public class MessagesData
{
    public static String youAreNotInAGuild;
    public static String youAreNotInTerrainYourGuild;
    public static String unknowDirection;
    public static String farmerDescription;
    public static String farmerName;
    public static String fromYLocOnly;
    private static MessagesConfig config;
    
    public static void loadMessages(final Plugin plugin) {
        (MessagesData.config = new MessagesConfig(plugin, "messages.yml")).saveDefaultConfig();
        MessagesData.config.reloadCustomConfig();
        MessagesData.youAreNotInAGuild = MessagesData.config.getString("youAreNotInAGuild");
        MessagesData.youAreNotInTerrainYourGuild = MessagesData.config.getString("youAreNotInTerrainYourGuild");
        MessagesData.unknowDirection = MessagesData.config.getString("unknowDirection");
        MessagesData.farmerDescription = MessagesData.config.getString("farmerDescription");
        MessagesData.farmerName = MessagesData.config.getString("farmerName");
        MessagesData.fromYLocOnly = MessagesData.config.getString("fromYLocOnly");
    }
}
