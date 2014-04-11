package exnihilo.blocks.itemBlocks;

import exnihilo.ENBlocks;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockLeavesInfested extends ItemBlock{

	public ItemBlockLeavesInfested() {
		super(ENBlocks.LeavesInfested);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return ModData.ID + "." + BlockData.LEAVES_INFESTED_UNLOCALIZED_NAMES[itemstack.getItemDamage()];
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
}
