package me.noapoleon.stonecutterwoodrecipes.stonecutterRecipes;

import me.noapoleon.stonecutterwoodrecipes.StonecutterWoodRecipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.StonecuttingRecipe;

import java.util.EnumMap;
import java.util.ArrayList;

public class RecipesSortingLogic
{
	public RecipesSortingLogic()
	{
		StonecutterWoodRecipes plugin = StonecutterWoodRecipes.getPlugin();
		EnumMap<Material, ArrayList<String>> recipesMap = new EnumMap<>(Material.class);

		// EDIT HERE TO ADD NEW MATERIALS RECIPES
		for (Material material : Material.values())
		{
			String matName = material.name(); // convenience variable

			if (matName.contains("_LOG"))											// FILTER: log types
				recipesMap.put(material, null);
			else if (matName.contains("_STEM"))										// FILTER: stem types
			{
				if (matName.contains("WARPED_") || matName.contains("CRIMSON_"))
					recipesMap.put(material, null);
			}
			else if (matName.contains("_WOOD"))										// FILTER: wood types
				recipesMap.put(material, null);
			else if (matName.contains("_HYPHAE"))
				recipesMap.put(material, null);
			else if(matName.contains("_PLANKS"))									// FILTER: planks types
				recipesMap.put(material, null);
		}

		// FILL THE MAP WITH CORRECT STRING
		for (EnumMap.Entry<Material, ArrayList<String>> recipeEntry : recipesMap.entrySet())
		{
			Material material = recipeEntry.getKey();
			if (material.name().contains("PLANKS"))
				fillSourceMaterialsResults(recipesMap, material, null, null);
			if (material.name().contains("_LOG") || material.name().contains("_WOOD"))
				fillSourceMaterialsResults(recipesMap, material, "_LOG", "_WOOD");
			if (material.name(). contains("_STEM") || material.name().contains("_HYPHAE"))
				fillSourceMaterialsResults(recipesMap, material, "_STEM", "_HYPHAE");
		}

		for (EnumMap.Entry<Material, ArrayList<String>> recipeEntry : recipesMap.entrySet())
		{
			Material source = recipeEntry.getKey();
			ArrayList<String> results = recipeEntry.getValue();
			for (String resultUnsplitName: results)
			{
				// separate the material enum value from the amount for the recipe
				String[] parts = resultUnsplitName.split("#");
				String resultName = parts[0];
				Material result = Material.getMaterial(resultName);
				assert result != null;
				String resultMaterialKey = (source.name() + "_TO_" + result.name() + "_KEY");
				int amount = Integer.parseInt(parts[1]);

				plugin.getServer().addRecipe(new StonecuttingRecipe(new NamespacedKey(plugin, resultMaterialKey), new ItemStack(result, amount), source));
			}
		}
	}

	String getWoodType(Material material)
	{
		String woodType = material.name();
		boolean isStripped = woodType.contains("STRIPPED_");
		int firstUnderscore = woodType.indexOf("_");
		int lastUnderscore = woodType.lastIndexOf("_");

		return isStripped ? woodType.substring(firstUnderscore + 1, lastUnderscore) : woodType.substring(0, lastUnderscore);
	}

	// CHANGE HERE TO ADD RECIPE RESULTS
	void fillSourceMaterialsResults(EnumMap<Material, ArrayList<String>> recipesMap, Material material, String logSuffix, String woodSuffix)
	{
		String woodType = getWoodType(material);
		String matName = material.name();
		boolean isStripped = matName.contains("STRIPPED_");
		// boolean isNetherVariant = matName.contains("CRIMSON_") || matName.contains("WARPED_");
		boolean isLog = matName.contains("_LOG") || matName.contains("_STEM");
		boolean isWood = matName.contains("_WOOD") || matName.contains("_HYPHAE");

		ArrayList<String> resultsList = new ArrayList<String>(){};

		int slabAmount = matName.contains("_PLANKS") ? 2 : 8;
		int stairAmount = matName.contains("_PLANKS") ? 2 : 8;
		int stickAmount = matName.contains("_PLANKS") ? 2 : 8;


		// COMMON RESULTS FOR EVERY RECIPE AND PLANKS
		resultsList.add(woodType + "_SLAB#" + slabAmount);
		resultsList.add(woodType + "_STAIRS#" + stairAmount);
		resultsList.add("STICK#" + stickAmount);

		// COMMON RESULTS FOR LOGS AND WOOD TYPES
		if (isLog || isWood)
		{
			resultsList.add(woodType + "_PLANKS#4");

			// COMMON FILTER FOR STRIPPED AND NON-STRIPPED
			if (isLog)
			{
				resultsList.add("STRIPPED_" + woodType + woodSuffix + "#1");
				if (!isStripped)
				{
					resultsList.add("STRIPPED_" + woodType + logSuffix + "#1");
					resultsList.add(woodType + woodSuffix + "#1");
				}
			}
			else
			{
				resultsList.add("STRIPPED_" + woodType + logSuffix + "#1");
				if (!isStripped)
				{
					resultsList.add("STRIPPED_" + woodType + woodSuffix + "#1");
					resultsList.add(woodType + logSuffix + "#1");
				}
			}
		}


		// ADD ARRAYLIST AT THE END
		recipesMap.put(material, resultsList);
	}
}
