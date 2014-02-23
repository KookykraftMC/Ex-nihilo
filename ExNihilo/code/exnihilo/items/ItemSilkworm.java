package exnihilo.items;

import exnihilo.Blocks;
import exnihilo.blocks.tileentities.TileEntityLeavesInfested;
import exnihilo.compatibility.foresty.Forestry;
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
	   Block block = Block.blocksList[world.getBlockId(x, y, z)];
	   if (block.isLeaves(null, 0, 0, 0) && !Forestry.addsThisLeaf(block) && block.blockID != Blocks.LeavesInfested.blockID)
	   {
		   int oldID = world.getBlockId(x, y, z);
		   int oldMeta = world.getBlockMetadata(x, y, z);
		   
		   world.setBlock(x, y, z, Blocks.LeavesInfested.blockID, oldMeta, 3);
		   TileEntityLeavesInfested te = (TileEntityLeavesInfested)world.getBlockTileEntity(x, y, z); 
		   te.setMimicBlock(oldID, oldMeta);
		   
		   item.stackSize -= 1;
		   
		   if (item.stackSize <= 0)
		   {
			  player.destroyCurrentEquippedItem(); 
		   }
		   
		   return true;
	   }
	   else
	   {
		   return false;
	   }
		   
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
