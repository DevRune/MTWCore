package nl.mtworld.mtwcore.data;

import nl.mtworld.mtwcore.AbstractModule;
import nl.mtworld.mtwcore.MTWCore;
import nl.mtworld.mtwcore.data.listeners.JoinListener;

public class DataModule extends AbstractModule {

    private MTWCore mtwCore;
    public DataModule(MTWCore mtwCore) {
        super(mtwCore);
    }

    @Override
    public void onEnable() {

        this.mtwCore.getServer().getPluginManager().registerEvents(new JoinListener(mtwCore), mtwCore);

    }

    @Override
    public void onDisable() {

    }
}
