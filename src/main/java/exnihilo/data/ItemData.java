package exnihilo.data;

@SuppressWarnings("unused")
public class ItemData {
	private static final String CATEGORY = "Items";
	private static final int ITEM_ID_BASE = 18000;
	private static int next_ID = 0;
	

	//HAMMER
	public static int HAMMER_IDS[] = new int[5];
	public static final String HAMMER_KEY = "hammer";
	public static final String[] HAMMER_NAMES = 
		{
		"Wooden Hammer",
		"Stone Hammer",
		"Iron Hammer",
		"Gold Hammer",
		"Diamond Hammer"
		}; 
	public static final String[] HAMMER_UNLOCALIZED_NAMES = 
		{
		"hammer_wood",
		"hammer_stone",
		"hammer_iron",
		"hammer_gold",
		"hammer_diamond"
		}; 

	//MESH
	public static int MESH_ID = GetNextID();
	public static final String MESH_KEY = "mesh";
	public static final String MESH_NAME = "Silk Mesh";
	public static final String MESH_UNLOCALIZED_NAME = "mesh";

	//SILKWORM
	public static int SILKWORM_ID = GetNextID();
	public static final String SILKWORM_KEY = "silkworm";
	public static final String SILKWORM_NAME = "Silkworm";
	public static final String SILKWORM_UNLOCALIZED_NAME = "silkworm";

	//CROOK
	public static int CROOK_ID = GetNextID();
	public static final String CROOK_KEY = "crook";
	public static final String CROOK_NAME = "Crook";
	public static final String CROOK_UNLOCALIZED_NAME = "crook";

	//SPORES
	public static int SPORES_ID = GetNextID();
	public static final String SPORES_KEY = "spores";
	public static final String SPORES_NAME = "Ancient Spores";
	public static final String SPORES_UNLOCALIZED_NAME = "spores";

	//GRASS SEEDS!
	public static int SEED_GRASS_ID = GetNextID();
	public static final String SEED_GRASS_KEY = "seed_grass";
	public static final String SEED_GRASS_NAME = "Grass Seeds";
	public static final String SEED_GRASS_UNLOCALIZED_NAME = "seed_grass";

	//STONES!
	public static int STONES_ID = GetNextID();
	public static final String STONES_KEY = "stone";
	public static final String STONES_NAME = "Stone";
	public static final String STONES_UNLOCALIZED_NAME = "stone";

	//PORCELAIN!
	public static int PORCELAIN_ID = GetNextID();
	public static final String PORCELAIN_KEY = "porcelain";
	public static final String PORCELAIN_NAME = "Porcelain Clay";
	public static final String PORCELAIN_UNLOCALIZED_NAME = "porcelain";

	//COOKED SILKWORMS!
	public static int SILKWORM_COOKED_ID = GetNextID();
	public static final String SILKWORM_COOKED_KEY = "silkworm_cooked";
	public static final String SILKWORM_COOKED_NAME = "Cooked Silkworm";
	public static final String SILKWORM_COOKED_UNLOCALIZED_NAME = "silkworm_cooked";
	
	//CROOK-BONE
	public static int CROOK_BONE_ID =GetNextID();
	public static final String CROOK_BONE_KEY = "crook_bone";
	public static final String CROOK_BONE_NAME = "Bone Crook";
	public static final String CROOK_BONE_UNLOCALIZED_NAME = "crook_bone";

	// ***
	//ORES
	// ***
	public static final String ORE_CATEGORY = "ore items";

	//IRON
	public static int IRON_ORE_IDS[] = new int[3];
	public static final String IRON_ORE_KEY = "item_iron_ore";
	public static final String IRON_ORE_NAMES[] = {"Broken Iron Ore", "Crushed Iron Ore", "Pulverized Iron Ore"};
	public static final String IRON_ORE_UNLOCALIZED_NAMES[] = {"iron_broken", "iron_crushed", "iron_pulverized"};

	//GOLD!
	public static int GOLD_ORE_IDS[] = new int[3];
	public static final String GOLD_ORE_KEY = "item_gold_gravel";
	public static final String GOLD_ORE_NAMES[] = {"Broken Gold Ore", "Crushed Gold Ore", "Pulverized Gold Ore"};
	public static final String GOLD_ORE_UNLOCALIZED_NAMES[] = {"gold_broken", "gold_crushed", "gold_pulverized"};

	//COPPER!
	public static int COPPER_ORE_IDS[] = new int[3];
	public static int COPPER_INGOT_ID = GetNextID();
	public static final String COPPER_ORE_KEY = "item_copper_gravel";
	public static final String COPPER_ORE_NAMES[] = {"Broken Copper Ore", "Crushed Copper Ore", "Pulverized Copper Ore", "Copper Ingot"};
	public static final String COPPER_ORE_UNLOCALIZED_NAMES[] = {"copper_broken", "copper_crushed", "copper_pulverized", "copper_ingot"};

	//TIN!
	public static int TIN_ORE_IDS[] = new int[3];
	public static int TIN_INGOT_ID = GetNextID();
	public static final String TIN_ORE_KEY = "item_tin_gravel";
	public static final String TIN_ORE_NAMES[] = {"Broken Tin Ore", "Crushed Tin Ore", "Pulverized Tin Ore", "Tin Ingot"};
	public static final String TIN_ORE_UNLOCALIZED_NAMES[] = {"tin_broken", "tin_crushed", "tin_pulverized", "tin_ingot"};

	//SILVER!
	public static int SILVER_ORE_IDS[] = new int[3];
	public static int SILVER_INGOT_ID = GetNextID();
	public static final String SILVER_ORE_KEY = "item_silver_gravel";
	public static final String SILVER_ORE_NAMES[] = {"Broken Silver Ore", "Crushed Silver Ore", "Pulverized Silver Ore", "Silver Ingot"};
	public static final String SILVER_ORE_UNLOCALIZED_NAMES[] = {"silver_broken", "silver_crushed", "silver_pulverized", "silver_ingot"};

	//LEAD!
	public static int LEAD_ORE_IDS[] = new int[3];
	public static int LEAD_INGOT_ID = GetNextID();
	public static final String LEAD_ORE_KEY = "item_lead_gravel";
	public static final String LEAD_ORE_NAMES[] = {"Broken Lead Ore", "Crushed Lead Ore", "Pulverized Lead Ore", "Lead Ingot"};
	public static final String LEAD_ORE_UNLOCALIZED_NAMES[] = {"lead_broken", "lead_crushed", "lead_pulverized", "lead_ingot"};

	//OSMIUM!
	public static int OSMIUM_ORE_IDS[] = new int[3];
	public static final String OSMIUM_ORE_KEY = "item_osmium_gravel";
	public static final String OSMIUM_ORE_NAMES[] = {"Broken Osmium Ore", "Crushed Osmium Ore", "Pulverized Osmium Ore"};
	public static final String OSMIUM_ORE_UNLOCALIZED_NAMES[] = {"osmium_broken", "osmium_crushed", "osmium_pulverized"};

	//PLATINUM!
	public static int PLATINUM_ORE_IDS[] = new int[3];
	public static int PLATINUM_INGOT_ID = GetNextID();
	public static final String PLATINUM_ORE_KEY = "item_platinum_gravel";
	public static final String PLATINUM_ORE_NAMES[] = {"Broken Platinum Ore", "Crushed Platinum Ore", "Pulverized Platinum Ore", "Platinum Ingot"};
	public static final String PLATINUM_ORE_UNLOCALIZED_NAMES[] = {"platinum_broken", "platinum_crushed", "platinum_pulverized", "platinum_ingot"};

	//NICKEL!
	public static int NICKEL_ORE_IDS[] = new int[3];
	public static int NICKEL_INGOT_ID = GetNextID();
	public static final String NICKEL_ORE_KEY = "item_nickel_gravel";
	public static final String NICKEL_ORE_NAMES[] = {"Broken Nickel Ore", "Crushed Nickel Ore", "Pulverized Nickel Ore", "Nickel Ingot"};
	public static final String NICKEL_ORE_UNLOCALIZED_NAMES[] = {"nickel_broken", "nickel_crushed", "nickel_pulverized", "nickel_ingot"};

	//ALUMINUM!
	public static int ALUMINUM_ORE_IDS[] = new int[3];
	public static int ALUMINUM_INGOT_ID = GetNextID();
	public static final String ALUMINUM_ORE_KEY = "item_aluminum_gravel";
	public static final String ALUMINUM_ORE_NAMES[] = {"Broken Aluminum Ore", "Crushed Aluminum Ore", "Pulverized Aluminum Ore", "Aluminum Ingot"};
	public static final String ALUMINUM_ORE_UNLOCALIZED_NAMES[] = {"aluminum_broken", "aluminum_crushed", "aluminum_pulverized", "aluminum_ingot"};
	// ***
	// SEED CATEGORY
	// ***
	public static final String SEED_CATEGORY = "seed items";

	//OAK SEEDS!
	public static int SEED_OAK_ID = GetNextID();
	public static final String SEED_OAK_KEY = "seed_oak";
	public static final String SEED_OAK_NAME = "Acorn";
	public static final String SEED_OAK_UNLOCALIZED_NAME = "seed_oak";

	//BIRCH SEEDS!
	public static int SEED_BIRCH_ID = GetNextID();
	public static final String SEED_BIRCH_KEY = "seed_birch";
	public static final String SEED_BIRCH_NAME = "Birch Seed";
	public static final String SEED_BIRCH_UNLOCALIZED_NAME = "seed_birch";

	//SPRUCE SEEDS!
	public static int SEED_SPRUCE_ID = GetNextID();
	public static final String SEED_SPRUCE_KEY = "seed_spruce";
	public static final String SEED_SPRUCE_NAME = "Spruce Seed";
	public static final String SEED_SPRUCE_UNLOCALIZED_NAME = "seed_spruce";

	//JUNGLE SEEDS!
	public static int SEED_JUNGLE_ID = GetNextID();
	public static final String SEED_JUNGLE_KEY = "seed_jungle";
	public static final String SEED_JUNGLE_NAME = "Exotic Seed";
	public static final String SEED_JUNGLE_UNLOCALIZED_NAME = "seed_jungle";

	//CACTUS SEEDS!
	public static int SEED_CACTUS_ID = GetNextID();
	public static final String SEED_CACTUS_KEY = "seed_cactus";
	public static final String SEED_CACTUS_NAME = "Cactus Seeds";
	public static final String SEED_CACTUS_UNLOCALIZED_NAME = "seed_cactus";

	//SUGAR CANE SEEDS!
	public static int SEED_SUGAR_CANE_ID = GetNextID();
	public static final String SEED_SUGAR_CANE_KEY = "seed_sugar_cane";
	public static final String SEED_SUGAR_CANE_NAME = "Sugar Cane Seeds";
	public static final String SEED_SUGAR_CANE_UNLOCALIZED_NAME = "seed_sugar_cane";

	//CARROT SEEDS!
	public static int SEED_CARROT_ID = GetNextID();
	public static final String SEED_CARROT_KEY = "seed_carrot";
	public static final String SEED_CARROT_NAME = "Carrot Seeds";
	public static final String SEED_CARROT_UNLOCALIZED_NAME = "seed_carrot";

	//POTATO SEEDS!
	public static int SEED_POTATO_ID = GetNextID();
	public static final String SEED_POTATO_KEY = "seed_potato";
	public static final String SEED_POTATO_NAME = "Potato Seeds";
	public static final String SEED_POTATO_UNLOCALIZED_NAME = "seed_potato";

	//RUBBER TREE SEEDS!
	public static int SEED_RUBBER_ID = GetNextID();
	public static final String SEED_RUBBER_KEY = "seed_rubber";
	public static final String SEED_RUBBER_NAME = "Rubber Tree Seeds";
	public static final String SEED_RUBBER_UNLOCALIZED_NAME = "seed_rubber";

	//PORCELAIN DOLL!
	public static int DOLL_ID = GetNextID();
	public static final String DOLL_KEY = "doll";
	public static final String DOLL_NAME = "Precious Doll";
	public static final String DOLL_UNLOCALIZED_NAME = "doll";

	//ANGRY DOLL!
	public static int ANGRY_DOLL_ID = GetNextID();
	public static final String ANGRY_DOLL_KEY = "doll_angry";
	public static final String ANGRY_DOLL_NAME = "Angry Doll";
	public static final String ANGRY_DOLL_UNLOCALIZED_NAME = "doll_angry";

	//CREEPY DOLL!
	public static int CREEPY_DOLL_ID = GetNextID();
	public static final String CREEPY_DOLL_KEY = "doll_creepy";
	public static final String CREEPY_DOLL_NAME = "Creepy Doll";
	public static final String CREEPY_DOLL_UNLOCALIZED_NAME = "doll_creepy";


	//LOAD ALL THE THINGS!
//	public static void load(Configuration config)
//	{
//		//HAMMERS!
//		for(int i = 0; i < 5; i++)
//		{
//			HAMMER_IDS[i] = config.getItem(CATEGORY, HAMMER_UNLOCALIZED_NAMES[i], GetNextID()).getInt() - 256;
//		}
//
//		//CROOK!
//		CROOK_ID = config.getItem(CATEGORY, CROOK_UNLOCALIZED_NAME, CROOK_ID).getInt() - 256;
//		CROOK_BONE_ID = config.getItem(CATEGORY, CROOK_BONE_UNLOCALIZED_NAME, CROOK_BONE_ID).getInt() - 256;
//		
//		//MESH!
//		MESH_ID = config.getItem(CATEGORY, MESH_UNLOCALIZED_NAME, MESH_ID).getInt() - 256;
//
//		//SPORES!
//		SPORES_ID = config.getItem(CATEGORY, SPORES_UNLOCALIZED_NAME, SPORES_ID).getInt() - 256;
//
//		//GRASS!
//		SEED_GRASS_ID = config.getItem(CATEGORY, SEED_GRASS_UNLOCALIZED_NAME, SEED_GRASS_ID).getInt() - 256;
//
//		//STONES!
//		STONES_ID = config.getItem(CATEGORY, STONES_UNLOCALIZED_NAME, STONES_ID).getInt() - 256;
//
//		//PORCELAIN!
//		PORCELAIN_ID = config.getItem(CATEGORY, PORCELAIN_UNLOCALIZED_NAME, PORCELAIN_ID).getInt() - 256;
//
//		//COOKED SILKWORMS!
//		SILKWORM_ID = config.getItem(CATEGORY, SILKWORM_UNLOCALIZED_NAME, SILKWORM_ID).getInt() - 256;
//		SILKWORM_COOKED_ID = config.getItem(CATEGORY, SILKWORM_COOKED_UNLOCALIZED_NAME, SILKWORM_COOKED_ID).getInt() - 256;
//
//		//SEEDS
//		SEED_OAK_ID = config.getItem(SEED_CATEGORY, SEED_OAK_UNLOCALIZED_NAME, SEED_OAK_ID).getInt() - 256;
//		SEED_SPRUCE_ID = config.getItem(SEED_CATEGORY, SEED_SPRUCE_UNLOCALIZED_NAME, SEED_SPRUCE_ID).getInt() - 256;
//		SEED_BIRCH_ID = config.getItem(SEED_CATEGORY, SEED_BIRCH_UNLOCALIZED_NAME, SEED_BIRCH_ID).getInt() - 256;
//		SEED_JUNGLE_ID = config.getItem(SEED_CATEGORY, SEED_JUNGLE_UNLOCALIZED_NAME, SEED_JUNGLE_ID).getInt() - 256;
//		SEED_CACTUS_ID = config.getItem(SEED_CATEGORY, SEED_CACTUS_UNLOCALIZED_NAME, SEED_CACTUS_ID).getInt() - 256;
//		SEED_SUGAR_CANE_ID = config.getItem(SEED_CATEGORY, SEED_SUGAR_CANE_UNLOCALIZED_NAME, SEED_SUGAR_CANE_ID).getInt() - 256;
//		SEED_CARROT_ID = config.getItem(SEED_CATEGORY, SEED_CARROT_UNLOCALIZED_NAME, SEED_CARROT_ID).getInt() - 256;
//		SEED_POTATO_ID = config.getItem(SEED_CATEGORY, SEED_POTATO_UNLOCALIZED_NAME, SEED_POTATO_ID).getInt() - 256;
//
//		SEED_RUBBER_ID = config.getItem(SEED_CATEGORY, SEED_RUBBER_UNLOCALIZED_NAME, SEED_RUBBER_ID).getInt() - 256;
//
//		//IRON ORE!
//		for(int i = 0; i < 3; i++)
//		{
//			IRON_ORE_IDS[i] = config.getItem(ORE_CATEGORY, IRON_ORE_UNLOCALIZED_NAMES[i], GetNextID()).getInt() - 256;
//		}
//
//		//GOLD ORE!
//		for(int i = 0; i < 3; i++)
//		{
//			GOLD_ORE_IDS[i] = config.getItem(ORE_CATEGORY, GOLD_ORE_UNLOCALIZED_NAMES[i], GetNextID()).getInt() - 256;
//		}
//
//		//COPPER ORE!
//		for(int i = 0; i < 3; i++)
//		{
//			COPPER_ORE_IDS[i] = config.getItem(ORE_CATEGORY, COPPER_ORE_UNLOCALIZED_NAMES[i], GetNextID()).getInt() - 256;
//		}
//		COPPER_INGOT_ID = config.getItem(ORE_CATEGORY, COPPER_ORE_UNLOCALIZED_NAMES[3], COPPER_INGOT_ID).getInt() - 256;
//
//		//TIN ORE!
//		for(int i = 0; i < 3; i++)
//		{
//			TIN_ORE_IDS[i] = config.getItem(ORE_CATEGORY, TIN_ORE_UNLOCALIZED_NAMES[i], GetNextID()).getInt() - 256;
//		}
//		TIN_INGOT_ID = config.getItem(ORE_CATEGORY, TIN_ORE_UNLOCALIZED_NAMES[3], TIN_INGOT_ID).getInt() - 256;
//
//		//LEAD ORE!
//		for(int i = 0; i < 3; i++)
//		{
//			LEAD_ORE_IDS[i] = config.getItem(ORE_CATEGORY, LEAD_ORE_UNLOCALIZED_NAMES[i], GetNextID()).getInt() - 256;
//		}
//		LEAD_INGOT_ID = config.getItem(ORE_CATEGORY, LEAD_ORE_UNLOCALIZED_NAMES[3], LEAD_INGOT_ID).getInt() - 256;
//
//		//SILVER ORE!
//		for(int i = 0; i < 3; i++)
//		{
//			SILVER_ORE_IDS[i] = config.getItem(ORE_CATEGORY, SILVER_ORE_UNLOCALIZED_NAMES[i], GetNextID()).getInt() - 256;
//		}
//		SILVER_INGOT_ID = config.getItem(ORE_CATEGORY, SILVER_ORE_UNLOCALIZED_NAMES[3], SILVER_INGOT_ID).getInt() - 256;
//
//		//OSMIUM ORE!
//		for(int i = 0; i < 3; i++)
//		{
//			OSMIUM_ORE_IDS[i] = config.getItem(ORE_CATEGORY, OSMIUM_ORE_UNLOCALIZED_NAMES[i], GetNextID()).getInt() - 256;
//		}
//
//		//PLATINUM ORE!
//		for(int i = 0; i < 3; i++)
//		{
//			PLATINUM_ORE_IDS[i] = config.getItem(ORE_CATEGORY, PLATINUM_ORE_UNLOCALIZED_NAMES[i], GetNextID()).getInt() - 256;
//		}
//		PLATINUM_INGOT_ID = config.getItem(ORE_CATEGORY, PLATINUM_ORE_UNLOCALIZED_NAMES[3], PLATINUM_INGOT_ID).getInt() - 256;
//
//		//NICKLE ORE!
//		for(int i = 0; i < 3; i++)
//		{
//			NICKEL_ORE_IDS[i] = config.getItem(ORE_CATEGORY, NICKEL_ORE_UNLOCALIZED_NAMES[i], GetNextID()).getInt() - 256;
//		}
//		NICKEL_INGOT_ID = config.getItem(ORE_CATEGORY, NICKEL_ORE_UNLOCALIZED_NAMES[3], NICKEL_INGOT_ID).getInt() - 256;
//
//		//ALUMINUM ORE!
//		for(int i = 0; i < 3; i++)
//		{
//			ALUMINUM_ORE_IDS[i] = config.getItem(ORE_CATEGORY, ALUMINUM_ORE_UNLOCALIZED_NAMES[i], GetNextID()).getInt() - 256;
//		}
//		ALUMINUM_INGOT_ID = config.getItem(ORE_CATEGORY, ALUMINUM_ORE_UNLOCALIZED_NAMES[3], ALUMINUM_INGOT_ID).getInt() - 256;
//
//		DOLL_ID = config.getItem(CATEGORY, DOLL_UNLOCALIZED_NAME, DOLL_ID).getInt() - 256;
//		CREEPY_DOLL_ID = config.getItem(CATEGORY, CREEPY_DOLL_UNLOCALIZED_NAME, CREEPY_DOLL_ID).getInt() - 256;
//		ANGRY_DOLL_ID = config.getItem(CATEGORY, ANGRY_DOLL_UNLOCALIZED_NAME, ANGRY_DOLL_ID).getInt() - 256;
//	}
	
	public static int GetNextID()
	{
		int current = next_ID;
		next_ID++;
		
		return  ITEM_ID_BASE + current;
	}
}

