package dev.nandi0813.zppapiexample;

import dev.nandi0813.api.Enum.DivisionName;
import dev.nandi0813.api.Enum.WeightClass;
import dev.nandi0813.api.Event.Match.MatchStartEvent;
import dev.nandi0813.api.Interface.Match;
import dev.nandi0813.api.ZonePracticeApi;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZPPApiExample extends JavaPlugin implements Listener {

    private ZonePracticeApi api;

    @Override
    public void onEnable() {
        api = ZonePracticeApi.getInstance();

        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        player.sendMessage("Your division: " + api.getPlayerDivision(player, DivisionName.FULL));
        player.sendMessage("Your wins: " + api.getLadderWins(player, "FireballFight", WeightClass.UNRANKED));
    }

    @EventHandler
    public void onMatchStart(MatchStartEvent e) {
        Match match = e.getMatch();

        match.getPlayers().forEach(player -> {
            player.sendMessage("Match has been started!");
        });

        match.sendMessage("<red>Welcome!", true);
    }

}
