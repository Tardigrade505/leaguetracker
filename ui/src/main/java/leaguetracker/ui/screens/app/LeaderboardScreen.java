package leaguetracker.ui.screens.app;

import leaguetracker.ui.screencomponents.UserAction;
import leaguetracker.ui.screens.Screen;
import leaguetracker.ui.screens.UserActionScreen;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardScreen extends UserActionScreen {
    public LeaderboardScreen(final String seasonName) {
        super("LEADERBOARD\n\n", null);
        this.displayText = this.displayText + backendInterface.getStandings(seasonName);
        List<UserAction> userActions = new ArrayList<>();
        userActions.add(new UserAction("Play another game in this session?", new EnterMissingPeopleScreen(seasonName)));
        userActions.add(new UserAction("End session.", new SeasonMainMenu(seasonName)));
        this.userActions = userActions;
    }

    @Override
    public Screen render() {
        printDisplayText();
        printUserActions();
        final int userInput = waitForUserNumberInput();
        return userActions.get(userInput-1).getNextScreen();
    }
}
