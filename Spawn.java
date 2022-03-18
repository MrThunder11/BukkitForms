    @EventHandler
    public void spawn(Player player) {
    	int spawncooldown = CooldownData.get().getInt(player.getDisplayName() + ".Spawn.Cooldown");
    	if (spawncooldown != 6) {
    		if (CooldownData.get().getString(player.getDisplayName() + ".Spawn.Spawn").contains("Disable")) {
    			player.sendMessage(ChatColor.RED + "You moved /spawn canceled !");
    			return;
    		}
				new BukkitRunnable() {
					public void run() {
						if (CooldownData.get().getString(player.getDisplayName() + ".Spawn.Spawn").contains("Enable")) {
							CooldownData.get().set(player.getDisplayName() + ".Spawn.Cooldown", CooldownData.get().getInt(player.getDisplayName() + ".Spawn.Cooldown" , 0) + 1);
							CooldownData.save();
							if (spawncooldown  < 6 && spawncooldown > 0) {
								player.sendMessage(ChatColor.GREEN + "You will be tp in " +ChatColor.RED +  spawncooldown + " / 5");
							}
							if (spawncooldown == 5) {
								player.teleport(new Location(Bukkit.getWorld("redstonepvp"), -2708.713 , 39 , -10205.839));
								player.sendMessage(ChatColor.GREEN + "Teleporting ...");
							}
							spawn(player);
						}
					}
				}.runTaskLater(this, 45);//Every 1 seconds 
    	}
    }
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
    	Player player = e.getPlayer();
        if (e.getFrom().getBlockX() == e.getTo().getBlockX() && e.getFrom().getBlockY() == e.getTo().getBlockY() && e.getFrom().getBlockZ() == e.getTo().getBlockZ()) {
        	if (CooldownData.get().getString(player.getDisplayName() + ".Spawn.Spawn").contains("Enable")) {
				CooldownData.get().set(player.getDisplayName() + ".Spawn.Spawn", "Disable");
				CooldownData.save();
        	}
        }
    }
	@EventHandler
	public boolean onCommand(CommandSender s, org.bukkit.command.Command c, String l, String[] args) {
		if (s instanceof Player) {
			if (c.getName().equalsIgnoreCase("spawn")) {
				Player player = (Player) s;
				int spawncooldown = CooldownData.get().getInt(player.getDisplayName() + ".Spawn.Cooldown");
				if (!CooldownData.get().contains(player.getDisplayName() + ".Spawn.Cooldown")) {
					CooldownData.get().set(player.getDisplayName() + ".Spawn.Cooldown", 6);
					CooldownData.get().set(player.getDisplayName() + ".Spawn.Spawn", "Enable");
					CooldownData.save();
				}
				if (spawncooldown == 6) {
					if (spawncooldown == 6) {
						CooldownData.get().set(player.getDisplayName() + ".Spawn.Cooldown", 0);
						CooldownData.save();
					}
					spawn(player);
				}else {
					player.sendMessage(ChatColor.RED + "Command is running !");
				}
			}
		}else {
			s.sendMessage(ChatColor.RED + "You need to be player to use command !");
		}
		return true;
	}
