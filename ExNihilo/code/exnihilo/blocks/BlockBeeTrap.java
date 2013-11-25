package exnihilo.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;

public class BlockBeeTrap extends Block{
	Icon topIcon;
	Icon sideIcon;
	
	public BlockBeeTrap(int id) {
		super(id, Material.ground);
		
		setStepSound(soundGrassFootstep);
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockData.BEE_TRAP_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.topIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconBeeTrapTopRaw");
		this.sideIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconBeeTrapSideRaw");
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
}
