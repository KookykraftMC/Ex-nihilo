package exnihilo;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.data.ItemData;
import exnihilo.items.ItemCrook;
import exnihilo.items.ItemCrookBone;
import exnihilo.items.ItemGrassSeeds;
import exnihilo.items.ItemMesh;
import exnihilo.items.ItemPorcelainBall;
import exnihilo.items.ItemSilkworm;
import exnihilo.items.ItemSilkwormCooked;
import exnihilo.items.ItemSpores;
import exnihilo.items.ItemStone;
import exnihilo.items.dolls.ItemDoll;
import exnihilo.items.dolls.ItemDollAngry;
import exnihilo.items.dolls.ItemDollCreepy;
import exnihilo.items.hammers.ItemHammerDiamond;
import exnihilo.items.hammers.ItemHammerGold;
import exnihilo.items.hammers.ItemHammerIron;
import exnihilo.items.hammers.ItemHammerStone;
import exnihilo.items.hammers.ItemHammerWood;
import exnihilo.items.ores.ItemAluminumDust;
import exnihilo.items.ores.ItemAluminumGravel;
import exnihilo.items.ores.ItemAluminumIngot;
import exnihilo.items.ores.ItemAluminumSand;
import exnihilo.items.ores.ItemCopperDust;
import exnihilo.items.ores.ItemCopperGravel;
import exnihilo.items.ores.ItemCopperIngot;
import exnihilo.items.ores.ItemCopperSand;
import exnihilo.items.ores.ItemGoldDust;
import exnihilo.items.ores.ItemGoldGravel;
import exnihilo.items.ores.ItemGoldSand;
import exnihilo.items.ores.ItemIronDust;
import exnihilo.items.ores.ItemIronGravel;
import exnihilo.items.ores.ItemIronSand;
import exnihilo.items.ores.ItemLeadDust;
import exnihilo.items.ores.ItemLeadGravel;
import exnihilo.items.ores.ItemLeadIngot;
import exnihilo.items.ores.ItemLeadSand;
import exnihilo.items.ores.ItemNickelDust;
import exnihilo.items.ores.ItemNickelGravel;
import exnihilo.items.ores.ItemNickelIngot;
import exnihilo.items.ores.ItemNickelSand;
import exnihilo.items.ores.ItemOre;
import exnihilo.items.ores.ItemOreFactory;
import exnihilo.items.ores.ItemOsmiumDust;
import exnihilo.items.ores.ItemOsmiumGravel;
import exnihilo.items.ores.ItemOsmiumSand;
import exnihilo.items.ores.ItemPlatinumDust;
import exnihilo.items.ores.ItemPlatinumGravel;
import exnihilo.items.ores.ItemPlatinumIngot;
import exnihilo.items.ores.ItemPlatinumSand;
import exnihilo.items.ores.ItemSilverDust;
import exnihilo.items.ores.ItemSilverGravel;
import exnihilo.items.ores.ItemSilverIngot;
import exnihilo.items.ores.ItemSilverSand;
import exnihilo.items.ores.ItemTinDust;
import exnihilo.items.ores.ItemTinGravel;
import exnihilo.items.ores.ItemTinIngot;
import exnihilo.items.ores.ItemTinSand;
import exnihilo.items.seeds.ItemSeedAcacia;
import exnihilo.items.seeds.ItemSeedBirch;
import exnihilo.items.seeds.ItemSeedCactus;
import exnihilo.items.seeds.ItemSeedCarrot;
import exnihilo.items.seeds.ItemSeedJungle;
import exnihilo.items.seeds.ItemSeedOak;
import exnihilo.items.seeds.ItemSeedPotato;
import exnihilo.items.seeds.ItemSeedRubber;
import exnihilo.items.seeds.ItemSeedSpruce;
import exnihilo.items.seeds.ItemSeedSugarcane;
import exnihilo.registries.helpers.Color;

public class ENItems {
	public static Item HammerWood;
	public static Item HammerStone;
	public static Item HammerIron;
	public static Item HammerGold;
	public static Item HammerDiamond;
	public static Item Crook;
	public static Item CrookBone;
	public static Item Silkworm;
	public static Item SilkwormCooked;
	public static Item Mesh;
	public static Item Stones;
	public static Item Porcelain;

	public static Item Doll;
	public static Item DollAngry;
	public static Item DollCreepy;

	//Seeds
	public static Item Spores;
	public static Item GrassSeeds;
	public static Item SeedsOak;
	public static Item SeedsAcacia;
	public static Item SeedsSpruce;
	public static Item SeedsBirch;
	public static Item SeedsJungle;
	public static Item SeedsCactus;
	public static Item SeedsSugarcane;
	public static Item SeedsCarrot;
	public static Item SeedsPotato;

	public static Item SeedsRubber;

	//Iron Ore
	public static Item IronGravel;
	public static Item IronSand;
	public static Item IronDust;

	//Gold Ore
	public static Item GoldGravel;
	public static Item GoldSand;
	public static Item GoldDust;

	//Copper Ore
	public static Item CopperGravel;
	public static Item CopperSand;
	public static Item CopperDust;
	public static Item CopperIngot;

	//Tin Ore
	public static Item TinGravel;
	public static Item TinSand;
	public static Item TinDust;
	public static Item TinIngot;

	//Silver Ore
	public static Item SilverGravel;
	public static Item SilverSand;
	public static Item SilverDust;
	public static Item SilverIngot;

	//Lead Ore
	public static Item LeadGravel;
	public static Item LeadSand;
	public static Item LeadDust;
	public static Item LeadIngot;

	//Osmium Ore
	public static Item OsmiumGravel;
	public static Item OsmiumSand;
	public static Item OsmiumDust;

	//Nickle Ore
	public static Item NickelGravel;
	public static Item NickelSand;
	public static Item NickelDust;
	public static Item NickelIngot;

	//Platinum Ore
	public static Item PlatinumGravel;
	public static Item PlatinumSand;
	public static Item PlatinumDust;
	public static Item PlatinumIngot;

	//Aluminum Ore
	public static Item AluminumGravel;
	public static Item AluminumSand;
	public static Item AluminumDust;
	public static Item AluminumIngot;


	public static void registerItems()
	{
	  //Testing Ore Generation;
    CreateOreItems("Testium", new Color("3423CC"));
    CreateOreItems("Reversium", new Color("FFB940"));
    CreateOreItems("Teslasium", new Color("40FF66"));
    CreateOreItems("Redrium", new Color("FF5050"));
    CreateOreItems("Pinkium", new Color("FF9999"));
	  
		HammerWood = new ItemHammerWood();
		GameRegistry.registerItem(HammerWood, ItemData.HAMMER_UNLOCALIZED_NAMES[0]);

		HammerStone = new ItemHammerStone();
		GameRegistry.registerItem(HammerStone, ItemData.HAMMER_UNLOCALIZED_NAMES[1]);

		HammerIron = new ItemHammerIron();
		GameRegistry.registerItem(HammerIron, ItemData.HAMMER_UNLOCALIZED_NAMES[2]);

		HammerGold = new ItemHammerGold();
		GameRegistry.registerItem(HammerGold, ItemData.HAMMER_UNLOCALIZED_NAMES[3]);

		HammerDiamond = new ItemHammerDiamond();
		GameRegistry.registerItem(HammerDiamond, ItemData.HAMMER_UNLOCALIZED_NAMES[4]);

		Crook = new ItemCrook();
		GameRegistry.registerItem(Crook, ItemData.CROOK_UNLOCALIZED_NAME);
		CrookBone = new ItemCrookBone();
		GameRegistry.registerItem(CrookBone, ItemData.CROOK_BONE_UNLOCALIZED_NAME);
		
		Silkworm = new ItemSilkworm();
		GameRegistry.registerItem(Silkworm, ItemData.SILKWORM_UNLOCALIZED_NAME);

		Mesh = new ItemMesh();
		GameRegistry.registerItem(Mesh, ItemData.MESH_UNLOCALIZED_NAME);

		Spores = new ItemSpores();
		GameRegistry.registerItem(Spores, ItemData.SPORES_UNLOCALIZED_NAME);

		GrassSeeds = new ItemGrassSeeds();
		GameRegistry.registerItem(GrassSeeds, ItemData.SEED_GRASS_UNLOCALIZED_NAME);

		Stones = new ItemStone();
		GameRegistry.registerItem(Stones, ItemData.STONES_UNLOCALIZED_NAME);

		Porcelain = new ItemPorcelainBall();
		GameRegistry.registerItem(Porcelain, ItemData.PORCELAIN_UNLOCALIZED_NAME);

		Doll = new ItemDoll();
		GameRegistry.registerItem(Doll, ItemData.DOLL_UNLOCALIZED_NAME);
		DollAngry = new ItemDollAngry();
		GameRegistry.registerItem(DollAngry, ItemData.ANGRY_DOLL_UNLOCALIZED_NAME);
		DollCreepy = new ItemDollCreepy();
		GameRegistry.registerItem(DollCreepy, ItemData.CREEPY_DOLL_UNLOCALIZED_NAME);

		SilkwormCooked = new ItemSilkwormCooked();
		GameRegistry.registerItem(SilkwormCooked, ItemData.SILKWORM_COOKED_UNLOCALIZED_NAME);

		SeedsOak = new ItemSeedOak();
		GameRegistry.registerItem(SeedsOak, ItemData.SEED_OAK_UNLOCALIZED_NAME);
		SeedsAcacia = new ItemSeedAcacia();
		GameRegistry.registerItem(SeedsAcacia, ItemData.SEED_ACACIA_UNLOCALIZED_NAME);
		SeedsSpruce = new ItemSeedSpruce();
		GameRegistry.registerItem(SeedsSpruce, ItemData.SEED_SPRUCE_UNLOCALIZED_NAME);
		SeedsBirch = new ItemSeedBirch();
		GameRegistry.registerItem(SeedsBirch, ItemData.SEED_BIRCH_UNLOCALIZED_NAME);
		SeedsJungle = new ItemSeedJungle();
		GameRegistry.registerItem(SeedsJungle, ItemData.SEED_JUNGLE_UNLOCALIZED_NAME);
		SeedsCactus = new ItemSeedCactus();
		GameRegistry.registerItem(SeedsCactus, ItemData.SEED_CACTUS_UNLOCALIZED_NAME);
		SeedsSugarcane = new ItemSeedSugarcane();
		GameRegistry.registerItem(SeedsSugarcane, ItemData.SEED_SUGAR_CANE_UNLOCALIZED_NAME);
		SeedsCarrot = new ItemSeedCarrot();
		GameRegistry.registerItem(SeedsCarrot, ItemData.SEED_CARROT_UNLOCALIZED_NAME);
		SeedsPotato = new ItemSeedPotato();
		GameRegistry.registerItem(SeedsPotato, ItemData.SEED_POTATO_UNLOCALIZED_NAME);

		SeedsRubber = new ItemSeedRubber();
		GameRegistry.registerItem(SeedsRubber, ItemData.SEED_RUBBER_UNLOCALIZED_NAME);

		//Iron Ore
		IronGravel = new ItemIronGravel();
		GameRegistry.registerItem(IronGravel, ItemData.IRON_ORE_UNLOCALIZED_NAMES[0]);
		IronSand = new ItemIronSand();
		GameRegistry.registerItem(IronSand, ItemData.IRON_ORE_UNLOCALIZED_NAMES[1]);
		IronDust = new ItemIronDust();
		GameRegistry.registerItem(IronDust, ItemData.IRON_ORE_UNLOCALIZED_NAMES[2]);

		//Gold Ore
		GoldGravel = new ItemGoldGravel();
		GameRegistry.registerItem(GoldGravel, ItemData.GOLD_ORE_UNLOCALIZED_NAMES[0]);
		GoldSand = new ItemGoldSand();
		GameRegistry.registerItem(GoldSand, ItemData.GOLD_ORE_UNLOCALIZED_NAMES[1]);
		GoldDust = new ItemGoldDust();
		GameRegistry.registerItem(GoldDust, ItemData.GOLD_ORE_UNLOCALIZED_NAMES[2]);

		//Copper Ore
		CopperGravel = new ItemCopperGravel();
		GameRegistry.registerItem(CopperGravel, ItemData.COPPER_ORE_UNLOCALIZED_NAMES[0]);
		CopperSand = new ItemCopperSand();
		GameRegistry.registerItem(CopperSand, ItemData.COPPER_ORE_UNLOCALIZED_NAMES[1]);
		CopperDust = new ItemCopperDust();
		GameRegistry.registerItem(CopperDust, ItemData.COPPER_ORE_UNLOCALIZED_NAMES[2]);
		CopperIngot = new ItemCopperIngot();
		GameRegistry.registerItem(CopperIngot, ItemData.COPPER_ORE_UNLOCALIZED_NAMES[3]);

		//Tin Ore
		TinGravel = new ItemTinGravel();
		GameRegistry.registerItem(TinGravel, ItemData.TIN_ORE_UNLOCALIZED_NAMES[0]);
		TinSand = new ItemTinSand();
		GameRegistry.registerItem(TinSand, ItemData.TIN_ORE_UNLOCALIZED_NAMES[1]);
		TinDust = new ItemTinDust();
		GameRegistry.registerItem(TinDust, ItemData.TIN_ORE_UNLOCALIZED_NAMES[2]);
		TinIngot = new ItemTinIngot();
		GameRegistry.registerItem(TinIngot, ItemData.TIN_ORE_UNLOCALIZED_NAMES[3]);

		//Silver Ore
		SilverGravel = new ItemSilverGravel();
		GameRegistry.registerItem(SilverGravel, ItemData.SILVER_ORE_UNLOCALIZED_NAMES[0]);
		SilverSand = new ItemSilverSand();
		GameRegistry.registerItem(SilverSand, ItemData.SILVER_ORE_UNLOCALIZED_NAMES[1]);
		SilverDust = new ItemSilverDust();
		GameRegistry.registerItem(SilverDust, ItemData.SILVER_ORE_UNLOCALIZED_NAMES[2]);
		SilverIngot = new ItemSilverIngot();
		GameRegistry.registerItem(SilverIngot, ItemData.SILVER_ORE_UNLOCALIZED_NAMES[3]);

		//Lead Ore
		LeadGravel = new ItemLeadGravel();
		GameRegistry.registerItem(LeadGravel, ItemData.LEAD_ORE_UNLOCALIZED_NAMES[0]);
		LeadSand = new ItemLeadSand();
		GameRegistry.registerItem(LeadSand, ItemData.LEAD_ORE_UNLOCALIZED_NAMES[1]);
		LeadDust = new ItemLeadDust();
		GameRegistry.registerItem(LeadDust, ItemData.LEAD_ORE_UNLOCALIZED_NAMES[2]);
		LeadIngot = new ItemLeadIngot();
		GameRegistry.registerItem(LeadIngot, ItemData.LEAD_ORE_UNLOCALIZED_NAMES[3]);

		//Osmium Ore
		OsmiumGravel = new ItemOsmiumGravel();
		GameRegistry.registerItem(OsmiumGravel, ItemData.OSMIUM_ORE_UNLOCALIZED_NAMES[0]);
		OsmiumSand = new ItemOsmiumSand();
		GameRegistry.registerItem(OsmiumSand, ItemData.OSMIUM_ORE_UNLOCALIZED_NAMES[1]);
		OsmiumDust = new ItemOsmiumDust();
		GameRegistry.registerItem(OsmiumDust, ItemData.OSMIUM_ORE_UNLOCALIZED_NAMES[2]);

		//Nickle Ore
		NickelGravel = new ItemNickelGravel();
		GameRegistry.registerItem(NickelGravel, ItemData.NICKEL_ORE_UNLOCALIZED_NAMES[0]);
		NickelSand = new ItemNickelSand();
		GameRegistry.registerItem(NickelSand, ItemData.NICKEL_ORE_UNLOCALIZED_NAMES[1]);
		NickelDust = new ItemNickelDust();
		GameRegistry.registerItem(NickelDust, ItemData.NICKEL_ORE_UNLOCALIZED_NAMES[2]);
		NickelIngot = new ItemNickelIngot();
		GameRegistry.registerItem(NickelIngot, ItemData.NICKEL_ORE_UNLOCALIZED_NAMES[3]);

		//Platinum Ore
		PlatinumGravel = new ItemPlatinumGravel();
		GameRegistry.registerItem(PlatinumGravel, ItemData.PLATINUM_ORE_UNLOCALIZED_NAMES[0]);
		PlatinumSand = new ItemPlatinumSand();
		GameRegistry.registerItem(PlatinumSand, ItemData.PLATINUM_ORE_UNLOCALIZED_NAMES[1]);
		PlatinumDust = new ItemPlatinumDust();
		GameRegistry.registerItem(PlatinumDust, ItemData.PLATINUM_ORE_UNLOCALIZED_NAMES[2]);
		PlatinumIngot = new ItemPlatinumIngot();
		GameRegistry.registerItem(PlatinumIngot, ItemData.PLATINUM_ORE_UNLOCALIZED_NAMES[3]);

		//Aluminum Ore
		AluminumGravel = new ItemAluminumGravel();
		GameRegistry.registerItem(AluminumGravel, ItemData.ALUMINUM_ORE_UNLOCALIZED_NAMES[0]);
		AluminumSand = new ItemAluminumSand();
		GameRegistry.registerItem(AluminumSand, ItemData.ALUMINUM_ORE_UNLOCALIZED_NAMES[1]);
		AluminumDust = new ItemAluminumDust();
		GameRegistry.registerItem(AluminumDust, ItemData.ALUMINUM_ORE_UNLOCALIZED_NAMES[2]);
		AluminumIngot = new ItemAluminumIngot();
		GameRegistry.registerItem(AluminumIngot, ItemData.ALUMINUM_ORE_UNLOCALIZED_NAMES[3]);
	}
	
	public static void CreateOreItems(String name, Color color)
  {
  //TODO Create a key,value pair registry that maps ore names to items;
    ItemOre[] TestOre = ItemOreFactory.MakeOverworldOreItems(name, color);
    
    for (ItemOre b : TestOre)
    {
      //TODO Don't create the same ore item twice!
      GameRegistry.registerItem(b, b.getUnlocalizedName());
    }
  }
}