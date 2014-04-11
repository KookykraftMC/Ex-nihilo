package exnihilo.blocks.ores;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;

public class BlockIronOre extends BlockSand{
	private Icon dust;
	private Icon gravel;
	private Icon sand;
	
	public BlockIronOre(int id) {
		super(id);
		setHardness(0.4f);
		setStepSound(soundSandFootstep);
		setUnlocalizedName(ModData.ID + "." + BlockData.IRON_ORE_KEY);
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		gravel = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconIronGravel");
		sand = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconIronSand");
		dust = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconIronDust");
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
