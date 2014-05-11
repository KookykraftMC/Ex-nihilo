package exnihilo.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;

public class BlockDust extends BlockSand {

	public BlockDust() {
		super();
		setHardness(0.4f);
		setStepSound(soundTypeSand);
	}

	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + BlockData.DUST_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		this.blockIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconBlockDust");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int id, int meta)
	{
		return this.blockIcon;
	}
}
