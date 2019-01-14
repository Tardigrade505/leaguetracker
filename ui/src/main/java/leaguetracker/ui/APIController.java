package leaguetracker.ui;

import leaguetracker.backend.objects.GameResults;

import java.util.List;

/**
 * A class translating UI requests to backend calls
 */
public class APIController {

    /**
     * Makes direct calls to the backend API
     */
    private APICaller apiCaller;

    public APIController() {
        this.apiCaller = new APICaller();
    }

    /**
     * Gets the names of all the saved seasons
     * @return a list of all the saved season names
     */
    public List<String> getAllSeasons() {
        // Get all season directory names
        return apiCaller.getAllDirectories();
    }

    /**
     * Get a list of all the players in the season
     * @param seasonName - the name of the season
     * @return a list of all the players in the season
     */
    public List<String> getPlayerList(final String seasonName) {
        return apiCaller.getPlayerList(seasonName);
    }

    /**
     * Creates a new season
     * @param seasonName
     * @param players
     * @param achievementFile - full path to the achievements file
     */
    public void createNewSeason(final String seasonName, final List<String> players, final String achievementFile) {
        apiCaller.createNewSeason(seasonName, players, achievementFile);
    }

    /**
     * Records the game results
     * @param seasonName
     * @param gameResults
     * @return
     */
    public boolean recordGameResults(final String seasonName, final GameResults gameResults) {
        return apiCaller.recordGameResults(seasonName, gameResults);
    }

    public String getStandings(final String seasonName) {
        return apiCaller.getStandings(seasonName);
    }
}
