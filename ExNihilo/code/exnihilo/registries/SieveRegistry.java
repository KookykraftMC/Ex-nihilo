package exnihilo.registries;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import exnihilo.Blocks;
import exnihilo.Items;
import exnihilo.registries.helpers.Compostable;
import exnihilo.registries.helpers.SiftReward;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;


public class SieveRegistry {
	public static ArrayList<SiftReward> rewards = new ArrayList<SiftReward>();
	
	public static boolean dropCopper = false;
	public static boolean dropTin = false;
	public static boolean dropSilver = false;
	public static boolean dropLead = false;
	public static boolean dropNickel = false;
	public static boolean dropPlatinum = false;
	
	public static void register(int sourceID, int sourceMeta, int outputID, int outputMeta, int rarity)
	{
		SiftReward entry = new SiftReward(sourceID, sourceMeta, outputID, outputMeta, rarity);
		rewards.add(entry);
	}
	
	public static ArrayList<SiftReward> getRewards(int id, int meta)
	{
		ArrayList<SiftReward> rewardList = new ArrayList();

		Iterator<SiftReward> it = rewards.iterator();
		while(it.hasNext())
		{
			SiftReward reward = it.next();

			if (reward.sourceID == id && reward.sourceMeta == meta)
			{
				rewardList.add(reward);
			}
		}
		
		return rewardList;
	}
	
	public static void load(Configuration config)
	{
		String CATEGORY_SIEVE_OPTIONS = "sieve options";
		
		dropCopper = config.get(CATEGORY_SIEVE_OPTIONS, "give copper", false, "Forces the sieve to give copper even if no mods are detected which require it.").getBoolean(false);
		dropTin = config.get(CATEGORY_SIEVE_OPTIONS, "give tin", false, "Forces the sieve to give tin even if no mods are detected which require it.").getBoolean(false);
		dropLead = config.get(CATEGORY_SIEVE_OPTIONS, "give lead", false, "Forces the sieve to give lead even if no mods are detected which require it.").getBoolean(false);
		dropSilver = config.get(CATEGORY_SIEVE_OPTIONS, "give silver", false, "Forces the sieve to give silver even if no mods are detected which require it.").getBoolean(false);
		dropNickel = config.get(CATEGORY_SIEVE_OPTIONS, "give nickel", false, "Forces the sieve to give nickel even if no mods are detected which require it.").getBoolean(false);
		dropPlatinum = config.get(CATEGORY_SIEVE_OPTIONS, "give platinum", false, "Forces the sieve to give platinum even if no mods are detected which require it.").getBoolean(false);
	}
	
	public static void registerRewards()
	{
		//Dirt!
		register(Block.dirt.blockID, 0, Items.Stones.itemID, 0, 1);
		register(Block.dirt.blockID, 0, Items.Stones.itemID, 0, 1);
		register(Block.dirt.blockID, 0, Items.Stones.itemID, 0, 2);
		register(Block.dirt.blockID, 0, Items.Stones.itemID, 0, 2);
		register(Block.dirt.blockID, 0, Items.Stones.itemID, 0, 3);
		register(Block.dirt.blockID, 0, Items.Stones.itemID, 0, 3);
		register(Block.dirt.blockID, 0, Item.seeds.itemID, 0, 15);
		register(Block.dirt.blockID, 0, Items.GrassSeeds.itemID, 0, 15);
		register(Block.dirt.blockID, 0, Item.melonSeeds.itemID, 0, 32);
		register(Block.dirt.blockID, 0, Item.pumpkinSeeds.itemID, 0, 32);
		register(Block.dirt.blockID, 0, Items.SeedsSugarcane.itemID, 0, 32);
		register(Block.dirt.blockID, 0, Items.SeedsCarrot.itemID, 0, 64);
		register(Block.dirt.blockID, 0, Items.SeedsPotato.itemID, 0, 64);
		register(Block.dirt.blockID, 0, Items.SeedsOak.itemID, 0, 64);
		register(Block.dirt.blockID, 0, Items.SeedsSpruce.itemID, 0, 90);
		register(Block.dirt.blockID, 0, Items.SeedsBirch.itemID, 0, 90);

		//Gravel!
		register(Block.gravel.blockID, 0, Item.flint.itemID, 0, 4);
		register(Block.gravel.blockID, 0, Items.IronGravel.itemID, 0, 5);
		register(Block.gravel.blockID, 0, Items.GoldGravel.itemID, 0, 11);
		register(Block.gravel.blockID, 0, Item.coal.itemID, 0, 8);
		register(Block.gravel.blockID, 0, Item.dyePowder.itemID, 4, 20); //Lapis Lazuli
		register(Block.gravel.blockID, 0, Item.diamond.itemID, 0, 128);
		register(Block.gravel.blockID, 0, Item.emerald.itemID, 0, 150);
		
		//Sand!
		register(Block.sand.blockID, 0, Items.IronSand.itemID, 0, 5);
		register(Block.sand.blockID, 0, Items.GoldSand.itemID, 0, 11);
		register(Block.sand.blockID, 0, Item.dyePowder.itemID, 3, 32); //Cocoa beans
		register(Block.sand.blockID, 0, Items.SeedsCactus.itemID, 0, 32);
		register(Block.sand.blockID, 0, Items.SeedsJungle.itemID, 0, 64);
		register(Block.sand.blockID, 0, Items.Spores.itemID, 0, 128);
				
		//Soul Sand!
		register(Block.slowSand.blockID, 0, Item.netherQuartz.itemID, 0, 1);
		register(Block.slowSand.blockID, 0, Item.netherQuartz.itemID, 0, 3);
		register(Block.slowSand.blockID, 0, Block.netherStalk.blockID, 0, 20);
		register(Block.slowSand.blockID, 0, Item.ghastTear.itemID, 0, 64);
		
		//Dust!
		register(Blocks.Dust.blockID, 0, Items.IronDust.itemID, 0, 5);
		register(Blocks.Dust.blockID, 0, Items.GoldDust.itemID, 0, 11);
		register(Blocks.Dust.blockID, 0, Item.dyePowder.itemID, 15, 5); //Bone Meal
		register(Blocks.Dust.blockID, 0, Item.redstone.itemID, 0, 12);		
		register(Blocks.Dust.blockID, 0, Item.gunpowder.itemID, 0, 15);
		register(Blocks.Dust.blockID, 0, Item.glowstone.itemID, 0, 16);
		register(Blocks.Dust.blockID, 0, Item.blazePowder.itemID, 0, 20);
	}
	
	public static void RegisterOptionalOres()
	{
		if (dropCopper)
		{
			register(Block.gravel.blockID, 0, Items.CopperGravel.itemID, 0, 7);
			register(Block.sand.blockID, 0, Items.CopperSand.itemID, 0, 7);
			register(Blocks.Dust.blockID, 0, Items.CopperDust.itemID, 0, 7);
		}
		
		if (dropTin)
		{
			register(Block.gravel.blockID, 0, Items.TinGravel.itemID, 0, 7);
			register(Block.sand.blockID, 0, Items.TinSand.itemID, 0, 7);
			register(Blocks.Dust.blockID, 0, Items.TinDust.itemID, 0, 7);
		}
		
		if (dropSilver)
		{
			register(Block.gravel.blockID, 0, Items.SilverGravel.itemID, 0, 11);
			register(Block.sand.blockID, 0, Items.SilverSand.itemID, 0, 11);
			register(Blocks.Dust.blockID, 0, Items.SilverDust.itemID, 0, 11);
		}
		
		if (dropLead)
		{
			register(Block.gravel.blockID, 0, Items.LeadGravel.itemID, 0, 9);
			register(Block.sand.blockID, 0, Items.LeadSand.itemID, 0, 9);
			register(Blocks.Dust.blockID, 0, Items.LeadDust.itemID, 0, 9);
		}
		
		if (dropNickel)
		{
			register(Block.gravel.blockID, 0, Items.NickelGravel.itemID, 0, 11);
			register(Block.sand.blockID, 0, Items.NickelSand.itemID, 0, 11);
			register(Blocks.Dust.blockID, 0, Items.NickelDust.itemID, 0, 11);
		}
		
		if (dropPlatinum)
		{
			register(Block.gravel.blockID, 0, Items.PlatinumGravel.itemID, 0, 24);
			register(Block.sand.blockID, 0, Items.PlatinumSand.itemID, 0, 24);
			register(Blocks.Dust.blockID, 0, Items.PlatinumDust.itemID, 0, 24);
		}
	}
}
