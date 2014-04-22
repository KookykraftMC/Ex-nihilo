package exnihilo.items;

import java.lang.reflect.Method;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;

import com.google.common.collect.Sets;

import exnihilo.ENBlocks;
import exnihilo.ENItems;
import exnihilo.compatibility.foresty.Forestry;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;
import exnihilo.proxies.Proxy;

public class ItemCrook extends ItemTool{
	public static final double pullingForce = 1.5d;
	public static final double pushingForce = 1.5d;

	@SuppressWarnings("rawtypes")
	public static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[]{});

	public ItemCrook() 
	{	
		super(0.0f, ToolMaterial.WOOD, blocksEffectiveAgainst);

		this.setMaxDamage((int)(this.getMaxDamage() * 3));
	}
	
	public ItemCrook(ToolMaterial mat) 
	{	
		super(0.0f, mat, blocksEffectiveAgainst);
	}

	@Override
	public boolean func_150897_b(Block block)
	{	
		if (block.isLeaves(Proxy.getProxy().getWorld(), 0, 0, 0))
		{
			return true;
		}

		return false;
	}

	@Override
	public float func_150893_a(ItemStack item, Block block)
	{	
		if (block.isLeaves(Proxy.getProxy().getWorld(), 0, 0, 0))
		{
			return efficiencyOnProperMaterial + 1;
		}

		return 1.0F;
	}

	//Break leaf block
	@SuppressWarnings("rawtypes")
	@Override
	public boolean onBlockStartBreak(ItemStack item, int X, int Y, int Z, EntityPlayer player)
	{
		World world = player.worldObj;
		Block block = world.getBlock(X,Y,Z);
		int meta = world.getBlockMetadata(X, Y, Z);
		boolean validTarget = false;
		boolean extraDropped = false;

		if (block.isLeaves(world, 0, 0, 0))
		{
			if (!world.isRemote)
			{
				if (Forestry.isLoaded())
				{
					//Forestry, why? Why did you make me have to do this? We could have been friends...
					Class forestryLeafBlock = null;
					try {
						forestryLeafBlock = Class.forName("forestry.arboriculture.gadgets.BlockLeaves");

						Method dropStuff = null;
						if (forestryLeafBlock != null)
						{	
							dropStuff = forestryLeafBlock.cast(block).getClass().getDeclaredMethod("spawnLeafDrops", World.class, int.class, int.class, int.class, int.class, float.class, boolean.class);
							dropStuff.setAccessible(true);
						}

						if (dropStuff != null)
						{
							//This gets called once here, and then it drops stuff again when it breaks.
							dropStuff.invoke(forestryLeafBlock.cast(block), world, X, Y, Z, meta, 1.0F, true);
							extraDropped = true;
						}
					}
					catch (Exception ex){}
				}

				//If the Forestry method didn't work, try the vanilla way.
				if (!extraDropped)
				{
					//Call it once here and it gets called again when it breaks. 
					block.dropBlockAsItem(world, X, Y, Z, meta, 0);
				}


				//Silkworms
				if (ModData.ALLOW_SILKWORMS && world.rand.nextInt(100) == 0)
				{
					world.spawnEntityInWorld(new EntityItem(world, X + 0.5D, Y + 0.5D, Z + 0.5D, new ItemStack(ENItems.Silkworm, 1, 0)));
				}
			}

			validTarget = true;
		}

		if (block == ENBlocks.LeavesInfested)
		{
			if (!world.isRemote)
			{
				if (ModData.ALLOW_SILKWORMS && world.rand.nextInt(15) == 0)
				{
					world.spawnEntityInWorld(new EntityItem(world, X + 0.5D, Y + 0.5D, Z + 0.5D, new ItemStack(ENItems.Silkworm, 1, 0)));
					world.getWorldTime();
				}
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
		}

		return false;
	}

	//Left click entity
	@Override
	public boolean onLeftClickEntity(ItemStack item, EntityPlayer player, Entity entity)
	{
		//TODO: Push entity away from you!
		if (!player.worldObj.isRemote)
		{
			double distance = Math.sqrt(Math.pow(player.posX - entity.posX, 2) + Math.pow(player.posZ - entity.posZ, 2));

			double scalarX = (player.posX - entity.posX) / distance;
			double scalarZ = (player.posZ - entity.posZ) / distance;

			double velX = 0 - scalarX * pushingForce;
			double velZ = 0 - scalarZ * pushingForce;
			double velY = 0; //- (player.posY - entity.posY);

			entity.addVelocity(velX, velY, velZ);
		}
		//Don't do damage
		item.damageItem(1, player);
		return true;
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack item, EntityPlayer player, EntityLivingBase entity)
	{
		double distance = Math.sqrt(Math.pow(player.posX - entity.posX, 2) + Math.pow(player.posZ - entity.posZ, 2));

		double scalarX = (player.posX - entity.posX) / distance;
		double scalarZ = (player.posZ - entity.posZ) / distance;

		double velX = scalarX * pullingForce;
		double velZ = scalarZ * pullingForce;
		double velY = 0; //- (player.posY - entity.posY);

		entity.addVelocity(velX, velY, velZ);

		item.damageItem(1, player);
		return true;
	}

	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + ItemData.CROOK_UNLOCALIZED_NAME;
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + ItemData.CROOK_UNLOCALIZED_NAME;
	}

	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":Crook");
	}

	/**
	 * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
	 * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
	 */
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	{
		//TODO: Remove this during the 1.7 update?
		// Fishing will allow the player to obtain Lilypads.
		if (world.getBlock(x, y, z) == Blocks.dirt && world.getBlock(x, y + 1, z) == FluidRegistry.WATER.getBlock() && y + 1 >= world.getTopSolidOrLiquidBlock(x, z) - 1)
		{
			if (!world.isRemote)
			{
				if (world.rand.nextInt(120) == 0)
				{
					ItemStack waterlily = new ItemStack(Blocks.waterlily, 1, 0);
					EntityItem entity = new EntityItem(world, x + 0.5D, y + 1.5D, z + 0.5D, waterlily);

					double distance = Math.sqrt(Math.pow(player.posX - entity.posX, 2) + Math.pow(player.posZ - entity.posZ, 2));

					double scalarX = (player.posX - entity.posX) / distance;
					double scalarZ = (player.posZ - entity.posZ) / distance;

					double velX = scalarX * pullingForce;
					double velZ = scalarZ * pullingForce;
					double velY = 0.1d; //- (player.posY - entity.posY);

					entity.addVelocity(velX, velY, velZ);
					world.spawnEntityInWorld(entity);
				}

//				if (world.rand.nextInt(30) == 0)
//				{
//					world.destroyBlock(x, y, z, false);
//				}
			}
			item.damageItem(1, player);

			return true;
		}
		return false;
	}
}
