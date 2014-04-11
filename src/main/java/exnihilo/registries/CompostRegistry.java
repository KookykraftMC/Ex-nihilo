package exnihilo.registries;

import java.util.Hashtable;

import net.minecraft.block.Block;
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
	public static void register(int id, int meta, float value, Color color)
	{
		Compostable entry = new Compostable(id, meta, value, color);
		entries.put(id + ":" + meta, entry);
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
		register(6, 0, 0.125f, ColorRegistry.color("oak"));
		register(6, 1, 0.125f, ColorRegistry.color("spruce"));
		register(6, 2, 0.125f, ColorRegistry.color("birch"));
		register(6, 3, 0.125f,  ColorRegistry.color("jungle")); 
		
		//leaves
		register(18, 0, 0.125f, ColorRegistry.color("oak"));
		register(18, 1, 0.125f, ColorRegistry.color("spruce"));
		register(18, 2, 0.125f, ColorRegistry.color("birch"));
		register(18, 3, 0.125f,  ColorRegistry.color("jungle"));
		
		//rotten flesh
		register(367, 0, 0.10f, ColorRegistry.color("rotten_flesh"));
		//spider eye
		register(375, 0, 0.08f, ColorRegistry.color("spider_eye"));
		
		//wheat
		register(296, 0, 0.08f, ColorRegistry.color("wheat"));
		//bread
		register(297, 0, 0.16f, ColorRegistry.color("bread"));
		
		//dandelion
		register(37, 0, 0.10f, ColorRegistry.color("dandelion"));
		//rose
		register(38, 0, 0.10f, ColorRegistry.color("rose"));
		
		//mushroom_brown
		register(39, 0, 0.10f, ColorRegistry.color("mushroom_brown"));
		//mushroom_red
		register(40, 0, 0.10f, ColorRegistry.color("mushroom_red"));
		
		//pumpkin pie
		register(400, 0, 0.16f, ColorRegistry.color("pumpkin_pie"));
		
		//pork
		register(319, 0, 0.2f, ColorRegistry.color("pork_raw"));
		//cooked pork
		register(320, 0, 0.2f, ColorRegistry.color("pork_cooked"));
		
		//beef
		register(363, 0, 0.2f, ColorRegistry.color("beef_raw"));
		//cooked beef
		register(364, 0, 0.2f, ColorRegistry.color("beef_cooked"));
		
		//chicken
		register(365, 0, 0.2f, ColorRegistry.color("chicken_raw"));
		//cooked chicken
		register(366, 0, 0.2f, ColorRegistry.color("chicken_cooked"));
		
		//fish
		register(349, 0, 0.15f, ColorRegistry.color("fish_raw"));
		//cooked fish
		register(350, 0, 0.15f, ColorRegistry.color("fish_cooked"));
		
		//cooked silkworms
		register(Item.getIdFromItem(ENItems.Silkworm), 0, 0.04f, ColorRegistry.color("silkworm_raw"));
		//cooked silkworms
		register(Item.getIdFromItem(ENItems.SilkwormCooked), 0, 0.04f, ColorRegistry.color("silkworm_cooked"));
		
		//apple
		register(260, 0, 0.10f, ColorRegistry.color("apple"));
		//melon slice
		register(360, 0, 0.04f, ColorRegistry.color("melon"));
		//melon
		register(103, 0, 1.0f / 6, ColorRegistry.color("melon"));
		//pumpkin
		register(86, 0, 1.0f / 6, ColorRegistry.color("pumpkin"));
		//jack o lantern
		register(91, 0, 1.0f / 6, ColorRegistry.color("pumpkin"));
		//cactus
		register(81, 0, 0.10f, ColorRegistry.color("cactus"));
		
		//carrot
		register(391, 0, 0.08f, ColorRegistry.color("carrot"));
		//potato
		register(392, 0, 0.08f, ColorRegistry.color("potato"));
		//baked potato
		register(393, 0, 0.08f, ColorRegistry.color("potato_baked"));
		//poison potato
		register(394, 0, 0.08f, ColorRegistry.color("potato_poison"));
		
		//waterlily
		register(106, 0, 0.10f, ColorRegistry.color("waterlily"));
		//vine
		register(111, 0, 0.10f, ColorRegistry.color("vine"));
		//tall grass
		register(Block.getIdFromBlock(Blocks.tallgrass), 1, 0.08f, ColorRegistry.color("tall_grass"));
		//egg
		register(344, 0, 0.08f, ColorRegistry.color("egg"));
		//netherwart
		register(372, 0, 0.10f, ColorRegistry.color("netherwart"));
		//sugar cane
		register(338, 0, 0.08f, ColorRegistry.color("sugar_cane"));
		//string
		register(Item.getIdFromItem(Items.string), 0, 0.04f, ColorRegistry.color("white"));
	}
}
