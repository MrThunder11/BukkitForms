package me.asem__1425.herocmcscoreboard.Listeners;

import me.asem__1425.herocmcscoreboard.HerocmcScoreBoard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    HerocmcScoreBoard main;
    public PlayerJoinListener(HerocmcScoreBoard main) {
        this.main = main;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        main.scoreboard.updateScoreBoard(e.getPlayer());
    }
}
