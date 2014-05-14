package exnihilo.registries;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import exnihilo.ENBlocks;
import exnihilo.ENItems;
import exnihilo.ExNihilo;
import exnihilo.registries.helpers.SiftReward;

public class SieveRegistry {
	public static ArrayList<SiftReward> rewards = new ArrayList<SiftReward>();
	
	public static boolean dropCopper = false;
	public static boolean dropTin = false;
	public static boolean dropSilver = false;
	public static boolean dropLead = false;
	public static boolean dropNickel = false;
	public static boolean dropPlatinum = false;
	public static boolean dropAluminum = false;
	
	public static boolean dropRubberSeeds = false;
	
	public static void register(Block source, int sourceMeta, Item output, int outputMeta, int rarity)
	{
		SiftReward entry = new SiftReward(source, sourceMeta, output, outputMeta, rarity);
		
		if(source != null)
		{
			rewards.add(entry);
		}else
		{
			ExNihilo.log.error("An item was added to the SieveRegistry which was not a block");
		}
	}
	
	public static void register(Block source, Item output, int outputMeta, int rarity)
	{
		SiftReward entry = new SiftReward(source, output, outputMeta, rarity);
		
		if(source != null)
		{
			rewards.add(entry);
		}else
		{
			ExNihilo.log.error("An item was added to the SieveRegistry which was not a block");
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<SiftReward> getRewards(Block block, int meta)
	{
		ArrayList<SiftReward> rewardList = new ArrayList();

		Iterator<SiftReward> it = rewards.iterator();
		while(it.hasNext())
		{
			SiftReward reward = it.next();

			if (reward.source == block && reward.sourceMeta == meta)
			{
				rewardList.add(reward);
			}
		}
		
		return rewardList;
	}
	
	public static boolean Contains(Block block, int meta)
	{
		Iterator<SiftReward> it = rewards.iterator();
		while(it.hasNext())
		{
			SiftReward reward = it.next();

			if (reward.source == block && (reward.sourceMeta == meta || reward.ignoreMeta == true))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean Contains(Block block)
	{
		Iterator<SiftReward> it = rewards.iterator();
		while(it.hasNext())
		{
			SiftReward reward = it.next();

			if (reward.source == block && reward.ignoreMeta == true)
			{
				return true;
			}
		}
		
		return false;
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
		dropAluminum = config.get(CATEGORY_SIEVE_OPTIONS, "give aluminum", false, "Forces the sieve to give aluminum even if no mods are detected which require it.").getBoolean(false);
	}
	
	public static void registerRewards()
	{
		//Dirt!
		register(Blocks.dirt, 0, ENItems.Stones, 0, 1);
		register(Blocks.dirt, 0, ENItems.Stones, 0, 1);
		register(Blocks.dirt, 0, ENItems.Stones, 0, 2);
		register(Blocks.dirt, 0, ENItems.Stones, 0, 2);
		register(Blocks.dirt, 0, ENItems.Stones, 0, 3);
		register(Blocks.dirt, 0, ENItems.Stones, 0, 3);
		register(Blocks.dirt, 0, Items.wheat_seeds, 0, 15);
		register(Blocks.dirt, 0, ENItems.GrassSeeds, 0, 15);
		register(Blocks.dirt, 0, Items.melon_seeds, 0, 32);
		register(Blocks.dirt, 0, Items.pumpkin_seeds, 0, 32);
		register(Blocks.dirt, 0, ENItems.SeedsSugarcane, 0, 32);
		register(Blocks.dirt, 0, ENItems.SeedsCarrot, 0, 64);
		register(Blocks.dirt, 0, ENItems.SeedsPotato, 0, 64);
		register(Blocks.dirt, 0, ENItems.SeedsOak, 0, 64);
		register(Blocks.dirt, 0, ENItems.SeedsAcacia, 0, 90);
		register(Blocks.dirt, 0, ENItems.SeedsSpruce, 0, 90);
		register(Blocks.dirt, 0, ENItems.SeedsBirch, 0, 90);

		//Gravel!
		register(Blocks.gravel, 0, Items.flint, 0, 4);
		register(Blocks.gravel, 0, ENItems.IronGravel, 0, 5);
		register(Blocks.gravel, 0, ENItems.GoldGravel, 0, 11);
		register(Blocks.gravel, 0, Items.coal, 0, 8);
		register(Blocks.gravel, 0, Items.dye, 4, 20); //Lapis Lazuli
		register(Blocks.gravel, 0, Items.diamond, 0, 128);
		register(Blocks.gravel, 0, Items.emerald, 0, 150);
		
		//Sand!
		register(Blocks.sand, 0, ENItems.IronSand, 0, 5);
		register(Blocks.sand, 0, ENItems.GoldSand, 0, 11);
		register(Blocks.sand, 0, Items.dye, 3, 32); //Cocoa beans
		register(Blocks.sand, 0, ENItems.SeedsCactus, 0, 32);
		register(Blocks.sand, 0, ENItems.SeedsJungle, 0, 64);
		register(Blocks.sand, 0, ENItems.Spores, 0, 128);
				
		//Soul Sand!
		register(Blocks.soul_sand, 0, Items.quartz, 0, 1);
		register(Blocks.soul_sand, 0, Items.quartz, 0, 3);
		register(Blocks.soul_sand, 0, Items.nether_wart, 0, 20);
		register(Blocks.soul_sand, 0, Items.ghast_tear, 0, 64);
		
		//Dust!
		register(ENBlocks.Dust, 0, ENItems.IronDust, 0, 5);
		register(ENBlocks.Dust, 0, ENItems.GoldDust, 0, 11);
		register(ENBlocks.Dust, 0, Items.dye, 15, 5); //Bone Meal
		register(ENBlocks.Dust, 0, Items.redstone, 0, 8);		
		register(ENBlocks.Dust, 0, Items.gunpowder, 0, 15);
		register(ENBlocks.Dust, 0, Items.glowstone_dust, 0, 16);
		register(ENBlocks.Dust, 0, Items.blaze_powder, 0, 20);
	}
	
	public static void RegisterOptionalOres()
	{
//		if (dropCopper)
//		{
//			register(Blocks.gravel, 0, ENItems.CopperGravel, 0, 7);
//			register(Blocks.sand, 0, ENItems.CopperSand, 0, 7);
//			register(ENBlocks.Dust, 0, ENItems.CopperDust, 0, 7);
//		}
		
		if (dropTin)
		{
			register(Blocks.gravel, 0, ENItems.TinGravel, 0, 7);
			register(Blocks.sand, 0, ENItems.TinSand, 0, 7);
			register(ENBlocks.Dust, 0, ENItems.TinDust, 0, 7);
		}
		
		if (dropSilver)
		{
			register(Blocks.gravel, 0, ENItems.SilverGravel, 0, 11);
			register(Blocks.sand, 0, ENItems.SilverSand, 0, 11);
			register(ENBlocks.Dust, 0, ENItems.SilverDust, 0, 11);
		}
		
		if (dropLead)
		{
			register(Blocks.gravel, 0, ENItems.LeadGravel, 0, 9);
			register(Blocks.sand, 0, ENItems.LeadSand, 0, 9);
			register(ENBlocks.Dust, 0, ENItems.LeadDust, 0, 9);
		}
		
		if (dropNickel)
		{
			register(Blocks.gravel, 0, ENItems.NickelGravel, 0, 11);
			register(Blocks.sand, 0, ENItems.NickelSand, 0, 11);
			register(ENBlocks.Dust, 0, ENItems.NickelDust, 0, 11);
		}
		
		if (dropPlatinum)
		{
			register(Blocks.gravel, 0, ENItems.PlatinumGravel, 0, 32);
			register(Blocks.sand, 0, ENItems.PlatinumSand, 0, 32);
			register(ENBlocks.Dust, 0, ENItems.PlatinumDust, 0, 32);
		}
		
		if (dropAluminum)
		{
			register(Blocks.gravel, 0, ENItems.AluminumGravel, 0, 10);
			register(Blocks.sand, 0, ENItems.AluminumSand, 0, 10);
			register(ENBlocks.Dust, 0, ENItems.AluminumDust, 0, 10);
		}
	}
}