package exnihilo.blocks;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.Blocks;
import exnihilo.blocks.tileentities.TileEntityBarrel;
import exnihilo.blocks.tileentities.TileEntitySieve;
import exnihilo.blocks.tileentities.TileEntityBarrel.BarrelMode;
import exnihilo.blocks.tileentities.TileEntitySieve.SieveMode;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockSieve extends BlockContainer{
	public static Icon meshIcon;
	
	public BlockSieve(int id) {
		super(id, Material.wood);
		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(2.0f);
		setBurnProperties(this.blockID, 5,150);
		
		setUnlocalizedName(ModData.ID + "." + BlockData.SIEVE_KEY);
		GameRegistry.registerTileEntity(TileEntitySieve.class, this.getUnlocalizedName());
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.blockIcon = Block.planks.getIcon(0,0);
		meshIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":" + "IconSieveMesh");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(int id, CreativeTabs tabs, List subItems) {
		for (int i = 0; i < 4; i++) {
			subItems.add(new ItemStack(id, 1, i));
		}
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
	public int damageDropped (int metadata) {
		return metadata;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntitySieve();
	}


	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		if (player == null)
		{
			return false;
		}

		TileEntitySieve sieve = (TileEntitySieve) world.getBlockTileEntity(x, y, z);

		if (sieve.mode == SieveMode.EMPTY && player.getCurrentEquippedItem() != null)
		{
			if (player.getCurrentEquippedItem().itemID == Block.dirt.blockID)
			{
				sieve.AddDirt();
				removeCurrentItem(player);
			}
			
			if (player.getCurrentEquippedItem().itemID == Block.gravel.blockID)
			{
				sieve.AddGravel();
				removeCurrentItem(player);
			}
			
			if (player.getCurrentEquippedItem().itemID == Block.sand.blockID)
			{
				sieve.AddSand();
				removeCurrentItem(player);
			}
			
			if (player.getCurrentEquippedItem().itemID == Block.slowSand.blockID)
			{
				sieve.AddSoulSand();
				removeCurrentItem(player);
			}
			
			if (player.getCurrentEquippedItem().itemID == Blocks.Dust.blockID)
			{
				sieve.AddDust();
				removeCurrentItem(player);
			}
			
			
		}else
		{
			if (sieve.mode != SieveMode.EMPTY)
			{
				if(!(player instanceof EntityPlayerMP))
				{
					sieve.ProcessContents(false);
				}				
			}
		}

		return true;
	}
	
	private void removeCurrentItem(EntityPlayer player)
	{
		ItemStack item = player.getCurrentEquippedItem();

		if (!player.capabilities.isCreativeMode)
		{
			item.stackSize -= 1;
			if (item.stackSize == 0)
			{
				item = null;
			}
		}

	}
}
