package me.lightdream.topdonator;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Topdonator extends JavaPlugin {

    Topdonator plugin;

    @Override
    public void onEnable() {

        plugin = this;

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {

            new BukkitRunnable() {

                @Override
                public void run() {
                    System.out.println("Updated the placeholders");
                    String[] top1 = PlaceholderAPI.setPlaceholders(Bukkit.getOfflinePlayer("_LightDream"), "%craftingstore_donator_1%").split(":");
                    String[] top2 = PlaceholderAPI.setPlaceholders(Bukkit.getOfflinePlayer("_LightDream"), "%craftingstore_donator_2%").split(":");
                    String[] top3 = PlaceholderAPI.setPlaceholders(Bukkit.getOfflinePlayer("_LightDream"), "%craftingstore_donator_3%").split(":");

                    try
                    {
                        plugin.getServer().dispatchCommand(Bukkit.getConsoleSender(), "npc select 48");
                        plugin.getServer().dispatchCommand(Bukkit.getConsoleSender(), "npc rename " + top1[0]);
                        plugin.getServer().dispatchCommand(Bukkit.getConsoleSender(), "npc select 49");
                        plugin.getServer().dispatchCommand(Bukkit.getConsoleSender(), "npc rename " + top2[0]);
                        plugin.getServer().dispatchCommand(Bukkit.getConsoleSender(), "npc select 50");
                        plugin.getServer().dispatchCommand(Bukkit.getConsoleSender(), "npc rename " + top3[0]);

                        plugin.getServer().dispatchCommand(Bukkit.getConsoleSender(), "holo setline donator1 4 &f&l" + top1[1] + "€ ");
                        plugin.getServer().dispatchCommand(Bukkit.getConsoleSender(), "holo setline donator2 4 &f&l" + top2[1] + "€ ");
                        plugin.getServer().dispatchCommand(Bukkit.getConsoleSender(), "holo setline donator3 4 &f&l" + top3[1] + "€ ");
                    }
                    catch (IndexOutOfBoundsException e)
                    {
                        System.out.println("One of the top donators placeholders is empty");
                    }

                }

            }.runTaskTimer(this, 0, 36000);

        } else {
            System.out.println("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {

    }
}
