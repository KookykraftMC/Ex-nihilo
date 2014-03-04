package exnihilo.data;


import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;

public class BlockData {
	private static final String CATEGORY = "blocks";
	private static final String ORE_CATEGORY = "ore blocks";	

	//Barrels (Wood)!
	public static int BARREL_ID = 3300;
	public static final String BARREL_KEY = "barrel";
	public static final String[] BARREL_NAMES = 
		{
		"Oak Barrel",
		"Spruce Barrel",
		"Birch Barrel",
		"Jungle Barrel"
		}; 
	public static final String[] BARREL_UNLOCALIZED_NAMES = 
		{
		"barrel.oak",
		"barrel.spruce",
		"barrel.birch",
		"barrel.jungle"
		}; 


	//Barrel (Stone)!
	public static int BARREL_STONE_ID = 3306;
	public static final String BARREL_STONE_KEY = "barrel_stone";
	public static final String BARREL_STONE_UNLOCALIZED_NAME = "barrel.stone";
	public static final String BARREL_STONE_NAME = "Stone Barrel";

	//Crucible!
	public static int CRUCIBLE_ID = 3307;
	public static final String CRUCIBLE_KEY = "crucible";
	public static final String CRUCIBLE_UNLOCALIZED_NAME = "crucible";
	public static final String CRUCIBLE_NAME = "Crucible";

	//Unfired Crucible!
	public static int CRUCIBLE_UNFIRED_ID = 3308;
	public static final String CRUCIBLE_UNFIRED_KEY = "crucible_unfired";
	public static final String CRUCIBLE_UNFIRED_UNLOCALIZED_NAME = "crucible_unfired";
	public static final String CRUCIBLE_UNFIRED_NAME = "Unfired Crucible";

	//Dust!
	public static int DUST_ID = 3301;
	public static final String DUST_KEY = "dust";
	public static final String DUST_UNLOCALIZED_NAME = "dust";
	public static final String DUST_NAME = "Dust";

	//Bee Trap!
	public static int BEE_TRAP_ID = 3316;
	public static final String BEE_TRAP_KEY = "bee_trap";
	public static final String BEE_TRAP_UNLOCALIZED_NAME = "bee_trap";
	public static final String BEE_TRAP_NAME = "Artificial Hive";

	//Bee Trap (Treated)!
	public static int BEE_TRAP_TREATED_ID = 3317;
	public static final String BEE_TRAP_TREATED_KEY = "bee_trap_treated";
	public static final String BEE_TRAP_TREATED_UNLOCALIZED_NAME = "bee_trap_treated";
	public static final String BEE_TRAP_TREATED_NAME = "Scented Artificial Hive";


	//Infested Leaves!
	public static int LEAVES_INFESTED_ID = 3302;
	public static final String LEAVES_INFESTED_KEY = "infested_leaves";
	public static final String[] LEAVES_INFESTED_NAMES = 
		{
		"Infested Leaves",
		"Infested Spruce Leaves",
		"Infested Birch Leaves",
		"Infested Jungle Leaves"
		}; 
	public static final String[] LEAVES_INFESTED_UNLOCALIZED_NAMES = 
		{
		"leaves.infested.oak",
		"leaves.infested.spruce",
		"leaves.infested.birch",
		"leaves.infested.jungle"
		}; 


	//Sift Table
	public static int SIEVE_ID = 3303;
	public static final String SIEVE_KEY = "sifting_table";
	public static final String[] SIEVE_NAMES = 
		{
		"Oak Sieve",
		"Spruce Sieve",
		"Birch Sieve",
		"Jungle Sieve"
		}; 
	public static final String[] SIEVE_UNLOCALIZED_NAMES = 
		{
		"sieve.oak",
		"sieve.spruce",
		"sieve.birch",
		"sieve.jungle"
		}; 

	//*****
	//ORES
	//*****

	//IRON
	public static int IRON_ORE_ID = 3304;
	public static final String IRON_ORE_KEY = "iron_ore";
	public static final String[] IRON_ORE_NAMES = 
		{
		"Iron Ore Gravel",
		"Iron Ore Sand",
		"Iron Ore Dust"
		}; 
	public static final String[] IRON_ORE_UNLOCALIZED_NAMES = 
		{
		"iron_gravel",
		"iron_sand",
		"iron_dust"
		}; 

	//GOLD
	public static int GOLD_ORE_ID = 3305;
	public static final String GOLD_ORE_KEY = "gold_ore";
	public static final String[] GOLD_ORE_NAMES = 
		{
		"Gold Ore Gravel",
		"Gold Ore Sand",
		"Gold Ore Dust"
		}; 
	public static final String[] GOLD_ORE_UNLOCALIZED_NAMES = 
		{
		"gold_gravel",
		"gold_sand",
		"gold_dust"
		}; 

	//COPPER
	public static int COPPER_ORE_ID = 3309;
	public static final String COPPER_ORE_KEY = "copper_ore";
	public static final String[] COPPER_ORE_NAMES = 
		{
		"Copper Ore Gravel",
		"Copper Ore Sand",
		"Copper Ore Dust"
		}; 
	public static final String[] COPPER_ORE_UNLOCALIZED_NAMES = 
		{
		"copper_gravel",
		"copper_sand",
		"copper_dust"
		}; 

	//TIN
	public static int TIN_ORE_ID = 3310;
	public static final String TIN_ORE_KEY = "tin_ore";
	public static final String[] TIN_ORE_NAMES = 
		{
		"Tin Ore Gravel",
		"Tin Ore Sand",
		"Tin Ore Dust"
		}; 
	public static final String[] TIN_ORE_UNLOCALIZED_NAMES = 
		{
		"tin_gravel",
		"tin_sand",
		"tin_dust"
		};

	//SILVER
	public static int SILVER_ORE_ID = 3311;
	public static final String SILVER_ORE_KEY = "silver_ore";
	public static final String[] SILVER_ORE_NAMES = 
		{
		"Silver Ore Gravel",
		"Silver Ore Sand",
		"Silver Ore Dust"
		}; 
	public static final String[] SILVER_ORE_UNLOCALIZED_NAMES = 
		{
		"silver_gravel",
		"silver_sand",
		"silver_dust"
		};

	//LEAD
	public static int LEAD_ORE_ID = 3312;
	public static final String LEAD_ORE_KEY = "lead_ore";
	public static final String[] LEAD_ORE_NAMES = 
		{
		"Lead Ore Gravel",
		"Lead Ore Sand",
		"Lead Ore Dust"
		}; 
	public static final String[] LEAD_ORE_UNLOCALIZED_NAMES = 
		{
		"lead_gravel",
		"lead_sand",
		"lead_dust"
		};

	//OSMIUM
	public static int OSMIUM_ORE_ID = 3313;
	public static final String OSMIUM_ORE_KEY = "osmium_ore";
	public static final String[] OSMIUM_ORE_NAMES = 
		{
		"Osmium Ore Gravel",
		"Osmium Ore Sand",
		"Osmium Ore Dust"
		}; 
	public static final String[] OSMIUM_ORE_UNLOCALIZED_NAMES = 
		{
		"osmium_gravel",
		"osmium_sand",
		"osmium_dust"
		};

	//PLATINUM
	public static int PLATINUM_ORE_ID = 3314;
	public static final String PLATINUM_ORE_KEY = "platinum_ore";
	public static final String[] PLATINUM_ORE_NAMES = 
		{
		"Platinum Ore Gravel",
		"Platinum Ore Sand",
		"Platinum Ore Dust"
		}; 
	public static final String[] PLATINUM_ORE_UNLOCALIZED_NAMES = 
		{
		"platinum_gravel",
		"platinum_sand",
		"platinum_dust"
		};

	//NICKLE
	public static int NICKEL_ORE_ID = 3315;
	public static final String NICKEL_ORE_KEY = "nickel_ore";
	public static final String[] NICKEL_ORE_NAMES = 
		{
		"Nickel Ore Gravel",
		"Nickel Ore Sand",
		"Nickel Ore Dust"
		}; 
	public static final String[] NICKEL_ORE_UNLOCALIZED_NAMES = 
		{
		"nickel_gravel",
		"nickel_sand",
		"nickel_dust"
		};

	//ALUMINUM
	public static int ALUMINUM_ORE_ID = 3316;
	public static final String ALUMINUM_ORE_KEY = "aluminum_ore";
	public static final String[] ALUMINUM_ORE_NAMES = 
		{
		"Aluminum Ore Gravel",
		"Aluminum Ore Sand",
		"Aluminum Ore Dust"
		}; 
	public static final String[] ALUMINUM_ORE_UNLOCALIZED_NAMES = 
		{
		"aluminum_gravel",
		"aluminum_sand",
		"aluminum_dust"
		};

	//Load it all!
	public static void load(Configuration config)
	{
		BARREL_ID = config.getBlock(CATEGORY, BARREL_KEY, BARREL_ID).getInt();
		BARREL_STONE_ID = config.getBlock(CATEGORY, BARREL_STONE_KEY, BARREL_STONE_ID).getInt();
		CRUCIBLE_ID = config.getBlock(CATEGORY, CRUCIBLE_KEY, CRUCIBLE_ID).getInt();
		CRUCIBLE_UNFIRED_ID = config.getBlock(CATEGORY, CRUCIBLE_UNFIRED_KEY, CRUCIBLE_UNFIRED_ID).getInt();
		DUST_ID = config.getBlock(CATEGORY, DUST_KEY, DUST_ID).getInt();
		LEAVES_INFESTED_ID = config.getBlock(CATEGORY, LEAVES_INFESTED_KEY, LEAVES_INFESTED_ID).getInt();
		SIEVE_ID = config.getBlock(CATEGORY, SIEVE_KEY, SIEVE_ID).getInt();
		BEE_TRAP_ID = config.getBlock(CATEGORY, BEE_TRAP_KEY, BEE_TRAP_ID).getInt();
		BEE_TRAP_TREATED_ID = config.getBlock(CATEGORY, BEE_TRAP_TREATED_KEY, BEE_TRAP_TREATED_ID).getInt();
		IRON_ORE_ID = config.getBlock(ORE_CATEGORY, IRON_ORE_KEY, IRON_ORE_ID).getInt();
		GOLD_ORE_ID = config.getBlock(ORE_CATEGORY, GOLD_ORE_KEY, GOLD_ORE_ID).getInt();
		TIN_ORE_ID = config.getBlock(ORE_CATEGORY, TIN_ORE_KEY, TIN_ORE_ID).getInt();
		COPPER_ORE_ID = config.getBlock(ORE_CATEGORY, COPPER_ORE_KEY, COPPER_ORE_ID).getInt();
		SILVER_ORE_ID = config.getBlock(ORE_CATEGORY, SILVER_ORE_KEY, SILVER_ORE_ID).getInt();
		LEAD_ORE_ID = config.getBlock(ORE_CATEGORY, LEAD_ORE_KEY, LEAD_ORE_ID).getInt();
		OSMIUM_ORE_ID = config.getBlock(ORE_CATEGORY, OSMIUM_ORE_KEY, OSMIUM_ORE_ID).getInt();
		PLATINUM_ORE_ID = config.getBlock(ORE_CATEGORY, PLATINUM_ORE_KEY, PLATINUM_ORE_ID).getInt();
		NICKEL_ORE_ID = config.getBlock(ORE_CATEGORY, NICKEL_ORE_KEY, NICKEL_ORE_ID).getInt();
		ALUMINUM_ORE_ID = config.getBlock(ORE_CATEGORY, ALUMINUM_ORE_KEY, ALUMINUM_ORE_ID).getInt();
	}


}
