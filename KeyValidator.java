
// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2024T1, Assignment 2
 * Name: Syeda Nusaiba Samin
 * Username: Saminsyed
 * ID: 300660917
 */

import ecs100.*;
import java.awt.Color;

/**
 * Asks user for a key word and checks whether it meets a set of rules or not.
 */

public class KeyValidator {

    /**
     * Asks user for key word and then checks if it is a valid key word.
     */
    public void checkKey(){
        UI.clearText();
        String key = UI.askString("Key:   ");
        UI.println();
        this.validateKey(key);
    }

    /**
     * Report that the key is valid or report ALL the rules that the key failed.
     */
    public void validateKey(String key){
        //boolean that will report back if password passed
        boolean check = true;
        
        //check lenght 6-12 accepted
        if (key.length() < 6 || key.length() > 12) {
            check = false;
            // seperate error messages
            if ((key.length() < 6)) {
                UI.println("Key must be longer than 6 characters");
            } else {
                UI.println("Key must be shorter than 12 charcters");
            }
        }
        // checks if contains @
        if (key.contains("@")) {
            check = false;
            UI.println("Do not use '@'");
        }
        //checks if starts with ?,! or @
        if (key.startsWith("?") || key.startsWith("!")) {
            check = false;
            UI.println("do not start with '?, !'");
        }
        //capital and lowrcase letter check
        if (key.equals(key.toLowerCase()) || key.equals(key.toUpperCase())) {
            check = false;
            //seperate errors messages
            if (key.equals(key.toLowerCase())) {
                UI.println("Have at least 1 capital letter");
            } else {
                UI.println("Have at least 1 lowercase letter");
            }
        }
        //final report to see if the key passed
        if (check == true) {
            UI.println("key set :)");
        } else {
            UI.println("Please try again :(");
        }
    }


    /**
     * Setup GUI and buttons
     */
    public void setupGUI(){
        UI.initialise();
        UI.addButton("Clear", UI::clearText );
        UI.addButton("Check Key", this::checkKey );
        UI.addButton("Quit", UI::quit );
        UI.setDivider(1);       // Expand the text area
    }

    /**
     * Create object and call setupGUI on it
     */ 
    public static void main(String[] args){
        KeyValidator kv = new KeyValidator();
        kv.setupGUI();
    }
}
