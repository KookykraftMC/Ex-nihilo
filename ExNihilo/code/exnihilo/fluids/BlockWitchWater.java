package exnihilo.fluids;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.data.BlockData;
import exnihilo.data.FluidData;
import exnihilo.data.ModData;
import exnihilo.registries.ColorRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockWitchWater extends BlockFluidClassic{
	@SideOnly(Side.CLIENT)
    protected Icon[] fluidIcons;
	public static final Material witchwater = new MaterialLiquid(MapColor.ironColor);
	
	public BlockWitchWater(int id, Fluid fluid, Material material) {
		super(id, fluid, material);
		
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return FluidData.WITCHWATER_UNLOCALIZED_NAME;
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
		this.fluidIcons = new Icon[] 
				{
				register.registerIcon(ModData.TEXTURE_LOCATION + ":IconWitchWaterStill"), 
				register.registerIcon(ModData.TEXTURE_LOCATION + ":IconWitchWaterFlow")
				};
    }
	
	@Override
    public Icon getIcon(int side, int meta) {
            return side != 0 && side != 1 ? this.fluidIcons[1] : this.fluidIcons[0];
    }
	
	@SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return ColorRegistry.color("witchwater").toInt();
    }
}
