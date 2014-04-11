package exnihilo.blocks.renderers;

import org.lwjgl.opengl.GL11;

import exnihilo.blocks.models.ModelBlock;
import exnihilo.blocks.tileentities.TileEntityLeavesInfested;
import exnihilo.registries.helpers.Color;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;

public class RenderLeaves extends TileEntitySpecialRenderer{
	private ModelBlock model;
	
	public RenderLeaves(ModelBlock model)
	{
		this.model = model;
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) 
	{
		TileEntityLeavesInfested leaves = (TileEntityLeavesInfested) tileentity;
		Block mimic = Block.blocksList[leaves.blockID];
		
		GL11.glPushMatrix();
		GL11.glTranslated(x,y,z);
		
		bindTexture(TextureMap.locationBlocksTexture);
		//int brightness = Block.leaves.getMixedBrightnessForBlock(tileentity.worldObj, tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
		int brightness = leaves.getBrightness();
		Color color = leaves.getRenderColor();
		
		model.render(color, mimic.getIcon(0, leaves.meta), brightness, true);

		GL11.glPopMatrix();
	}
}
