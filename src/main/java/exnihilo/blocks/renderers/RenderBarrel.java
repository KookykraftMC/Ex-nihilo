package exnihilo.blocks.renderers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

import org.lwjgl.opengl.GL11;

import exnihilo.blocks.BlockBarrel;
import exnihilo.blocks.BlockBeeTrapTreated;
import exnihilo.blocks.models.ModelBarrel;
import exnihilo.blocks.models.ModelBarrelInternal;
import exnihilo.blocks.tileentities.TileEntityBarrel;
import exnihilo.blocks.tileentities.TileEntityBarrel.BarrelMode;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.helpers.Color;

public class RenderBarrel extends TileEntitySpecialRenderer{
	private ModelBarrel barrel;
	private ModelBarrelInternal internal;

	public RenderBarrel(ModelBarrel model)
	{
		this.barrel = model;
		internal = new ModelBarrelInternal();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) 
	{
		drawBarrel(tileentity, x, y, z, f);
		drawBarrelContents(tileentity, x, y, z, f);
	}


	private void drawBarrel(TileEntity tileentity, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F,(float)y + 1.5F,(float)z + 0.5F);
		GL11.glScalef(-0.8F, -1F, 0.8F);

		bindBarrelTexture(tileentity.getBlockType(), tileentity.getBlockMetadata());
		barrel.simpleRender(0.0625F);

		GL11.glPopMatrix();
	}

	private void drawBarrelContents(TileEntity tileentity, double x, double y, double z, float f)
	{
		TileEntityBarrel barrel = (TileEntityBarrel)tileentity;

		if (barrel.mode != BarrelMode.EMPTY)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.5F,(float)y + barrel.getAdjustedVolume(),(float)z + 0.5F);
			GL11.glScalef(0.8f, 1.0f, 0.8f);

			bindInternalTexture();

			Fluid content = barrel.fluid.getFluid();
			IIcon icon = content.getIcon();
			Color color = barrel.color;
			boolean transparency = false;
			boolean clouds = false;
			boolean trap = false;

			switch (barrel.mode)
			{
			case COMPOST:
				icon = BlockBarrel.iconCompost;
				break;

			case FLUID:
				color = new Color(content.getColor());
				transparency = true;
				break;

			case DIRT:
				icon = Blocks.dirt.getIcon(0, 0);
				break;

			case CLAY:
				icon = Blocks.clay.getIcon(0, 0);
				break;

			case SPORED:
				clouds = true;
				transparency = true;
				break;	

			case SLIME:
				clouds = true;
				transparency = true;
				break;

			case NETHERRACK:
				icon = Blocks.netherrack.getIcon(0, 0);
				break;

			case ENDSTONE:
				icon = Blocks.end_stone.getIcon(0, 0);
				break;

			case MILKED:
				transparency = true;
				clouds = true;
				break;

			case BEETRAP: 
				transparency = true;
				trap = true;
				break;

			case SOULSAND:
				icon = Blocks.soul_sand.getIcon(0, 0);
				break;
				
			case OBSIDIAN:
				icon = Blocks.obsidian.getIcon(0, 0);
				break;
				
			case COBBLESTONE:
				icon = Blocks.cobblestone.getIcon(0, 0);
				break;
				
			case BLAZE_COOKING:
				color = new Color(content.getColor());
				transparency = true;
				break;
				
			case BLAZE:
				color = new Color(content.getColor());
				transparency = true;
				break;
				
			case ENDER_COOKING:
				color = new Color(content.getColor());
				transparency = true;
				break;
				
			case ENDER:
				color = new Color(content.getColor());
				transparency = true;
				break;
				
			default:
				break;
			}

			
			
			if (clouds)
			{
				GL11.glTranslatef(0,-0.0001f,0);
				internal.render(ColorRegistry.color("black"), BlockBarrel.iconClouds, transparency);
				GL11.glTranslatef(0,0.0001f,0);
			}
			
			if (trap)
			{
				GL11.glTranslatef(0,-0.05f,0);
				internal.render(ColorRegistry.color("white"), BlockBeeTrapTreated.topIcon, false);
				GL11.glTranslatef(0,0.05f,0);
			}

			internal.render(color, icon, transparency);
			
			GL11.glPopMatrix();
		}


	}

	public void bindBarrelTexture(Block block, int meta)
	{
		if (meta >= 0)
		{
			bindTexture(barrel.getBarrelTexture(block, meta));
		}
	}

	public void bindInternalTexture()
	{
		ResourceLocation fluidTexture = TextureMap.locationBlocksTexture;
		bindTexture(fluidTexture);
	}
}
