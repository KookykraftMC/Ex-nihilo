package exnihilo.items;

import exnihilo.Blocks;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSilkworm extends Item{

	public ItemSilkworm(int par1) {
		super(par1);
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	/**
    * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
    * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
    */
   public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
   {
	   if (world.getBlockId(x, y, z) == Block.leaves.blockID)
	   {
		   world.setBlock(x, y, z, Blocks.LeavesInfested.blockID, world.getBlockMetadata(x, y, z) & 3, 3);
		   
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
		return ItemData.SILKWORM_UNLOCALIZED_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemData.SILKWORM_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":Silkworm");
	}
}
