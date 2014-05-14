package exnihilo.blocks;

import java.util.List;

import net.minecraft.block.BlockGravel;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.data.ModData;

public class BlockEnderGravel extends BlockGravel {

  public BlockEnderGravel() {
    super();
    setHardness(0.6f);
    setStepSound(soundTypeGravel);
  }

  @Override
  public String getUnlocalizedName()
  {
    return ModData.ID + ".gravel_ender";
  }
  
  @Override
  public void registerBlockIcons(IIconRegister register)
  {
    this.blockIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconEnderGravel");
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
  
  @SideOnly(Side.CLIENT)
  @Override
  public IIcon getIcon(int id, int meta)
  {
    return this.blockIcon;
  }
}
