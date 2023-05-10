package nl.mtworld.mtwcore;

import nl.mtworld.mtwcore.city.CityManager;
import nl.mtworld.mtwcore.city.CityModule;
import nl.mtworld.mtwcore.data.DataModule;
import nl.mtworld.mtwcore.data.mongodb.MongoDBManager;
import nl.mtworld.mtwcore.scoreboard.MTWScoreboardManager;
import nl.mtworld.mtwcore.scoreboard.ScoreBoardModule;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class MTWCore extends JavaPlugin {

    public ModuleRegistry moduleRegistry;
    private MongoDBManager mongoDBManager;
    private CityManager cityManager;
    private MTWScoreboardManager mtwScoreboardManager;

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

        this.moduleRegistry.register(new DataModule(this));
        this.moduleRegistry.register(new CityModule(this));
        this.moduleRegistry.register(new ScoreBoardModule(this));

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
}
