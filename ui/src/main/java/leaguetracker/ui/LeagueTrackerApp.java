package leaguetracker.ui;

import leaguetracker.ui.screens.Screen;

public class LeagueTrackerApp {

    /**
     * The main while loop that runs the app
     * @param startingScreen - the first screen to render
     */
    public void run(Screen startingScreen) {
        Screen currentScreen = startingScreen;

        while (null != currentScreen) {
            currentScreen = currentScreen.render();
        }
    }
}
