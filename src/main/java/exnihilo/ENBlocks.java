package exnihilo;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.blocks.BlockBarrel;
import exnihilo.blocks.BlockBarrelStone;
import exnihilo.blocks.BlockBeeTrap;
import exnihilo.blocks.BlockBeeTrapTreated;
import exnihilo.blocks.BlockCrucible;
import exnihilo.blocks.BlockCrucibleUnfired;
import exnihilo.blocks.BlockDust;
import exnihilo.blocks.BlockLeavesInfested;
import exnihilo.blocks.BlockSieve;
import exnihilo.blocks.itemBlocks.ItemBlockBarrel;
import exnihilo.blocks.itemBlocks.ItemBlockBarrelStone;
import exnihilo.blocks.itemBlocks.ItemBlockCrucible;
import exnihilo.blocks.itemBlocks.ItemBlockCrucibleUnfired;
import exnihilo.blocks.itemBlocks.ItemBlockLeavesInfested;
import exnihilo.blocks.itemBlocks.ItemBlockSieve;
import exnihilo.blocks.ores.BlockAluminumOre;
import exnihilo.blocks.ores.BlockCopperOre;
import exnihilo.blocks.ores.BlockGoldOre;
import exnihilo.blocks.ores.BlockIronOre;
import exnihilo.blocks.ores.BlockLeadOre;
import exnihilo.blocks.ores.BlockNickelOre;
import exnihilo.blocks.ores.BlockOsmiumOre;
import exnihilo.blocks.ores.BlockPlatinumOre;
import exnihilo.blocks.ores.BlockSilverOre;
import exnihilo.blocks.ores.BlockTinOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockAluminumOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockCopperOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockGoldOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockIronOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockLeadOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockNickelOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockOsmiumOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockPlatinumOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockSilverOre;
import exnihilo.blocks.ores.itemBlocks.ItemBlockTinOre;
import exnihilo.data.BlockData;

public class ENBlocks {
	public static Block Barrel;
	public static Block BarrelStone;
	public static Block Crucible;
	public static Block CrucibleUnfired;
	public static Block Dust;
	public static Block LeavesInfested;
	public static Block Sieve;
	public static Block BeeTrap;
	public static Block BeeTrapTreated;

	public static Block IronOre;
	public static Block GoldOre;
	public static Block CopperOre;
	public static Block TinOre;
	public static Block SilverOre;
	public static Block LeadOre;
	public static Block OsmiumOre;
	public static Block NickelOre;
	public static Block PlatinumOre;
	public static Block AluminumOre;

	public static void registerBlocks()
	{
		Barrel = new BlockBarrel();
		GameRegistry.registerBlock(Barrel, ItemBlockBarrel.class, BlockData.BARREL_KEY);

		BarrelStone = new BlockBarrelStone();
		GameRegistry.registerBlock(BarrelStone, ItemBlockBarrelStone.class, BlockData.BARREL_STONE_KEY);

		Crucible = new BlockCrucible();
		GameRegistry.registerBlock(Crucible, ItemBlockCrucible.class, BlockData.CRUCIBLE_KEY);

		CrucibleUnfired = new BlockCrucibleUnfired();
		GameRegistry.registerBlock(CrucibleUnfired, ItemBlockCrucibleUnfired.class, BlockData.CRUCIBLE_UNFIRED_KEY);

		Dust = new BlockDust();
		GameRegistry.registerBlock(Dust, BlockData.DUST_KEY);

		LeavesInfested = new BlockLeavesInfested();
		GameRegistry.registerBlock(LeavesInfested, ItemBlockLeavesInfested.class, BlockData.LEAVES_INFESTED_KEY);

		Sieve = new BlockSieve();
		GameRegistry.registerBlock(Sieve, ItemBlockSieve.class, BlockData.SIEVE_KEY);

		BeeTrap = new BlockBeeTrap();
		GameRegistry.registerBlock(BeeTrap, BlockData.BEE_TRAP_KEY);
		BeeTrapTreated = new BlockBeeTrapTreated();
		GameRegistry.registerBlock(BeeTrapTreated, BlockData.BEE_TRAP_TREATED_KEY);

		IronOre = new BlockIronOre();
		GameRegistry.registerBlock(IronOre, ItemBlockIronOre.class, BlockData.IRON_ORE_KEY);

		GoldOre = new BlockGoldOre();
		GameRegistry.registerBlock(GoldOre, ItemBlockGoldOre.class, BlockData.GOLD_ORE_KEY);

		CopperOre = new BlockCopperOre();
		GameRegistry.registerBlock(CopperOre, ItemBlockCopperOre.class, BlockData.COPPER_ORE_KEY);

		TinOre = new BlockTinOre(BlockData.TIN_ORE_ID);
		GameRegistry.registerBlock(TinOre, ItemBlockTinOre.class, BlockData.TIN_ORE_KEY);

		SilverOre = new BlockSilverOre(BlockData.SILVER_ORE_ID);
		GameRegistry.registerBlock(SilverOre, ItemBlockSilverOre.class, BlockData.SILVER_ORE_KEY);

		LeadOre = new BlockLeadOre();
		GameRegistry.registerBlock(LeadOre, ItemBlockLeadOre.class, BlockData.LEAD_ORE_KEY);

		OsmiumOre = new BlockOsmiumOre();
		GameRegistry.registerBlock(OsmiumOre, ItemBlockOsmiumOre.class, BlockData.OSMIUM_ORE_KEY);

		NickelOre = new BlockNickelOre();
		GameRegistry.registerBlock(NickelOre, ItemBlockNickelOre.class, BlockData.NICKEL_ORE_KEY);

		PlatinumOre = new BlockPlatinumOre();
		GameRegistry.registerBlock(PlatinumOre, ItemBlockPlatinumOre.class, BlockData.PLATINUM_ORE_KEY);

		AluminumOre = new BlockAluminumOre();
		GameRegistry.registerBlock(AluminumOre, ItemBlockAluminumOre.class, BlockData.ALUMINUM_ORE_KEY);
	}

//	public static void registerNames()
//	{
//		//Barrels!
//		if (ModData.ALLOW_BARRELS)
//		{
//			for(int i = 0; i < 4; i++)
//			{
//				ItemStack item = new ItemStack(Barrel, 1, i);
//				LanguageRegistry.addName(item, BlockData.BARREL_NAMES[i]);
//			}
//
//			//Stone Barrel!
//			ItemStack barrelStoneInstance = new ItemStack(BarrelStone, 1, 0);
//			LanguageRegistry.addName(barrelStoneInstance, BlockData.BARREL_STONE_NAME);	
//		}
//
//		//Crucible!
//		ItemStack crucibleInstance = new ItemStack(Crucible, 1, 0);
//		LanguageRegistry.addName(crucibleInstance, BlockData.CRUCIBLE_NAME);
//
//		//Crucible Unfired!
//		ItemStack crucibleRawInstance = new ItemStack(CrucibleUnfired, 1, 0);
//		LanguageRegistry.addName(crucibleRawInstance, BlockData.CRUCIBLE_UNFIRED_NAME);
//
//		//Dust!
//		LanguageRegistry.addName(Dust, BlockData.DUST_NAME);
//
//		//Bee Trap
//		LanguageRegistry.addName(BeeTrap, BlockData.BEE_TRAP_NAME);
//		//Bee Trap Treated
//		LanguageRegistry.addName(BeeTrapTreated, BlockData.BEE_TRAP_TREATED_NAME);
//
//		//Leaves!
//		for(int i = 0; i < 4; i++)
//		{
//			ItemStack item = new ItemStack(LeavesInfested, 1, i);
//			LanguageRegistry.addName(item, BlockData.LEAVES_INFESTED_NAMES[i]);
//		}
//
//		//Sift Table!
//		for(int i = 0; i < 4; i++)
//		{
//			ItemStack item = new ItemStack(Sieve, 1, i);
//			LanguageRegistry.addName(item, BlockData.SIEVE_NAMES[i]);
//		}
//
//
//		//Ore Blocks!
//		//Iron
//		for(int i = 0; i < 3; i++)
//		{
//			ItemStack item = new ItemStack(IronOre, 1, i);
//			LanguageRegistry.addName(item, BlockData.IRON_ORE_NAMES[i]);
//		}
//		//Gold
//		for(int i = 0; i < 3; i++)
//		{
//			ItemStack item = new ItemStack(GoldOre, 1, i);
//			LanguageRegistry.addName(item, BlockData.GOLD_ORE_NAMES[i]);
//		}
//		//Copper
//		for(int i = 0; i < 3; i++)
//		{
//			ItemStack item = new ItemStack(CopperOre, 1, i);
//			LanguageRegistry.addName(item, BlockData.COPPER_ORE_NAMES[i]);
//		}
//		//Tin
//		for(int i = 0; i < 3; i++)
//		{
//			ItemStack item = new ItemStack(TinOre, 1, i);
//			LanguageRegistry.addName(item, BlockData.TIN_ORE_NAMES[i]);
//		}
//		//Silver
//		for(int i = 0; i < 3; i++)
//		{
//			ItemStack item = new ItemStack(SilverOre, 1, i);
//			LanguageRegistry.addName(item, BlockData.SILVER_ORE_NAMES[i]);
//		}
//		//Lead
//		for(int i = 0; i < 3; i++)
//		{
//			ItemStack item = new ItemStack(LeadOre, 1, i);
//			LanguageRegistry.addName(item, BlockData.LEAD_ORE_NAMES[i]);
//		}
//
//		//Lead
//		for(int i = 0; i < 3; i++)
//		{
//			ItemStack item = new ItemStack(OsmiumOre, 1, i);
//			LanguageRegistry.addName(item, BlockData.OSMIUM_ORE_NAMES[i]);
//		}
//
//		//Nickle
//		for(int i = 0; i < 3; i++)
//		{
//			ItemStack item = new ItemStack(NickelOre, 1, i);
//			LanguageRegistry.addName(item, BlockData.NICKEL_ORE_NAMES[i]);
//		}
//
//		//Platinum
//		for(int i = 0; i < 3; i++)
//		{
//			ItemStack item = new ItemStack(PlatinumOre, 1, i);
//			LanguageRegistry.addName(item, BlockData.PLATINUM_ORE_NAMES[i]);
//		}
//
//		//Aluminum
//		for(int i = 0; i < 3; i++)
//		{
//			ItemStack item = new ItemStack(AluminumOre, 1, i);
//			LanguageRegistry.addName(item, BlockData.ALUMINUM_ORE_NAMES[i]);
//		}
//	}


}
