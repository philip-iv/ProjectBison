package com.tlaminecraft.projectbison;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public final class MobEventListener implements Listener {
	private Map<Integer, Boolean> bisonTamed = new HashMap<Integer, Boolean>();
	private Map<Integer, Player> lemurOwner = new HashMap<Integer, Player>();
	
	@EventHandler
	public void MobSpawn(CreatureSpawnEvent event) {
		Entity entity = event.getEntity();		
		if (entity.getType().equals(EntityType.COW)) {
			//prevents spawning of cows/sky bison naturally
			if (event.getSpawnReason().equals(SpawnReason.NATURAL) || event.getSpawnReason().equals(SpawnReason.CHUNK_GEN)) {
				 ((Damageable) entity).damage(((Damageable) entity).getHealth());
			 }
			//makes them default to not tamed
			else {
				bisonTamed.put(entity.getEntityId(), false);
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
	public void MobInteract(PlayerInteractEntityEvent event) {
		Entity entity = event.getRightClicked();
		ItemStack item = event.getPlayer().getItemInHand();
		
		if (entity.getType().equals(EntityType.COW)) {
			//mount the bison if it's tamed
			if (bisonTamed.get(entity.getEntityId())) {
				entity.setPassenger(event.getPlayer());
			}
			//tames bison at cost of 1 apple
			else if (item.isSimilar(new ItemStack(Material.APPLE))) {
				item.setAmount(item.getAmount()-1);
				bisonTamed.put(entity.getEntityId(), true);
			}
		}
		
		if (entity.getType().equals(EntityType.BAT)) {
			if (item.isSimilar(new ItemStack(Material.BREAD)) && lemurOwner.get(entity.getEntityId()).equals(null)) {
				item.setAmount(item.getAmount()-1);
				lemurOwner.put(entity.getEntityId(), event.getPlayer());
			}
		}
	}
}
