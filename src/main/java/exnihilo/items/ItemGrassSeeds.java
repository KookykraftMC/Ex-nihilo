package exnihilo.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;

public class ItemGrassSeeds  extends Item{

	public ItemGrassSeeds() {
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
			world.setBlock(x, y, z, Blocks.grass, 0, 3);

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
		return ModData.ID + "." + ItemData.SEED_GRASS_UNLOCALIZED_NAME;
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + ItemData.SEED_GRASS_UNLOCALIZED_NAME;
	}

	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconGrassSeed");
	}
}
