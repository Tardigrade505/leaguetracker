package leaguetracker.ui;

import leaguetracker.backend.handler.LeagueTrackerAPI;
import leaguetracker.backend.objects.GameResults;

import java.util.List;

/**
 * A class for interacting directly with the backend API
 */
public class APICaller {

    /**
     * A reference to the backend API
     */
    private LeagueTrackerAPI api;

    public APICaller() {
        this.api = new LeagueTrackerAPI();
    }

    /**
     * Queries the backend API to get a list of directories
     * @return a list of the names of the season directories
     */
    public List<String> getAllDirectories() {
        return api.getAllSeasons();
    }

    /**
     * Gets all the players in the season
     * @param seasonName - the name of the season
     * @return a list of all the players in the season
     */
    public List<String> getPlayerList(final String seasonName) {
        return api.getAllPlayers(seasonName);
    }

    public void createNewSeason(final String seasonName, final List<String> players, final String achievementFile) {
        api.createNewSeason(seasonName, players, achievementFile);
    }

    /**
     * Record the game results
     * @param seasonName
     * @param gameResults
     * @return
     */
    public boolean recordGameResults(final String seasonName, final GameResults gameResults) {
        return api.recordGameResults(seasonName, gameResults);
    }

    public String getStandings(final String seasonName) {
        return api.getStandings(seasonName);
    }
}
