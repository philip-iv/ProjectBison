package com.tlaminecraft.projectbison;

import org.bukkit.plugin.java.JavaPlugin;

public class ProjectBison extends JavaPlugin {
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
	
}
