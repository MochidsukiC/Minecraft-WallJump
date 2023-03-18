package com.gmail.whim2058.alordproject;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AllowFlight extends BukkitRunnable {
    Player player;
    boolean allow;
    public AllowFlight(Player player,boolean allow){
        this.player = player;
        this.allow = allow;
    }

    @Override
    public void run() {
        player.setAllowFlight(allow);
    }
}
