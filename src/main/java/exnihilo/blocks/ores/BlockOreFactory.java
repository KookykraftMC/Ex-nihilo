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
    String gravel_name = "IconGravel" + formatName(name);
    
    ResourceLocation baseTexture = TextureDynamic.getTextureLocation("exnihilo", "IconGravelBase");
    ResourceLocation templateTexture = TextureDynamic.getTextureLocation("exnihilo", "IconGravelTemplate");
    
    BlockOre gravel = new BlockOre(gravel_name, baseTexture, templateTexture, color);
    
    gravel
      .setHardness(0.8f)
      .setStepSound(Block.soundTypeGravel)
      .setBlockName(ModData.ID + "." + gravel_name);
    
    return gravel;
  }
  
  private static BlockOre MakeSand(String name, Color color)
  {
    String sand_name = "IconSand" + formatName(name);
    
    ResourceLocation baseTexture = TextureDynamic.getTextureLocation("exnihilo", "IconSandBase");
    ResourceLocation templateTexture = TextureDynamic.getTextureLocation("exnihilo", "IconSandTemplate");
    
    BlockOre sand = new BlockOre(sand_name, baseTexture, templateTexture, color);
    
    sand
      .setHardness(0.6f)
      .setStepSound(Block.soundTypeSand)
      .setBlockName(ModData.ID + "." + sand_name);
    
    return sand;
  }
  
  
  private static BlockOre MakeDust(String name, Color color)
  {
    String dust_name = "IconDust" + formatName(name);
    
    ResourceLocation baseTexture = TextureDynamic.getTextureLocation("exnihilo", "IconDustBase");
    ResourceLocation templateTexture = TextureDynamic.getTextureLocation("exnihilo", "IconDustTemplate");
    
    BlockOre dust = new BlockOre(dust_name, baseTexture, templateTexture, color);
    
    dust
      .setHardness(0.4f)
      .setStepSound(Block.soundTypeSnow)
      .setBlockName(ModData.ID + "." + dust_name);
    
    return dust;
  }
  
  private static String formatName(String input)
  {
    String lcase = input.toLowerCase();
    
    String output = lcase.substring(0, 1).toUpperCase() + lcase.substring(1);
    
    return output;
  }
}
