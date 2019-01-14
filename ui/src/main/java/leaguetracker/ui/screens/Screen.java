package leaguetracker.ui.screens;

import leaguetracker.ui.BackendInterface;

public abstract class Screen {
    /**
     * The text that appears at the top of a screen, like a title
     */
    protected String displayText;

    /**
     * A controller for calling the backend API to perform backend tasks
     */
    protected BackendInterface backendInterface = new BackendInterface();

    /**
     * Creates a new screen
     *
     * @param displayText - the display text
     */
    public Screen(final String displayText) {
        this.displayText = displayText;
    }

    /**
     * A method that all Screens must implement that prints out the desired appearance of the screen
     * @return the next screen to render
     */
    public abstract Screen render();

    /**
     * A common way to print out all display text
     */
    protected void printDisplayText() {
        // If there is display text, show it like:
        /*

        Welcome to this screen!


         */
        if (null != displayText) {
            System.out.println("\n" + displayText + "\n");
        }
    }

//    @Override
//    public String toString() {
//        StringBuilder displayString = new StringBuilder();
//
//        // If you have some display text on this screen, put that at the top like:
//        //
//        // Welcome! This is some Display Text!
//        if (null != displayText) {
//            displayString.append("\n").append(displayString).append("\n\n");
//        }
//
//        // If you have any user actions put that next, like:
//        //
//        // Welcome! This is some Display Text!
//        //
//        //
//        // 1. user action 1
//        // 2. user action 2
//        if (null != userActions) {
//            displayString.append(userActions.toString()).append("\n\n");
//        }
//
//        // If you have any text fields, put them next, like:
//        //
//        // Welcome! This is some Display Text!
//        //
//        //
//        // 1. user action 1
//        // 2. user action 2
//        //
//        //
//        // Name: _______
//        // Achievement: ________
//        if (null != textFields) {
//            displayString.append(textFields.toString());
//        }
//
//        return displayString.toString();
//     }

}

