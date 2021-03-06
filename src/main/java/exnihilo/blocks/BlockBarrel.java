package exnihilo.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.ENBlocks;
import exnihilo.ENItems;
import exnihilo.Fluids;
import exnihilo.blocks.tileentities.TileEntityBarrel;
import exnihilo.blocks.tileentities.TileEntityBarrel.BarrelMode;
import exnihilo.blocks.tileentities.TileEntityBarrel.ExtractMode;
import exnihilo.compatibility.AE2;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;
import exnihilo.registries.CompostRegistry;

public class BlockBarrel extends BlockContainer
{
	@SideOnly(Side.CLIENT)
	public static IIcon iconCompost;
	public static IIcon iconClouds;

	public BlockBarrel() {
		super(Material.wood);
		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(2.0f);
		setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);

		setBlockName(ModData.ID + "." + BlockData.BARREL_KEY);
		GameRegistry.registerTileEntity(TileEntityBarrel.class, this.getUnlocalizedName());
	}

	public BlockBarrel(Material material) {
		super(material);  
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List subItems) {
		for (int i = 0; i < 6; i++) {
			subItems.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public int damageDropped (int metadata) {
		return metadata;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBarrel();
	}

	@Override
	@SuppressWarnings("unused")
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);

		int meta = world.getBlockMetadata(x, y, z);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		if (player == null)
		{
			return false;
		}

		TileEntityBarrel barrel = (TileEntityBarrel) world.getTileEntity(x, y, z);

		if (barrel.getMode().canExtract == ExtractMode.Always || (world.difficultySetting.getDifficultyId() == 0 && barrel.getMode().canExtract == ExtractMode.PeacefulOnly))
		{
			barrel.giveAppropriateItem();
		}
		else if (player.getCurrentEquippedItem() != null)
		{
			ItemStack item = player.getCurrentEquippedItem();
			if (item!=null)
			{

				//COMPOST!
				if (ModData.ALLOW_BARREL_RECIPE_DIRT)
				{
					if (barrel.getMode() == BarrelMode.EMPTY || barrel.getMode() == BarrelMode.COMPOST && !barrel.isFull())
					{
						if (CompostRegistry.containsItem(item.getItem(), item.getItemDamage()))
						{
							barrel.addCompostItem(CompostRegistry.getItem(item.getItem(), item.getItemDamage()));

							if (!player.capabilities.isCreativeMode)
							{
								item.stackSize -= 1;
								if (item.stackSize == 0)
								{
									item = null;
								}
							}
						}
						//						else
						//						{
						//							System.out.println("Item not registered for compost: " + item.itemID + ":" + item.getItemDamage());
						//						}	
					}
				}



				//FLUIDS!
				if (barrel.getMode() == BarrelMode.EMPTY || barrel.getMode() == BarrelMode.FLUID)
				{
					FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(item);
					//FILL
					if (fluid != null)
					{

						int capacity = barrel.fill(ForgeDirection.UP, fluid, false);

						if(capacity > 0) //&& fluid.fluidID == FluidRegistry.WATER.getID())
						{
							barrel.fill(ForgeDirection.UP, fluid, true);

							if (!player.capabilities.isCreativeMode)
							{
								if (item.getItem() == Items.potionitem && item.getItemDamage() == 0)
								{
									player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Items.glass_bottle, 1, 0));
								}else
								{
									player.inventory.setInventorySlotContents(player.inventory.currentItem, getContainer(item));
								}
							}
						}
					}
					//DRAIN
					else if(FluidContainerRegistry.isContainer(item))
					{				
						FluidStack available = barrel.drain(ForgeDirection.DOWN, Integer.MAX_VALUE, false);
						if (available != null)
						{
							ItemStack filled = FluidContainerRegistry.fillFluidContainer(available, item);
							FluidStack liquid = FluidContainerRegistry.getFluidForFilledItem(filled);
							if (liquid != null) {

								if (item.stackSize > 1) {
									if (!player.inventory.addItemStackToInventory(filled)) {
										return false;
									} else {
										item.stackSize -= 1;
									}
								} else {
									player.inventory.setInventorySlotContents(player.inventory.currentItem, filled);
								}

								barrel.drain(ForgeDirection.DOWN, liquid.amount, true);
								return true;
							}
						}
					}
				}

				//XXX BARREL RECIPES!
				if (item!= null)
				{
					if (barrel.getMode() == BarrelMode.FLUID && barrel.isFull())
					{
						if (barrel.fluid.fluidID == FluidRegistry.WATER.getID())
						{
							//Dust turns water into clay!
							if(ModData.ALLOW_BARREL_RECIPE_CLAY && item.getItem() == Item.getItemFromBlock(ENBlocks.Dust))
							{
								barrel.setMode(BarrelMode.CLAY);
								useItem(player);
							}

							//Milk + Water = Slime!
							if(ModData.ALLOW_BARREL_RECIPE_SLIME && item.getItem() == Items.milk_bucket)
							{
								barrel.setMode(BarrelMode.MILKED);
								useItem(player);
							}

							//Mushroom stew + Water = Witch Water!
							if(ModData.ALLOW_BARREL_RECIPE_SOULSAND && (item.getItem() == Items.mushroom_stew || item.getItem() == ENItems.Spores))
							{
								barrel.setMode(BarrelMode.SPORED);
								useItem(player);
							}

						} 
						
						if (barrel.fluid.fluidID == FluidRegistry.LAVA.getID())
						{
							//Redstone + Lava = Netherrack
							if(ModData.ALLOW_BARREL_RECIPE_NETHERRACK && item.getItem() == Items.redstone)
							{
								barrel.setMode(BarrelMode.NETHERRACK);
								useItem(player);
							}

							//Glowstone + Lava = End Stone
							if(ModData.ALLOW_BARREL_RECIPE_ENDSTONE && item.getItem() == Items.glowstone_dust)
							{
								barrel.setMode(BarrelMode.ENDSTONE);
								useItem(player);
							}
							
							//Angry doll + Lava = Blaze!
							if(ModData.ALLOW_BARREL_RECIPE_BLAZE_RODS && item.getItem() == ENItems.DollAngry)
							{
								barrel.setMode(BarrelMode.BLAZE_COOKING);
								useItem(player);
							}
							
							if(Loader.isModLoaded("appliedenergistics2") && item.getItem() == AE2.certusDust)
							{
								barrel.block = AE2.skyStone;
								barrel.setMode(BarrelMode.BLOCK);
								useItem(player);
							}
						}
						
						if (barrel.fluid.fluidID == Fluids.fluidWitchWater.getID())
						{
							//Witch water + Sand = Soul Sand
							if(ModData.ALLOW_BARREL_RECIPE_SOULSAND && item.getItem() == Item.getItemFromBlock(Blocks.sand))
							{
								barrel.setMode(BarrelMode.SOULSAND);
								barrel.resetColor();
								useItem(player);
							}
							
							if(ModData.ALLOW_BARREL_RECIPE_ENDER_PEARLS && item.getItem() == ENItems.DollCreepy)
							{
								barrel.setMode(BarrelMode.ENDER_COOKING);
								useItem(player);
							}
							
							if(ModData.ALLOW_BARREL_RECIPE_DARK_OAK && Block.getBlockFromItem(item.getItem()) == Blocks.sapling && item.getItemDamage() == 0)
							{
								barrel.setMode(BarrelMode.DARKOAK);
								useItem(player);
							}
						}
						
						Fluid seedOil = FluidRegistry.getFluid("seedoil");
						if (seedOil != null && barrel.fluid.fluidID == seedOil.getID() && item.getItem() == Item.getItemFromBlock(ENBlocks.BeeTrap))
						{
							barrel.setMode(BarrelMode.BEETRAP);
							useItem(player);
						}
					}
				}
			}
		}
		//Return true to keep buckets from pouring all over the damn place.
		return true;
	}

	public void useItem(EntityPlayer player)
	{
		if (!player.capabilities.isCreativeMode)
		{

			ItemStack item = player.inventory.mainInventory[player.inventory.currentItem];
			//Special cases
			if (item.getItem() == Items.milk_bucket)
			{
				player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(Items.bucket, 1);
			}
			else if (item.getItem() == Items.mushroom_stew)
			{
				player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(Items.bowl, 1);
			}
			//Generic case
			else
			{
				item.stackSize -= 1;

				if (item.stackSize == 0)
				{
					item = null;
				}
			}
		}
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = Blocks.planks.getIcon(0, 0);
		iconCompost = register.registerIcon(ModData.TEXTURE_LOCATION + ":" + "IconBarrelCompost");
		iconClouds = register.registerIcon(ModData.TEXTURE_LOCATION + ":" + "IconBarrelInternalClouds");
	}

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean hasTileEntity(int meta)
	{
		return true;
	}

	private ItemStack getContainer(ItemStack item)
	{
		if (item.stackSize == 1) {
			if (item.getItem().hasContainerItem(item)) 
			{
				return item.getItem().getContainerItem(item);
			} else 
			{
				return null;
			}
		} else 
		{
			item.splitStack(1);
			return item;
		}
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z)
	{
		TileEntityBarrel te = (TileEntityBarrel) world.getTileEntity(x, y, z);
		
		if (te != null)
		{
			return te.getLightLevel();
		}
		return 0;
	}
}
