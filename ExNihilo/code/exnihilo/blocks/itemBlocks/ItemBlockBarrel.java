package exnihilo.blocks.itemBlocks;

import exnihilo.data.BlockData;
import exnihilo.data.ModData;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBarrel extends ItemBlock
{

	public ItemBlockBarrel(int par1) {
		super(par1);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return ModData.ID + "." + BlockData.BARREL_UNLOCALIZED_NAMES[itemstack.getItemDamage()];
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
}
