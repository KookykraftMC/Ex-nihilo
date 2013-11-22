package exnihilo.fluids;

import exnihilo.registries.ColorRegistry;
import net.minecraft.block.Block;
import net.minecraft.util.Icon;
import net.minecraftforge.fluids.Fluid;

public class FluidWitchWater extends Fluid{

	public FluidWitchWater(String fluidName) {
		super(fluidName);
	}
	
	public int getColor()
    {
        return ColorRegistry.color("witchwater").toInt();
    }
}
