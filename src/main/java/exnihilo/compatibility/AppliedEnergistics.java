//package exnihilo.compatibility;
//
//import net.minecraft.init.Blocks;
//import cpw.mods.fml.common.Loader;
//import exnihilo.ENBlocks;
//import exnihilo.registries.SieveRegistry;
//
//public class AppliedEnergistics {
//	public static boolean isLoaded()
//	{
//		return Loader.isModLoaded("AppliedEnergistics");
//	}
//	
//	public static void loadCompatibility()
//	{	
//		//Quartz Crystal, metadata 6
//    	SieveRegistry.register(Blocks.sand, 0, Materials.matQuartz.itemID, Materials.matQuartz.getItemDamage(), 6);
//
//    	//Quartz Dust, metadata 7
//    	SieveRegistry.register(ENBlocks.Dust, 0, Materials.matQuartzDust.itemID, Materials.matQuartzDust.getItemDamage(), 6);
//	}
//}
