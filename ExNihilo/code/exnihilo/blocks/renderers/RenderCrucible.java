package exnihilo.blocks.renderers;

import org.lwjgl.opengl.GL11;

import exnihilo.blocks.models.ModelCrucible;
import exnihilo.blocks.models.ModelCrucibleInternal;
import exnihilo.blocks.tileentities.TileEntityBarrel;
import exnihilo.blocks.tileentities.TileEntityCrucible;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.helpers.Color;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class RenderCrucible extends TileEntitySpecialRenderer{
	private ModelCrucible model;
	private ModelCrucibleInternal internal;
	
	public RenderCrucible(ModelCrucible model)
	{
		this.model = model;
		this.internal = new ModelCrucibleInternal();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		drawCrucible(tileentity, x, y, z, f);
		drawContents(tileentity, x, y, z, f);
	}

	
	private void drawCrucible(TileEntity tileentity, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F,(float)y + 1.5F,(float)z + 0.5F);
		GL11.glScalef(-1.0F, -1F, 1.0F);
		
		bindCrucibleTexture();
		model.simpleRender(0.0625F);
		
		GL11.glPopMatrix();
	}
	
	private void drawContents(TileEntity tileentity, double x, double y, double z, float f)
	{
		TileEntityCrucible crucible = (TileEntityCrucible)tileentity;
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F,(float)y + crucible.getAdjustedVolume(),(float)z + 0.5F);
		GL11.glScalef(0.92f, 1.0f, 0.92f);
		
		bindInternalTexture();
		
		if (crucible.hasSolids() && !crucible.renderFluid())
		{
			renderSolid(tileentity);
		}
		else
		{
			switch (crucible.mode)
			{
			case EMPTY:
				//don't render
				break;

			case USED:
				renderFluid(tileentity);
				break;

			default:
				break;
			}
		}
		
		
		GL11.glPopMatrix();
	}
	
	private void renderSolid(TileEntity tileentity)
	{
		TileEntityCrucible crucible = (TileEntityCrucible)tileentity;
		
		Icon icon = crucible.getContentIcon();
		Color color = ColorRegistry.color("white");
		internal.render(color, icon, false);
	}
	
	private void renderFluid(TileEntity tileentity)
	{
		TileEntityCrucible crucible = (TileEntityCrucible)tileentity;
		
		Fluid content = crucible.fluid.getFluid();
		Icon icon = content.getIcon();
		Color color = new Color(content.getColor());
		internal.render(color, icon, true);
	}
	
	
	
	public void bindCrucibleTexture()
	{
		bindTexture(model.textures[0]);
	}
	
	public void bindInternalTexture()
	{
		ResourceLocation fluidTexture = TextureMap.locationBlocksTexture;
		bindTexture(fluidTexture);
	}
}
