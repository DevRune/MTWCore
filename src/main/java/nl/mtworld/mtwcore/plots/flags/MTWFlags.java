package nl.mtworld.mtwcore.plots.flags;

import com.sk89q.worldguard.protection.flags.*;
import com.sk89q.worldguard.protection.flags.registry.FlagRegistry;
import nl.mtworld.mtwcore.MTWCore;
import org.bukkit.Location;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MTWFlags {


    private MTWCore mtwCore;
    private FlagRegistry flagRegistry;

    private LocationFlag DOORPOINT;
    private IntegerFlag PRICE;
    private IntegerFlag DEFAULT_PRICE;
    private BooleanFlag TEKOOP;
    private EnumFlag<PlotFlags> PLOTFLAGS;

     public MTWFlags(MTWCore mtwCore){
         this.mtwCore = mtwCore;
         this.flagRegistry = mtwCore.getWorldGuard().getFlagRegistry();
     }

     public void registerFlags(){
         DOORPOINT = new LocationFlag("mtw-doorpoint");
         PRICE = new IntegerFlag("mtw-price");
         DEFAULT_PRICE = new IntegerFlag("mtw-default-price");
         TEKOOP = new BooleanFlag("mtw-tekoop");
         PLOTFLAGS = new EnumFlag("mtw-plotflags", PlotFlags.class);
         flagRegistry.register(DOORPOINT);
         flagRegistry.register(PRICE);
         flagRegistry.register(DEFAULT_PRICE);
         flagRegistry.register(TEKOOP);
         flagRegistry.register(PLOTFLAGS);
     }

}
