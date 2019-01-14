package leaguetracker.ui.screens.app;

import leaguetracker.ui.screens.DisplayScreen;
import leaguetracker.ui.screens.Screen;

public class LeaderboardPreviewScreen extends DisplayScreen {
    private String seasonName;
    public LeaderboardPreviewScreen(final String seasonName) {
        super("LEADERBOARD\n\n", null);
        this.displayText = this.displayText + backendInterface.getStandings(seasonName);
        this.seasonName = seasonName;
    }

    @Override
    public Screen render() {
        printDisplayText();
        return new SeasonMainMenu(seasonName);
    }
}
