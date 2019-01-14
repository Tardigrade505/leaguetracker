package leaguetracker.backend.adapter;

import leaguetracker.backend.database.DataModelNames;
import leaguetracker.backend.database.FileHandler;

import java.io.File;
import java.util.List;

/**
 * A class for interfacing with the Database API
 */
public class DatabaseAdapter {
    /**
     * The base location of the apps data directory
     */
    private String basePath;

    /**
     * A reference to the Database API
     */
    private FileHandler api;

    /**
     * Instance of itself to implement singleton design pattern
     */
    private static DatabaseAdapter instance;

    /**
     * Method that instantiates a new Database adapter if it does not exist, or
     * returns the already created one. Implementing the singleton design pattern
     * @return an instance of DatabaseAdapter
     */
    public static DatabaseAdapter getInstance() {
        if (null == instance) {
            instance = new DatabaseAdapter();
        }
        return instance;
    }
    private DatabaseAdapter() {
        this.api = new FileHandler();

        // Determine full path of location to store data
        final String workingDir = System.getProperty("user.dir");
        String[] splitWorkingDir = workingDir.split("leaguetracker");
        this.basePath = splitWorkingDir[0] + "leaguetracker/data/";

        // Create the data directory if it does not already exist
        File dataFile = new File(basePath);
        if (!dataFile.isDirectory()) {
            // TODO: add error handling to deal with failure to create data file
            dataFile.mkdir();
        }
    }

    /**
     * Returns a list of all the seasons saved in the data directory
     */
    public List<String> getAllDirectories() {
        return api.readFile(basePath + DataModelNames.SEASON_LIST);
    }

    /**
     * Gets a list of all the players in the season
     * @param seasonName - the name of the season
     * @return a list of all the players in the season
     */
    public List<String> getAllPlayers(final String seasonName) {
        return api.readFile(basePath + seasonName + DataModelNames.PLAYER_LIST);
    }

    public void createNewSeasonDirectory(final String dirName) {
        api.createNewDir(basePath + dirName);
    }

    public String getBasePath() {
        return basePath;
    }
}
