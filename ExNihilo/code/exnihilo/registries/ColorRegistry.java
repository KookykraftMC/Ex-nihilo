package exnihilo.registries;

import java.util.Hashtable;
import java.util.List;

import net.minecraftforge.common.Configuration;

import com.google.common.collect.Lists;

import exnihilo.registries.helpers.Color;


public class ColorRegistry {
	public static Hashtable<String, Color> entries = new Hashtable<String, Color>();
	
	public static void register(String name, Color color)
	{
		entries.put(name, color);
	}
	
	public static Color color(String name)
	{
		return entries.get(name);	
	}
	
	
	public static String CATEGORY_COLORS = "Colors";
	
	public static void load(Configuration config)
	{
		//Used by the render system.
		register("white", new Color(1f,1f,1f,1f));
		register("black", new Color(0f,0f,0f,1f));
		
		//Block colors.
		register("dirt", new Color(config.get(CATEGORY_COLORS, "dirt", "EEA96D").getString()));
		register("gravel", new Color(config.get(CATEGORY_COLORS, "gravel", "E3E3E3").getString()));
		register("sand", new Color(config.get(CATEGORY_COLORS, "sand", "FFFEA8").getString()));
		register("dust", new Color(config.get(CATEGORY_COLORS, "dust", "FFFEDB").getString()));
		register("soul_sand", new Color(config.get(CATEGORY_COLORS, "soul_sand", "8F5B4D").getString()));
		
		//Saplings
		register("oak", new Color(config.get(CATEGORY_COLORS, "oak", "35A82A").getString()));
		register("birch", new Color(config.get(CATEGORY_COLORS, "birch", "6CC449").getString()));
		register("spruce", new Color(config.get(CATEGORY_COLORS, "spruce", "2E8042").getString()));
		register("jungle", new Color(config.get(CATEGORY_COLORS, "jungle", "22A116").getString()));
		
		//Meats
		register("pork_raw", new Color(config.get(CATEGORY_COLORS, "pork_raw", "FFA091").getString()));
		register("pork_cooked", new Color(config.get(CATEGORY_COLORS, "pork_cooked", "FFFDBD").getString()));
		register("beef_raw", new Color(config.get(CATEGORY_COLORS, "beef_raw", "FF4242").getString()));
		register("beef_cooked", new Color(config.get(CATEGORY_COLORS, "beef_cooked", "80543D").getString()));
		register("chicken_raw", new Color(config.get(CATEGORY_COLORS, "chicken_raw", "FFE8E8").getString()));
		register("chicken_cooked", new Color(config.get(CATEGORY_COLORS, "chicken_cooked", "FA955F").getString()));
		register("fish_raw", new Color(config.get(CATEGORY_COLORS, "fish_raw", "6DCFB3").getString()));
		register("fish_cooked", new Color(config.get(CATEGORY_COLORS, "fish_cooked", "D8EBE5").getString()));
		register("silkworm_raw", new Color(config.get(CATEGORY_COLORS, "silkworm_raw", "FFFDC9").getString()));	
		register("silkworm_cooked", new Color(config.get(CATEGORY_COLORS, "silkworm_cooked", "EDA17B").getString()));	
		
		//Fruits and veggies
		register("apple", new Color(config.get(CATEGORY_COLORS, "apple", "FFF68F").getString()));
		register("melon", new Color(config.get(CATEGORY_COLORS, "melon", "FF443B").getString()));
		register("pumpkin", new Color(config.get(CATEGORY_COLORS, "pumpkin", "FFDB66").getString()));
		register("carrot", new Color(config.get(CATEGORY_COLORS, "carrot", "FF9B0F").getString()));
		register("potato", new Color(config.get(CATEGORY_COLORS, "potato", "FFF1B5").getString()));
		register("potato_baked", new Color(config.get(CATEGORY_COLORS, "potato_baked", "FFF1B5").getString()));
		register("potato_poison", new Color(config.get(CATEGORY_COLORS, "potato_poison", "E0FF8A").getString()));
		
		//mob drops
		register("rotten_flesh", new Color(config.get(CATEGORY_COLORS, "rotten_flesh", "C45631").getString()));
		register("spider_eye", new Color(config.get(CATEGORY_COLORS, "spider_eye", "963E44").getString()));
		
		//Other stuff
		register("wheat", new Color(config.get(CATEGORY_COLORS, "wheat", "E3E162").getString()));
		register("bread", new Color(config.get(CATEGORY_COLORS, "bread", "D1AF60").getString()));
		register("pumpkin_pie", new Color(config.get(CATEGORY_COLORS, "pumpkin_pie", "E39A6D").getString()));
		register("dandelion", new Color(config.get(CATEGORY_COLORS, "dandelion", "FFF461").getString()));
		register("rose", new Color(config.get(CATEGORY_COLORS, "rose", "FF1212").getString()));
		register("mushroom_brown", new Color(config.get(CATEGORY_COLORS, "mushroom_brown", "CFBFB6").getString()));
		register("mushroom_red", new Color(config.get(CATEGORY_COLORS, "mushroom_red", "D6A8A5").getString()));
		register("cactus", new Color(config.get(CATEGORY_COLORS, "cactus", "DEFFB5").getString()));
		register("vine", new Color(config.get(CATEGORY_COLORS, "vine", "23630E").getString()));
		register("tall_grass", new Color(config.get(CATEGORY_COLORS, "tall_grass", "23630E").getString()));
		register("waterlily", new Color(config.get(CATEGORY_COLORS, "waterlily", "269900").getString()));
		register("egg", new Color(config.get(CATEGORY_COLORS, "egg", "FFFA66").getString()));
		register("netherwart", new Color(config.get(CATEGORY_COLORS, "netherwart", "FF2B52").getString()));
		register("sugar_cane", new Color(config.get(CATEGORY_COLORS, "sugar_cane", "9BFF8A").getString()));
		
		register("water_slime_offset", new Color("33ff22"));
		register("witchwater", new Color("990066"));
		register("water_witchy_offset", new Color("851E3A"));
		//register("water_witchy_offset", new Color("912140"));
		//register("water_witchy_offset", new Color("dd2255"));
	}
}