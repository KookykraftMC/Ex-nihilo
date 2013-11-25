package exnihilo.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.blocks.tileentities.TileEntityBeeTrap;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;

public class BlockBeeTrapTreated extends BlockContainer{
	public static Icon topIcon;
	public static Icon sideIcon;
	
	public BlockBeeTrapTreated(int id) {
		super(id, Material.ground);
		
		setStepSound(soundGrassFootstep);
		setCreativeTab(CreativeTabs.tabBlock);
		
		GameRegistry.registerTileEntity(TileEntityBeeTrap.class, this.getUnlocalizedName());
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockData.BEE_TRAP_TREATED_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.topIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconBeeTrapTopTreated");
		this.sideIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconBeeTrapSideTreated");
		this.blockIcon = this.sideIcon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
    {
		if (side == 0 || side == 1)
		{
			return this.topIcon;
		}
		return this.sideIcon;
    }

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityBeeTrap();
	}
}
