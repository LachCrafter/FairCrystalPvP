package eu.felicianware.faircrystalpvp;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class FairCrystalPvP extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Registering events
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("FairCrystalPvP has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("FairCrystalPvP has been disabled!");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getMaterial().isBlock()) {
            Block clickedBlock = event.getClickedBlock();
            if (event.getMaterial().equals(Material.END_CRYSTAL)) {
                long placeTime = System.currentTimeMillis();

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    assert clickedBlock != null;
                    if (clickedBlock.getType().equals(Material.END_CRYSTAL)) {
                        long breakTime = System.currentTimeMillis();
                        long timeDifference = breakTime - placeTime;

                        if (timeDifference > 250) { // 250ms = 5 ticks
                            event.setCancelled(true);
                        }
                    }
                }, 5L);
            }
        }
    }
}
