package leaguetracker.ui.screens.app;

import leaguetracker.ui.screencomponents.UserAction;
import leaguetracker.ui.screens.Screen;
import leaguetracker.ui.screens.UserActionScreen;

public class SeasonPickerScreen extends UserActionScreen {
    public SeasonPickerScreen() {
        super("Choose a current season, or create a new one!", null);
    }

    @Override
    public Screen render() {
        printDisplayText();

        // Find all of the existing seasons on this machine
        userActions = backendInterface.createUserActionsFromExistingSeasons();
        userActions.add(new UserAction("Create a new season", new CreateNewSeasonScreen()));
        printUserActions();

        // Wait for user input
        final int userInput = waitForUserNumberInput();

        return userActions.get(userInput-1).getNextScreen();
    }
}
