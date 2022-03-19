        Player player = event.getPlayer();
        Main.API = LuckPermsProvider.get();
        ClanConfiguration clanConfiguration = new ClanConfiguration();
    	String clan = clanConfiguration.getClan(player);

    	String clan_with_prefix = clanConfiguration.getPrefix(clan);
        String prefix = Main.API.getGroupManager().getGroup(Main.API.getUserManager().getUser(player.getUniqueId()).getPrimaryGroup()).getCachedData().getMetaData().getPrefix();
        
        ScoreboardManager scoreboardManager = this.getServer().getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("Test", "Dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        
        Team health = scoreboard.registerNewTeam("§eING: §f");
        health.addEntry("§eING: §f");
        health.setSuffix(player.getDisplayName());
        health.setPrefix("");
        
        Team health1 = scoreboard.registerNewTeam("§eRank: §f");
        health1.addEntry("§eRank: §f");
        health1.setSuffix(prefix);
        health1.setPrefix("");
        
        Team health2 = scoreboard.registerNewTeam("§aKills: §f");
        health2.addEntry("§aKills: §f");
        health2.setSuffix("");
        health2.setPrefix("");
        
        Team health3 = scoreboard.registerNewTeam("§cDeaths: §f");
        health3.addEntry("§cDeaths: §f");
        health3.setSuffix("");
        health3.setPrefix("");
        
        Team health4 = scoreboard.registerNewTeam("§6KDR: §f");
        health4.addEntry("§6KDR: §f");
        health4.setSuffix("");
        health4.setPrefix("");
        
        Team health5 = scoreboard.registerNewTeam("§eClan: §f");
        health5.addEntry("§eClan: §f");
        health5.setSuffix("");
        health5.setPrefix("");
        
        objective.getScore("").setScore(9);
        objective.getScore("§eING: §f").setScore(8);
        objective.getScore("§eRank: §f").setScore(7);
        objective.getScore("§eClan: §f").setScore(6);
        objective.getScore(" ").setScore(5);
        objective.getScore("§aKills: §f").setScore(4);
        objective.getScore("§6KDR: §f").setScore(3);
        objective.getScore("§cDeaths: §f").setScore(2);
        objective.getScore("  ").setScore(1);
        objective.getScore("§eHorec§6MC§e.ml  ").setScore(0);
        new BukkitRunnable() {
            @Override
            public void run() {
            	if (player.isOnline()) {
                    objective.setDisplayName("§cRedstone§4PvP");
                    health2.setSuffix(KillData.get().getString(player.getDisplayName() + ".KillData.Kills"));
                    health3.setSuffix(KillData.get().getString(player.getDisplayName() + ".KillData.Deaths"));
                    health4.setSuffix(KillData.get().getString(player.getDisplayName() + ".KillData.KDR"));
                    health5.setSuffix("§8["+clan_with_prefix + "§8]");
            	}
                    
            }
        }.runTaskTimer(this, 0, 10);

        player.setScoreboard(scoreboard);
