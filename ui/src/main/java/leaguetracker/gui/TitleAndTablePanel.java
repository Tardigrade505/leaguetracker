package leaguetracker.gui;

import leaguetracker.backend.objects.Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TitleAndTablePanel extends JPanel {
    TitleAndTablePanel(Game game) {

        setBorder(BorderFactory.createTitledBorder("Game border"));

        // Components
        JLabel seasonNameLabel = new JLabel(game.getSeasonName());
        seasonNameLabel.setFont(seasonNameLabel.getFont().deriveFont(35.0f));

        List<JLabel> tableLabels = new ArrayList<>();
        int tableNumber = 0;
        for (List<String> table : game.getTables()) {
            JLabel tempLabel = new JLabel("Table " + ++tableNumber + ": " + table.toString());
            tempLabel.setFont(tempLabel.getFont().deriveFont(25.0f));
            tableLabels.add(tempLabel);
        }

        // Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        ///////// FIRST COLUMN /////////
        gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        add(seasonNameLabel, gc);

        ///////// LATER ROWS /////////
        gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 1;

        for (JLabel label : tableLabels) {
            add(label, gc);
            gc.gridy++;
        }


    }
}
