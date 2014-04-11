package exnihilo.blocks.itemBlocks;

import exnihilo.data.BlockData;
import exnihilo.data.ModData;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockLeavesInfested extends ItemBlock{

	public ItemBlockLeavesInfested(int par1) {
		super(par1);
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
