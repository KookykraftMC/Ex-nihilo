package exnihilo.compatibility;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.Blocks;
import exnihilo.Items;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.SieveRegistry;
import exnihilo.registries.helpers.Color;

public class IC2 {
	public static boolean isLoaded()
	{
		return Loader.isModLoaded("IC2");
	}
	
	public static void loadCompatibility()
	{
		ArrayList<ItemStack> ores;
		
		ores = OreDictionary.getOres("dustSulfur");
		if (ores.size() > 0)
		{
			ItemStack sulfur = ores.toArray(new ItemStack[ores.size()])[0];
			
			SieveRegistry.register(Blocks.Dust.blockID, 0, sulfur.itemID, sulfur.getItemDamage(), 32);
		}
		
		SieveRegistry.register(Block.dirt.blockID, 0, Items.SeedsRubber.itemID, 0, 64);
		
		Item crushedUranium = GameRegistry.findItem("IC2", "itemCrushedOre");
    	if (crushedUranium != null)
    	{
    		SieveRegistry.register(Block.sand.blockID, 0, crushedUranium.itemID, 4, 48);
    	}
    	
    	Item plantBall = null;
    	for (Item i : Item.itemsList)
		{
			if (i != null)
			{
				if (i.getUnlocalizedName().contains("itemFuelPlantBall"))
				{
					plantBall = i;
				}
			}
		}
    	
    	if (plantBall != null)
    	{
    		CompostRegistry.register(plantBall.itemID, 0, 0.5f, new Color("269900"));
    	}
    	
    	Item plantBallCompressed = null;
    	for (Item i : Item.itemsList)
		{
			if (i != null)
			{
				if (i.getUnlocalizedName().contains("itemFuelPlantCmpr"))
				{
					plantBallCompressed = i;
				}
			}
		}
    	
    	if (plantBallCompressed != null)
    	{
    		CompostRegistry.register(plantBallCompressed.itemID, 0, 1.0f, new Color("269900"));
    	}
    	
    	//CommonOre.dumpUnlocalizedNames("Ball");
	}

}
