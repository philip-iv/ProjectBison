package com.tlaminecraft.projectbison;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class SLAPI {
	public static <T extends Object> void save(T obj,String path) throws Exception
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}
	
	public static <T extends Object> T load(String path) throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		@SuppressWarnings("unchecked")
		T result = (T)ois.readObject();
		ois.close();
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public static String inventoryToString (Inventory invInventory)
    {
        String serialization = invInventory.getSize() + ";";
        for (int i = 0; i < invInventory.getSize(); i++)
        {
            ItemStack is = invInventory.getItem(i);
            if (is != null)
            {
                String serializedItemStack = new String();
               
                String isType = String.valueOf(is.getType());
                serializedItemStack += "t@" + isType;
               
                if (is.getDurability() != 0)
                {
                    String isDurability = String.valueOf(is.getDurability());
                    serializedItemStack += ":d@" + isDurability;
                }
               
                if (is.getAmount() != 1)
                {
                    String isAmount = String.valueOf(is.getAmount());
                    serializedItemStack += ":a@" + isAmount;
                }
                
                if (is.getType().name().contains("LEATHER")) {
                	String isColor = String.valueOf(((LeatherArmorMeta) is.getItemMeta()).getColor().asRGB());
                	serializedItemStack += ":c@" + isColor;
                }
                
                
               if(is.getItemMeta().hasLore()) {
                	List<String> isLore = is.getItemMeta().getLore();
                	for (String lore : isLore) {
                		serializedItemStack+= ":l@" + lore;
                	} 
                }
               
                Map<Enchantment,Integer> isEnch = is.getEnchantments();
                if (isEnch.size() > 0)
                {
                    for (Entry<Enchantment,Integer> ench : isEnch.entrySet())
                    {
                        serializedItemStack += ":e@" + ench.getKey().getId() + "@" + ench.getValue();
                    }
                }
               
                serialization += i + "#" + serializedItemStack + ";";
            }
        }
        return serialization;
    }
   
    @SuppressWarnings("deprecation")
	public static Inventory stringToInventory (String invString)
    {
        String[] serializedBlocks = invString.split(";");
        String invInfo = serializedBlocks[0];
        Inventory deserializedInventory = Bukkit.getServer().createInventory(null, Integer.valueOf(invInfo));
       
        for (int i = 1; i < serializedBlocks.length; i++)
        {
            String[] serializedBlock = serializedBlocks[i].split("#");
            int stackPosition = Integer.valueOf(serializedBlock[0]);
           
            if (stackPosition >= deserializedInventory.getSize())
            {
                continue;
            }
           
            ItemStack is = null;
            Boolean createdItemStack = false;
           
            String[] serializedItemStack = serializedBlock[1].split(":");
            for (String itemInfo : serializedItemStack)
            {
                String[] itemAttribute = itemInfo.split("@");
                if (itemAttribute[0].equals("t"))
                {
                    is = new ItemStack(Material.getMaterial(itemAttribute[1]));
                    createdItemStack = true;
                }
                else if (itemAttribute[0].equals("d") && createdItemStack)
                {
                    is.setDurability(Short.valueOf(itemAttribute[1]));
                }
                else if (itemAttribute[0].equals("a") && createdItemStack)
                {
                    is.setAmount(Integer.valueOf(itemAttribute[1]));
                }
                else if (itemAttribute[0].equals("e") && createdItemStack)
                {
                    is.addEnchantment(Enchantment.getById(Integer.valueOf(itemAttribute[1])), Integer.valueOf(itemAttribute[2]));
                }
                else if (itemAttribute[0].equals("c") && createdItemStack) {
                	ItemMeta im = is.getItemMeta();
                	((LeatherArmorMeta) im).setColor(Color.fromRGB(Integer.valueOf(itemAttribute[1])));
                	is.setItemMeta(im);
                }
               else if (itemAttribute[0].equals("l") && createdItemStack) {
                	ItemMeta im = is.getItemMeta();
                	List<String> lore;
                	if (im.hasLore()) {
                		lore = im.getLore();
                	}
                	else {
                		lore = new ArrayList<String>();
                	}
                	String loreText = itemAttribute[1];
                	lore.add(loreText);
                	im.setLore(lore);
                	is.setItemMeta(im);
                }
            }
            deserializedInventory.setItem(stackPosition, is);
        }
       
        return deserializedInventory;
    }

    public static Map<Location, Inventory> stringToMap(String mapString) {
    	Map<Location, Inventory> deserializedMap = new HashMap<Location, Inventory>();
    	String[] serializedInventories = mapString.split("'");
    	for (int i=0; i<serializedInventories.length; i++) {
    		String[] wtfNamed = serializedInventories[i].split("!");
    		if (wtfNamed.length >= 5) {
    			World world = Bukkit.getServer().getWorld(wtfNamed[0]);
    			double x = Double.parseDouble(wtfNamed[1]);
    			double y = Double.parseDouble(wtfNamed[2]);
    			double z = Double.parseDouble(wtfNamed[3]);
    			Location loc = new Location(world, x, y, z);
    			deserializedMap.put(loc, stringToInventory(wtfNamed[4]));
    		}
    	}
    	return deserializedMap;
    }
    
    public static String mapToString(Map<Location, Inventory> map) {
    	String serializedMap = "";
    	for (Entry<Location, Inventory> entry : map.entrySet()) {
    		Location key = entry.getKey();
    		serializedMap = serializedMap + key.getWorld().getName() + "!" + key.getX() + "!" + key.getY() + "!" + key.getZ() + "!" + inventoryToString(entry.getValue()) + "'";
    	}
    	return serializedMap;
    }
}
