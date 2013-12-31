package com.tlaminecraft.projectbison;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public final class MobEventListener implements Listener {
	public void HorseSpawn(CreatureSpawnEvent event) {
		Entity entity = event.getEntity();
		if (entity.getType()==EntityType.HORSE) {
			Horse horse = (Horse) entity;
			//Komodo Rhino
			if (horse.getColor()==Horse.Color.BLACK) {
				horse.setMaxHealth(20);
				horse.setHealth(20);
				horse.setJumpStrength(0);
			}
			//Eel Hound
			else if (horse.getColor()==Horse.Color.CHESTNUT) {
				horse.setMaxHealth(10);
				horse.setHealth(10);
				horse.setJumpStrength(2);
			}
			//Ostrich Horse
			else if (horse.getColor()==Horse.Color.CREAMY) {
				horse.setMaxHealth(10);
				horse.setHealth(10);
				horse.setJumpStrength(1.3);
			}
			//Buffalo Yak
			else if (horse.getVariant()==Horse.Variant.DONKEY) {
				horse.setMaxHealth(10);
				horse.setHealth(10);
				horse.setJumpStrength(1.3);
			}
			//Polar Bear Dog
			else if (horse.getColor()==Horse.Color.BROWN) {
				horse.setMaxHealth(16);
				horse.setHealth(16);
				horse.setJumpStrength(1.1);
			}
		}
	}
}
