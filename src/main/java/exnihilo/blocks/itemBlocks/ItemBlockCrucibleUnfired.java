package exnihilo.blocks.itemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;

public class ItemBlockCrucibleUnfired extends ItemBlock
{
	public ItemBlockCrucibleUnfired(Block block) {
		super(block);
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
