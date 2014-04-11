package exnihilo.compatibility;

import java.util.ArrayList;

import appeng.api.Materials;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.ENBlocks;
import exnihilo.registries.SieveRegistry;

public class AppliedEnergistics {
	public static boolean isLoaded()
	{
		return Loader.isModLoaded("AppliedEnergistics");
	}
	
	public static void loadCompatibility()
	{	
		//Quartz Crystal, metadata 6
    	SieveRegistry.register(Block.sand.blockID, 0, Materials.matQuartz.itemID, Materials.matQuartz.getItemDamage(), 6);

    	//Quartz Dust, metadata 7
    	SieveRegistry.register(ENBlocks.Dust.blockID, 0, Materials.matQuartzDust.itemID, Materials.matQuartzDust.getItemDamage(), 6);
	}
}
