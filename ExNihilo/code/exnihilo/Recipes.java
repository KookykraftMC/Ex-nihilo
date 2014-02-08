package exnihilo;

import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.data.ModData;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes {


	public static void registerCraftingRecipes()
	{
		if (ModData.ALLOW_BARRELS)
		{
			//Barrels!
			for(int i = 0; i < 4; i++)
			{
				GameRegistry.addRecipe(new ItemStack(Blocks.Barrel, 1, i),
						"x x",
						"x x",
						"xyx",
						'x', new ItemStack(Block.planks, 1, i), 
						'y', new ItemStack(Block.woodSingleSlab, 1, i));
			}

			//Stone Barrel!
			GameRegistry.addRecipe(
					new ShapedOreRecipe(
							new ItemStack(Blocks.BarrelStone, 1, 0),
							new Object[]
									{
								"x x",
								"x x",
								"xyx",
								'x', new ItemStack(Block.stone, 1, 0),
								'y', new ItemStack(Block.stoneSingleSlab, 1, 0)
									}));
		}


		if (ModData.ALLOW_HAMMERS)
		{
			//Hammers!
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Items.HammerWood, 1, 0),
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
						new ItemStack(Items.HammerStone, 1, 0),
						new Object[]
								{
							" x ",
							" yx",
							"y  ",
							'x', Block.cobblestone, 
							'y', "stickWood"
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Items.HammerIron, 1, 0),
						new Object[]
								{
							" x ",
							" yx",
							"y  ",
							'x', Item.ingotIron, 
							'y', "stickWood"
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Items.HammerGold, 1, 0),
						new Object[]
								{
							" x ",
							" yx",
							"y  ",
							'x', Item.ingotGold, 
							'y', "stickWood"
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Items.HammerDiamond, 1, 0),
						new Object[]
								{
							" x ",
							" yx",
							"y  ",
							'x', Item.diamond, 
							'y', "stickWood"
								}));
		}
		

		if (ModData.ALLOW_CROOKS)
		{
			//Crook!
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Items.Crook, 1, 0),
						new Object[]
								{
							"xx ",
							" x ",
							" x ",
							'x', "stickWood"
								}));
		}
		

		//Mesh!
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Items.Mesh, 1, 0),
						new Object[]
								{
							"xxx",
							"xxx",
							"xxx",
							'x', Item.silk
								}));
		
		if (ModData.ALLOW_SIEVES)
		{
			

		//SIEVES!
		for(int i = 0; i < 4; i++)
		{
			GameRegistry.addRecipe(
					new ShapedOreRecipe(
							new ItemStack(Blocks.Sieve, 1, i),
							new Object[]
									{
								"xzx",
								"xzx",
								"y y",
								'x', new ItemStack(Block.planks, 1, i),
								'y', "stickWood",
								'z', Items.Mesh}));
		}
		}
		

		//Porcelain!
		GameRegistry.addRecipe(
				new ShapelessOreRecipe(
						new ItemStack(Items.Porcelain, 1, 0),
						new Object[]
								{ 
							new ItemStack(Item.clay, 1, 0),
							new ItemStack(Item.dyePowder, 1, 15)
								}));
		if (ModData.ALLOW_CRUCIBLES)
		{
		//Raw Crucible!
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Blocks.CrucibleUnfired, 1, 0),
						new Object[]
								{
							"x x",
							"x x",
							"xxx",
							'x', new ItemStack(Items.Porcelain, 1, 0)
								}));
		}
		


		//Stone -> Cobblestone!
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Block.cobblestone, 1, 0),
						new Object[]
								{
							"xx",
							"xx",
							'x', Items.Stones
								}));
		
		
		//Precious Doll!
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Items.Doll, 1, 0),
								new Object[]
										{
									"xyx",
									" x ",
									"x x",
									'x', Items.Porcelain,
									'y', Item.diamond
										}));
				
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Items.Doll, 1, 0),
								new Object[]
										{
									"xyx",
									" x ",
									"x x",
									'x', Items.Porcelain,
									'y', Item.emerald
										}));
				
				//Angry Doll!
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Items.DollAngry, 1, 0),
								new Object[]
										{
									"xyx",
									"zwz",
									"xvx",
									'v', Item.redstone,
									'w', Items.Doll,
									'x', Item.blazePowder,
									'y', Item.netherStalkSeeds,
									'z', Item.glowstone
										}));
				
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Items.DollAngry, 1, 0),
								new Object[]
										{
									"xyx",
									"zwz",
									"xvx",
									'v', Item.netherStalkSeeds,
									'w', Items.Doll,
									'x', Item.blazePowder,
									'y', Item.redstone,
									'z', Item.glowstone
										}));
				
				//Creepy Doll
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Items.DollCreepy, 1, 0),
								new Object[]
										{
									"xyx",
									"zwz",
									"xvx",
									'v', Item.redstone,
									'w', Items.Doll,
									'x', new ItemStack(Item.dyePowder, 1, 0),
									'y', Item.netherStalkSeeds,
									'z', new ItemStack(Item.dyePowder, 1, 4)
										}));
				
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
								new ItemStack(Items.DollCreepy, 1, 0),
								new Object[]
										{
									"xyx",
									"zwz",
									"xvx",
									'v', Item.netherStalkSeeds,
									'w', Items.Doll,
									'x', new ItemStack(Item.dyePowder, 1, 0),
									'y', Item.redstone,
									'z', new ItemStack(Item.dyePowder, 1, 4)
										}));

		registerOreRecipes();
	}

	public static void registerOreRecipes()
	{
		//IRON!
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Blocks.IronOre, 1, 0),
						new Object[]
								{
							"xx",
							"xx",
							'x', Items.IronGravel
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Blocks.IronOre, 1, 1),
						new Object[]
								{
							"xx",
							"xx",
							'x', Items.IronSand
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Blocks.IronOre, 1, 2),
						new Object[]
								{
							"xx",
							"xx",
							'x', Items.IronDust
								}));

		//GOLD!
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Blocks.GoldOre, 1, 0),
						new Object[]
								{
							"xx",
							"xx",
							'x', Items.GoldGravel
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Blocks.GoldOre, 1, 1),
						new Object[]
								{
							"xx",
							"xx",
							'x', Items.GoldSand
								}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(Blocks.GoldOre, 1, 2),
						new Object[]
								{
							"xx",
							"xx",
							'x', Items.GoldDust
								}));
	}

	public static void registerFurnaceRecipes()
	{
		FurnaceRecipes.smelting().addSmelting(Items.Silkworm.itemID, 0, new ItemStack(Items.SilkwormCooked, 1, 0), 0.1f);
		
		FurnaceRecipes.smelting().addSmelting(Blocks.IronOre.blockID, 0, new ItemStack(Item.ingotIron, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(Blocks.IronOre.blockID, 1, new ItemStack(Item.ingotIron, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(Blocks.IronOre.blockID, 2, new ItemStack(Item.ingotIron, 1, 0), 0.1f);

		FurnaceRecipes.smelting().addSmelting(Blocks.GoldOre.blockID, 0, new ItemStack(Item.ingotGold, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(Blocks.GoldOre.blockID, 1, new ItemStack(Item.ingotGold, 1, 0), 0.1f);
		FurnaceRecipes.smelting().addSmelting(Blocks.GoldOre.blockID, 2, new ItemStack(Item.ingotGold, 1, 0), 0.1f);
		
		if (ModData.ALLOW_CRUCIBLES)
		{
			FurnaceRecipes.smelting().addSmelting(Blocks.CrucibleUnfired.blockID, 0, new ItemStack(Blocks.Crucible, 1, 0), 0.1f);
		}
		
	}
}