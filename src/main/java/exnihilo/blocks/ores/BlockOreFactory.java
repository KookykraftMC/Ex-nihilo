package exnihilo.blocks.ores;


import java.util.ArrayList;
import java.util.List;

import exnihilo.data.ModData;
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
    String gravel_name = "ore_gravel_" + name.toLowerCase();
    
    ResourceLocation baseTexture = TextureOre.getTextureLocation("minecraft", "gravel");
    ResourceLocation templateTexture = TextureOre.getTextureLocation("ExNihilo", "testtemplate");
    
    BlockOre gravel = new BlockOre(gravel_name, baseTexture, templateTexture, color);
    
    gravel
      .setHardness(0.8f)
      .setStepSound(Block.soundTypeGravel)
      .setBlockName(ModData.ID + "." + gravel_name);
    
    return gravel;
  }
  
  private static BlockOre MakeSand(String name, Color color)
  {
    String sand_name = "ore_sand_" + name.toLowerCase();
    
    ResourceLocation baseTexture = TextureOre.getTextureLocation("minecraft", "sand");
    ResourceLocation templateTexture = TextureOre.getTextureLocation("ExNihilo", "testtemplate");
    
    BlockOre sand = new BlockOre(sand_name, baseTexture, templateTexture, color);
    
    sand
      .setHardness(0.6f)
      .setStepSound(Block.soundTypeSand)
      .setBlockName(ModData.ID + "." + sand_name);
    
    return sand;
  }
  
  
  private static BlockOre MakeDust(String name, Color color)
  {
    String dust_name = "ore_dust_" + name.toLowerCase();
    
    ResourceLocation baseTexture = TextureOre.getTextureLocation("ExNihilo", "IconBlockDust");
    ResourceLocation templateTexture = TextureOre.getTextureLocation("ExNihilo", "testtemplate");
    
    BlockOre dust = new BlockOre(dust_name, baseTexture, templateTexture, color);
    
    dust
      .setHardness(0.4f)
      .setStepSound(Block.soundTypeSnow)
      .setBlockName(ModData.ID + "." + dust_name);
    
    return dust;
  }
}
