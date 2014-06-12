package com.tlaminecraft.projectbison;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import net.milkbowl.vault.chat.Chat;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class ProjectBison extends JavaPlugin {
	static JavaPlugin instance;
	static Chat chat;
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(new MobEventListener(), this);
		getServer().getPluginManager().registerEvents(new GliderListener(), this);
		getServer().getPluginManager().registerEvents(new ContainerListener(), this);
		setupChat();
       
		 Iterator<Recipe> recipes = Bukkit.recipeIterator();
		 
		 while(recipes.hasNext()) {
			 Recipe recipe = recipes.next();
			 if(recipe.getResult().getType().name().contains("CHESTPLATE") || recipe.getResult().getType().name().contains("BOOTS")
					 || recipe.getResult().getType().name().contains("LEGGINGS") || recipe.getResult().getType().name().contains("HELMET")
					 || recipe.getResult().equals(new ItemStack(Material.WOOD_SWORD)) || recipe.getResult().getType().name().contains("HOE"))
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
        getServer().addRecipe(Recipes.Cabinet);
        getServer().addRecipe(Recipes.Crate);
        
        //load inventories
        if (!getDataFolder().exists()) {
          getDataFolder().mkdir();
        }
        try {
        	String crates = SLAPI.load(getDataFolder() + File.separator + "crates.txt");
			ContainerListener.crates = SLAPI.stringToMap(crates);
			this.getLogger().info("crates.txt successfully loaded");
		} catch (Exception e) {
			this.getLogger().warning("Couldn't find/load crates.txt, creating new file");
			ContainerListener.crates = new HashMap<Location, Inventory>();
		}
        try {
        	MobEventListener.bisonTamed = SLAPI.load(getDataFolder() + File.separator + "bison.txt");
			this.getLogger().info("bison.txt successfully loaded");
        } catch (Exception e) {
        	this.getLogger().warning("Couldn't find/load bison.txt, creating new file");
        	MobEventListener.bisonTamed = new HashMap<UUID, Boolean>();
    	}
}

	public void onDisable() {
	
	//Makes sure the Recipes are continually added every time the Plugin reloads	
	getServer().clearRecipes();
	
	//save inventories
	try {
		SLAPI.save(SLAPI.mapToString(ContainerListener.crates), getDataFolder() + File.separator + "crates.txt");
	} catch (Exception e) {
		this.getLogger().severe("Failed to save crates.txt");
	}
	try {
		SLAPI.save(MobEventListener.bisonTamed, getDataFolder() + File.separator + "bison.txt");
	} catch (Exception e) {
		this.getLogger().severe("Failed to save bison.txt");
        	e.printStackTrace();
	}
	}
	
	@EventHandler
	public void onSave(WorldSaveEvent event) {
		try {
			SLAPI.save(SLAPI.mapToString(ContainerListener.crates), getDataFolder() + File.separator + "crates.txt");
		} catch (Exception e) {
			this.getLogger().severe("Failed to save crates.txt");
		}
	}

	public static JavaPlugin getInstance() {
		return instance;
	}
	
	private boolean setupChat()
    {
        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (chat != null);
    }
}
