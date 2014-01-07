package com.tlaminecraft.projectbison;

import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;

public class ProjectBison extends JavaPlugin {
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new MobEventListener(), this);
		getServer().getPluginManager().registerEvents(new GliderListener(), this);
		getServer().getPluginManager().registerEvents(new ContainerListener(), this);
       
		 Iterator<Recipe> recipes = Bukkit.recipeIterator();
		 
		 while(recipes.hasNext()) {
			 Recipe recipe = recipes.next();
			 if(recipe.getResult().equals(new ItemStack(Material.LEATHER_HELMET)) || recipe.getResult().equals(new ItemStack(Material.LEATHER_CHESTPLATE))
					 || recipe.getResult().equals(new ItemStack(Material.LEATHER_LEGGINGS)) || recipe.getResult().equals(new ItemStack(Material.LEATHER_BOOTS))
					 || recipe.getResult().equals(new ItemStack(Material.IRON_HELMET)) || recipe.getResult().equals(new ItemStack(Material.IRON_CHESTPLATE))
					 || recipe.getResult().equals(new ItemStack(Material.IRON_LEGGINGS)) || recipe.getResult().equals(new ItemStack(Material.IRON_BOOTS))
					 || recipe.getResult().equals(new ItemStack(Material.GOLD_HELMET)) || recipe.getResult().equals(new ItemStack(Material.GOLD_CHESTPLATE))
					 || recipe.getResult().equals(new ItemStack(Material.GOLD_LEGGINGS)) || recipe.getResult().equals(new ItemStack(Material.GOLD_BOOTS))
					 || recipe.getResult().equals(new ItemStack(Material.DIAMOND_HELMET)) || recipe.getResult().equals(new ItemStack(Material.DIAMOND_CHESTPLATE))
					 || recipe.getResult().equals(new ItemStack(Material.DIAMOND_LEGGINGS)) || recipe.getResult().equals(new ItemStack(Material.DIAMOND_BOOTS))
					 || recipe.getResult().equals(new ItemStack(Material.IRON_HOE)) || recipe.getResult().equals(new ItemStack(Material.GOLD_HOE))
					 || recipe.getResult().equals(new ItemStack(Material.STONE_HOE)) || recipe.getResult().equals(new ItemStack(Material.DIAMOND_HOE))
					 || recipe.getResult().equals(new ItemStack(Material.WOOD_SWORD)))
				 recipes.remove();
		 }
		 
        //Adds Recipes
        getServer().addRecipe(Recipes.SWTArmor);
        getServer().addRecipe(Recipes.SWTLeggings);
        getServer().addRecipe(Recipes.SWTBoots);
        getServer().addRecipe(Recipes.SWTHelmet);
        getServer().addRecipe(Recipes.SWTSpear);
        getServer().addRecipe(Recipes.NWTArmor);
        getServer().addRecipe(Recipes.NWTLeggings);
        getServer().addRecipe(Recipes.NWTBoots);
        getServer().addRecipe(Recipes.NWTHelmet);
        getServer().addRecipe(Recipes.NWTSpear);
        getServer().addRecipe(Recipes.FNArmor);
        getServer().addRecipe(Recipes.FNLeggings);
        getServer().addRecipe(Recipes.FNBoots);
        getServer().addRecipe(Recipes.FNHelmet);
        getServer().addRecipe(Recipes.FNSpear);
        getServer().addRecipe(Recipes.EKArmor);
        getServer().addRecipe(Recipes.EKLeggings);
        getServer().addRecipe(Recipes.EKBoots);
        getServer().addRecipe(Recipes.EKHelmet);
        getServer().addRecipe(Recipes.EKSpear);
        getServer().addRecipe(Recipes.Glider);
        
        //load inventories
        try {
			ContainerListener.crates = SLAPI.load("crates.bin");
			this.getLogger().info("crates successfully loaded");
		} catch (Exception e) {
			this.getLogger().severe("Couldnt find/load crates.bin");
			this.getLogger().severe("Creating new file");
			ContainerListener.crates = new HashMap<Block, Inventory>();
		}
}

	public void onDisable() {
	
	//Makes sure the Recipes are continually added every time the Plugin reloads	
	getServer().clearRecipes();
	
	//save inventories
	try {
		SLAPI.save(ContainerListener.crates, "crates.bin");
	} catch (Exception e) {
		this.getLogger().severe("Failed to save crates.bin");
	}
	}
	
}
