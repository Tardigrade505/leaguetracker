package leaguetracker.gui;

import leaguetracker.ui.BackendInterface;
import leaguetracker.backend.objects.Game;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameScreenGUI implements Runnable {
    private Game game;
    private BackendInterface backendInterface = new BackendInterface();

    public GameScreenGUI(Game game) {
        this.game = game;
    }
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Game");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 400);
//        frame.setVisible(true);
//    }

    @Override
    public void run() {
        List<String> playerList = new ArrayList<>();
        playerList.add("Player1");
        playerList.add("Player2");
//        Game game = backendInterface.createNewGame("Season Name", playerList);
        JFrame frame = new MainFrame("Game", game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 400);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
