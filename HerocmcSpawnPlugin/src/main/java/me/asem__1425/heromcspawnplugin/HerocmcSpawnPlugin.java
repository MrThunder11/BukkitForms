package me.asem__1425.heromcspawnplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;

public final class HerocmcSpawnPlugin extends JavaPlugin {
    public Map<Player, BukkitTask> tasks = new HashMap<>();
    public String prefix = "§8[§6HerocMC§8] §7";
    @Override
    public void onEnable() {
        // Plugin startup logic
        // Setup Config
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        Bukkit.getLogger().info("HerocmcSpawnPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
