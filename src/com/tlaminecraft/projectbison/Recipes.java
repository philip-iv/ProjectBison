package com.tlaminecraft.projectbison;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Recipes {
	//SWT armor
    static ShapedRecipe SWTArmor =
    	new ShapedRecipe(setLore(setColor(new ItemStack(Material.LEATHER_CHESTPLATE, 1), Color.WHITE), ChatColor.DARK_AQUA + "Southern Water Tribe"))
    		.shape("*%*","***","***")
    		.setIngredient('*', Material.LEATHER)
    		.setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 4).getData());
    //Water Tribe Leggings
    static ShapedRecipe SWTLeggings =
    	new ShapedRecipe(setLore(setColor(new ItemStack(Material.LEATHER_LEGGINGS, 1), Color.WHITE), ChatColor.DARK_AQUA + "Southern Water Tribe"))
    		.shape("***","*%*","* *")
        	.setIngredient('*', Material.LEATHER)
            .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 4).getData());
    //Water Tribe Boots
    static ShapedRecipe SWTBoots =
		new ShapedRecipe(setLore(setColor(new ItemStack(Material.LEATHER_BOOTS, 1), Color.WHITE), ChatColor.DARK_AQUA + "Southern Water Tribe"))
    		.shape("   ","* *","*%*")
            .setIngredient('*', Material.LEATHER)
            .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 4).getData());
    //Water Tribe Helmet
    static ShapedRecipe SWTHelmet =
		new ShapedRecipe(setLore(setColor(new ItemStack(Material.LEATHER_HELMET, 1), Color.WHITE), ChatColor.DARK_AQUA + "Southern Water Tribe"))
    		.shape("***","*%*","   ")
            .setIngredient('*', Material.LEATHER)
            .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 4).getData());
    //SWT Spear
    static ShapedRecipe SWTSpear =
    		new ShapedRecipe(setLore(new ItemStack(Material.STONE_HOE, 1), ChatColor.DARK_AQUA + "Southern Water Tribe"))
        		.shape(" i ", " sg", " s ")
        		.setIngredient('i', Material.BONE)
        		.setIngredient('s', Material.STICK)
        		.setIngredient('g', new ItemStack(Material.INK_SACK, 1, (short) 4).getData());
    
    //NWT armor
    static ShapedRecipe NWTArmor =
		new ShapedRecipe(setLore(new ItemStack(Material.IRON_CHESTPLATE, 1), ChatColor.DARK_AQUA + "Northern Water Tribe"))
    		.shape("*%*","***","***")
            .setIngredient('*', Material.LEATHER)
            .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 12).getData());
    //Water Tribe Leggings
    static ShapedRecipe NWTLeggings =
		new ShapedRecipe(setLore(new ItemStack(Material.IRON_LEGGINGS, 1), ChatColor.DARK_AQUA + "Northern Water Tribe"))
    		.shape("***","*%*","* *")
            .setIngredient('*', Material.LEATHER)
            .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 12).getData());
    //Water Tribe Boots
    static ShapedRecipe NWTBoots =
		new ShapedRecipe(setLore(new ItemStack(Material.IRON_BOOTS, 1), ChatColor.DARK_AQUA + "Northern Water Tribe"))
    		.shape("   ","* *","*%*")
            .setIngredient('*', Material.LEATHER)
            .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 12).getData());
    //Water Tribe Helmet
    static ShapedRecipe NWTHelmet = 
		new ShapedRecipe(setLore(new ItemStack(Material.IRON_HELMET, 1), ChatColor.DARK_AQUA + "Northern Water Tribe"))
    		.shape("***","*%*","   ")
            .setIngredient('*', Material.LEATHER)
            .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 12).getData());
   //NWT Spear
    static ShapedRecipe NWTSpear =
    		new ShapedRecipe(setLore(new ItemStack(Material.IRON_HOE, 1), ChatColor.DARK_AQUA + "Northern Water Tribe"))
    			.shape(" i ", " sg", " s ")
        		.setIngredient('i', Material.IRON_INGOT)
        		.setIngredient('s', Material.STICK)
        		.setIngredient('g', new ItemStack(Material.INK_SACK, 1, (short) 12).getData());
    
    //FN Armor
    static ShapedRecipe FNArmor = 
		new ShapedRecipe(setLore(new ItemStack(Material.DIAMOND_CHESTPLATE, 1), ChatColor.DARK_RED + "Fire Nation"))
    		.shape("*%*","***","***")
            .setIngredient('*', Material.IRON_INGOT)
            .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 1).getData());
    //FN Leggings
    static ShapedRecipe FNLeggings = 
		new ShapedRecipe(setLore(new ItemStack(Material.DIAMOND_LEGGINGS, 1), ChatColor.DARK_RED + "Fire Nation"))
    		.shape("***","*%*","* *")
            .setIngredient('*', Material.IRON_INGOT)
            .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 1).getData());
    //FN Boots
    static ShapedRecipe FNBoots = 
		new ShapedRecipe(setLore(new ItemStack(Material.DIAMOND_BOOTS, 1), ChatColor.DARK_RED + "Fire Nation"))
    		.shape("   ","* *","*%*")
            .setIngredient('*', Material.IRON_INGOT)
            .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 1).getData());
    //FN Helmet
    static ShapedRecipe FNHelmet = 
    		new ShapedRecipe(setLore(new ItemStack(Material.DIAMOND_HELMET, 1), ChatColor.DARK_RED + "Fire Nation"))
    			.shape("***","*%*","   ")
    			.setIngredient('*', Material.IRON_INGOT)
    			.setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 1).getData());
    //FN Spear
    static ShapedRecipe FNSpear =
    		new ShapedRecipe(setLore(new ItemStack(Material.DIAMOND_HOE, 1), ChatColor.DARK_RED + "Fire Nation"))
    			.shape(" i ", " sg", " s ")
        		.setIngredient('i', Material.IRON_INGOT)
        		.setIngredient('s', Material.STICK)
        		.setIngredient('g', new ItemStack(Material.INK_SACK, 1, (short) 1).getData());
    
	//EK Armor
    static ShapedRecipe EKArmor = 
		new ShapedRecipe(setLore(new ItemStack(Material.GOLD_CHESTPLATE, 1), ChatColor.DARK_GREEN + "Earth Kingdom"))
    		.shape("*%*","***","*!*")
            .setIngredient('*', Material.LEATHER)
            .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 2).getData())
            .setIngredient('!', Material.GOLD_NUGGET);
    //EK Leggings
    static ShapedRecipe EKLeggings = 
		new ShapedRecipe(setLore(new ItemStack(Material.GOLD_LEGGINGS, 1), ChatColor.DARK_GREEN + "Earth Kingdom"))
    		.shape("***","*%*","* *")
            .setIngredient('*', Material.LEATHER)
            .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 2).getData());
    //EK Boots
    static ShapedRecipe EKBoots = 
		new ShapedRecipe(setLore(new ItemStack(Material.GOLD_BOOTS, 1), ChatColor.DARK_GREEN + "Earth Kingdom"))
    		.shape("   ","* *","*%*")
            .setIngredient('*', Material.LEATHER)
            .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 2).getData());
    //EK Helmet
    static ShapedRecipe EKHelmet = 
		new ShapedRecipe(setLore(new ItemStack(Material.GOLD_HELMET, 1), ChatColor.DARK_GREEN + "Earth Kingdom"))
    		.shape("***","*%*"," ! ")
            .setIngredient('*', Material.LEATHER)
            .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 2).getData())
            .setIngredient('!', Material.GOLD_NUGGET); 
    //EK Spear
    static ShapedRecipe EKSpear =
		new ShapedRecipe(setLore(new ItemStack(Material.GOLD_HOE, 1), ChatColor.DARK_GREEN + "Earth Kingdom"))
    		.shape(" i ", " sg", " s ")
    		.setIngredient('i', Material.IRON_INGOT)
    		.setIngredient('s', Material.STICK)
    		.setIngredient('g', new ItemStack(Material.INK_SACK, 1, (short) 2).getData());
    
    //glider
    static ShapedRecipe Glider = 
    	new ShapedRecipe(setLore(new ItemStack(Material.WOOD_SWORD, 1), ChatColor.YELLOW + "Air Nomads"))
    		.shape("sss","wsw","wsw")
    		.setIngredient('s', Material.STICK)
    		.setIngredient('w', Material.WOOL);
       
    public static ItemStack setLore(ItemStack item, String lore) {
    	ItemMeta Meta = item.getItemMeta();
    	List<String> l = new ArrayList<String>();
    	l.add(lore);
    	Meta.setLore(l);
    	item.setItemMeta(Meta);
    	return item;
    }

	public static ItemStack setColor(ItemStack item, Color color) {
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		meta.setColor(color);
		item.setItemMeta(meta);
		return item;
	}
}