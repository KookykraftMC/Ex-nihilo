package exnihilo.compatibility;

import net.minecraft.init.Blocks;
import appeng.api.AEApi;
import appeng.api.definitions.Materials;
import cpw.mods.fml.common.Loader;
import exnihilo.ENBlocks;
import exnihilo.ExNihilo;
import exnihilo.registries.SieveRegistry;

public class AE2 {
	public static boolean isLoaded()
	{
		return Loader.isModLoaded("appliedenergistics2");
	}
	
	public static void loadCompatibility()
	{
		ExNihilo.log.info("Beginning AE2 Integration...");
		Materials materials = AEApi.instance().materials();
		//Quartz Crystal, metadata 6
    	SieveRegistry.register(Blocks.sand, 0, materials.materialCertusQuartzCrystal.item(), materials.materialCertusQuartzCrystal.stack(1).getItemDamage(), 6);

    	//Quartz Dust, metadata 7
    	SieveRegistry.register(ENBlocks.Dust, 0, materials.materialCertusQuartzDust.item(), materials.materialCertusQuartzDust.stack(1).getItemDamage(), 6);
    	ExNihilo.log.info("Certus Quartz was successfully integrated");
    	ExNihilo.log.info("AE2 Integration Complete!");
	}
}
