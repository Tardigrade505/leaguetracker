package leaguetracker.gui;

import leaguetracker.backend.objects.Achievement;
import leaguetracker.backend.objects.Game;
import leaguetracker.ui.BackendInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AchievementsPanel extends JPanel {
    private float titleFontSize = 30.0f;
    private double cardImageSizePercentage = 0.60d;

    public AchievementsPanel(JFrame superFrame, Game game) {
        BackendInterface backendInterface = new BackendInterface();

        setBorder(BorderFactory.createTitledBorder("Achievement border"));

        // Grab the standings info
        final String standings = backendInterface.getStandings(game.getSeasonName());
        String[] standingsRows = standings.split("\n");
        final String playerInFirst = standingsRows[0].split(",")[0];
        final String pointsOfPlayerInFirst = standingsRows[0].split(",")[1]; // Use this to determine if this is the first game in the session
        final String playerInLast = standingsRows[standingsRows.length-1].split(",")[0];

        // Handle case where there aren't any standings yet (first game of season)
        JLabel achievementTitle;

        boolean isFirstSession = " 0 points".equals(pointsOfPlayerInFirst);
        if (isFirstSession) {
            achievementTitle = new JLabel("Achievements");
            achievementTitle.setFont(achievementTitle.getFont().deriveFont(titleFontSize+10));
        } else {
            achievementTitle = new JLabel("Achievements for NOT " + playerInFirst);
            achievementTitle.setFont(achievementTitle.getFont().deriveFont(titleFontSize));
        }

        // Components

        List<JLabel> achievementImageLabels = new ArrayList<>();
        for (Achievement achievement : game.getAchievements()) {
            JLabel imageLabel = new JLabel(scaleImageIcon(new ImageIcon(achievement.getImagePath()), cardImageSizePercentage));
//            imageLabel.setBounds(100, 100, 400, 400);
//            imageLabel.setVisible(true);
            achievementImageLabels.add(imageLabel);
        }

        JLabel bonusAchievementTitle = new JLabel("\n\n\nBonus Achievement for " + playerInLast);
        bonusAchievementTitle.setFont(bonusAchievementTitle.getFont().deriveFont(titleFontSize));
        JLabel bonusAchievementLabel = new JLabel(scaleImageIcon(new ImageIcon(game.getBonusAchievement().getImagePath()), cardImageSizePercentage));

        JButton recordResultsButton = new JButton("Finish and Record");

        // Add behavior to components
        recordResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Your button action goes here
                superFrame.dispose();
            }
        });

        // Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // First Row
        gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 1;
        gc.gridy = 0;

        add(achievementTitle, gc);

        // Second row
        gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 1;

//        setLayout(new FlowLayout());

//        add(bonusAchievementLabel, gc);

        for (JLabel achievementImage : achievementImageLabels) {
            add(achievementImage, gc);
            gc.gridx++;
        }

        // Only render if this is not the first session
        if (!isFirstSession) {
            // Next row
            gc.gridy++;
            gc.gridx = 1;
            add(bonusAchievementTitle, gc);

            // Next row
            gc.gridy++;
            add(bonusAchievementLabel, gc);
        }

        // Next row
        gc.gridx = 1;
        gc.gridy++;
        add(recordResultsButton, gc);

    }

    private ImageIcon scaleImageIcon(ImageIcon imageIcon, double percentage) {
        int newWidth = (int) Math.round(imageIcon.getIconWidth() * percentage);
        int newHeight = (int) Math.round(imageIcon.getIconHeight() * percentage);

        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(newWidth, newHeight,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

//    private BufferedImage scaleImage(BufferedImage image, double percentage) {
//        long newWidth = Math.round(image.getWidth() * percentage);
//        long newHeight = Math.round(image.getHeight() * percentage);
//        image.getScaledInstance(newWidth, newHeight)
//    }
}
