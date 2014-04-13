package exnihilo.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;

public class ItemSpores extends Item{

	public ItemSpores() {
		super();

		setCreativeTab(CreativeTabs.tabMaterials);
	}

	/**
	 * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
	 * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
	 */
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	{
		if (world.getBlock(x, y, z) == Blocks.dirt)
		{
			world.setBlock(x, y, z, Blocks.mycelium, 0, 3);

			item.stackSize -= 1;

			if (item.stackSize <= 0)
			{
				player.destroyCurrentEquippedItem(); 
			}

			return true;
		}
		return false;
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack item, EntityPlayer player, EntityLivingBase entity)
    {
		if (!entity.worldObj.isRemote && entity instanceof EntityCow)
		{
			entity.setDead();
	        EntityMooshroom mooshroom = new EntityMooshroom(entity.worldObj);
	        mooshroom.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
	        mooshroom.setHealth(entity.getHealth());
	        mooshroom.renderYawOffset = entity.renderYawOffset;
	        entity.worldObj.spawnEntityInWorld(mooshroom);
	        entity.worldObj.spawnParticle("largeexplode", entity.posX, entity.posY + (double)(entity.height / 2.0F), entity.posZ, 0.0D, 0.0D, 0.0D);
			
			item.stackSize -= 1;

			if (item.stackSize <= 0)
			{
				player.destroyCurrentEquippedItem(); 
			}
			
			return true;
		}
		return false;
    }

	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + ItemData.SPORES_UNLOCALIZED_NAME;
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + ItemData.SPORES_UNLOCALIZED_NAME;
	}

	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconSpores");
	}

}
