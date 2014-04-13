package exnihilo.blocks.renderers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import exnihilo.blocks.models.ModelBlock;
import exnihilo.blocks.tileentities.TileEntityLeavesInfested;
import exnihilo.registries.helpers.Color;

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
		Block mimic = Blocks.leaves;
		
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
