package exnihilo;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.data.ModData;

public class Recipes {


	public static void registerCraftingRecipes()
	{
		if (ModData.ALLOW_BARRELS)
		{
			//Barrels!
			for(int i = 0; i < 4; i++)
			{
				GameRegistry.addRecipe(new ItemStack(ENBlocks.Barrel, 1, i),
						"x x",
						"x x",
						"xyx",
						'x', new ItemStack(Blocks.planks, 1, i), 
						'y', new ItemStack(Blocks.wooden_slab, 1, i));
			}

			//Stone Barrel!
			GameRegistry.addRecipe(
					new ShapedOreRecipe(
							new ItemStack(ENBlocks.BarrelStone, 1, 0),
							new Object[]
									{
								"x x",
								"x x",
								"xyx",
								'x', new ItemStack(Blocks.stone, 1, 0),
								'y', new ItemStack(Blocks.stone_slab, 1, 0)
									}));
		}


		if (ModData.ALLOW_HAMMERS)
		{
			//Hammers!
			GameRegistry.addRecipe(
					new ShapedOreRecipe(
							new ItemStack(ENItems.HammerWood, 1, 0),
							new Object[]
									{
								" x ",
								" yx",
								"y  ",
								'x', "plankWood", 
								'y', "stickWood"
									}));

			GameRegistry.addRecipe(
					new ShapedOreRecipe(
							new ItemStack(ENItems.HammerStone, 1, 0),
							new Object[]
									{
								" x ",
								" yx",
								"y  ",
								'x', Blocks.cobblestone, 
								'y', "stickWood"
									}));

			GameRegistry.addRecipe(
					new ShapedOreRecipe(
							new ItemStack(ENItems.HammerIron, 1, 0),
							new Object[]
									{
								" x ",
								" yx",
								"y  ",
								'x', Items.iron_ingot, 
								'y', "stickWood"
									}));

			GameRegistry.addRecipe(
					new ShapedOreRecipe(
							new ItemStack(ENItems.HammerGold, 1, 0),
							new Object[]
									{
								" x ",
								" yx",
								"y  ",
								'x', Items.gold_ingot, 
								'y', "stickWood"
									}));

			GameRegistry.addRecipe(
					new ShapedOreRecipe(
							new ItemStack(ENItems.HammerDiamond, 1, 0),
							new Object[]
									{
								" x ",
								" yx",
								"y  ",
								'x', Items.diamond, 
								'y', "stickWood"
									}));
		}


		if (ModData.ALLOW_CROOKS)
		{
			//Crook!
			GameRegistry.addRecipe(
					new ShapedOreRecipe(
							new ItemStack(ENItems.Crook, 1, 0),
							new Object[]
									{
								"xx ",
								" x ",
								" x ",
								'x', "stickWood"
									}));

			//Bone Crook!
			GameRegistry.addRecipe(
					new ShapedOreRecipe(
							new ItemStack(ENItems.CrookBone, 1, 0),
							new Object[]
									{
								"xx ",
								" x ",
								" x ",
								'x', Items.bone
									}));

		}


		//Mesh!
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENItems.Mesh, 1, 0),
						new Object[]
								{
							"xxx",
							"xxx",
							"xxx",
							'x', Items.string
								}));

		if (ModData.ALLOW_SIEVES)
		{


			//SIEVES!
			for(int i = 0; i < 4; i++)
			{
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(ENBlocks.Sieve, 1, i),
								new Object[]
										{
									"xzx",
									"xzx",
									"y y",
									'x', new ItemStack(Blocks.planks, 1, i),
									'y', "stickWood",
									'z', ENItems.Mesh}));
			}
		}


		//Porcelain!
		GameRegistry.addRecipe(
				new ShapelessOreRecipe(
						new ItemStack(ENItems.Porcelain, 1, 0),
						new Object[]
								{ 
							new ItemStack(Items.clay_ball, 1, 0),
							new ItemStack(Items.dye, 1, 15)
								}));
		if (ModData.ALLOW_CRUCIBLES)
		{
			//Raw Crucible!
			GameRegistry.addRecipe(
					new ShapedOreRecipe(
							new ItemStack(ENBlocks.CrucibleUnfired, 1, 0),
							new Object[]
									{
								"x x",
								"x x",
								"xxx",
								'x', new ItemStack(ENItems.Porcelain, 1, 0)
									}));
		}



		//Stone -> Cobblestone!
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Blocks.cobblestone, 1, 0),
						new Object[]
								{
							"xx",
							"xx",
							'x', ENItems.Stones
								}));


		//Precious Doll!
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENItems.Doll, 1, 0),
						new Object[]
								{
							"xyx",
							" x ",
							"x x",
							'x', ENItems.Porcelain,
							'y', Items.diamond
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENItems.Doll, 1, 0),
						new Object[]
								{
							"xyx",
							" x ",
							"x x",
							'x', ENItems.Porcelain,
							'y', Items.emerald
								}));

		//Angry Doll!
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENItems.DollAngry, 1, 0),
						new Object[]
								{
							"xyx",
							"zwz",
							"xvx",
							'v', Items.redstone,
							'w', ENItems.Doll,
							'x', Items.blaze_powder,
							'y', Items.nether_wart,
							'z', Items.glowstone_dust
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENItems.DollAngry, 1, 0),
						new Object[]
								{
							"xyx",
							"zwz",
							"xvx",
							'v', Items.nether_wart,
							'w', ENItems.Doll,
							'x', Items.blaze_powder,
							'y', Items.redstone,
							'z', Items.glowstone_dust
								}));

		//Creepy Doll
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENItems.DollCreepy, 1, 0),
						new Object[]
								{
							"xyx",
							"zwz",
							"xvx",
							'v', Items.redstone,
							'w', ENItems.Doll,
							'x', new ItemStack(Items.dye, 1, 0),
							'y', Items.nether_wart,
							'z', new ItemStack(Items.dye, 1, 4)
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENItems.DollCreepy, 1, 0),
						new Object[]
								{
							"xyx",
							"zwz",
							"xvx",
							'v', Items.nether_wart,
							'w', ENItems.Doll,
							'x', new ItemStack(Items.dye, 1, 0),
							'y', Items.redstone,
							'z', new ItemStack(Items.dye, 1, 4)
								}));

		registerOreRecipes();
	}

	public static void registerOreRecipes()
	{
		//IRON!
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENBlocks.IronOre, 1, 0),
						new Object[]
								{
							"xx",
							"xx",
							'x', ENItems.IronGravel
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENBlocks.IronOre, 1, 1),
						new Object[]
								{
							"xx",
							"xx",
							'x', ENItems.IronSand
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENBlocks.IronOre, 1, 2),
						new Object[]
								{
							"xx",
							"xx",
							'x', ENItems.IronDust
								}));

		//GOLD!
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENBlocks.GoldOre, 1, 0),
						new Object[]
								{
							"xx",
							"xx",
							'x', ENItems.GoldGravel
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENBlocks.GoldOre, 1, 1),
						new Object[]
								{
							"xx",
							"xx",
							'x', ENItems.GoldSand
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ENBlocks.GoldOre, 1, 2),
						new Object[]
								{
							"xx",
							"xx",
							'x', ENItems.GoldDust
								}));
	}

	public static void registerFurnaceRecipes()
	{
		FurnaceRecipes.smelting().func_151396_a(ENItems.Silkworm, new ItemStack(ENItems.SilkwormCooked, 1, 0), 0.1f);

		FurnaceRecipes.smelting().func_151393_a(ENBlocks.IronOre, new ItemStack(Items.iron_ingot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(ENBlocks.IronOre, 1, 1), new ItemStack(Items.iron_ingot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(ENBlocks.IronOre, 1, 2), new ItemStack(Items.iron_ingot, 1, 0), 0.1f);

		FurnaceRecipes.smelting().func_151393_a(ENBlocks.GoldOre, new ItemStack(Items.gold_ingot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(ENBlocks.GoldOre, 1, 1), new ItemStack(Items.gold_ingot, 1, 0), 0.1f);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(ENBlocks.GoldOre, 1, 2), new ItemStack(Items.gold_ingot, 1, 0), 0.1f);

		if (ModData.ALLOW_CRUCIBLES)
		{
			FurnaceRecipes.smelting().func_151393_a(ENBlocks.CrucibleUnfired, new ItemStack(ENBlocks.Crucible, 1, 0), 0.1f);
		}

	}
}