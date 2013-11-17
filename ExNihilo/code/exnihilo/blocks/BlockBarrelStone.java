package exnihilo.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.blocks.tileentities.TileEntityBarrel;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;

public class BlockBarrelStone extends BlockBarrel{

	public BlockBarrelStone(int id) {
		super(id, Material.rock);
		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(4.0f);

		setUnlocalizedName(ModData.ID + "." + BlockData.BARREL_STONE_KEY);
		GameRegistry.registerTileEntity(TileEntityBarrel.class, this.getUnlocalizedName());
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(int id, CreativeTabs tabs, List subItems) {
		subItems.add(new ItemStack(id, 1, 0));
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = Block.stone.getIcon(0, 0);
		iconCompost = register.registerIcon(ModData.TEXTURE_LOCATION + ":" + "IconBarrelCompost");
	}

}
