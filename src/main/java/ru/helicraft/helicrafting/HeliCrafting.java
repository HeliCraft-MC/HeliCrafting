package ru.helicraft.helicrafting;

import org.bukkit.plugin.java.JavaPlugin;
import ru.helicraft.helicrafting.registry.RecipeRegistry;

public final class HeliCrafting extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin loaded. Initializing custom recipes...");
        RecipeRegistry.registerAll(this);
        getLogger().info("Custom recipes successfully loaded.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin unloaded.");
    }
}
