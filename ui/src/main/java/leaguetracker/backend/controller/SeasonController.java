package leaguetracker.backend.controller;

import leaguetracker.backend.database.DataModelNames;
import leaguetracker.backend.database.SeasonDatabase;
import leaguetracker.backend.util.BackendUtils;

import java.util.List;

/**
 * Groups API calls made to various services together and handles business logic of requests
 */
public class SeasonController {
    private static final String DEFAULT_ACHIEVEMENT_LOCATION = BackendUtils.getProjectBasePath() + "ui/src/main/resources/" + DataModelNames.ACHIEVEMENTS_FILE;

    /**
     * An object handles interacting with the DataBaseAPI
     */
    private SeasonDatabase seasonDatabase;

    public SeasonController() {
        this.seasonDatabase = SeasonDatabase.getInstance();
    }

    /**
     * Gets all season names
     * @return a list of all the names of the seasons
     */
    public List<String> getAllSeasonNames() {
        return seasonDatabase.selectAllSeasons();
    }

    public boolean createNewSeason(final String seasonName, final List<String> players, final String achievementFile) {
        if ("default".equals(achievementFile)) {
            return seasonDatabase.createSeason(seasonName, players, DEFAULT_ACHIEVEMENT_LOCATION);
        }
        return seasonDatabase.createSeason(seasonName, players, achievementFile);

    }
}
