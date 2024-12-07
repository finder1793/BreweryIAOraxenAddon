package dev.jsinco;

import com.dre.brewery.BreweryPlugin;
import com.dre.brewery.api.addons.AddonFileManager;
import com.dre.brewery.api.addons.AddonLogger;
import com.dre.brewery.api.addons.BreweryAddon;
import com.dre.brewery.recipe.PluginItem;
import org.bukkit.Bukkit;

public class NexoAddon extends BreweryAddon {


  private static boolean useNexo = false;

  public NexoAddon(BreweryPlugin plugin, AddonLogger logger) {
    super(plugin, logger);
  }

  @Override
  public void onAddonEnable(AddonFileManager addonFileManager) {
    PluginItem.registerForConfig("nexo", NexoPluginItem::new);

    BreweryPlugin.getScheduler().runTaskLater(() -> {
      useNexo = Bukkit.getPluginManager().getPlugin("Nexo") != null;


      if (useNexo) {
        getLogger().info("Nexo support enabled!");
      }
    }, 1L);
  }

  public static boolean isUsingNexo() {
    return useNexo;
  }

  @Override
  public void onBreweryReload() {
  }
}