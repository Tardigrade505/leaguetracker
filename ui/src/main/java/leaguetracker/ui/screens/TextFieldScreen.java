package leaguetracker.ui.screens;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public abstract class TextFieldScreen extends Screen {
    /**
     * A list of text fields that can be filled out
     */
    protected List<String> textFields;

    /**
     * The next screen to render
     */
    protected Screen nextScreen;

    public TextFieldScreen(final String displayText, final List<String> textFields) {
        super(displayText);
        this.textFields = textFields;
    }

    /**
     * A method that all TextFieldScreens must implement. Performs some
     * kind of action once the render is complete
     * @param fieldsWithResponses - A map of field names to their responses
     */
    protected abstract void onCompleteRender(HashMap<String, String> fieldsWithResponses);

    /**
     * Prints each text field one by one, waiting for user input between each
     * and saves the responses
     */
    protected HashMap<String, String> printTextFieldsAndGatherResponses() {
        HashMap<String, String> fieldsWithResponses = new HashMap<>();

        for (String textField : textFields) {
            System.out.print(textField + ": ");
            fieldsWithResponses.put(textField, getValidTextFieldInput());
        }
        return fieldsWithResponses;
    }

    /**
     * Prints each text field one by one, waiting for user input between each
     * and saves the responses as an array
     */
    protected List<String> printTextFieldsAndGatherResponsesAsArray() {
        List<String> responses = new ArrayList<>();

        for (String textField : textFields) {
            System.out.print(textField + ": ");
            responses.add(getValidTextFieldInput());
        }
        return responses;
    }

    private String getValidTextFieldInput() {
        Scanner sc = new Scanner(System.in);
        String userInput;
        while (true) {
            if (!(userInput = sc.nextLine()).isEmpty()) {
                break;
            } else {
                System.out.println("Invalid user input. Value may not be nothing. Try again.");
            }
        }
        return userInput;
    }
}
