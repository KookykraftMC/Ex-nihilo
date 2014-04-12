package exnihilo.registries;

import java.util.Hashtable;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import exnihilo.ENItems;
import exnihilo.registries.helpers.Color;
import exnihilo.registries.helpers.Compostable;


public class CompostRegistry {
	public static Hashtable<String, Compostable> entries = new Hashtable<String, Compostable>();
	
	//Value is how much it fills a barrel. 0.01 = 1%, 1 = 100%;
	public static void register(Item item, int meta, float value, Color color)
	{
		Compostable entry = new Compostable(item, meta, value, color);
		entries.put(item + ":" + meta, entry);
	}
	
	public static boolean containsItem(int id, int meta)
	{
		return entries.containsKey(id + ":" + meta);
	}
	
	
	public static Compostable getItem(int id, int meta)
	{
		return entries.get(id + ":" + meta);
	}
	
	public static void load(Configuration config)
	{
		//saplings
		register(Item.getItemFromBlock(Blocks.sapling), 0, 0.125f, ColorRegistry.color("oak"));
		register(Item.getItemFromBlock(Blocks.sapling), 1, 0.125f, ColorRegistry.color("spruce"));
		register(Item.getItemFromBlock(Blocks.sapling), 2, 0.125f, ColorRegistry.color("birch"));
		register(Item.getItemFromBlock(Blocks.sapling), 3, 0.125f,  ColorRegistry.color("jungle")); 
		
		//leaves
		register(Item.getItemFromBlock(Blocks.leaves), 0, 0.125f, ColorRegistry.color("oak"));
		register(Item.getItemFromBlock(Blocks.leaves), 1, 0.125f, ColorRegistry.color("spruce"));
		register(Item.getItemFromBlock(Blocks.leaves), 2, 0.125f, ColorRegistry.color("birch"));
		register(Item.getItemFromBlock(Blocks.leaves), 3, 0.125f,  ColorRegistry.color("jungle"));
		
		//rotten flesh
		register(Items.rotten_flesh, 0, 0.10f, ColorRegistry.color("rotten_flesh"));
		//spider eye
		register(Items.spider_eye, 0, 0.08f, ColorRegistry.color("spider_eye"));
		
		//wheat
		register(Items.wheat, 0, 0.08f, ColorRegistry.color("wheat"));
		//bread
		register(Items.bread, 0, 0.16f, ColorRegistry.color("bread"));
		
		//dandelion
		register(Item.getItemFromBlock(Blocks.yellow_flower), 0, 0.10f, ColorRegistry.color("dandelion"));
		//poppy
		register(Item.getItemFromBlock(Blocks.red_flower), 0, 0.10f, ColorRegistry.color("rose"));
		
		//mushroom_brown
		register(Item.getItemFromBlock(Blocks.brown_mushroom), 0, 0.10f, ColorRegistry.color("mushroom_brown"));
		//mushroom_red
		register(Item.getItemFromBlock(Blocks.red_mushroom), 0, 0.10f, ColorRegistry.color("mushroom_red"));
		
		//pumpkin pie
		register(Items.pumpkin_pie, 0, 0.16f, ColorRegistry.color("pumpkin_pie"));
		
		//pork
		register(Items.porkchop, 0, 0.2f, ColorRegistry.color("pork_raw"));
		//cooked pork
		register(Items.cooked_porkchop, 0, 0.2f, ColorRegistry.color("pork_cooked"));
		
		//beef
		register(Items.beef, 0, 0.2f, ColorRegistry.color("beef_raw"));
		//cooked beef
		register(Items.cooked_beef, 0, 0.2f, ColorRegistry.color("beef_cooked"));
		
		//chicken
		register(Items.chicken, 0, 0.2f, ColorRegistry.color("chicken_raw"));
		//cooked chicken
		register(Items.cooked_chicken, 0, 0.2f, ColorRegistry.color("chicken_cooked"));
		
		//fish
		register(Items.fish, 0, 0.15f, ColorRegistry.color("fish_raw"));
		//cooked fish
		register(Items.cooked_fished, 0, 0.15f, ColorRegistry.color("fish_cooked"));
		
		//cooked silkworms
		register(ENItems.Silkworm, 0, 0.04f, ColorRegistry.color("silkworm_raw"));
		//cooked silkworms
		register(ENItems.SilkwormCooked, 0, 0.04f, ColorRegistry.color("silkworm_cooked"));
		
		//apple
		register(Items.apple, 0, 0.10f, ColorRegistry.color("apple"));
		//melon slice
		register(Items.melon, 0, 0.04f, ColorRegistry.color("melon"));
		//melon
		register(Item.getItemFromBlock(Blocks.melon_block), 0, 1.0f / 6, ColorRegistry.color("melon"));
		//pumpkin
		register(Item.getItemFromBlock(Blocks.pumpkin), 0, 1.0f / 6, ColorRegistry.color("pumpkin"));
		//jack o lantern
		register(Item.getItemFromBlock(Blocks.lit_pumpkin), 0, 1.0f / 6, ColorRegistry.color("pumpkin"));
		//cactus
		register(Item.getItemFromBlock(Blocks.cactus), 0, 0.10f, ColorRegistry.color("cactus"));
		
		//carrot
		register(Items.carrot, 0, 0.08f, ColorRegistry.color("carrot"));
		//potato
		register(Items.potato, 0, 0.08f, ColorRegistry.color("potato"));
		//baked potato
		register(Items.baked_potato, 0, 0.08f, ColorRegistry.color("potato_baked"));
		//poison potato
		register(Items.poisonous_potato, 0, 0.08f, ColorRegistry.color("potato_poison"));
		
		//waterlily
		register(Item.getItemFromBlock(Blocks.waterlily), 0, 0.10f, ColorRegistry.color("waterlily"));
		//vine
		register(Item.getItemFromBlock(Blocks.vine), 0, 0.10f, ColorRegistry.color("vine"));
		//tall grass
		register(Item.getItemFromBlock(Blocks.tallgrass), 1, 0.08f, ColorRegistry.color("tall_grass"));
		//egg
		register(Items.egg, 0, 0.08f, ColorRegistry.color("egg"));
		//netherwart
		register(Items.nether_wart, 0, 0.10f, ColorRegistry.color("netherwart"));
		//sugar cane
		register(Items.reeds, 0, 0.08f, ColorRegistry.color("sugar_cane"));
		//string
		register(Items.string, 0, 0.04f, ColorRegistry.color("white"));
	}
}
