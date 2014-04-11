package exnihilo.blocks;

import exnihilo.data.BlockData;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;

public class BlockDust extends BlockSand{

	public BlockDust(int id) {
		super(id);
		setHardness(0.4f);
		setStepSound(soundSandFootstep);
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockData.DUST_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.blockIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconBlockDust");
	}
}
