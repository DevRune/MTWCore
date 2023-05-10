package nl.mtworld.mtwcore.scoreboard;

import dev.jcsoftware.jscoreboards.JPerPlayerScoreboard;
import nl.mtworld.mtwcore.MTWCore;
import org.bson.Document;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class MTWScoreboardManager {

    JPerPlayerScoreboard scoreboard;
    MTWCore mtwCore;
    public MTWScoreboardManager(MTWCore mtwCore){
        this.mtwCore = mtwCore;
    }

    public void createScoreboard(){
        scoreboard = new JPerPlayerScoreboard(
                (player) -> {
                    return ChatColor.WHITE + ChatColor.BOLD.toString() + "CHAXIA";
                },
                (player) -> {
                    Document playerdoc = new Document("UUID", player.getUniqueId().toString());
                    Location location = player.getLocation().clone();
                    location.setY(0);
                    ChatColor cityColor = mtwCore.getCityManager().getCityByBlock(location.getBlock().getType()).getColor();
                    return Arrays.asList(
                            "\u0600 " + cityColor + mtwCore.getCityManager().getCityByBlock(location.getBlock().getType()).getName(),
                            " ",
                            "\u0602 " + cityColor + " Saldo:",
                            "§f€0,00",
                            "  ",
                            "۞ " + cityColor + "Level:",
                            "§f1",
                            "   ",
                            "۩ " + cityColor + "Fitheid:",
                            "§f20/225",
                            "    ",
                            "\u0603 " + cityColor + "WorldShards:",
                            "§f0",
                            "     ",
                            "§7play.mtworld.nl"
                    );
                }

        );

    }

    public void addPlayerToScoreboard(Player player){
        scoreboard.addPlayer(player);
    }

    public void updateScoreboard(){
        scoreboard.updateScoreboard();
    }

}
