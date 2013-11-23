package exnihilo.blocks;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.ExNihilo;
import exnihilo.Fluids;
import exnihilo.Items;
import exnihilo.blocks.tileentities.TileEntityBarrel;
import exnihilo.blocks.tileentities.TileEntityBarrel.BarrelMode;
import exnihilo.blocks.tileentities.TileEntityBarrel.ExtractMode;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;
import exnihilo.registries.CompostRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class BlockBarrel extends BlockContainer
{
	@SideOnly(Side.CLIENT)
	public static Icon iconCompost;
	public static Icon iconClouds;

	public BlockBarrel(int id) {
		super(id, Material.wood);
		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(2.0f);
		setBurnProperties(this.blockID, 5,150);

		setUnlocalizedName(ModData.ID + "." + BlockData.BARREL_KEY);
		GameRegistry.registerTileEntity(TileEntityBarrel.class, this.getUnlocalizedName());
	}

	public BlockBarrel(int id, Material material) {
		super(id, material);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(int id, CreativeTabs tabs, List subItems) {
		for (int i = 0; i < 4; i++) {
			subItems.add(new ItemStack(id, 1, i));
		}
	}

	@Override
	public int damageDropped (int metadata) {
		return metadata;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityBarrel();
	}

	@Override
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

		TileEntityBarrel barrel = (TileEntityBarrel) world.getBlockTileEntity(x, y, z);

		if (barrel.mode.canExtract == ExtractMode.Always || (world.difficultySetting == 0 && barrel.mode.canExtract == ExtractMode.PeacefulOnly))
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
					if (barrel.mode == BarrelMode.EMPTY || barrel.mode == BarrelMode.COMPOST && !barrel.isFull())
					{
						if (CompostRegistry.containsItem(item.itemID, item.getItemDamage()))
						{
							barrel.addCompostItem(CompostRegistry.getItem(item.itemID, item.getItemDamage()));

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
				if (barrel.mode == BarrelMode.EMPTY || barrel.mode == BarrelMode.FLUID)
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
								if (item.itemID == Item.potion.itemID && item.getItemDamage() == 0)
								{
									player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Item.glassBottle, 1, 0));
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

				//BARREL RECIPES!
				if (item!= null)
				{
					if (barrel.mode == BarrelMode.FLUID && barrel.isFull())
					{
						if (barrel.fluid.fluidID == FluidRegistry.WATER.getID())
						{
							//Dust turns water into clay!
							if(ModData.ALLOW_BARREL_RECIPE_CLAY && item.itemID == BlockData.DUST_ID)
							{
								barrel.mode = BarrelMode.CLAY;
								useItem(player);
							}

							//Milk + Water = Slime!
							if(ModData.ALLOW_BARREL_RECIPE_SLIME && item.itemID == Item.bucketMilk.itemID)
							{
								barrel.mode = BarrelMode.MILKED;
								useItem(player);
							}

							//Mushroom stew + Water = Witch Water!
							if(ModData.ALLOW_BARREL_RECIPE_SOULSAND && (item.itemID == Item.bowlSoup.itemID || item.itemID == Items.Spores.itemID))
							{
								barrel.mode = BarrelMode.SPORED;
								useItem(player);
							}

						} else if (barrel.fluid.fluidID == FluidRegistry.LAVA.getID())
						{
							//Redstone + Lava = Netherrack
							if(ModData.ALLOW_BARREL_RECIPE_NETHERRACK && item.itemID == Item.redstone.itemID)
							{
								barrel.mode = BarrelMode.NETHERRACK;
								useItem(player);
							}

							//Glowstone + Lava = End Stone
							if(ModData.ALLOW_BARREL_RECIPE_ENDSTONE && item.itemID == Item.glowstone.itemID)
							{
								barrel.mode = BarrelMode.ENDSTONE;
								useItem(player);
							}
							
							//Angry doll + Lava = Blaze!
							if(ModData.ALLOW_BARREL_RECIPE_BLAZE_RODS && (item.itemID == Items.DollAngry.itemID))
							{
								barrel.mode = BarrelMode.BLAZE_COOKING;
								useItem(player);
							}
						}else if (barrel.fluid.fluidID == Fluids.fluidWitchWater.getID())
						{
							//Witch water + Sand = Soul Sand
							if(ModData.ALLOW_BARREL_RECIPE_SOULSAND && item.itemID == Block.sand.blockID)
							{
								barrel.mode = BarrelMode.SOULSAND;
								barrel.resetColor();
								useItem(player);
							}
							
							if(ModData.ALLOW_BARREL_RECIPE_ENDER_PEARLS && item.itemID == Items.DollCreepy.itemID)
							{
								barrel.mode = BarrelMode.ENDER_COOKING;
								useItem(player);
							}
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
			if (item.itemID == Item.bucketMilk.itemID)
			{
				player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(Item.bucketEmpty, 1);
			}
			else if (item.itemID == Item.bowlSoup.itemID)
			{
				player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(Item.bowlEmpty, 1);
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
	public void registerIcons(IconRegister register)
	{
		blockIcon = Block.wood.getIcon(0, 0);
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
	public boolean hasTileEntity()
	{
		return true;
	}

	private ItemStack getContainer(ItemStack item)
	{
		if (item.stackSize == 1) {
			if (item.getItem().hasContainerItem()) 
			{
				return item.getItem().getContainerItemStack(item);
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
		TileEntityBarrel te = (TileEntityBarrel) world.getBlockTileEntity(x, y, z);
		return te.getLightLevel();
	}
}
