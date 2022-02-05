package me.noapoleon.stonecutterwoodrecipes;

import org.bukkit.inventory.Recipe;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.StonecuttingRecipe;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class StonecutterWoodRecipes extends JavaPlugin {

	@Override
	public void onEnable() {
		// Plugin startup logic

		StonecuttingRecipe oakStairs_stonecutter = new StonecuttingRecipe(new NamespacedKey(this, "oakStairs_stonecutter_key"), new ItemStack(Material.OAK_STAIRS, 1), Material.OAK_PLANKS);
		StonecuttingRecipe oakSlab_stonecutter = new StonecuttingRecipe(new NamespacedKey(this, "oakSlab_stonecutter_key"), new ItemStack(Material.OAK_SLAB, 2), Material.OAK_PLANKS);

		StonecuttingRecipe spruceStairs_stonecutter = new StonecuttingRecipe(new NamespacedKey(this, "spruceStairs_stonecutter_key"), new ItemStack(Material.SPRUCE_STAIRS, 1), Material.SPRUCE_PLANKS);
		StonecuttingRecipe spruceSlab_stonecutter = new StonecuttingRecipe(new NamespacedKey(this, "spruceSlab_stonecutter_key"), new ItemStack(Material.SPRUCE_SLAB, 2), Material.SPRUCE_PLANKS);

		StonecuttingRecipe birchStairs_stonecutter = new StonecuttingRecipe(new NamespacedKey(this, "birchStairs_stonecutter_key"), new ItemStack(Material.BIRCH_STAIRS, 1), Material.BIRCH_PLANKS);
		StonecuttingRecipe birchSlab_stonecutter = new StonecuttingRecipe(new NamespacedKey(this, "birchSlab_stonecutter_key"), new ItemStack(Material.BIRCH_SLAB, 2), Material.BIRCH_PLANKS);

		StonecuttingRecipe jungleStairs_stonecutter = new StonecuttingRecipe(new NamespacedKey(this, "jungleStairs_stonecutter_key"), new ItemStack(Material.JUNGLE_STAIRS, 1), Material.JUNGLE_PLANKS);
		StonecuttingRecipe jungleSlab_stonecutter = new StonecuttingRecipe(new NamespacedKey(this, "jungleSlab_stonecutter_key"), new ItemStack(Material.JUNGLE_SLAB, 2), Material.JUNGLE_PLANKS);

		StonecuttingRecipe acaciaStairs_stonecutter = new StonecuttingRecipe(new NamespacedKey(this, "acaciaStairs_stonecutter_key"), new ItemStack(Material.ACACIA_STAIRS, 1), Material.ACACIA_PLANKS);
		StonecuttingRecipe acaciaSlab_stonecutter = new StonecuttingRecipe(new NamespacedKey(this, "acaciaSlab_stonecutter_key"), new ItemStack(Material.ACACIA_SLAB, 2), Material.ACACIA_PLANKS);

		StonecuttingRecipe darkOakStairs_stonecutter = new StonecuttingRecipe(new NamespacedKey(this, "darkOakStairs_stonecutter_key"), new ItemStack(Material.DARK_OAK_STAIRS, 1), Material.DARK_OAK_PLANKS);
		StonecuttingRecipe darkOakSlab_stonecutter = new StonecuttingRecipe(new NamespacedKey(this, "darkOakSlab_stonecutter_key"), new ItemStack(Material.DARK_OAK_SLAB, 2), Material.DARK_OAK_PLANKS);

		StonecuttingRecipe crimsonStairs_stonecutter = new StonecuttingRecipe(new NamespacedKey(this, "crimsonStairs_stonecutter_key"), new ItemStack(Material.CRIMSON_STAIRS, 1), Material.CRIMSON_PLANKS);
		StonecuttingRecipe crimsonSlab_stonecutter = new StonecuttingRecipe(new NamespacedKey(this, "crimsonSlab_stonecutter_key"), new ItemStack(Material.CRIMSON_SLAB, 2), Material.CRIMSON_PLANKS);

		StonecuttingRecipe warpedStairs_stonecutter = new StonecuttingRecipe(new NamespacedKey(this, "warpedStairs_stonecutter_key"), new ItemStack(Material.WARPED_STAIRS, 1), Material.WARPED_PLANKS);
		StonecuttingRecipe warpedSlab_stonecutter = new StonecuttingRecipe(new NamespacedKey(this, "warpedSlab_stonecutter_key"), new ItemStack(Material.WARPED_SLAB, 2), Material.WARPED_PLANKS);

		this.getServer().addRecipe((Recipe)oakStairs_stonecutter);
		this.getServer().addRecipe((Recipe)oakSlab_stonecutter);

		this.getServer().addRecipe((Recipe)spruceStairs_stonecutter);
		this.getServer().addRecipe((Recipe)spruceSlab_stonecutter);

		this.getServer().addRecipe((Recipe)birchStairs_stonecutter);
		this.getServer().addRecipe((Recipe)birchSlab_stonecutter);

		this.getServer().addRecipe((Recipe)jungleStairs_stonecutter);
		this.getServer().addRecipe((Recipe)jungleSlab_stonecutter);

		this.getServer().addRecipe((Recipe)acaciaStairs_stonecutter);
		this.getServer().addRecipe((Recipe)acaciaSlab_stonecutter);

		this.getServer().addRecipe((Recipe)darkOakStairs_stonecutter);
		this.getServer().addRecipe((Recipe)darkOakSlab_stonecutter);

		this.getServer().addRecipe((Recipe)crimsonStairs_stonecutter);
		this.getServer().addRecipe((Recipe)crimsonSlab_stonecutter);

		this.getServer().addRecipe((Recipe)warpedStairs_stonecutter);
		this.getServer().addRecipe((Recipe)warpedSlab_stonecutter);
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
