package leaguetracker.ui.screens.app;

import leaguetracker.gui.GameScreenGUI;
import leaguetracker.backend.objects.Game;
import leaguetracker.ui.screens.Screen;

import javax.swing.*;

public class GameScreen extends Screen {
    /**
     * A reference to the game object that this screen represents
     */
    private Game game;

    /**
     * Creates a new screen
     *
     */
    public GameScreen(final Game game) {
        super("");
        this.game = game;
    }

    @Override
    public Screen render() {
        SwingUtilities.invokeLater(new GameScreenGUI(game));
        return new EnterGameResultsScreen(game);
    }
}
