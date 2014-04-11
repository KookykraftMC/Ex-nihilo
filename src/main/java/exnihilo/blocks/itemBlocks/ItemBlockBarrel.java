package exnihilo.blocks.itemBlocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import exnihilo.ENBlocks;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;

public class ItemBlockBarrel extends ItemBlock
{
	public ItemBlockBarrel() {
		super(ENBlocks.Barrel);
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
