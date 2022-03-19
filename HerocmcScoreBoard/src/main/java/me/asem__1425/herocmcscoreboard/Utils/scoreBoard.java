package me.asem__1425.herocmcscoreboard.Utils;

import me.asem__1425.herocmcscoreboard.HerocmcScoreBoard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import me.clip.placeholderapi.PlaceholderAPI;

public class scoreBoard {

    HerocmcScoreBoard main;


    public scoreBoard(HerocmcScoreBoard main) {
        this.main = main;
    }

    public void createScoreBoard(Player player){

        String rankName = PlaceholderAPI.setPlaceholders(player, "%luckperms_prefix%");
        String playerKills = PlaceholderAPI.setPlaceholders(player, "%killstats_kills%");
        String playerKdr = PlaceholderAPI.setPlaceholders(player, "%killstats_kdr%");
        String playerDeaths = PlaceholderAPI.setPlaceholders(player, "%killstats_deaths%");
        String clan = PlaceholderAPI.setPlaceholders(player, "%clans_clan_tag%");

        /**
         *
         *
         *
         * &eIGN: &f
         * &eRank: &f
         *
         * &aKills: &f
         * &6Kdr: &f
         * &cDeaths: &f
         *
         * &4Clan: &f
         * &bLevel: &f
         * &bRate: &f
         *
         */

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getMainScoreboard();

        Objective objective = board.registerNewObjective(ChatColor.translateAlternateColorCodes('&', "&4&lRedstone&c&lPvP"), "dummy");
        objective.setDisplaySlot(org.bukkit.scoreboard.DisplaySlot.SIDEBAR);

        Score ign = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&eIGN: &f" + player.getName()));
        ign.setScore(8);
        Score rank = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&eRank: &f" + rankName));
        rank.setScore(7);
        Score clanName = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&4Clan: &f" + clan));
        clanName.setScore(6);
        Score space = objective.getScore(" ");
        space.setScore(5);
        Score kills = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&aKills: &f" + playerKills));
        kills.setScore(4);
        Score kdr = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&6Kdr: &f" + playerKdr));
        kdr.setScore(3);
        Score deaths = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&cDeaths: &f" + playerDeaths));
        deaths.setScore(2);
        Score space2 = objective.getScore(" ");
        space2.setScore(1);
        Score ip = objective.getScore(ChatColor.translateAlternateColorCodes('&', "§eHorec§6MC§e.ml"));
        ip.setScore(0);

        player.setScoreboard(board);
    }

    public void updateScoreBoard(Player player){
        new BukkitRunnable(){
            @Override
            public void run() {
                createScoreBoard(player);
            }
        }.runTaskTimer(main, 0, 20 * main.getConfig().getInt("scoreboard.update-time"));
    }
}
