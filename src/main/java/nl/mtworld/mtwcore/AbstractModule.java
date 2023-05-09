package nl.mtworld.mtwcore;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

import java.util.Objects;
import java.util.function.Supplier;

public abstract class AbstractModule {

    MTWCore mtwCore;
    public AbstractModule(MTWCore mtwCore){
        this.mtwCore = mtwCore;
    }
    public abstract void onEnable();
    public abstract void onDisable();

    public MTWCore getPlugin() {
        return mtwCore;
    }
}
