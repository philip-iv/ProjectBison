package com.tlaminecraft.projectbison;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
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
	Map<Block, Inventory> crates = new HashMap<Block, Inventory>();
	
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
		Player p = event.getPlayer();
	    Block clicked = event.getClickedBlock();
	    if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (p.isSneaking())
				return;
			if (!(crates.containsKey(clicked))) {
				if (clicked.getType().equals(Material.TNT)) {
					crates.put(clicked, Bukkit.createInventory(null, 9, "Cabinet"));
					p.openInventory(crates.get(clicked));
				}
				else if (clicked.getType().equals(Material.SPONGE)) {
					crates.put(clicked, Bukkit.createInventory(null, 9, "Crate"));
					p.openInventory(crates.get(clicked));
				}
			}
			else
				p.openInventory(crates.get(clicked));
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void blockBreak(BlockBreakEvent event) {
		Block block = event.getBlock();
		Player p = event.getPlayer();
		Inventory crate = crates.get(block);
		if (block.getType().equals(Material.TNT) || block.getType().equals(Material.SPONGE)) {
			for (ItemStack item : crate) {
				if (item!=null) {
					p.getWorld().dropItemNaturally(block.getLocation(), item);
					crate.clear(crate.first(item));
				}
				
			}
		}
		crates.put(block, crate);
	}
}
