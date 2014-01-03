package com.tlaminecraft.projectbison;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class ProjectBison extends JavaPlugin //implements Listener 
{
	private Map<Location, Inventory> crates = new HashMap<Location, Inventory>();
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new MobEventListener(), this);
		getServer().getPluginManager().registerEvents(new GliderListener(), this);
       
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

}

	public void onDisable() {
	
	//Makes sure the Recipes are continually added every time the Plugin reloads	
	getServer().clearRecipes();
		
	}
	
	Inventory test = Bukkit.createInventory(null, 9, "Crate");
	@EventHandler (priority=EventPriority.HIGH)
	public void onPlayerUse(PlayerInteractEvent event){
		Player p = event.getPlayer();
	    Block clicked = event.getClickedBlock();
	    if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
	    	if (clicked.getType() == Material.TNT) {
    			p.openInventory(test);
	    	}
		}
	}
	
	
}
