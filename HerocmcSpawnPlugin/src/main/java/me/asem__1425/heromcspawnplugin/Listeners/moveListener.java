package me.asem__1425.heromcspawnplugin.Listeners;

import me.asem__1425.heromcspawnplugin.HerocmcSpawnPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitTask;

public class moveListener implements Listener {

    HerocmcSpawnPlugin main;

    public moveListener(HerocmcSpawnPlugin main) {
        this.main = main;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if (main.getConfig().getBoolean("spawn-enabled")) {
            BukkitTask task = main.tasks.get(player);
            if (task != null) {
                task.cancel();
                main.tasks.remove(player);
                player.sendMessage(
                        main.prefix + ChatColor.DARK_RED + "" + ChatColor.BOLD + "You Moved !, Teleporting Canceled.");
                return;
            }
        }
    }
}
