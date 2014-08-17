package exnihilo.items;

import java.lang.reflect.Method;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import com.google.common.collect.Sets;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.ENBlocks;
import exnihilo.ENItems;
import exnihilo.ExNihilo;
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
				if (Loader.isModLoaded("Forestry"))
				{
					//Forestry, why? Why did you make me have to do this? We could have been friends...
					Class forestryLeafBlock = null;
					try {
						forestryLeafBlock = Class.forName("forestry.arboriculture.gadgets.BlockLeaves");

						Method dropStuff = null;
						if (forestryLeafBlock != null)
						{
							dropStuff = forestryLeafBlock.getDeclaredMethod("spawnLeafDrops", World.class, int.class, int.class, int.class, int.class, float.class, boolean.class);
							dropStuff.setAccessible(true);
						}else{
							ExNihilo.log.error("forestryLeafBlock == null");
						}

						if (dropStuff != null)
						{
							//This gets called once here, and then it drops stuff again when it breaks.
							dropStuff.invoke(forestryLeafBlock.newInstance(), world, X, Y, Z, meta, 1.0F, true);
							extraDropped = true;
						}else{
							ExNihilo.log.error("dropStuff == null");
						}
					}
					catch (Exception ex){
						ExNihilo.log.error("Failed to get spawnLeafDrops from Forestry BlockLeaves class");
						ex.printStackTrace();
					}
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
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":Crook");
	}
}
