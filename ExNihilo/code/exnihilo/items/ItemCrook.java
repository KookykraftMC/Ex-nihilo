package exnihilo.items;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import exnihilo.Blocks;
import exnihilo.Items;
import exnihilo.compatibility.Forestry;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class ItemCrook extends ItemTool{
	public static final double pullingForce = 1.5d;
	public static final double pushingForce = 1.5d;

	public static final Block[] blocksEffectiveAgainst = new Block[]{};

	public ItemCrook(int id) 
	{
		super(id, 0.0f, EnumToolMaterial.WOOD, blocksEffectiveAgainst);
		
		this.setMaxDamage((int)(this.getMaxDamage() * 3));
	}

	@Override
	public boolean canHarvestBlock(Block block)
	{
		if (block.isLeaves(null, 0, 0, 0))
		{
			return true;
		}

		return false;
	}

	@Override
	public float getStrVsBlock(ItemStack item, Block block)
	{
		if (block.isLeaves(null, 0, 0, 0))
		{
			return efficiencyOnProperMaterial + 1;
		}

		return 1.0F;
	}

	//Break leaf block
	@Override
	public boolean onBlockStartBreak(ItemStack item, int X, int Y, int Z, EntityPlayer player)
	{
		World world = player.worldObj;
		int blockID = world.getBlockId(X,Y,Z);
		int meta = world.getBlockMetadata(X, Y, Z);
		boolean validTarget = false;
		boolean extraDropped = false;

		Block block = Block.blocksList[blockID];

		if (block.isLeaves(null, 0, 0, 0))
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
							//This gets called once here, and then it drops stuff again when it breaks. It's not supposed to, but it does.
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
					world.spawnEntityInWorld(new EntityItem(world, X + 0.5D, Y + 0.5D, Z + 0.5D, new ItemStack(Items.Silkworm, 1, 0)));
				}
				
				world.destroyBlock(X, Y, Z, true);
			}

			validTarget = true;
		}

		if (blockID == Blocks.LeavesInfested.blockID)
		{
			if (!world.isRemote)
			{
				if (ModData.ALLOW_SILKWORMS && world.rand.nextInt(15) == 0)
				{
					world.spawnEntityInWorld(new EntityItem(world, X + 0.5D, Y + 0.5D, Z + 0.5D, new ItemStack(Items.Silkworm, 1, 0)));
				}
			}

			validTarget = true;
		}

		if (validTarget)
		{
			if (!world.isRemote)
			{
				world.destroyBlock(X, Y, Z, false);
			}

			item.damageItem(1, player);

			if (item.stackSize == 0)
			{
				player.destroyCurrentEquippedItem();
			}
			return true;
		}else
		{
			return false;
		}
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
		return ItemData.CROOK_UNLOCALIZED_NAME;
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.CROOK_UNLOCALIZED_NAME;
	}

	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":Crook");
	}
}
