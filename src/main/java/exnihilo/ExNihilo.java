package exnihilo;

import java.io.File;

import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.compatibility.AE2;
import exnihilo.compatibility.OreList;
import exnihilo.compatibility.IC2;
import exnihilo.compatibility.foresty.Forestry;
import exnihilo.data.ModData;
import exnihilo.data.WorldData;
import exnihilo.network.ChannelHandler;
import exnihilo.network.ENNetwork;
import exnihilo.proxies.Proxy;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.CrucibleRegistry;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.HeatRegistry;
import exnihilo.registries.SieveRegistry;

@Mod(modid = ModData.ID, name = ModData.NAME, version = ModData.VERSION)
public class ExNihilo extends ENNetwork 
{
	@Instance(ModData.ID)
	public static ExNihilo instance;

	@SidedProxy(clientSide = "exnihilo.proxies.ClientProxy", serverSide = "exnihilo.proxies.ServerProxy")
	public static Proxy proxy = Proxy.getProxy();
	
	public static Configuration config;
	public static Logger log;

	@EventHandler
	public void PreInitialize(FMLPreInitializationEvent event)
	{
		log = LogManager.getLogger(ModData.NAME);
		//Metadata!
		ModData.setMetadata(event.getModMetadata());

		//Item and Block IDs!
		config = new Configuration(new File(event.getModConfigurationDirectory(), "/ExNihilo.cfg"));
		config.load();
		
		ModData.load(config);
		WorldData.load(config);

		ENBlocks.registerBlocks();

		Fluids.registerFluids();
		Fluids.registerBuckets();

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
		channels = NetworkRegistry.INSTANCE.newChannel("ExNihilo", new ChannelHandler());
		Blocks.fire.setFireInfo(ENBlocks.Barrel, 5, 150);
		Blocks.fire.setFireInfo(ENBlocks.LeavesInfested, 5, 150);
		Blocks.fire.setFireInfo(ENBlocks.Sieve, 5, 150);

		SieveRegistry.registerRewards();
		HammerRegistry.registerSmashables();
		CrucibleRegistry.registerMeltables();
		HeatRegistry.registerVanillaHeatSources();

		Recipes.registerCraftingRecipes();
		Recipes.registerFurnaceRecipes();

		World.registerWorldProviders();
		
		FMLInterModComms.sendMessage("Waila", "register", "exnihilo.compatibility.Waila.callbackRegister");
	}

	@EventHandler
	public void PostInitialize(FMLPostInitializationEvent event)
	{
		OreList.registerOres();

		if (Loader.isModLoaded("IC2"))
		{
			log.info("Found IC2!");

			IC2.loadCompatibility();
		}

		if (Loader.isModLoaded("Forestry"))
		{
			log.info("Found Forestry!");

			Forestry.loadCompatibility();
		}
		
		//No 1.7 API out yet
//		if (ThermalExpansion.isLoaded())
//		{
//			System.out.println(ModData.NAME + ": Found ThermalExpansion!");
//
//			ThermalExpansion.loadCompatibility();
//		}

		if (Loader.isModLoaded("appliedenergistics2"))
		{
			log.info("Found AE2!");

			AE2.loadCompatibility();
		}

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
