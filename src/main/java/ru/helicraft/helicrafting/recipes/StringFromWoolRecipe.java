package ru.helicraft.helicrafting.recipes;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import ru.helicraft.helicrafting.api.AbstractHeliRecipe;

/** 1 шт. любой шерсти → 4 нитки. */
public final class StringFromWoolRecipe extends AbstractHeliRecipe {

    public StringFromWoolRecipe(JavaPlugin plugin) {
        super(plugin, "wool_to_string");
    }

    @Override
    public Recipe build() {
        ItemStack result = new ItemStack(Material.STRING, 4);
        ShapelessRecipe r = new ShapelessRecipe(key, result);
        r.addIngredient(new RecipeChoice.MaterialChoice(Tag.WOOL)); // Tag.WOOL
        return r;
    }
}
