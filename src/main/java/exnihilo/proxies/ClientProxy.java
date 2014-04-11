package exnihilo.proxies;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import exnihilo.ENItems;
import exnihilo.blocks.models.ModelBarrel;
import exnihilo.blocks.models.ModelBlock;
import exnihilo.blocks.models.ModelCrucible;
import exnihilo.blocks.models.ModelCrucibleRaw;
import exnihilo.blocks.models.ModelSieve;
import exnihilo.blocks.models.ModelSieveMesh;
import exnihilo.blocks.renderers.RenderBarrel;
import exnihilo.blocks.renderers.RenderCrucible;
import exnihilo.blocks.renderers.RenderCrucibleUnfired;
import exnihilo.blocks.renderers.RenderLeaves;
import exnihilo.blocks.renderers.RenderSieve;
import exnihilo.blocks.renderers.blockItems.ItemRenderBarrel;
import exnihilo.blocks.renderers.blockItems.ItemRenderCrucible;
import exnihilo.blocks.renderers.blockItems.ItemRenderCrucibleUnfired;
import exnihilo.blocks.renderers.blockItems.ItemRenderLeaves;
import exnihilo.blocks.renderers.blockItems.ItemRenderSieve;
import exnihilo.blocks.tileentities.TileEntityBarrel;
import exnihilo.blocks.tileentities.TileEntityCrucible;
import exnihilo.blocks.tileentities.TileEntityCrucibleUnfired;
import exnihilo.blocks.tileentities.TileEntityLeavesInfested;
import exnihilo.blocks.tileentities.TileEntitySieve;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;
import exnihilo.entities.EntityStone;
import exnihilo.items.ItemStone;

public class ClientProxy extends Proxy {

	@Override
	public void initializeSounds() {
		// TODO Initialize sounds!
	}

	@Override
	public void initializeRenderers() {

		ModelBarrel barrel = new ModelBarrel();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrel.class, new RenderBarrel(barrel));
		MinecraftForgeClient.registerItemRenderer(BlockData.BARREL_ID, new ItemRenderBarrel(barrel));
		MinecraftForgeClient.registerItemRenderer(BlockData.BARREL_STONE_ID, new ItemRenderBarrel(barrel));

		ModelBlock block = new ModelBlock();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLeavesInfested.class, new RenderLeaves(block));
		MinecraftForgeClient.registerItemRenderer(BlockData.LEAVES_INFESTED_ID, new ItemRenderLeaves(block));

		ModelSieve sieve = new ModelSieve();
		ModelSieveMesh mesh = new ModelSieveMesh();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySieve.class, new RenderSieve(sieve, mesh));
		MinecraftForgeClient.registerItemRenderer(BlockData.SIEVE_ID, new ItemRenderSieve(sieve, mesh));

		ModelCrucible crucible = new ModelCrucible();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrucible.class, new RenderCrucible(crucible));
		MinecraftForgeClient.registerItemRenderer(BlockData.CRUCIBLE_ID, new ItemRenderCrucible(crucible));

		ModelCrucibleRaw crucibleRaw = new ModelCrucibleRaw();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrucibleUnfired.class, new RenderCrucibleUnfired(crucibleRaw));
		MinecraftForgeClient.registerItemRenderer(BlockData.CRUCIBLE_UNFIRED_ID, new ItemRenderCrucibleUnfired(crucibleRaw));

		RenderingRegistry.registerEntityRenderingHandler(EntityStone.class, new RenderSnowball(ENItems.Stones));
	}

}
