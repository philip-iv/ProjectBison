package com.tlaminecraft.projectbison;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
//import org.bukkit.block.Block;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.EventPriority;
//import org.bukkit.event.Listener;
//import org.bukkit.event.block.Action;
//import org.bukkit.event.player.PlayerInteractEvent;
//import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

<<<<<<< HEAD
public class ProjectBison extends JavaPlugin {
=======
public class ProjectBison extends JavaPlugin //implements Listener 
{

	@SuppressWarnings("deprecation")
>>>>>>> 5d8853b2f7789ca176de55a3cdb13a20de730b7e
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
<<<<<<< HEAD
        ShapedRecipe EKHelmet = 
    		new ShapedRecipe(setName(new ItemStack(Material.GOLD_HELMET, 1), ChatColor.DARK_GREEN + "Earth Kingdom Helmet"))
        		.shape("***","*%*"," ! ")
                .setIngredient('*', Material.LEATHER)
                .setIngredient('%', new ItemStack(Material.INK_SACK, 1, (short) 2).getData())
                .setIngredient('!', Material.GOLD_NUGGET);       
=======
        ShapedRecipe EKHelmet = new ShapedRecipe(setName(new ItemStack(Material.GOLD_HELMET, 1), ChatColor.DARK_GREEN + "Earth Kingdom Helmet")).shape("***","*%*"," ! ")
                        .setIngredient('*', Material.LEATHER)
                        .setIngredient('%', Material.INK_SACK, 15 - DyeColor.GREEN.getData())
                        .setIngredient('!', Material.GOLD_NUGGET);

       
>>>>>>> 5d8853b2f7789ca176de55a3cdb13a20de730b7e
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
	
	//Makes sure the Recepies are continually added every time the Plugin reloads	
	getServer().clearRecipes();
		
	}
	
	//Crate Code
	
	//The problem is, this code creates an inventory, but more along the lines of a personal inventory, and I can't figure out how to attach the inventory to the block and not the person.
	//So right now it acts more like an Enderchest
	
	//public static Inventory myInventory = Bukkit.createInventory(null, 9, ChatColor.DARK_AQUA + "Crate");
	        //static {
		//}

        //This is the listener that monitors when a tnt block is right clicked so it can open the inventory but it's
       // a little glitchy

	       // @EventHandler
	        //(priority=EventPriority.HIGH)
	       // public void onPlayerUse(PlayerInteractEvent event){
	           // Player p = event.getPlayer();
	            //Block clicked = event.getClickedBlock();
	 
	            //if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			//		if (clicked.getType() == Material.TNT){
	                  //  p.openInventory(myInventory);
	          //  }
				//	}

	public ItemStack setName(ItemStack item, String name) {
        ItemMeta Meta = item.getItemMeta();
        Meta.setDisplayName(name);
        item.setItemMeta(Meta);
        return item;
	}
}
