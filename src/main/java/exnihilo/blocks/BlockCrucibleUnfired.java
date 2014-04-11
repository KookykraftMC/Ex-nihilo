package exnihilo.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.blocks.tileentities.TileEntityCrucibleUnfired;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;

public class BlockCrucibleUnfired extends BlockContainer{

	public BlockCrucibleUnfired() {
		super(Material.clay);

		setCreativeTab(CreativeTabs.tabMaterials);
		setHardness(2.0f);

		setBlockName(ModData.ID + "." + BlockData.CRUCIBLE_UNFIRED_KEY);
		GameRegistry.registerTileEntity(TileEntityCrucibleUnfired.class, this.getUnlocalizedName());
	}


	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = Blocks.clay.getIcon(0, 0);
	}

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean hasTileEntity()
	{
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCrucibleUnfired();
	}
}
