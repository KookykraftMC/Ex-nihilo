package exnihilo.items.hammers;

import java.util.ArrayList;
import java.util.Iterator;

import exnihilo.Blocks;
import exnihilo.Items;
import exnihilo.data.ItemData;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.SieveRegistry;
import exnihilo.registries.helpers.SiftReward;
import exnihilo.registries.helpers.Smashable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class ItemHammerBase extends ItemTool{
	public static Block[] blocksEffectiveAgainst = new Block[]{};

	public ItemHammerBase(int id, EnumToolMaterial material) 
	{
		super(id, 0.0F, material, blocksEffectiveAgainst);
		this.damageVsEntity += 3;
	}

	@Override
	public boolean canHarvestBlock(Block par1Block)
	{
		Block[] blocks = HammerRegistry.getBlocks();

		for (int i = 0; i < blocks.length; ++i)
		{
			if (blocks[i] == par1Block)
			{
				return true;
			}
		}
		return false;
	}

	public float getStrVsBlock(ItemStack item, Block block)
	{
		Block[] blocks = HammerRegistry.getBlocks();

		for (int i = 0; i < blocks.length; ++i)
		{
			if (blocks[i] == block)
			{
				if (block.blockID == block.cobblestone.blockID)
				{
					return (1.0f + efficiencyOnProperMaterial) / 2;
				}
				else
				{
					return (1.0f + efficiencyOnProperMaterial) / 6;
				}
			}
		}

		return 1.0F;
	}

	@Override
	public boolean onBlockStartBreak(ItemStack item, int X, int Y, int Z, EntityPlayer player)
	{
		World world = player.worldObj;
		int blockID = world.getBlockId(X,Y,Z);
		int blockMeta = world.getBlockMetadata(X,Y,Z);
		int fortune = EnchantmentHelper.getFortuneModifier(player);

		ArrayList<Smashable> rewards = HammerRegistry.getRewards(blockID, blockMeta);
		boolean validTarget = false;

		if (rewards.size() > 0)
		{
			Iterator<Smashable> it = rewards.iterator();
			while(it.hasNext())
			{
				Smashable reward = it.next();

				if (!world.isRemote && world.rand.nextFloat() <= reward.chance + (reward.luckMultiplier * fortune))
				{
					EntityItem entityitem = new EntityItem(world, (double)X + 0.5D, (double)Y + 0.5D, (double)Z + 0.5D, new ItemStack(reward.id, 1, reward.meta));

					double f3 = 0.05F;
					entityitem.motionX = world.rand.nextGaussian() * f3;
					entityitem.motionY = (0.2d);
					entityitem.motionZ = world.rand.nextGaussian() * f3;

					world.spawnEntityInWorld(entityitem);
				}

				validTarget = true;
			}

			if (validTarget)
			{
				item.damageItem(1, player);
				
				if (item.stackSize == 0)
				{
					player.destroyCurrentEquippedItem();
				}
				
				if (!world.isRemote)
				{
					world.destroyBlock(X, Y, Z, false);
				}
			}

			return true;
		}
		else
		{
			return false;
		}
	}


}
