package exnihilo;

import java.io.File;

import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.compatibility.CommonOre;
import exnihilo.data.ModData;
import exnihilo.data.WorldData;
import exnihilo.proxies.Proxy;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.CrucibleRegistry;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.HeatRegistry;
import exnihilo.registries.SieveRegistry;

@Mod(modid = ModData.ID, name = ModData.NAME, version = ModData.VERSION)
public class ExNihilo 
{
	@Instance(ModData.ID)
	public static ExNihilo instance;

	@SidedProxy(clientSide = "exnihilo.proxies.ClientProxy", serverSide = "exnihilo.proxies.ServerProxy")
	public static Proxy proxy;
	
	public static Configuration config;

	@EventHandler
	public void PreInitialize(FMLPreInitializationEvent event)
	{
		//Metadata!
		ModData.setMetadata(event.getModMetadata());

		//Item and Block IDs!
		config = new Configuration(new File(event.getModConfigurationDirectory(), "/ExNihilo.cfg"));
		config.load();
		
		ModData.load(config);
		WorldData.load(config);

//		BlockData.load(config);
		ENBlocks.registerBlocks();

//		FluidData.load(config);
		Fluids.registerFluids();
		Fluids.registerBuckets();

//		ItemData.load(config);
		ENItems.registerItems();

		Entities.registerEntities();

		ColorRegistry.load(config);
		CompostRegistry.load(config);
		SieveRegistry.load(config);
		CrucibleRegistry.load(config);
		HammerRegistry.load(config);

		if(config.hasChanged())
			config.save();

		proxy.initializeSounds();
		proxy.initializeRenderers();
		
		MinecraftForge.EVENT_BUS.register(this);
	}

	@EventHandler
	public void Initialize(FMLInitializationEvent event)
	{
		Blocks.fire.setFireInfo(ENBlocks.Barrel, 5, 150);
		Blocks.fire.setFireInfo(ENBlocks.LeavesInfested, 5, 150);
		Blocks.fire.setFireInfo(ENBlocks.Sieve, 5, 150);
//		ENBlocks.registerNames();
//		Fluids.registerNames();
//		ENItems.registerNames();

		SieveRegistry.registerRewards();
		HammerRegistry.registerSmashables();
		CrucibleRegistry.registerMeltables();
		HeatRegistry.registerVanillaHeatSources();

		CommonOre.registerOres();
		CommonOre.registerIngots();	

		Recipes.registerCraftingRecipes();
		Recipes.registerFurnaceRecipes();

		World.registerWorldProviders();
	}



	@EventHandler
	public void PostInitialize(FMLPostInitializationEvent event)
	{
		CommonOre.registerRecipes();

		//For Later Forge Versions
//		if (Loader.isModLoaded("IC2"))
//		{
//			System.out.println(ModData.NAME + ": Found IC2!");
//
//			IC2.loadCompatibility();
//		}

		//1.7 API not stable yet
//		if (Forestry.isLoaded())
//		{
//			System.out.println(ModData.NAME + ": Found Forestry!");
//
//			Forestry.loadCompatibility();
//		}
		
		//No 1.7 API out yet
//		if (ThermalExpansion.isLoaded())
//		{
//			System.out.println(ModData.NAME + ": Found ThermalExpansion!");
//
//			ThermalExpansion.loadCompatibility();
//		}

		//AE is done, AE2 API is not stable
//		if (AppliedEnergistics.isLoaded())
//		{
//			System.out.println(ModData.NAME + ": Found Applied Energistics!");
//
//			AppliedEnergistics.loadCompatibility();
//		}

		//No 1.7 API out yet
//		if (Mekanism.isLoaded())
//		{
//			System.out.println(ModData.NAME + ": Found Mekanism!");
//
//			Mekanism.loadCompatibility();
//		}

		//No 1.7 API out yet
//		if (Chococraft.isLoaded())
//		{
//			System.out.println(ModData.NAME + ": Found Chococraft!");
//
//			Chococraft.loadCompatibility();
//		}
		
		//No 1.7 API out yet
//		if (MineFactoryReloaded.isLoaded())
//		{
//			System.out.println(ModData.NAME + ": Found MineFactory Reloaded!");
//			
//			MineFactoryReloaded.loadCompatibility();
//		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void textureHook(TextureStitchEvent.Post event) {
		Fluids.registerIcons(event);
	}
}
