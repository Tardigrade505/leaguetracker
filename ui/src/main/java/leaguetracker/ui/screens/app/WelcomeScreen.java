package leaguetracker.ui.screens.app;

import leaguetracker.ui.screens.TimedScreen;

public class WelcomeScreen extends TimedScreen {
    public WelcomeScreen() {
        super("Welcome to GgEDH Brawlin'!", 2000, new SeasonPickerScreen());
    }
}
