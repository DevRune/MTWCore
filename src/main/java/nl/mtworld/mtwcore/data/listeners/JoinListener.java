package nl.mtworld.mtwcore.data.listeners;

import nl.mtworld.mtwcore.MTWCore;
import nl.mtworld.mtwcore.city.City;
import nl.mtworld.mtwcore.data.mongodb.MongoDBManager;
import nl.mtworld.mtwcore.utils.ColorUtils;
import org.bson.Document;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinListener implements Listener {

    MongoDBManager mongoDBManager;
    MTWCore mtwCore;
    public JoinListener(MTWCore mtwCore){
        this.mtwCore = mtwCore;
        this.mongoDBManager = mtwCore.getMongoDBManager();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Location loc = event.getPlayer().getLocation().clone();
        loc.setY(0);
        City city = mtwCore.getCityManager().getCityByBlock(loc.getBlock().getType());
        event.getPlayer().sendTitle(city.getColor() + "Welkom in", city.getColor() + city.getName(), 20, 100, 40);
        event.getPlayer().sendMessage("§cDe volgende LabyMod Addons zijn niet toegestaan:\n§cDamageIndicator, LabysMinimap en VoiceChat\n§cIndien je deze aan hebt, kan je hiervoor permanent verbannen worden van de server.");
        Document playerdoc = new Document("UUID", event.getPlayer().getUniqueId().toString());
        Document found = (Document) mongoDBManager.getPlayerData().find(playerdoc).first();

        if(found == null){
            mongoDBManager.getPlayerData().insertOne(playerdoc);
            event.getPlayer().sendMessage(ColorUtils.color("&a&l[Tutorial] &fWelkom op &e&lMinetopia&f! Voet het command &e/tutorial &fuit om te starten met spelen!"));
            event.getPlayer().sendMessage(ColorUtils.color("&a&l[Tutorial] &fOm te beginnen krijg je wat te drinken en te eten om de &atutorial &fdoor te komen!"));
            event.getPlayer().sendMessage(ColorUtils.color("&a&l[Tutorial] &fDoorloop de gehele &atutorial &f& ontvang een beloning! Tijdens de tutorial ga je alle belangerijke plaatsen van Minetopia langs. &e&lSucces!"));
            event.getPlayer().getInventory().addItem(new ItemStack(Material.POTION, 3), new ItemStack(Material.BREAD, 64));
            System.out.println(ColorUtils.color("&2[MongoDB] &aPlayer " + event.getPlayer().getName() + " &acreated."));
        }else{
            System.out.println(ColorUtils.color("&2[MongoDB] &aPlayer " + event.getPlayer().getName() + " &afound."));
        }
        mtwCore.getMtwScoreboardManager().addPlayerToScoreboard(event.getPlayer());
        new BukkitRunnable(){
            @Override
            public void run() {
                mtwCore.getMtwScoreboardManager().updateScoreboard();
            }
        }.runTaskLater(mtwCore, 10);
    }

}
