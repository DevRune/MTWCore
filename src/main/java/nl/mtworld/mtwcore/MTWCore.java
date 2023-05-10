package nl.mtworld.mtwcore;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import nl.mtworld.mtwcore.city.CityManager;
import nl.mtworld.mtwcore.city.CityModule;
import nl.mtworld.mtwcore.data.DataModule;
import nl.mtworld.mtwcore.data.mongodb.MongoDBManager;
import nl.mtworld.mtwcore.plots.PlotModule;
import nl.mtworld.mtwcore.plots.flags.MTWFlags;
import nl.mtworld.mtwcore.scoreboard.MTWScoreboardManager;
import nl.mtworld.mtwcore.scoreboard.ScoreBoardModule;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class MTWCore extends JavaPlugin {

    public ModuleRegistry moduleRegistry;
    private MongoDBManager mongoDBManager;
    private CityManager cityManager;
    private MTWScoreboardManager mtwScoreboardManager;
    private MTWFlags mtwFlags;

    public MTWCore(){
        super();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.moduleRegistry = new ModuleRegistry(this);
        this.cityManager = new CityManager();
        this.mongoDBManager = new MongoDBManager(this);
        this.mtwScoreboardManager = new MTWScoreboardManager(this);
        this.mtwFlags = new MTWFlags(this);

        this.moduleRegistry.register(new DataModule(this));
        this.moduleRegistry.register(new CityModule(this));
        this.moduleRegistry.register(new ScoreBoardModule(this));
        this.moduleRegistry.register(new PlotModule(this));

        this.getLogger().log(Level.INFO, "Minetopia World Core plugin enabled.");

        this.moduleRegistry.onEnable();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        this.getLogger().log(Level.INFO, "Minetopia World Core plugin disabled.");

        if (moduleRegistry != null) this.moduleRegistry.onDisable();

    }

    public MongoDBManager getMongoDBManager() {
        return mongoDBManager;
    }

    public CityManager getCityManager() {
        return cityManager;
    }

    public MTWScoreboardManager getMtwScoreboardManager() {
        return mtwScoreboardManager;
    }

    public MTWFlags getMtwFlags() {
        return mtwFlags;
    }

    public WorldGuardPlugin getWorldGuard() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");

        // WorldGuard may not be loaded
        if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
            return null; // Maybe you want throw an exception instead
        }

        return (WorldGuardPlugin) plugin;
    }

    public WorldEditPlugin getWorldEdit() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");

        // WorldGuard may not be loaded
        if (plugin == null || !(plugin instanceof WorldEditPlugin)) {
            return null; // Maybe you want throw an exception instead
        }

        return (WorldEditPlugin) plugin;
    }
}
