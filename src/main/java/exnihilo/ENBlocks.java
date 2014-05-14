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
	}
}
