package dev.jsinco;

import com.dre.brewery.BreweryPlugin;
import com.dre.brewery.api.addons.AddonFileManager;
import com.dre.brewery.api.addons.AddonLogger;
import com.dre.brewery.api.addons.BreweryAddon;
import com.dre.brewery.recipe.PluginItem;
import org.bukkit.Bukkit;

public class IAOraxenAddon extends BreweryAddon {


    private static AddonLogger logger;
    private static boolean useItemsAdder = false;
    private static boolean useOraxen = false;

    public IAOraxenAddon(BreweryPlugin plugin, AddonLogger logger) {
        super(plugin, logger);
        IAOraxenAddon.logger = logger;
    }

    @Override
    public void onAddonEnable(AddonFileManager addonFileManager) {
        PluginItem.registerForConfig("itemsadder", ItemsAdderPluginItem::new);
        PluginItem.registerForConfig("oraxen", OraxenPluginItem::new);
        PluginItem.registerForConfig("nexo", NexoPluginItem::new);

        BreweryPlugin.getScheduler().runTaskLater(() -> {
            useItemsAdder = Bukkit.getPluginManager().getPlugin("ItemsAdder") != null;
            useOraxen = Bukkit.getPluginManager().getPlugin("Oraxen") != null;

            if (useItemsAdder) {
                logger.info("ItemsAdder support enabled!");
            }
            if (useOraxen) {
                logger.info("Oraxen support enabled!");
            }
            if (useNexo) {
                logger.info("Nexo support enabled!");
            }
        }, 1L);
    }

    public static boolean isUsingItemsAdder() {
        return useItemsAdder;
    }

    public static boolean isUsingOraxen() {
        return useOraxen;
    }

    @Override
    public void onBreweryReload() {
    }
}