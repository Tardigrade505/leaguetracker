package leaguetracker;

import leaguetracker.ui.screens.Screen;
import leaguetracker.ui.screens.app.WelcomeScreen;

public class LeagueTrackerMain {
    public static void main(String[] args) {
        Screen currentScreen = new WelcomeScreen();
        while (null != currentScreen) {
            currentScreen = currentScreen.render();
        }
    }
}
