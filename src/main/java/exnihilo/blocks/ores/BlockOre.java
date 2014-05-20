package exnihilo.blocks.ores;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.data.ModData;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockOre
    extends BlockSand
{
  private String name;
  private IIcon icon;
  private TextureAtlasSprite texture;
  
  public BlockOre(String name)
  {
    super();
    this.name = name;
  }
  
  @SideOnly(Side.CLIENT)
  public void setTexture(TextureAtlasSprite texture)
  {
    this.texture = texture;
  }

  @SuppressWarnings({
      "unchecked", "rawtypes"
  })
  @Override
  public void getSubBlocks(Item item, CreativeTabs tabs, List items)
  {
    items.add(new ItemStack(item, 1, 0));
  }

  @SideOnly(Side.CLIENT)
  @Override
  public void registerBlockIcons(IIconRegister register)
  {
    if(this.texture != null)
    {
      TextureMap map = (TextureMap) register;

      TextureAtlasSprite existing = map.getTextureExtry(texture.getIconName());
      if (existing == null)
      {
        boolean success = map.setTextureEntry(texture.getIconName(), texture);
        if (success)
        {
          //System.out.println("Registered icon successfully: " + texture.getIconName());
          this.icon = map.getTextureExtry(texture.getIconName());
        }
      }
    }
  }

  @SideOnly(Side.CLIENT)
  @Override
  public IIcon getIcon(int id, int meta)
  {
    if (this.icon != null)
    {
      return this.icon;
    }

    return Blocks.stone.getIcon(id, meta);
  }
  
  @Override
  public String getUnlocalizedName()
  {
    return ModData.ID + "." + name;
  }

  public String getName()
  {
    return name;
  }
}
