package com.tlaminecraft.projectbison;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class GliderListener implements Listener {

	@EventHandler
	public void GliderAscend(PlayerInteractEvent event) {
		if (event.getMaterial().equals(Material.WOOD_SWORD)) {
			Player player = event.getPlayer();
			Vector velocity = player.getLocation().getDirection();
			if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				player.setVelocity(velocity.add(new Vector(velocity.getX() * 20, 3, velocity.getX() * 20)));
			}
			else if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
				player.setVelocity(velocity.add(new Vector(velocity.getX() * 10, 2, velocity.getZ() * 10)));
			}
		}
	}
	
	@EventHandler
	public void FallDamage(EntityDamageEvent event) {
		Entity entity = event.getEntity();
		if (Bukkit.getPluginManager().isPluginEnabled("Vault") && ProjectBison.chat.getPlayerPrefix((Player) entity).contains("&e")) {
			
		}
		else if (event.getCause().equals(DamageCause.FALL) && entity instanceof Player && ((Player) entity).getInventory().getItemInHand().getType() == Material.WOOD_SWORD) {
			event.setCancelled(true);
		}
	}
	
}