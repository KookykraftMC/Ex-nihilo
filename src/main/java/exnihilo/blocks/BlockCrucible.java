package exnihilo.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.blocks.tileentities.TileEntityBarrel;
import exnihilo.blocks.tileentities.TileEntityCrucible;
import exnihilo.blocks.tileentities.TileEntityBarrel.BarrelMode;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;
import exnihilo.registries.CompostRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class BlockCrucible extends BlockContainer{

	public BlockCrucible(int id) {
		super(id, Material.rock);

		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(2.0f);

		setUnlocalizedName(ModData.ID + "." + BlockData.CRUCIBLE_KEY);
		GameRegistry.registerTileEntity(TileEntityCrucible.class, this.getUnlocalizedName());
	}


	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = Block.stone.getIcon(0, 0);
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

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityCrucible();
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z)
	{
		TileEntityCrucible te = (TileEntityCrucible) world.getBlockTileEntity(x, y, z);
		return te.getLightLevel();
	}


	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		if (player == null)
		{
			return false;
		}
		else
		{
			TileEntityCrucible crucible = (TileEntityCrucible) world.getBlockTileEntity(x, y, z);

			if (player.getCurrentEquippedItem() != null)
			{
				ItemStack item = player.getCurrentEquippedItem();
				if (item!=null)
				{
					if (crucible.addItem(item) && !player.capabilities.isCreativeMode)
					{
						item.stackSize -= 1;
						if (item.stackSize == 0)
						{
							item = null;
						}
					}
				}

				FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(item);
				//FILL
				if (fluid != null)
				{

					int capacity = crucible.fill(ForgeDirection.UP, fluid, false);

					if(capacity > 0) //&& fluid.fluidID == FluidRegistry.WATER.getID())
					{
						crucible.fill(ForgeDirection.UP, fluid, true);

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
					FluidStack available = crucible.drain(ForgeDirection.DOWN, Integer.MAX_VALUE, false);
					if (available != null)
					{
						ItemStack filled = FluidContainerRegistry.fillFluidContainer(available, item);
						if (filled != null)
						{
							FluidStack liquid = FluidContainerRegistry.getFluidForFilledItem(filled);
							if (liquid != null) {

								if (item.stackSize > 1) {
									boolean added = player.inventory.addItemStackToInventory(filled);

									if (!added) {
										return false;
									} else {
										item.stackSize -= 1;
									}

								} else {
									player.inventory.setInventorySlotContents(player.inventory.currentItem, filled);
								}

								crucible.drain(ForgeDirection.DOWN, liquid.amount, true);
								return true;
							}
						}
					}
				}
			}
			//Return true to keep buckets from pouring all over the damn place.
			return true;
		}
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
}
