//package exnihilo.compatibility;
//
//import net.minecraft.block.Block;
//import net.minecraft.init.Blocks;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.crafting.FurnaceRecipes;
//import net.minecraftforge.oredict.ShapedOreRecipe;
//import cpw.mods.fml.common.Loader;
//import cpw.mods.fml.common.registry.GameRegistry;
//import exnihilo.ENBlocks;
//import exnihilo.ENItems;
//import exnihilo.registries.HammerRegistry;
//import exnihilo.registries.SieveRegistry;
//
//public class Mekanism {
//	public static boolean isLoaded()
//	{
//		return Loader.isModLoaded("Mekanism");
//	}
//
//	public static void loadCompatibility()
//	{
//		SieveRegistry.register(Blocks.gravel, 0, ENItems.OsmiumGravel, 0, 12);
//		SieveRegistry.register(Blocks.sand, 0, ENItems.OsmiumSand, 0, 12);
//		SieveRegistry.register(ENBlocks.Dust, 0, ENItems.OsmiumDust, 0, 12);
//
//		ItemStack ingotOsmium = mekanism.api.ItemRetriever.getItem("Ingot");
//		ingotOsmium.setItemDamage(1);
//
//		if (ingotOsmium != null)
//		{
//			FurnaceRecipes.smelting().func_151393_a(ENBlocks.OsmiumOre, ingotOsmium, 0.1f);
//			FurnaceRecipes.smelting().func_151394_a(new ItemStack(ENBlocks.OsmiumOre, 1, 1), ingotOsmium, 0.1f);
//			FurnaceRecipes.smelting().func_151394_a(new ItemStack(ENBlocks.OsmiumOre, 1, 2), ingotOsmium, 0.1f);
//		}
//
//		GameRegistry.addRecipe(
//				new ShapedOreRecipe(
//						new ItemStack(ENBlocks.OsmiumOre, 1, 0),
//						new Object[]
//								{
//							"xx",
//							"xx",
//							'x', ENItems.OsmiumGravel
//								}));
//
//		GameRegistry.addRecipe(
//				new ShapedOreRecipe(
//						new ItemStack(ENBlocks.OsmiumOre, 1, 1),
//						new Object[]
//								{
//							"xx",
//							"xx",
//							'x', ENItems.OsmiumSand
//								}));
//
//		GameRegistry.addRecipe(
//				new ShapedOreRecipe(
//						new ItemStack(ENBlocks.OsmiumOre, 1, 2),
//						new Object[]
//								{
//							"xx",
//							"xx",
//							'x', ENItems.OsmiumDust
//								}));
//
//		ItemStack oreOsmium = mekanism.api.ItemRetriever.getItem("OreBlock");
//
//		if (oreOsmium != null)
//		{
//			HammerRegistry.registerOre(Block.getBlockFromItem(oreOsmium.getItem()), oreOsmium.getItemDamage(), ENItems.OsmiumGravel, 0);
//		}
//
//		HammerRegistry.registerOre(ENBlocks.OsmiumOre, 0, ENItems.OsmiumSand, 0);
//		HammerRegistry.registerOre(ENBlocks.OsmiumOre, 1, ENItems.OsmiumDust, 0);
//
//
//	}
//}
