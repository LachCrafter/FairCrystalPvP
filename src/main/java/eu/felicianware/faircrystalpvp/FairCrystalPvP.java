package eu.felicianware.faircrystalpvp;

import org.bukkit.Material;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class FairCrystalPvP extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("FairCrystalPvP has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("FairCrystalPvP has been disabled!");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getItem() != null && event.getItem().getType() == Material.END_CRYSTAL) {
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntityType() == EntityType.ENDER_CRYSTAL) {
            EnderCrystal crystal = (EnderCrystal) event.getEntity();
            int ticksLived = crystal.getTicksLived();
            if (ticksLived < 3) {
                event.setCancelled(true);
            }
        }
    }
}
