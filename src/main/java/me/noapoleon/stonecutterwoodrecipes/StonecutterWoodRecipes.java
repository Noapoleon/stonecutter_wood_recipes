package me.noapoleon.stonecutterwoodrecipes;

import me.noapoleon.stonecutterwoodrecipes.stonecutterRecipes.RecipesSortingLogic;
import org.bukkit.plugin.java.JavaPlugin;

public final class StonecutterWoodRecipes extends JavaPlugin {

	public static StonecutterWoodRecipes plugin;

	@Override
	public void onEnable() {
		// Plugin startup logic
		plugin = this;

		RecipesSortingLogic testRecipes = new RecipesSortingLogic();
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic

		this.getServer().clearRecipes();
	}

	public static StonecutterWoodRecipes getPlugin()
	{
		return plugin;
	}
}
