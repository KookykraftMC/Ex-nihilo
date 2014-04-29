package exnihilo.compatibility;

import java.text.DecimalFormat;
import java.util.List;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.item.ItemStack;
import exnihilo.blocks.BlockBarrel;
import exnihilo.blocks.BlockCrucible;
import exnihilo.blocks.BlockLeavesInfested;
import exnihilo.blocks.BlockSieve;
import exnihilo.blocks.tileentities.TileEntityBarrel;
import exnihilo.blocks.tileentities.TileEntityBarrel.BarrelMode;
import exnihilo.blocks.tileentities.TileEntityCrucible;
import exnihilo.blocks.tileentities.TileEntityLeavesInfested;
import exnihilo.blocks.tileentities.TileEntitySieve;
import exnihilo.blocks.tileentities.TileEntitySieve.SieveMode;

public class Waila implements IWailaDataProvider {

	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return null;
	}

	@Override
	public List<String> getWailaHead(ItemStack stack, List<String> currentTip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return currentTip;
	}

	@Override
	public List<String> getWailaBody(ItemStack stack, List<String> currentTip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		if(accessor.getBlock() instanceof BlockBarrel){
			TileEntityBarrel teBarrel = (TileEntityBarrel)accessor.getTileEntity();
			currentTip.add(getBarrelDisplay(teBarrel.getMode(), teBarrel));
		}else if(accessor.getBlock() instanceof BlockLeavesInfested) {
			TileEntityLeavesInfested teLeaves = (TileEntityLeavesInfested)accessor.getTileEntity();
			currentTip.add(getLeavesDisplay(teLeaves));
		}else if(accessor.getBlock() instanceof BlockSieve){
			TileEntitySieve teSieve = (TileEntitySieve)accessor.getTileEntity();
			currentTip.add(getSieveDisplay(teSieve));
		}else if(accessor.getBlock() instanceof BlockCrucible){
			TileEntityCrucible teCrucible = (TileEntityCrucible)accessor.getTileEntity();
			currentTip.add(getCrucibleDisplay(teCrucible));
		}
		return currentTip;
	}

	@Override
	public List<String> getWailaTail(ItemStack stack, List<String> currentTip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return currentTip;
	}
	
	public String getBarrelDisplay(BarrelMode mode, TileEntityBarrel barrel) {
		DecimalFormat format = new DecimalFormat("##.#");
		switch(mode){
			case EMPTY:
				return "Empty";
			case FLUID:
				if(barrel.isFull())
					return barrel.fluid.getFluid().getLocalizedName();
				else
					return barrel.fluid.getFluid().getLocalizedName() + " " + format.format(barrel.getVolume() * 100) + "%";
			case COMPOST:
				if(barrel.isFull())
					return "Composting: " + Math.round(getBarrelTimeRemaining(barrel)) + "%";
				else
					return "Collecting Material: " + format.format(barrel.getVolume() * 100) + "%";
			case DIRT:
				return "Dirt";
			case MILKED:
				return "Sliming: " + Math.round(getBarrelTimeRemaining(barrel)) + "%";
			case SLIME:
				return "Slime";
			case SPORED:
				return "Transforming: " + Math.round(getBarrelTimeRemaining(barrel)) + "%";
			case ENDER_COOKING:
			case BLAZE_COOKING:
				return "Summoning: " + Math.round(getBarrelTimeRemaining(barrel)) + "%";
			case ENDER:
			case BLAZE:
				return "Incoming!";
			default:
				return "";
		}
	}
	
	public String getLeavesDisplay(TileEntityLeavesInfested leaves) {
		if(leaves.getProgress() >= 1.0F)
			return "Infested";
		else
			return "Infesting: " + Math.round(getLeavesTimeRemaining(leaves)) + "%";
	}
	
	public String getSieveDisplay(TileEntitySieve sieve) {
		if(sieve.mode == SieveMode.EMPTY)
			return "Empty";
		else
			return Math.round(getSieveClicksRemaining(sieve)) + "% left";
	}
	
	public String getCrucibleDisplay(TileEntityCrucible crucible) {
		return "Melting Speed: " + (crucible.getMeltSpeed() * 10) + "x";
	}
	
	public float getBarrelTimeRemaining(TileEntityBarrel barrel) {
		return (barrel.getTimer() / (float)1000) * 100;
	}
	
	public float getLeavesTimeRemaining(TileEntityLeavesInfested leaves) {
		return (leaves.getProgress() / 1) * 100;
	}
	
	public float getSieveClicksRemaining(TileEntitySieve sieve) {
		return (sieve.getVolume() / 1) * 100;
	}

	public static void callbackRegister(IWailaRegistrar registrar) {
		Waila instance = new Waila();
		registrar.registerBodyProvider(instance, BlockBarrel.class);
		registrar.registerBodyProvider(instance, BlockLeavesInfested.class);
		registrar.registerBodyProvider(instance, BlockSieve.class);
		registrar.registerBodyProvider(instance, BlockCrucible.class);
	}
}
