package exnihilo;

import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Loader;
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
import exnihilo.compatibility.AppliedEnergistics;
import exnihilo.compatibility.Chococraft;
import exnihilo.compatibility.CommonOre;
import exnihilo.compatibility.IC2;
import exnihilo.compatibility.Mekanism;
import exnihilo.compatibility.MineFactoryReloaded;
import exnihilo.compatibility.ThermalExpansion;
import exnihilo.compatibility.foresty.Forestry;
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
	@Instance
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
		config = new Configuration(event.getSuggestedConfigurationFile());
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

		config.save();

		proxy.initializeSounds();
		proxy.initializeRenderers();
		
		MinecraftForge.EVENT_BUS.register(this);
	}

	@EventHandler
	public void Initialize(FMLInitializationEvent event)
	{
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

		if (Loader.isModLoaded("IC2"))
		{
			System.out.println(ModData.NAME + ": Found IC2!");

			IC2.loadCompatibility();
		}

		if (Forestry.isLoaded())
		{
			System.out.println(ModData.NAME + ": Found Forestry!");

			Forestry.loadCompatibility();
		}
		
		if (ThermalExpansion.isLoaded())
		{
			System.out.println(ModData.NAME + ": Found ThermalExpansion!");

			ThermalExpansion.loadCompatibility();
		}

		if (AppliedEnergistics.isLoaded())
		{
			System.out.println(ModData.NAME + ": Found Applied Energistics!");

			AppliedEnergistics.loadCompatibility();
		}

		if (Mekanism.isLoaded())
		{
			System.out.println(ModData.NAME + ": Found Mekanism!");

			Mekanism.loadCompatibility();
		}

		if (Chococraft.isLoaded())
		{
			System.out.println(ModData.NAME + ": Found Chococraft!");

			Chococraft.loadCompatibility();
		}
		
		if (MineFactoryReloaded.isLoaded())
		{
			System.out.println(ModData.NAME + ": Found MineFactory Reloaded!");
			
			MineFactoryReloaded.loadCompatibility();
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void textureHook(TextureStitchEvent.Post event) {
		Fluids.registerIcons(event);
	}
}
