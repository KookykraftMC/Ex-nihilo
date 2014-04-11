package exnihilo.blocks.itemBlocks;

import exnihilo.ENBlocks;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBarrelStone extends ItemBlock
{
	public ItemBlockBarrelStone() {
		super(ENBlocks.BarrelStone);
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return ModData.ID + "." + BlockData.BARREL_STONE_UNLOCALIZED_NAME;
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}

}
