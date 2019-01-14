package leaguetracker.gui;

import javax.swing.*;
import java.awt.*;

public class DetailsPanel extends JPanel {
    public DetailsPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Game border"));

        JLabel nameLabel = new JLabel("Name: ");
        JLabel occupationLabel = new JLabel("Occupation: ");

        JTextField nameField = new JTextField(10);
        JTextField occupationField = new JTextField(10);

        JButton addBtn = new JButton("Record results");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        ///////// FIRST COLUMN /////////
        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        add(nameLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(occupationLabel, gc);

        ///////// SECOND COLUMN /////////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        add(nameField, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(occupationField, gc);

        ///////// FINAL ROW /////////
        gc.weighty = 10;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 1;
        gc.gridy = 2;
        add(addBtn, gc);



    }

}
