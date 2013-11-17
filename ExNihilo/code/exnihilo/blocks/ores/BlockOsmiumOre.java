package exnihilo.blocks.ores;

import java.util.List;

import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;

public class BlockOsmiumOre extends BlockSand{
	private Icon dust;
	private Icon gravel;
	private Icon sand;
	
	public BlockOsmiumOre(int id) {
		super(id);
		setHardness(0.4f);
		setStepSound(soundSandFootstep);
		setUnlocalizedName(ModData.ID + "." + BlockData.OSMIUM_ORE_KEY);
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		gravel = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconOsmiumGravel");
		sand = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconOsmiumSand");
		dust = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconOsmiumDust");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public Icon getIcon(int id, int meta)
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
		
        return this.blockIcon;
    }
	
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(int id, CreativeTabs tabs, List subItems) {
		for (int i = 0; i < 3; i++) {
			subItems.add(new ItemStack(id, 1, i));
		}
	}
	
	@Override
	public int damageDropped (int meta) {
		return meta;
	}
}
