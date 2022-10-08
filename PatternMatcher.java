// CSC1016S assignment 08
// Question 3
// Sibusiso Buthelezi
// BTHSIB016
// Date: 27/10/2021

// A java class that takes in user input to create a pattern, creates an Object array containing
// all the words that matches the pattern, and putting this array in the JList for display.

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatternMatcher implements ActionListener {
    private JTextField userInputField;
    private WordList dictionary;
    private JList JListRef;


    public PatternMatcher(JTextField inputField, WordList dictionary, JList matches){
        userInputField = inputField;
        this.dictionary = dictionary;
        JListRef = matches;
    }

    public void actionPerformed(ActionEvent e) {
        // Obtain the text input by the user.
        String input = userInputField.getText();

        // Create a new Pattern object with the text input by the user.
        Pattern pattern = new Pattern(input);

        // Find all the words that match the pattern create above from the dictionary
        // and store them in a new WordList object.
        WordList foundWords = dictionary.match(pattern);

        // Copy all the matching words from foundWords into an Object array.
        Object[] foundWordsList = new Object[foundWords.size()];
        int index = 0;
        for (Word word : foundWords){
            foundWordsList[index] = word;
            index++;
        }

        // Pass the Object array foundWordsList in the JList for display.
        JListRef.setListData(foundWordsList);
    }
}

