package leaguetracker.backend.controller;

import leaguetracker.backend.database.AchievementDatabase;
import leaguetracker.backend.objects.Achievement;


import java.util.HashMap;

public class AchievementController {
    /**
     * An object that handles interacting with achievement data
     */
    private AchievementDatabase achievementDatabase;

    public AchievementController() {
        this.achievementDatabase = new AchievementDatabase();
    }

    /**
     * Records which achievements were used and other achievement data
     * @return a boolean representing whether or not the record was successful
     */
    public boolean recordAchievementResults(final String seasonName, final HashMap<Achievement, String> achievementWinners) {
        return false;
    }
}
