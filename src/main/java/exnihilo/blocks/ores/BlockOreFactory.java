package exnihilo.blocks.ores;


import java.util.ArrayList;
import java.util.List;

import exnihilo.data.ModData;
import exnihilo.images.TextureDynamic;
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
  
  private static BlockOre MakeOverworldGravel(String name, Color color)
  {
    String texture_name = "IconGravel" + formatName(name);
    String block_name = "ore_gravel_" + name.toLowerCase();
    
    ResourceLocation baseTexture = TextureDynamic.getBlockTextureLocation("exnihilo", "IconGravelBase");
    ResourceLocation templateTexture = TextureDynamic.getBlockTextureLocation("exnihilo", "IconGravelTemplate");
    
    TextureDynamic texture = new TextureDynamic(texture_name, baseTexture, templateTexture, color);
    BlockOre gravel = new BlockOre(block_name, texture);
    
    gravel
      .setHardness(0.8f)
      .setStepSound(Block.soundTypeGravel)
      .setBlockName(ModData.ID + "." + block_name);
    
    return gravel;
  }
  
  private static BlockOre MakeSand(String name, Color color)
  {
    String texture_name = "IconSand" + formatName(name);
    String block_name = "ore_sand_" + name.toLowerCase();
    
    ResourceLocation baseTexture = TextureDynamic.getBlockTextureLocation("exnihilo", "IconSandBase");
    ResourceLocation templateTexture = TextureDynamic.getBlockTextureLocation("exnihilo", "IconSandTemplate");
    
    TextureDynamic texture = new TextureDynamic(texture_name, baseTexture, templateTexture, color);
    BlockOre sand = new BlockOre(block_name, texture);
    
    sand
      .setHardness(0.6f)
      .setStepSound(Block.soundTypeSand)
      .setBlockName(ModData.ID + "." + block_name);
    
    return sand;
  }
  
  
  private static BlockOre MakeDust(String name, Color color)
  {
    String texture_name = "IconDust" + formatName(name);
    String block_name = "ore_dust_" + name.toLowerCase();
    
    ResourceLocation baseTexture = TextureDynamic.getBlockTextureLocation("exnihilo", "IconDustBase");
    ResourceLocation templateTexture = TextureDynamic.getBlockTextureLocation("exnihilo", "IconDustTemplate");
    
    TextureDynamic texture = new TextureDynamic(texture_name, baseTexture, templateTexture, color);
    BlockOre dust = new BlockOre(block_name, texture);
    
    dust
      .setHardness(0.4f)
      .setStepSound(Block.soundTypeSnow)
      .setBlockName(ModData.ID + "." + block_name);
    
    return dust;
  }
  
  private static String formatName(String input)
  {
    String lcase = input.toLowerCase();
    
    String output = lcase.substring(0, 1).toUpperCase() + lcase.substring(1);
    
    return output;
  }
}
