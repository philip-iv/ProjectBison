package com.tlaminecraft.projectbison;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class ProjectBison extends JavaPlugin {
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new MobEventListener(), this);
		getServer().getPluginManager().registerEvents(new GliderListener(), this);
        //Recipes
          //SWT
        ShapedRecipe SWTArmor =
        	new ShapedRecipe(setName(new ItemStack(Material.LEATHER_CHESTPLATE, 1), ChatColor.AQUA + "Southern Water Tribe Armor"))
        		.shape("*%*","***","***")
        		.setIngredient('*', Material.LEATHER)
        		.setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 4).getData());
        //Water Tribe Leggings
        ShapedRecipe SWTLeggings =
        	new ShapedRecipe(setName(new ItemStack(Material.LEATHER_LEGGINGS, 1), ChatColor.AQUA + "Southern Water Tribe Leggings"))
        		.shape("***","*%*","* *")
            	.setIngredient('*', Material.LEATHER)
                .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 4).getData());
        //Water Tribe Boots
        ShapedRecipe SWTBoots =
    		new ShapedRecipe(setName(new ItemStack(Material.LEATHER_BOOTS, 1), ChatColor.AQUA + "Southern Water Tribe Boots"))
        		.shape("   ","* *","*%*")
                .setIngredient('*', Material.LEATHER)
                .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 4).getData());
        //Water Tribe Helmet
        ShapedRecipe SWTHelmet =
    		new ShapedRecipe(setName(new ItemStack(Material.LEATHER_HELMET, 1), ChatColor.AQUA + "Southern Water Tribe Helmet"))
        		.shape("***","*%*","   ")
                .setIngredient('*', Material.LEATHER)
                .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 4).getData());
         
        //NWT
        ShapedRecipe NWTArmor =
    		new ShapedRecipe(setName(new ItemStack(Material.IRON_CHESTPLATE, 1), ChatColor.DARK_BLUE + "Northern Water Tribe Armor"))
        		.shape("*%*","***","***")
                .setIngredient('*', Material.LEATHER)
                .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 12).getData());
        //Water Tribe Leggings
        ShapedRecipe NWTLeggings =
    		new ShapedRecipe(setName(new ItemStack(Material.IRON_LEGGINGS, 1), ChatColor.DARK_BLUE + "Northern Water Tribe Leggings"))
        		.shape("***","*%*","* *")
                .setIngredient('*', Material.LEATHER)
                .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 12).getData());
        //Water Tribe Boots
        ShapedRecipe NWTBoots =
    		new ShapedRecipe(setName(new ItemStack(Material.IRON_BOOTS, 1), ChatColor.DARK_BLUE + "Northern Water Tribe Boots"))
        		.shape("   ","* *","*%*")
                .setIngredient('*', Material.LEATHER)
                .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 12).getData());
        //Water Tribe Helmet
        ShapedRecipe NWTHelmet = 
    		new ShapedRecipe(setName(new ItemStack(Material.IRON_HELMET, 1), ChatColor.DARK_BLUE + "Northern Water Tribe Helmet"))
        		.shape("***","*%*","   ")
                .setIngredient('*', Material.LEATHER)
                .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 12).getData());
       
        //FN
        ShapedRecipe FNArmor = 
    		new ShapedRecipe(setName(new ItemStack(Material.DIAMOND_CHESTPLATE, 1), ChatColor.RED + "Fire Nation Armor"))
        		.shape("*%*","***","***")
                .setIngredient('*', Material.IRON_INGOT)
                .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 1).getData());
        //FN Leggings
        ShapedRecipe FNLeggings = 
    		new ShapedRecipe(setName(new ItemStack(Material.DIAMOND_LEGGINGS, 1), ChatColor.RED + "Fire Nation Leggings"))
        		.shape("***","*%*","* *")
                .setIngredient('*', Material.IRON_INGOT)
                .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 1).getData());
        //FN Boots
        ShapedRecipe FNBoots = 
    		new ShapedRecipe(setName(new ItemStack(Material.DIAMOND_BOOTS, 1), ChatColor.RED + "Fire Nation Boots"))
        		.shape("   ","* *","*%*")
                .setIngredient('*', Material.IRON_INGOT)
                .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 1).getData());
        //FN Helmet
        ShapedRecipe FNHelmet = 
        		new ShapedRecipe(setName(new ItemStack(Material.DIAMOND_HELMET, 1), ChatColor.RED + "Fire Nation Helmet"))
        			.shape("***","*%*","   ")
        			.setIngredient('*', Material.IRON_INGOT)
        			.setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 1).getData());
       
        //EK
        ShapedRecipe EKArmor = 
    		new ShapedRecipe(setName(new ItemStack(Material.GOLD_CHESTPLATE, 1), ChatColor.DARK_GREEN + "Earth Kingdom Armor"))
        		.shape("*%*","***","*!*")
                .setIngredient('*', Material.LEATHER)
                .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 2).getData())
                .setIngredient('!', Material.GOLD_NUGGET);
        //EK Leggings
        ShapedRecipe EKLeggings = 
    		new ShapedRecipe(setName(new ItemStack(Material.GOLD_LEGGINGS, 1), ChatColor.DARK_GREEN + "Earth Kingdom Leggings"))
        		.shape("***","*%*","* *")
                .setIngredient('*', Material.LEATHER)
                .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 2).getData());
        //EK Boots
        ShapedRecipe EKBoots = 
    		new ShapedRecipe(setName(new ItemStack(Material.GOLD_BOOTS, 1), ChatColor.DARK_GREEN + "Earth Kingdom Boots"))
        		.shape("   ","* *","*%*")
                .setIngredient('*', Material.LEATHER)
                .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 2).getData());
        //EK Helmet
        ShapedRecipe EKHelmet = 
    		new ShapedRecipe(setName(new ItemStack(Material.GOLD_HELMET, 1), ChatColor.DARK_GREEN + "Earth Kingdom Helmet"))
        		.shape("***","*%*"," ! ")
                .setIngredient('*', Material.LEATHER)
                .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 2).getData())
                .setIngredient('!', Material.GOLD_NUGGET);       
//Other
       
       
        //Adds Recipe
        getServer().addRecipe(SWTArmor);
        getServer().addRecipe(SWTLeggings);
        getServer().addRecipe(SWTBoots);
        getServer().addRecipe(SWTHelmet);
        getServer().addRecipe(NWTArmor);
        getServer().addRecipe(NWTLeggings);
        getServer().addRecipe(NWTBoots);
        getServer().addRecipe(NWTHelmet);
        getServer().addRecipe(FNArmor);
        getServer().addRecipe(FNLeggings);
        getServer().addRecipe(FNBoots);
        getServer().addRecipe(FNHelmet);
        getServer().addRecipe(EKArmor);
        getServer().addRecipe(EKLeggings);
        getServer().addRecipe(EKBoots);
        getServer().addRecipe(EKHelmet);

}

	public void onDisable() {
		
	}

	public ItemStack setName(ItemStack item, String name) {
        ItemMeta Meta = item.getItemMeta();
        Meta.setDisplayName(name);
        item.setItemMeta(Meta);
        return item;
	}
}
