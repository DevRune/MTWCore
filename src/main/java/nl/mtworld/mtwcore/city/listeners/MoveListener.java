package nl.mtworld.mtwcore.city.listeners;

import nl.mtworld.mtwcore.MTWCore;
import nl.mtworld.mtwcore.city.City;
import nl.mtworld.mtwcore.city.CityManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class MoveListener implements Listener {
    
    private MTWCore mtwCore;
    public MoveListener(MTWCore mtwCore){
        this.mtwCore = mtwCore;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Location from = event.getFrom().clone();
        Location to = event.getTo().clone();
        from.setY(0);
        to.setY(0);
        if(from.getBlock().getType() != to.getBlock().getType()){
            City city = mtwCore.getCityManager().getCityByBlock(to.getBlock().getType());
            event.getPlayer().sendTitle(city.getColor() + "Welkom in", city.getColor() + city.getName(), 20, 100, 40);
            new BukkitRunnable(){
                @Override
                public void run() {
                    mtwCore.getMtwScoreboardManager().updateScoreboard();
                }
            }.runTaskLater(mtwCore, 10);
        }
    }

}
