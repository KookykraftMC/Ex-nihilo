package exnihilo;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.compatibility.AppliedEnergistics;
import exnihilo.compatibility.Chococraft;
import exnihilo.compatibility.CommonOre;
import exnihilo.compatibility.Forestry;
import exnihilo.compatibility.IC2;
import exnihilo.compatibility.Mekanism;
import exnihilo.data.BlockData;
import exnihilo.data.FluidData;
import exnihilo.data.ItemData;
import exnihilo.data.ModData;
import exnihilo.data.WorldData;
import exnihilo.network.PacketHandler;
import exnihilo.proxies.Proxy;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.CrucibleRegistry;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.SieveRegistry;
import exnihilo.world.WorldProviderDefaultVoid;

@Mod(modid = ModData.ID, name = ModData.NAME, version = ModData.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {"crowley"}, packetHandler = PacketHandler.class)

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

		BlockData.load(config);
		Blocks.registerBlocks();

		FluidData.load(config);
		Fluids.registerFluids();
		Fluids.registerBuckets();

		ItemData.load(config);
		Items.registerItems();

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
		Blocks.registerNames();
		Fluids.registerNames();
		Items.registerNames();

		SieveRegistry.registerRewards();
		HammerRegistry.registerSmashables();
		CrucibleRegistry.registerMeltables();

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

		if (IC2.isLoaded())
		{
			System.out.println(ModData.NAME + ": Found IC2!");

			IC2.loadCompatibility();
		}

		if (Forestry.isLoaded())
		{
			System.out.println(ModData.NAME + ": Found Forestry!");

			Forestry.loadCompatibility();
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
	}

	@ForgeSubscribe
	@SideOnly(Side.CLIENT)
	public void textureHook(TextureStitchEvent.Post event) {
		Fluids.registerIcons(event);
	}
}
