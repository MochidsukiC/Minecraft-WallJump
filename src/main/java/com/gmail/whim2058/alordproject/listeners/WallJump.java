package com.gmail.whim2058.alordproject.listeners;

import com.gmail.whim2058.alordproject.AllowFlight;
import com.gmail.whim2058.alordproject.Alordproject;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.util.Vector;

public class WallJump implements Listener {

    /*

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.getPlayer().setAllowFlight(true);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
        Player player = event.getPlayer();
            player.setAllowFlight(true);
        }

     */

    @EventHandler
    public void onPlayerWallJump(PlayerToggleFlightEvent event) {
        Player player = event.getPlayer();
        if (player.getGameMode() != GameMode.CREATIVE) {
            event.setCancelled(true);
            event.getPlayer().setAllowFlight(false);

            Block wxblock = player.getWorld().getBlockAt(player.getLocation().subtract(1.05, 0, 0));
            Block nxblock = player.getWorld().getBlockAt(player.getLocation().subtract(0, 0, 1.05));
            Block exblock = player.getWorld().getBlockAt(player.getLocation().subtract(-1.05, 0, 0));
            Block sxblock = player.getWorld().getBlockAt(player.getLocation().subtract(0, 0, -1.05));

            double angle = player.getLocation().getYaw();
            double yaw = Utils.normalAbsoluteAngleDegrees(angle);
            double velox = player.getVelocity().getX();
            double veloz = player.getVelocity().getZ();

            if (!wxblock.getType().equals(Material.AIR)) {
                if (yaw >= 50 && yaw <= 130) {
                    if (velox <= -0.001 && velox >= -1.0 && veloz <= -0.001 && veloz >= -1.0) {
                        Vector vector = player.getLocation().getDirection().multiply(0.5).setX(velox * -4.25).setY(0.525).setZ(veloz * 5.25);
                        player.setVelocity(vector);
                        Location location = player.getLocation().subtract(1,0,0);
                        player.playSound(location, Sound.BLOCK_ANCIENT_DEBRIS_STEP,1,1);
                        player.spawnParticle(Particle.CRIT_MAGIC,location,20);
                    } else if (velox <= -0.001 && velox >= -1.0 && veloz <= 1.0 && veloz >= 0.001) {
                        Vector vector = player.getLocation().getDirection().multiply(0.5).setX(velox * -4.25).setY(0.525).setZ(veloz * 5.25);
                        player.setVelocity(vector);
                        Location location = player.getLocation().subtract(1,0,0);
                        player.playSound(location, Sound.BLOCK_ANCIENT_DEBRIS_STEP,1,1);
                        player.spawnParticle(Particle.CRIT_MAGIC,location,20);
                    }
                }
            } else if (!nxblock.getType().equals(Material.AIR)) {
                if (yaw >= 140 && yaw <= 220 ) {
                    if (velox <= 1.0 && velox >= 0.001 && veloz <= -0.001 && veloz >= -1.0) {
                        Vector vector = player.getLocation().getDirection().multiply(0.5).setX(velox * 5.25).setY(0.525).setZ(veloz * -4.25);
                        player.setVelocity(vector);
                        Location location = player.getLocation().subtract(0,0,1);
                        player.playSound(location, Sound.BLOCK_ANCIENT_DEBRIS_STEP,1,1);
                        player.spawnParticle(Particle.CRIT_MAGIC,location,20);
                    } else if (velox <= -0.001 && velox >= -1.0 && veloz <= -0.001 && veloz >= -1.0) {
                        Vector vector = player.getLocation().getDirection().multiply(0.5).setX(velox * 5.25).setY(0.525).setZ(veloz * -4.25);
                        player.setVelocity(vector);
                        Location location = player.getLocation().subtract(0,0,1);
                        player.playSound(location, Sound.BLOCK_ANCIENT_DEBRIS_STEP,1,1);
                        player.spawnParticle(Particle.CRIT_MAGIC,location,20);
                    }
                }
            } else if (!exblock.getType().equals(Material.AIR)) {
                if (yaw >= 230 && yaw <= 310) {
                    if (velox <= 1.0 && velox >= 0.001 && veloz <= 1.0 && veloz >= 0.001) {
                        Vector vector = player.getLocation().getDirection().multiply(0.5).setX(velox * -4.25).setY(0.525).setZ(veloz * 5.25);
                        player.setVelocity(vector);
                        Location location = player.getLocation().subtract(-1,0,0);
                        player.playSound(location, Sound.BLOCK_ANCIENT_DEBRIS_STEP,1,1);
                        player.spawnParticle(Particle.CRIT_MAGIC,location,20);
                    } else if (velox <= 1.0 && velox >= 0.001 && veloz <= -0.001 && veloz >= -1.0) {
                        Vector vector = player.getLocation().getDirection().multiply(0.5).setX(velox * -4.25).setY(0.525).setZ(veloz * 5.25);
                        player.setVelocity(vector);
                        Location location = player.getLocation().subtract(-1,0,0);
                        player.playSound(location, Sound.BLOCK_ANCIENT_DEBRIS_STEP,1,1);
                        player.spawnParticle(Particle.CRIT_MAGIC,location,20);
                    }
                }
            } else if (!sxblock.getType().equals(Material.AIR)) {
                if (yaw >= 320 && yaw <= 360 || yaw >= 0 && yaw <= 40 ) {
                    if (velox <= -0.001 && velox >= -1.0 && veloz <= 1.0 && veloz >= 0.001) {
                        Vector vector = player.getLocation().getDirection().multiply(0.5).setX(velox * 5.25).setY(0.525).setZ(veloz * -4.25);
                        player.setVelocity(vector);
                        Location location = player.getLocation().subtract(0,0,-1);
                        player.playSound(location, Sound.BLOCK_ANCIENT_DEBRIS_STEP,1,1);
                        player.spawnParticle(Particle.CRIT_MAGIC,location,20);
                    } else if (velox <= 1.0 && velox >= 0.001 && veloz <= 1.0 && veloz >= 0.001) {
                        Vector vector = player.getLocation().getDirection().multiply(0.5).setX(velox * 5.25).setY(0.525).setZ(veloz * -4.25);
                        player.setVelocity(vector);
                        Location location = player.getLocation().subtract(0,0,-1);
                        player.playSound(location, Sound.BLOCK_ANCIENT_DEBRIS_STEP,1,1);
                        player.spawnParticle(Particle.CRIT_MAGIC,location,20);
                    }
                }
            }
        }
    }

    @EventHandler
    public void PlayerMoveEvent(PlayerMoveEvent event){
        if(event.getPlayer().getGameMode() != GameMode.CREATIVE) {
            //event.getPlayer().sendMessage(event.getPlayer().getAllowFlight() + ":" + event.getPlayer().getVelocity().getX() + ":" + event.getPlayer().getVelocity().getZ()); //debug-log

            if (event.getPlayer().getVelocity().getY() > 0.3) {
                new AllowFlight(event.getPlayer(),false).runTaskLater(Alordproject.getPlugin(), 10);
            }
            Entity playerEntity = event.getPlayer();
            if (playerEntity.isOnGround()) {
                new AllowFlight(event.getPlayer(),true).runTaskLater(Alordproject.getPlugin(), 1);
            }
            if(event.getPlayer().getVelocity().getY() < -0.7){
                event.getPlayer().setAllowFlight(false);
            }
        }
    }
}

class Utils {
    /**
     * Normalizes an angle to an absolute angle.
     * The normalized angle will be in the range from 0 to 360, where 360
     * itself is not included.
     *
     * @param angle the angle to normalize
     * @return the normalized angle that will be in the range of [0,360[
     */
    public static double normalAbsoluteAngleDegrees(double angle) {
        return (angle %= 360) >= 0 ? angle : (angle + 360);
    }
}
