package com.tlaminecraft.projectbison;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class GliderListener implements Listener {
	@EventHandler
	public void GliderAscend(PlayerInteractEvent event) {
		if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getMaterial().equals(Material.WOOD_SWORD)) {
			Player player = event.getPlayer();
			//player.teleport(player.getLocation().add(0, 10, 0));
			player.setVelocity(player.getVelocity().add(new Vector(0, 10, 0)));
		}
	}
}
