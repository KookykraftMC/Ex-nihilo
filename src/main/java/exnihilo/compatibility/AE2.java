package exnihilo.compatibility;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import appeng.api.AEApi;
import appeng.api.definitions.Materials;
import exnihilo.ENBlocks;
import exnihilo.ExNihilo;
import exnihilo.registries.SieveRegistry;

public class AE2 {
	public static Item certusDust = AEApi.instance().materials().materialCertusQuartzDust.item();
	public static Item skyStoneDust = AEApi.instance().materials().materialSkyDust.item();
	public static Block skyStone = AEApi.instance().blocks().blockSkyStone.block();
	
	public static void loadCompatibility()
	{
		Materials materials = AEApi.instance().materials();
		//Quartz Crystal, metadata 6
    	SieveRegistry.register(Blocks.sand, 0, materials.materialCertusQuartzCrystal.item(), materials.materialCertusQuartzCrystal.stack(1).getItemDamage(), 6);
    	SieveRegistry.register(Blocks.sand, 0, materials.materialCertusQuartzCrystal.item(), materials.materialCertusQuartzCrystalCharged.stack(1).getItemDamage(), 128);
    	
    	//Quartz Dust, metadata 7
    	SieveRegistry.register(ENBlocks.Dust, 0, materials.materialCertusQuartzDust.item(), materials.materialCertusQuartzDust.stack(1).getItemDamage(), 6);
    	ExNihilo.log.info("Certus Quartz was successfully integrated");
    	
    	SieveRegistry.register(ENBlocks.Dust, 0, materials.materialSkyDust.item(), materials.materialSkyDust.stack(1).getItemDamage(), 8);
    	ExNihilo.log.info("Skystone was successfully integrated");
    	
    	ExNihilo.log.info("--- AE2 Integration Complete!");
	}
}
