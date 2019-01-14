package leaguetracker.backend.database.types;

import java.util.List;

/**
 * An ADT that represents a league season
 */
public class Season {
    /**
     * The name of the season
     */
    private String name;

    /**
     * The list of player names in the season
     */
    private List<String> playerNames;

    /**
     * The full path to a file containing all the achievements for this season
     */
    private String achievementsFile;

    public Season(String name, List<String> playerNames) {
        this.name = name;
        this.playerNames = playerNames;
    }
}
