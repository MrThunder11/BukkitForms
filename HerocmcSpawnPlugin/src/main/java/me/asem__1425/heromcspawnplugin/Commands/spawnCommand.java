package me.asem__1425.heromcspawnplugin.Commands;

import me.asem__1425.heromcspawnplugin.HerocmcSpawnPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class spawnCommand implements CommandExecutor {
    HerocmcSpawnPlugin main;

    public spawnCommand(HerocmcSpawnPlugin main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            int cooldown = main.getConfig().getInt("cooldown");
            if (args.length == 0) {
                if (!main.tasks.containsKey(player)) {
                    main.tasks.put(player, (new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.teleport(new Location(Bukkit.getWorld("redstonepvp"), -2708.713, 39, -10205.839));
                            player.sendMessage(main.prefix + "Teleported to the spawn!.");
                            main.tasks.remove(player);
                        }
                    }).runTaskLater(main, 20L * cooldown));
                    return true;
                }
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    main.reloadConfig();
                    player.sendMessage(main.prefix + "§aHeromcspawnplugin config reloaded!");
                    return true;
                } else {
                    player.sendMessage(main.prefix + "§cUsage: /spawn");
                    return true;
                }
            } else {
                player.sendMessage(main.prefix + "§cUsage: /spawn");
                return true;
            }
        } else {
            sender.sendMessage("You must be a player to use this command!");
            return true;
        }
        return false;
    }
}