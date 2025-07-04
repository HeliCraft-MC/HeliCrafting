package ru.helicraft.helicrafting.registry;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.helicraft.helicrafting.recipes.StringFromWoolRecipe;

/**
 * Централизованная точка регистрации всех рецептов плагина
 */
public final class RecipeRegistry {

    private RecipeRegistry() { /* static-only */ }

    public static void registerAll(JavaPlugin plugin) {

        new StringFromWoolRecipe(plugin).register();

        // Пример других рецептов, которые можно добавить:
        // new CopperToDiamondRecipe(plugin).register(true);
        // new BlastRecycleRecipe(plugin).register();
    }
}
