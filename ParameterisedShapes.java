// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2024T1, Assignment 2
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;


/** Parameterised Shapes: 
 * Pass/Fail level: draw rectangles with three horizontal stripes
 * Challenge: draw the flag of China
 */
public class ParameterisedShapes{

    /**
     * Asks user for a position, three colours, three heights and whether the circles are filled.
     * Then calls the drawFancyRect method, passing the appropriate arguments
     */
    public void doFancyRect(){
        double left = UI.askDouble("Left of rectangle");
        double top = UI.askDouble("Top of rectangle");
        
        UI.println("Now choose the colours");
        Color col1 = JColorChooser.showDialog(null, "First Stripe", Color.white);
        Color col2 = JColorChooser.showDialog(null, "Second Stripe", Color.white);
        Color col3 = JColorChooser.showDialog(null, "Third Stripe", Color.white);
        UI.println("Now choose the sizes");
        int topH = UI.askInt("Top rectangle height: ");
        int midH = UI.askInt("Middle rectangle height: ");
        int botH = UI.askInt("Bottom rectangle width: ");
        UI.println("To Fill or not to Fill...");
        boolean filling = UI.askBoolean("That is the question(y/n): ");
        drawFancyRect(col1, col2, col3, left, top, topH, midH, botH, filling);
    }

    /**
     * Calculates the total height and width of the rectangle.
     * The width of the rectangle is 1.5 times the height of the rectangle.
     * It then calls drawStripe three times to draw the three stripes,
     * and outlines the rectangle with a black contour.
     */
    public void drawFancyRect(Color c1, Color c2, Color c3, double xPos, double topY, double tH, double mH, double bH, boolean fill){
        UI.clearGraphics();
        double h = tH + mH + bH;
        double w = h * 1.5; // width of rectngle
        double midY = topY + tH; // y pos of mid rectangle
        double botY = midY + mH; // y pos of bottom rectangle
        
        drawStripe(c1, xPos, topY, w, tH, 0.1666667, fill); //top
        drawStripe(c2, xPos, midY, w, mH, 0.5, fill); // mid
        drawStripe(c3, xPos, botY, w, bH, 0.833333, fill); //bottom
        UI.setColor(Color.black);
        UI.drawRect(xPos, topY, w, h);
    }

    /**
     * Draws a stripe at the given position that has the right circle at the right place.
     */
    public void drawStripe(Color col, double left_pos, double top_pos, double width, double height, double circPos, boolean f){
        double circW = 0.2 * height;
        double circY = top_pos + height/2 - circW/2;
        double circX = left_pos + (width * circPos);
        // rect
        UI.setColor(col);
        UI.fillRect(left_pos, top_pos, width, height);
        //circle
        UI.setColor(Color.black);
        if (f == true) {
            UI.fillOval(circX ,circY, circW, circW);
        } else {
            UI.drawOval(circX ,circY, circW, circW);
        }
    }

    public void setupGUI(){
        UI.initialise();
        UI.addButton("Clear", UI::clearPanes );
        UI.addButton("Fancy Rect", this::doFancyRect );
        // Add a button here to call your method for the challenge part
        UI.addButton("Quit", UI::quit );
    }

    public static void main(String[] args){
        ParameterisedShapes ps = new ParameterisedShapes ();
        ps.setupGUI();
    }

}
