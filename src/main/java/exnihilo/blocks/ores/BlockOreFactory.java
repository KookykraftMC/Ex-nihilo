package exnihilo.blocks.ores;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.data.ModData;
import exnihilo.images.Resource;
import exnihilo.images.TextureFactory;
import exnihilo.proxies.Proxy;
import exnihilo.registries.helpers.Color;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

public class BlockOreFactory
{
  public static BlockOre[] MakeOverworldOres(String name, Color color)
  {
    List<BlockOre> blocks = new ArrayList<BlockOre>();
    
    //Make gravel;
    BlockOre gravel = MakeOverworldGravel(name, color);
    blocks.add(gravel);
    
    //Make sand;
    BlockOre sand = MakeSand(name, color);
    blocks.add(sand);
    
    //Make dust;
    BlockOre dust = MakeDust(name, color);
    blocks.add(dust);
    
    BlockOre[] blockArray = new BlockOre[blocks.size()];
    blocks.toArray(blockArray);
    
    return blocks.toArray(blockArray);
  }
  
  public static BlockOre MakeOverworldGravel(String name, Color color)
  {
    String texture_name = "IconGravel" + formatName(name);
    String block_name = name.toLowerCase() + "_gravel";
    
    BlockOre gravel = new BlockOre(block_name);
    
    ResourceLocation baseTexture = Resource.getBlockTextureLocation("exnihilo", "IconGravelBase");
    ResourceLocation templateTexture = Resource.getBlockTextureLocation("exnihilo", "IconGravelTemplate"); 
    
    if (!Proxy.runningOnServer())
    {
      attachTexture(gravel, texture_name, baseTexture, templateTexture, color);
    }
    
    gravel
      .setHardness(0.8f)
      .setStepSound(Block.soundTypeGravel)
      .setBlockName(ModData.ID + "." + block_name);
    
    return gravel;
  }
  
  public static BlockOre MakeSand(String name, Color color)
  {
    String texture_name = "IconSand" + formatName(name);
    String block_name = name.toLowerCase() + "_sand";

    BlockOre sand = new BlockOre(block_name);
    
    ResourceLocation baseTexture = Resource.getBlockTextureLocation("exnihilo", "IconSandBase");
    ResourceLocation templateTexture = Resource.getBlockTextureLocation("exnihilo", "IconSandTemplate");
    
    if (!Proxy.runningOnServer())
    {
      attachTexture(sand, texture_name, baseTexture, templateTexture, color);
    }
    sand
      .setHardness(0.6f)
      .setStepSound(Block.soundTypeSand)
      .setBlockName(ModData.ID + "." + block_name);
    
    return sand;
  }
  
  public static BlockOre MakeDust(String name, Color color)
  {
    String texture_name = "IconDust" + formatName(name);
    String block_name = name.toLowerCase() + "_dust";
    
    BlockOre dust = new BlockOre(block_name);

    ResourceLocation baseTexture = Resource.getBlockTextureLocation("exnihilo", "IconDustBase");
    ResourceLocation templateTexture = Resource.getBlockTextureLocation("exnihilo", "IconDustTemplate");
    
    if (!Proxy.runningOnServer())
    {
      attachTexture(dust, texture_name, baseTexture, templateTexture, color);
    }
    
    dust
      .setHardness(0.4f)
      .setStepSound(Block.soundTypeSnow)
      .setBlockName(ModData.ID + "." + block_name);
    
    return dust;
  }
  
  @SideOnly(Side.CLIENT)
  private static void attachTexture(BlockOre block, String name, ResourceLocation base, ResourceLocation template, Color color)
  {
    TextureFactory.makeTexture(block, name, base, template, color);
  }
  
  private static String formatName(String input)
  {
    String lcase = input.toLowerCase();
    
    String output = lcase.substring(0, 1).toUpperCase() + lcase.substring(1);
    
    return output;
  }
}
