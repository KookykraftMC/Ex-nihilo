package exnihilo.blocks.ores;

import java.util.List;

import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;

public class BlockSilverOre extends BlockSand {
	private IIcon dust;
	private IIcon gravel;
	private IIcon sand;
	
	public BlockSilverOre() {
		super();
		setHardness(0.4f);
		setStepSound(soundTypeSand);
		setBlockName(ModData.ID + "." + BlockData.SILVER_ORE_KEY);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		gravel = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconSilverGravel");
		sand = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconSilverSand");
		dust = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconSilverDust");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public IIcon getIcon(int id, int meta)
    {
		switch(meta)
		{
		case 0:
			return gravel;
		case 1:
			return sand;
		case 2:
			return dust;
		}
        return blockIcon;
    }
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List subItems) {
		for (int i = 0; i < 3; i++) {
			subItems.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public int damageDropped (int meta) {
		return meta;
	}
}
