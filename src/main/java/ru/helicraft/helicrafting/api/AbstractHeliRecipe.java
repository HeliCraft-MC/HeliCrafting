package ru.helicraft.helicrafting.api;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Базовый класс для всех кастом-рецептов HeliCrafting.
 * Наследники определяют только метод build().
 */
public abstract class AbstractHeliRecipe {

    protected final JavaPlugin plugin;
    protected final NamespacedKey key;

    protected AbstractHeliRecipe(JavaPlugin plugin, String id) {
        this.plugin = plugin;
        this.key = new NamespacedKey(plugin, id);  // уникальный ключ
    }

    /** Построить объект org.bukkit.inventory.Recipe. */
    public abstract Recipe build();

    /** Зарегистрировать рецепт */
    public void register(boolean broadcast) {
        plugin.getServer().addRecipe(build(), broadcast);
    }
    public void register() {
        register(true);
    }

    /** Снять рецепт по ключу */
    public static boolean removeRecipe(JavaPlugin plugin, NamespacedKey key) {
        return plugin.getServer().removeRecipe(key);
    }

    /** Массово удалить рецепты, удовлетворяющие фильтру (по результату, типу и т.д.) */
    public static int removeIf(JavaPlugin plugin, Predicate<Recipe> filter) {
        int removed = 0;
        Iterator<Recipe> it = plugin.getServer().recipeIterator(); // даёт мутабельный итератор
        while (it.hasNext()) {
            Recipe r = it.next();
            if (filter.test(r)) {
                it.remove();
                removed++;
            }
        }
        return removed;
    }
}
