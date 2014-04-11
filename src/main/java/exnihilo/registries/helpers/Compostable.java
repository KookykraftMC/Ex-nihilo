package exnihilo.registries.helpers;



public class Compostable {

	public String unlocalizedName;
	public int id;
	public int meta;
	public float value;
	public Color color;
	
	public Compostable(int id, int meta, float value, Color color)
	{
		this.id = id;
		this.meta = meta;
		this.value = value;
		this.color = color;
	}
}
