package com.tlaminecraft.projectbison;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public final class MobEventListener implements Listener {
	public static Map<UUID, Boolean> bisonTamed;
	public static Map<UUID, Player> lemurOwner = new HashMap<UUID, Player>();
	
	@EventHandler
	public void mobSpawn(CreatureSpawnEvent event) {
		Entity entity = event.getEntity();		
		if (entity.getType().equals(EntityType.COW)) {
			//prevents spawning of cows/sky bison naturally
			if (event.getSpawnReason().equals(SpawnReason.NATURAL) || event.getSpawnReason().equals(SpawnReason.CHUNK_GEN)) {
				 ((Damageable) entity).damage(((Damageable) entity).getHealth());
			 }
		}
		
		//sets custom mount behaviors
		if (entity.getType().equals(EntityType.HORSE)) {
			Horse horse = (Horse) entity;
			//Komodo Rhino
			if (horse.getColor().equals(Horse.Color.BLACK)) {
				horse.setMaxHealth(20);
				horse.setHealth(20);
				horse.setJumpStrength(0);
			}
			//Eel Hound
			else if (horse.getColor().equals(Horse.Color.CHESTNUT)) {
				horse.setMaxHealth(10);
				horse.setHealth(10);
				horse.setJumpStrength(2);
			}
			//Ostrich Horse
			else if (horse.getColor().equals(Horse.Color.CREAMY)) {
				horse.setMaxHealth(10);
				horse.setHealth(10);
				horse.setJumpStrength(1.3);
			}
			//Buffalo Yak
			else if (horse.getVariant().equals(Horse.Variant.DONKEY)) {
				horse.setMaxHealth(10);
				horse.setHealth(10);
				horse.setJumpStrength(1.3);
			}
			//Polar Bear Dog
			else if (horse.getColor().equals(Horse.Color.BROWN)) {
				horse.setMaxHealth(16);
				horse.setHealth(16);
				horse.setJumpStrength(1.1);
			}
		}
	}

	@EventHandler
	public void mobInteract(PlayerInteractEntityEvent event) {
		Entity entity = event.getRightClicked();
		ItemStack item = event.getPlayer().getItemInHand();
		
		if (entity.getType().equals(EntityType.COW)) {
			//mount the bison if it's tamed
			if (bisonTamed.containsKey(entity.getUniqueId()) && bisonTamed.get(entity.getUniqueId())) {
				entity.setPassenger(event.getPlayer());
				//doesn't really work, trying to make cow move in player look direction
				entity.setVelocity(event.getPlayer().getLocation().getDirection());
			}
			//tames bison at cost of 1 apple
			else if (item.isSimilar(new ItemStack(Material.APPLE))) {
				item.setAmount(item.getAmount()-1);
				bisonTamed.put(entity.getUniqueId(), true);
			}
		}
		
		//tames lemur for 1 bread
		else if (entity.getType().equals(EntityType.BAT)) {
			if (item.isSimilar(new ItemStack(Material.BREAD)) && lemurOwner.get(entity.getUniqueId()).equals(null)) {
				item.setAmount(item.getAmount()-1);
				lemurOwner.put(entity.getUniqueId(), event.getPlayer());
			}
		}
	}

	@EventHandler
	public void mobHit(EntityDamageByEntityEvent event) {
		if (event.getDamager().getType().equals(EntityType.PLAYER) && event.getEntity().getType().equals(EntityType.PIG) && ((HumanEntity) event.getDamager()).getItemInHand().equals(Material.AIR)) {
			((Damageable) event.getDamager()).damage(3);
		}
	}
	
	@EventHandler
	public void mobDeath(EntityDeathEvent event) {
		Entity entity = event.getEntity();
		if (entity.getType().equals(EntityType.WOLF)) {
			entity.getWorld().dropItemNaturally(entity.getLocation(), new ItemStack(Material.LEATHER, (int) (Math.random() *10 % 3 + 1)));
		}
	}
}
