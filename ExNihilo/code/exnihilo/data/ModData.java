package exnihilo.data;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.ModMetadata;

public class ModData {
	
	//Paths
	public static final String TEXTURE_LOCATION = "exnihilo";
	
	//Metadata
	public static final String ID = "crowley.skyblock";
	public static final String NAME = "Ex Nihilo";
	public static final String VERSION = "1.26b";
	
	public static void setMetadata(ModMetadata data)
	{
		data.autogenerated = false;		
		data.url = "";
		data.credits = "Cooley, for being my besty. =)";
		data.authorList.add("Erasmus Crowley");
		data.description = "Making the whole world renewable.";
		data.logoFile = "";
		data.updateUrl = "";
		data.parent = "";
	}
	
	//Options
	public static String CATEGORY_OPTIONS = "options";
	
	public static String ALLOW_BARRELS_KEY = "barrels allowed";
	public static boolean ALLOW_BARRELS = true;
	
	public static String ALLOW_SIEVES_KEY = "sieves allowed";
	public static boolean ALLOW_SIEVES = true;
	
	public static String ALLOW_CRUCIBLES_KEY = "crucibles allowed";
	public static boolean ALLOW_CRUCIBLES = true;
	
	public static String ALLOW_HAMMERS_KEY = "hammers allowed";
	public static boolean ALLOW_HAMMERS = true;
	
	public static String ALLOW_CROOKS_KEY = "crooks allowed";
	public static boolean ALLOW_CROOKS = true;
	
	public static String ALLOW_SILKWORMS_KEY = "silkworms allowed";
	public static boolean ALLOW_SILKWORMS = true;
	
	public static String ALLOW_SIEVE_AUTOMATION_KEY = "sieve automation allowed";
	public static boolean ALLOW_SIEVE_AUTOMATION = false;
	
	//BARREL OPTIONS
	public static String CATEGORY_OPTIONS_BARREL = "barrel options";
	
	public static String ALLOW_BARREL_RECIPE_DIRT_KEY = "enable barrel recipe (dirt)";
	public static boolean ALLOW_BARREL_RECIPE_DIRT = true;
	
	public static String ALLOW_BARREL_RECIPE_CLAY_KEY = "enable barrel recipe (clay)";
	public static boolean ALLOW_BARREL_RECIPE_CLAY = true;
	
	public static String ALLOW_BARREL_RECIPE_NETHERRACK_KEY = "enable barrel recipe (netherrack)";
	public static boolean ALLOW_BARREL_RECIPE_NETHERRACK = true;
	
	public static String ALLOW_BARREL_RECIPE_ENDSTONE_KEY = "enable barrel recipe (end stone)";
	public static boolean ALLOW_BARREL_RECIPE_ENDSTONE = true;
	
	public static String ALLOW_BARREL_RECIPE_SLIME_KEY = "enable barrel recipe (slime)";
	public static boolean ALLOW_BARREL_RECIPE_SLIME = true;
	
	public static String ALLOW_BARREL_RECIPE_SOULSAND_KEY = "enable barrel recipe (soul sand)";
	public static boolean ALLOW_BARREL_RECIPE_SOULSAND = true;
	
	public static String ALLOW_BARREL_RECIPE_BLAZE_RODS_KEY = "enable barrel recipe (blaze rods)";
	public static boolean ALLOW_BARREL_RECIPE_BLAZE_RODS = true;
	
	public static String ALLOW_BARREL_RECIPE_ENDER_PEARLS_KEY = "enable barrel recipe (ender pearls)";
	public static boolean ALLOW_BARREL_RECIPE_ENDER_PEARLS = true;
	
	//COMPATIBILITY OPTIONS!
	public static String CATEGORY_OPTIONS_COMPATIBILITY = "compatibility options";
	
	public static String OVERWRITE_DEFAULT_MACERATOR_RECIPES_KEY = "overwrite default macerator recipes";
	public static boolean OVERWRITE_DEFAULT_MACERATOR_RECIPES = true;
	
	public static String OVERWRITE_DEFAULT_PULVERIZER_RECIPES_KEY = "overwrite default pulverizer recipes";
	public static boolean OVERWRITE_DEFAULT_PULVERIZER_RECIPES = true;
	
	//Agriculture
	public static String CATEGORY_OPTIONS_AGRICULTURE = "agriculture options";
	public static String SILKWORM_STRING_PROBABILITY_KEY = "infested leaf string chance";
	public static double SILKWORM_STRING_PROBABILITY = 0.4d;
	
	
	public static void load(Configuration config)
	{
		//Options
		ALLOW_BARRELS = config.get(CATEGORY_OPTIONS, ALLOW_BARRELS_KEY, ALLOW_BARRELS).getBoolean(ALLOW_BARRELS);
		ALLOW_SIEVES = config.get(CATEGORY_OPTIONS, ALLOW_SIEVES_KEY, ALLOW_SIEVES).getBoolean(ALLOW_SIEVES);
		ALLOW_SIEVE_AUTOMATION  = config.get(CATEGORY_OPTIONS, ALLOW_SIEVE_AUTOMATION_KEY, ALLOW_SIEVE_AUTOMATION).getBoolean(ALLOW_SIEVE_AUTOMATION);
		ALLOW_CRUCIBLES = config.get(CATEGORY_OPTIONS, ALLOW_CRUCIBLES_KEY, ALLOW_CRUCIBLES).getBoolean(ALLOW_CRUCIBLES);
		ALLOW_HAMMERS = config.get(CATEGORY_OPTIONS, ALLOW_HAMMERS_KEY, ALLOW_HAMMERS).getBoolean(ALLOW_HAMMERS);
		ALLOW_CROOKS = config.get(CATEGORY_OPTIONS, ALLOW_CROOKS_KEY, ALLOW_CROOKS).getBoolean(ALLOW_CROOKS);
		ALLOW_SILKWORMS = config.get(CATEGORY_OPTIONS, ALLOW_SILKWORMS_KEY, ALLOW_SILKWORMS).getBoolean(ALLOW_SILKWORMS);
		
		//Barrel Options
		ALLOW_BARREL_RECIPE_DIRT = config.get(CATEGORY_OPTIONS_BARREL, ALLOW_BARREL_RECIPE_DIRT_KEY, ALLOW_BARREL_RECIPE_DIRT).getBoolean(ALLOW_BARREL_RECIPE_DIRT);
		ALLOW_BARREL_RECIPE_CLAY = config.get(CATEGORY_OPTIONS_BARREL, ALLOW_BARREL_RECIPE_CLAY_KEY, ALLOW_BARREL_RECIPE_CLAY).getBoolean(ALLOW_BARREL_RECIPE_CLAY);
		ALLOW_BARREL_RECIPE_NETHERRACK = config.get(CATEGORY_OPTIONS_BARREL, ALLOW_BARREL_RECIPE_NETHERRACK_KEY, ALLOW_BARREL_RECIPE_NETHERRACK).getBoolean(ALLOW_BARREL_RECIPE_NETHERRACK);
		ALLOW_BARREL_RECIPE_ENDSTONE = config.get(CATEGORY_OPTIONS_BARREL, ALLOW_BARREL_RECIPE_ENDSTONE_KEY, ALLOW_BARREL_RECIPE_ENDSTONE).getBoolean(ALLOW_BARREL_RECIPE_ENDSTONE);
		ALLOW_BARREL_RECIPE_SLIME = config.get(CATEGORY_OPTIONS_BARREL, ALLOW_BARREL_RECIPE_SLIME_KEY, ALLOW_BARREL_RECIPE_SLIME).getBoolean(ALLOW_BARREL_RECIPE_SLIME);
		ALLOW_BARREL_RECIPE_SOULSAND = config.get(CATEGORY_OPTIONS_BARREL, ALLOW_BARREL_RECIPE_SOULSAND_KEY, ALLOW_BARREL_RECIPE_SOULSAND).getBoolean(ALLOW_BARREL_RECIPE_SOULSAND);

		ALLOW_BARREL_RECIPE_BLAZE_RODS = config.get(CATEGORY_OPTIONS_BARREL, ALLOW_BARREL_RECIPE_BLAZE_RODS_KEY, ALLOW_BARREL_RECIPE_BLAZE_RODS).getBoolean(ALLOW_BARREL_RECIPE_BLAZE_RODS);
		ALLOW_BARREL_RECIPE_ENDER_PEARLS = config.get(CATEGORY_OPTIONS_BARREL, ALLOW_BARREL_RECIPE_ENDER_PEARLS_KEY, ALLOW_BARREL_RECIPE_ENDER_PEARLS).getBoolean(ALLOW_BARREL_RECIPE_ENDER_PEARLS);

		//Agricultre Options
		SILKWORM_STRING_PROBABILITY = config.get(CATEGORY_OPTIONS_AGRICULTURE, SILKWORM_STRING_PROBABILITY_KEY, SILKWORM_STRING_PROBABILITY).getDouble(SILKWORM_STRING_PROBABILITY);

		OVERWRITE_DEFAULT_MACERATOR_RECIPES = config.get(CATEGORY_OPTIONS_COMPATIBILITY, OVERWRITE_DEFAULT_MACERATOR_RECIPES_KEY, OVERWRITE_DEFAULT_MACERATOR_RECIPES).getBoolean(OVERWRITE_DEFAULT_MACERATOR_RECIPES);
		OVERWRITE_DEFAULT_PULVERIZER_RECIPES = config.get(CATEGORY_OPTIONS_COMPATIBILITY, OVERWRITE_DEFAULT_PULVERIZER_RECIPES_KEY, OVERWRITE_DEFAULT_PULVERIZER_RECIPES).getBoolean(OVERWRITE_DEFAULT_PULVERIZER_RECIPES);
		
	}
}
