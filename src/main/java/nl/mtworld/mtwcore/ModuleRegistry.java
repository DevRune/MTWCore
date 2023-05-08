package nl.mtworld.mtwcore;

import java.util.HashMap;

public class ModuleRegistry {

    private MTWCore mtwCore;
    private HashMap<Class<? extends AbstractModule>, AbstractModule> moduleRegistry = new HashMap<>();

    public ModuleRegistry(MTWCore mtwCore) {
        this.mtwCore = mtwCore;
    }

    public void register(AbstractModule abstractModule) {
        this.moduleRegistry.put(abstractModule.getClass(), abstractModule);
    }

    public AbstractModule get(Class<? extends AbstractModule> clazz) {
        return this.moduleRegistry.get(clazz);
    }

    public void onEnable() {
        this.moduleRegistry.values().forEach(AbstractModule::onEnable);
    }

    public void onDisable() {
        this.moduleRegistry.values().forEach(AbstractModule::onDisable);
    }

    public void onLoad() {
        this.moduleRegistry.values().forEach(AbstractModule::onLoad);
    }

}
