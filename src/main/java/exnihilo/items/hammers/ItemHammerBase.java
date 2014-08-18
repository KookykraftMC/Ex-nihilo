package exnihilo.items.hammers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

import com.google.common.collect.Sets;

import exnihilo.registries.HammerRegistry;
import exnihilo.registries.helpers.Smashable;

public class ItemHammerBase extends ItemTool{
	@SuppressWarnings("rawtypes")
	public static Set blocksEffectiveAgainst = Sets.newHashSet(new Block[]{});

	public ItemHammerBase(ToolMaterial material) 
	{
		super(3.0F, material, blocksEffectiveAgainst);
	}

	@Override
	public boolean func_150897_b(Block block)
	{
		Block[] blocks = HammerRegistry.getBlocks();

		for (int i = 0; i < blocks.length; ++i)
		{
			if (blocks[i] == block)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public float getDigSpeed(ItemStack item, Block block, int meta)
	{
		Block[] blocks = HammerRegistry.getBlocks();

		for (int i = 0; i < blocks.length; ++i)
		{
			if (blocks[i] == block && block.getHarvestLevel(meta) <= this.toolMaterial.getHarvestLevel())
			{
				return efficiencyOnProperMaterial * 0.75f;
			}
		}

		return 0.8f;
	}

	@Override
	public boolean onBlockStartBreak(ItemStack item, int X, int Y, int Z, EntityPlayer player)
	{
		World world = player.worldObj;
		Block block = world.getBlock(X,Y,Z);
		int blockMeta = world.getBlockMetadata(X,Y,Z);
		int fortune = EnchantmentHelper.getFortuneModifier(player);
		boolean valid = false;

		ArrayList<Smashable> rewards = HammerRegistry.getRewards(block, blockMeta);
		
		if (rewards.size() > 0 && block.getHarvestLevel(blockMeta) <= this.toolMaterial.getHarvestLevel())
		{
			Iterator<Smashable> it = rewards.iterator();
			while(it.hasNext())
			{
				Smashable reward = it.next();

				if (!world.isRemote && world.rand.nextFloat() <= reward.chance + (reward.luckMultiplier * fortune))
				{
					EntityItem entityitem = new EntityItem(world, (double)X + 0.5D, (double)Y + 0.5D, (double)Z + 0.5D, new ItemStack(reward.item, 1, reward.meta));

					double f3 = 0.05F;
					entityitem.motionX = world.rand.nextGaussian() * f3;
					entityitem.motionY = (0.2d);
					entityitem.motionZ = world.rand.nextGaussian() * f3;

					world.spawnEntityInWorld(entityitem);
				}
				
				valid = true;
			}
		}else
		{
			if (block.getMaterial().isToolNotRequired() || block.getHarvestTool(blockMeta) == null)
			{
				valid = false;
			}
		}
		
		item.damageItem(1, player);

		if (item.stackSize == 0)
		{
			player.destroyCurrentEquippedItem();
		}

		if (!world.isRemote)
		{
			world.func_147480_a(X, Y, Z, false);
		}
		
		return valid;
	}


}
