package leaguetracker.ui.screens;

import leaguetracker.backend.objects.Game;
import leaguetracker.gui.GameScreenGUI;
import leaguetracker.ui.BackendInterface;
import leaguetracker.ui.LeagueTrackerApp;
import leaguetracker.ui.screencomponents.UserAction;
import leaguetracker.ui.screens.app.SeasonPickerScreen;
import leaguetracker.ui.screens.app.WelcomeScreen;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ScreenTests {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ScreenTests screenTests = new ScreenTests();

        Scanner sc = new Scanner(System.in);
        final String testToRun = sc.nextLine();

        Method method = ScreenTests.class.getDeclaredMethod(testToRun);
        method.invoke(screenTests);
    }

//    /**
//     * Test that a timed screen can be created, displays its text, and waits, then moves to a display screen
//     */
//    private void testTimedScreenRender() {
//        TimedScreen timedScreen = new TimedScreen("This is a timed screen", 3000,
//                new WelcomeScreen("Display Screen", null));
//        timedScreen.render();
//    }

//    /**
//     * Test that you can pick an action from a user action screen, and navigate to the correct screen for that choice
//     */
//    private void testUserActionScreenRender() {
//        UserActionScreen userActionScreen = new UserActionScreen("This is a User Action Screen",
//                Collections.singletonList(new UserAction("Go to the next screen",
//                        new DisplayScreen("This is the next screen!", null))));
//
//        LeagueTrackerApp leagueTrackerApp = new LeagueTrackerApp();
//        leagueTrackerApp.run(userActionScreen);
//    }

    /**
     * Test flow 1:
     * 1. User sees action screen
     * 2. User sees season picker screen
     * 3. User chooses to create a new season
     * 4. User sees enter season info screen and fills in season info
     * 5. User sees main menu for that season
     * 6. User selects to play a new game from the main menu
     * 7. User views the game with players at tables, and achievements
     */
    private void flow1() {
        // Define screens
        ScreenFactory screenFactory = new ScreenFactory();
        WelcomeScreen welcomeScreen = (WelcomeScreen) screenFactory.getScreen(ScreenTypes.WELCOME_SCREEN);
        SeasonPickerScreen seasonPickerScreen = (SeasonPickerScreen) screenFactory.getScreen(ScreenTypes.SEASON_PICKER);
//        TextFieldScreen enterSeasonInfoScreen = getSeasonInfoScreen();

        // Link screens
        welcomeScreen.setNextScreen(seasonPickerScreen);

        run(welcomeScreen);
    }

    /**
     * Test the GUI of the Game page
     */
    private void gameGUI() {
        List<String> players = new ArrayList<>();
        players.add("Elliot");
        players.add("Ryan");
        SwingUtilities.invokeLater(new GameScreenGUI(Game.generateNewGame("NEW SEASON", players)));
    }

    /**
     * Helper method that runs the test using the LeagueTrackerApp
     * @param screen - the first screen to run the test on
     */
    private void run(Screen screen) {
        LeagueTrackerApp leagueTrackerApp = new LeagueTrackerApp();
        leagueTrackerApp.run(screen);
    }
}
