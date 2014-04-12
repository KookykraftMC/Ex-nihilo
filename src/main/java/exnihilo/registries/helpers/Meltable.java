package exnihilo.registries.helpers;

import net.minecraft.block.Block;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.Fluid;

public class Meltable {
	public int id;
	public int meta;
	public float solidVolume;
	public Fluid fluid;
	public float fluidVolume;
	public Block appearance;
	
	public Meltable(int id, int meta, float solidAmount, Fluid fluid, float fluidAmount, Block appearance)
	{
		this.id = id;
		this.meta = meta;
		this.solidVolume = solidAmount;
		this.fluid = fluid;
		this.fluidVolume = fluidAmount;
		
		this.appearance = appearance;
	}
	
	public IIcon getIcon()
	{
		return appearance.getIcon(0, 0);
	}
}
