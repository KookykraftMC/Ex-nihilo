package exnihilo.particles;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.registries.helpers.Color;

@SideOnly(Side.CLIENT)
public class ParticleSieve extends EntityFX{
	
	    public ParticleSieve(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, Color color)
	    {
	        super(par1World, par2, par4, par6, par8, par10, par12);
	        float f = this.rand.nextFloat() * 0.5F + 0.3F;
	        this.particleRed = f * color.r;
	        this.particleGreen = f * color.g;
	        this.particleBlue = f * color.b;
	        this.setParticleTextureIndex(0);
	        this.setSize(0.02F, 0.02F);
	        this.particleScale *= this.rand.nextFloat() * 1.0F + 0.5F;
	        this.motionX *= 0.019999999552965164D;
	        this.motionY *= -0.4;//0.019999999552965164D;
	        this.motionZ *= 0.019999999552965164D;
	        this.particleMaxAge = (int)(20.0D / (Math.random() * 0.2D + 0.2D));
	        this.noClip = true;
	    }

	    /**
	     * Called to update the entity's position/logic.
	     */
	    public void onUpdate()
	    {
	        this.prevPosX = this.posX;
	        this.prevPosY = this.posY;
	        this.prevPosZ = this.posZ;
	        this.moveEntity(this.motionX, this.motionY, this.motionZ);
	        this.motionX *= 0.99D;
	        this.motionY *= 0.99D;
	        this.motionZ *= 0.99D;

	        if (this.particleMaxAge-- <= 0)
	        {
	            this.setDead();
	        }
	    }
}
