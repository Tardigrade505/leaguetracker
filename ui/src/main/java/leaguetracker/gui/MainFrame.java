package leaguetracker.gui;

import leaguetracker.backend.objects.Game;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private DetailsPanel detailsPanel;
    private TitleAndTablePanel titleAndTablePanel;
    private AchievementsPanel achievementsPanel;

    public MainFrame(final String title, final Game game) {
        super(title);
        detailsPanel = new DetailsPanel();
        titleAndTablePanel = new TitleAndTablePanel(game);
        achievementsPanel = new AchievementsPanel(this, game);

        // Set layout manager
        setLayout(new BorderLayout());

        // Create Swing components
        final JTextArea textArea = new JTextArea();
        JScrollPane scrollp = new JScrollPane(achievementsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//this is for the main panel
//        JButton button = new JButton("Record results");

        // Add Swing components to content pane
        Container c = getContentPane();
//        c.add(textArea, BorderLayout.CENTER);
//        c.add(button, BorderLayout.SOUTH);
//        c.add(detailsPanel, BorderLayout.WEST);
        c.add(titleAndTablePanel, BorderLayout.NORTH);
//        c.add(achievementsPanel, BorderLayout.CENTER);
        c.add(scrollp, BorderLayout.CENTER);
//        pack();
//        setVisible(true);

//        // Add behavior
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Your button action goes here
//                textArea.append("Hello");
//            }
//        });
    }
}
