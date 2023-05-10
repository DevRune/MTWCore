package nl.mtworld.mtwcore.scoreboard;

import nl.mtworld.mtwcore.AbstractModule;
import nl.mtworld.mtwcore.MTWCore;

public class ScoreBoardModule extends AbstractModule {

    private MTWCore mtwCore;
    public ScoreBoardModule(MTWCore mtwCore) {
        super(mtwCore);
        this.mtwCore = mtwCore;
    }

    @Override
    public void onEnable() {
        mtwCore.getMtwScoreboardManager().createScoreboard();
    }

    @Override
    public void onDisable() {

    }
}
