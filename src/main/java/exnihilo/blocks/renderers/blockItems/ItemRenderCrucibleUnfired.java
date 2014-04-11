package exnihilo.blocks.renderers.blockItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

import org.lwjgl.opengl.GL11;

import exnihilo.blocks.models.ModelCrucible;
import exnihilo.blocks.models.ModelCrucibleRaw;

public class ItemRenderCrucibleUnfired implements IItemRenderer{
	private ModelCrucibleRaw model;

	public ItemRenderCrucibleUnfired(ModelCrucibleRaw model)
	{
		this.model = model;
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type)
		{
		case ENTITY:
			break;
		case EQUIPPED:
			break;
		case EQUIPPED_FIRST_PERSON:
			break;
		case FIRST_PERSON_MAP:
			return false;
		case INVENTORY:
			break;
		}
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		switch (type)
		{
		case ENTITY:
			break;
		case EQUIPPED:
			break;
		case EQUIPPED_FIRST_PERSON:
			break;
		case FIRST_PERSON_MAP:
			return false;
		case INVENTORY:
			break;
		}
		
		switch (helper)
		{
		case BLOCK_3D:
			break;
		case ENTITY_BOBBING:
			break;
		case ENTITY_ROTATION:
			break;
		case EQUIPPED_BLOCK:
			break;
		case INVENTORY_BLOCK:
			break;
		default:
			break;
		
		}
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		renderCrucible(type, item);
	}
	
	private void renderCrucible(ItemRenderType type, ItemStack item)
	{
		GL11.glPushMatrix();
		GL11.glScalef(-1F, -1F, 1F);

		switch (type)
		{
		case EQUIPPED:
			GL11.glTranslatef(-0.5F, -1.5F, 0.5F);
			break;
		
		case EQUIPPED_FIRST_PERSON:
			GL11.glTranslatef(0F, -1.6F, 0.6F);
			break;
			
		case ENTITY:
			GL11.glTranslatef(0F, -1.0F, 0F);
			break;
			
		case INVENTORY:
			GL11.glTranslatef(0F, -1.0F, 0F);
			break;
			
		default:
			GL11.glTranslatef(0F, 0F, 0F);
			break;
		}
		
		bindTexture();
		model.simpleRender(0.0625F);
		
		GL11.glPopMatrix();
	}
	
	protected void bindTexture()
    {
        TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();

        if (texturemanager != null)
        {
    		texturemanager.bindTexture(model.textures[0]);
        }
    }
}
