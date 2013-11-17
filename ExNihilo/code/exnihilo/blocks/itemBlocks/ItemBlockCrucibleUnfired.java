package exnihilo.blocks.itemBlocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;

public class ItemBlockCrucibleUnfired extends ItemBlock
{

	public ItemBlockCrucibleUnfired(int par1) {
		super(par1);
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return ModData.ID + "." + BlockData.CRUCIBLE_UNFIRED_UNLOCALIZED_NAME;
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}

}
