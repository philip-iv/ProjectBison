package com.tlaminecraft.projectbison;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.util.Vector;

public class GliderListener implements Listener {

	@EventHandler
	public void GliderAscend(PlayerInteractEvent event) {
		if (event.getMaterial().equals(Material.WOOD_SWORD)) {
			Player player = event.getPlayer();
			Vector velocity = player.getVelocity();
			if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				player.setVelocity(velocity.add(new Vector(0, 3, 0)));
			}
			else if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
				player.setVelocity(velocity.add(new Vector(velocity.getX() * 100, 2, velocity.getZ() * 100)));
			}
		}
	}
	
	@EventHandler
	public void FallDamage(EntityDamageEvent event) {
		Entity entity = event.getEntity();
		if (event.getCause().equals(DamageCause.FALL) && entity.getType().equals(EntityType.PLAYER) && ((Player)entity).getInventory().getItemInHand().equals(Material.WOOD_SWORD)) {
			event.setCancelled(true);
		}
	}
	
	Inventory test = Bukkit.createInventory(null, 9, "Crate");
	Map<Block, Inventory> crates = new HashMap<Block, Inventory>();
	
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
		Player p = event.getPlayer();
	    Block clicked = event.getClickedBlock();
	    if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
	    	if (clicked.getType().equals(Material.TNT)) {
				if (crates.containsKey(clicked)) {
					p.openInventory(crates.get(clicked));
				}
				else {
					crates.put(clicked, Bukkit.createInventory(null, 9, "Crate"));
				}
	    	}
		}
	}
}