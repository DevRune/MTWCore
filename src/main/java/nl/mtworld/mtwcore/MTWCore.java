package nl.mtworld.mtwcore;

import nl.mtworld.mtwcore.data.DataModule;
import nl.mtworld.mtwcore.data.mongodb.MongoDBManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class MTWCore extends JavaPlugin {

    public ModuleRegistry moduleRegistry;
    private MongoDBManager mongoDBManager;

    public MTWCore(){
        super();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.moduleRegistry = new ModuleRegistry(this);

        this.moduleRegistry.register(new DataModule(this));

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
}
