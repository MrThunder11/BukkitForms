package me.asem__1425.herocmcscoreboard;

import me.asem__1425.herocmcscoreboard.Listeners.PlayerJoinListener;
import me.asem__1425.herocmcscoreboard.Utils.scoreBoard;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HerocmcScoreBoard extends JavaPlugin {

    public scoreBoard scoreboard;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("HerocmcScoreBoard has been enabled!");

        //Setup Config
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        registerUtils();
        registerListeners();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerUtils(){
        scoreboard = new scoreBoard(this);
    }

    public void registerListeners(){
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
    }
}
