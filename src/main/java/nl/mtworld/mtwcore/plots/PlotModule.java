package nl.mtworld.mtwcore.plots;

import nl.mtworld.mtwcore.AbstractModule;
import nl.mtworld.mtwcore.MTWCore;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import nl.mtworld.mtwcore.plots.flags.MTWFlags;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class PlotModule extends AbstractModule {

    private MTWCore mtwCore;

    public PlotModule(MTWCore mtwCore) {
        super(mtwCore);
        this.mtwCore = mtwCore;
    }

    @Override
    public void onEnable() {

        mtwCore.getMtwFlags().registerFlags();

    }

    @Override
    public void onDisable() {

    }

    private WorldGuardPlugin getWorldGuard() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");

        // WorldGuard may not be loaded
        if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
            return null; // Maybe you want throw an exception instead
        }

        return (WorldGuardPlugin) plugin;
    }

    private WorldEditPlugin getWorldEdit() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");

        // WorldGuard may not be loaded
        if (plugin == null || !(plugin instanceof WorldEditPlugin)) {
            return null; // Maybe you want throw an exception instead
        }

        return (WorldEditPlugin) plugin;
    }
}
