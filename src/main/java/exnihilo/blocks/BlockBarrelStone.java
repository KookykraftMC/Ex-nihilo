package exnihilo.blocks;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.blocks.tileentities.TileEntityBarrel;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;

public class BlockBarrelStone extends BlockBarrel{

	public BlockBarrelStone() {
		super(Material.rock);
		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(4.0f);
		setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);

		setBlockName(ModData.ID + "." + BlockData.BARREL_STONE_KEY);
		GameRegistry.registerTileEntity(TileEntityBarrel.class, this.getUnlocalizedName());
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List subItems) {
		subItems.add(new ItemStack(item, 1, 0));
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = Blocks.stone.getIcon(0, 0);
		iconCompost = register.registerIcon(ModData.TEXTURE_LOCATION + ":" + "IconBarrelCompost");
	}

}
