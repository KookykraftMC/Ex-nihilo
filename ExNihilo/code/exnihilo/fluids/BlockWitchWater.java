package exnihilo.fluids;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.data.BlockData;
import exnihilo.data.FluidData;
import exnihilo.data.ModData;
import exnihilo.registries.ColorRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumEntitySize;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockWitchWater extends BlockFluidClassic{
	@SideOnly(Side.CLIENT)
	protected Icon[] fluidIcons;
	public static final Material witchwater = new MaterialLiquid(MapColor.ironColor);

	public BlockWitchWater(int id, Fluid fluid, Material material) {
		super(id, fluid, material);
	}

	@Override
	public String getUnlocalizedName()
	{
		return FluidData.WITCHWATER_UNLOCALIZED_NAME;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		this.fluidIcons = new Icon[] 
				{
				register.registerIcon(ModData.TEXTURE_LOCATION + ":IconWitchWaterStill"), 
				register.registerIcon(ModData.TEXTURE_LOCATION + ":IconWitchWaterFlow")
				};
	}

	@Override
	public Icon getIcon(int side, int meta) {
		return side != 0 && side != 1 ? this.fluidIcons[1] : this.fluidIcons[0];
	}

	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		return ColorRegistry.color("witchwater").toInt();
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) 
	{
		if(!world.isRemote && !entity.isDead)
		{
			if (entity instanceof EntityVillager)
			{
				EntityVillager villager = (EntityVillager)entity;
				
				if (villager.getProfession() == 2 && !villager.isChild())
				{
					villager.setDead();
					
					EntityWitch witch = new EntityWitch(world);
					witch.setLocationAndAngles(villager.posX, villager.posY, villager.posZ, villager.rotationYaw, villager.rotationPitch);
					witch.renderYawOffset = villager.renderYawOffset;
					witch.setHealth(villager.getHealth());
					
					world.spawnEntityInWorld(witch);
				}
				else
				{
					villager.setDead();
					
					EntityZombie zombie = new EntityZombie(world);
					zombie.setLocationAndAngles(villager.posX, villager.posY, villager.posZ, villager.rotationYaw, villager.rotationPitch);
					zombie.renderYawOffset = villager.renderYawOffset;
					zombie.setHealth(villager.getHealth());
					zombie.setVillager(true);
					zombie.setChild(villager.isChild());
					
					world.spawnEntityInWorld(zombie);
				}
			}
			
			if (!entity.isDead && entity instanceof EntitySkeleton)
			{
				if (((EntitySkeleton)entity).getSkeletonType() == 0)
				{
					EntitySkeleton skeleton = (EntitySkeleton)entity;
					skeleton.setSkeletonType(1);
					skeleton.setHealth(skeleton.getMaxHealth());
				}
			}
			
			if (!entity.isDead && entity instanceof EntityCreeper)
			{
				if (!((EntityCreeper)entity).getPowered())
				{
					EntityCreeper creeper = (EntityCreeper)entity;
					creeper.onStruckByLightning(null);
					creeper.setHealth(creeper.getMaxHealth());
				}
			}
			
			if (!entity.isDead && entity instanceof EntitySpider && !(entity instanceof EntityCaveSpider))
			{
				EntitySpider spider = (EntitySpider)entity;
				spider.setDead();
				
				EntityCaveSpider caveSpider = new EntityCaveSpider(world);
				caveSpider.setLocationAndAngles(spider.posX, spider.posY, spider.posZ, spider.rotationYaw, spider.rotationPitch);
				caveSpider.renderYawOffset = spider.renderYawOffset;
				caveSpider.setHealth(caveSpider.getMaxHealth());
				
				world.spawnEntityInWorld(caveSpider);
			}
			
			if (!entity.isDead && entity instanceof EntitySquid)
			{
				EntitySquid squid = (EntitySquid)entity;
				squid.setDead();
				
				EntityGhast ghast = new EntityGhast(world);
				ghast.setLocationAndAngles(squid.posX, squid.posY + 2, squid.posZ, squid.rotationYaw, squid.rotationPitch);
				ghast.renderYawOffset = squid.renderYawOffset;
				ghast.setHealth(ghast.getMaxHealth());
				
				world.spawnEntityInWorld(ghast);
			}
			
			if(!entity.isDead && entity instanceof EntityAnimal)
			{
				EntityAnimal animal = (EntityAnimal)entity;
				animal.onStruckByLightning(null);
			}
			
			if(!entity.isDead && entity instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)entity;
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 210, 0));
				player.addPotionEffect(new PotionEffect(Potion.weakness.id, 210, 2));
				player.addPotionEffect(new PotionEffect(Potion.wither.id, 210, 0));
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 210, 0));
			}
		}
	}
}
