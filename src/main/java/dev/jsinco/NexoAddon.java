package dev.jsinco;

import com.dre.brewery.BreweryPlugin;
import com.dre.brewery.api.addons.AddonFileManager;
import com.dre.brewery.api.addons.BreweryAddon;
import com.dre.brewery.recipe.PluginItem;
import org.bukkit.Bukkit;

public class NexoAddon extends BreweryAddon {


    private static boolean useNexo = false;

    @Override
    public void onAddonEnable(AddonFileManager addonFileManager) {
        PluginItem.registerForConfig("nexo", NexoPluginItem::new);

        BreweryPlugin.getScheduler().runTaskLater(() -> {
            useNexo = Bukkit.getPluginManager().getPlugin("Nexo") != null;
        }, 1L);
    }

    public static boolean isUsingNexo() {
        return useNexo;
    }
    @Override
    public void onBreweryReload() {
    }
}