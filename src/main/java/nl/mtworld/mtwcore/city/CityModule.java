package nl.mtworld.mtwcore.city;

import nl.mtworld.mtwcore.AbstractModule;
import nl.mtworld.mtwcore.MTWCore;
import nl.mtworld.mtwcore.city.listeners.MoveListener;

public class CityModule extends AbstractModule {

    MTWCore mtwCore;
    public CityModule(MTWCore mtwCore) {
        super(mtwCore);
        this.mtwCore = mtwCore;
    }

    @Override
    public void onEnable() {

        mtwCore.getServer().getPluginManager().registerEvents(new MoveListener(mtwCore), mtwCore);

    }

    @Override
    public void onDisable() {

    }
}
