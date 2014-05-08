package exnihilo.blocks.ores;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockOre extends BlockSand
{
  private String name;
  private TextureOre texture;
  
  public BlockOre(String name, TextureOre texture)
  {
    super();
    this.name = name;
    this.texture = texture;
  }
  
  @SuppressWarnings({
      "unchecked", "rawtypes"
  })
  @Override
  @SideOnly(Side.CLIENT)
  public void getSubBlocks(Item item, CreativeTabs tabs, List items)
  {
    items.add(new ItemStack(item, 1, 0));
  }
  
  @Override
  public void registerBlockIcons(IIconRegister register)
  {
    if (this.texture != null)
    {
      TextureMap map = (TextureMap) register;
      
      map.setTextureEntry(TextureOre.getTextureName(name), texture);
    }
  }
  
  @SideOnly(Side.CLIENT)
  @Override
   public IIcon getIcon(int id, int meta)
  {
    if (this.texture != null)
    {
      return (IIcon)texture;
    }
    
    return Blocks.stone.getIcon(id, meta);
  }
  
  public String getName()
  {
    return name;
  }
}
