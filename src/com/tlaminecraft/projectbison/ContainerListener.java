package com.tlaminecraft.projectbison;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ContainerListener implements Listener {
	static Map<Location, Inventory> crates;
	
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
	    if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
	    	Player p = event.getPlayer();
	    	Block block = event.getClickedBlock();
	    	Location clicked = event.getClickedBlock().getLocation();
			if (p.isSneaking())
				return;
			if (!(crates.containsKey(clicked))) {
				if (block.getType().equals(Material.TNT)) {
					crates.put(clicked, Bukkit.createInventory(null, 9, "Cabinet"));
					p.openInventory(crates.get(clicked));
					event.setCancelled(true);
				}
				else if (block.getType().equals(Material.SPONGE)) {
					crates.put(clicked, Bukkit.createInventory(null, 9, "Crate"));
					p.openInventory(crates.get(clicked));
					event.setCancelled(true);
				}
			}
			else {
				p.openInventory(crates.get(clicked));
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void blockBreak(BlockBreakEvent event) {
		Block block = event.getBlock();
		Player p = event.getPlayer();
		Inventory crate = crates.get(block.getLocation());
		if ((block.getType().equals(Material.TNT) || block.getType().equals(Material.SPONGE)) && crate != null) {
			for (ItemStack item : crate) {
				if (item!=null) {
					p.getWorld().dropItemNaturally(block.getLocation(), item);
					crate.clear(crate.first(item));
				}
				
			}
		}
		crates.remove(block.getLocation());
	}
}
