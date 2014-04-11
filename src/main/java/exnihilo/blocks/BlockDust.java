package exnihilo.blocks;

import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
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
		return BlockData.DUST_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		this.blockIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconBlockDust");
	}
}
