//Ronuel Diaz
//Software Design Lab Assignment 1
package assignment1;

import javax.swing.JFrame;

/**
 *
 * @author Ronny
 */
public class visuals {

    //Incharge of the Frame
    public static void main(String[] args) {
        graphicsHandler panel = new graphicsHandler();
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(1440, 1000);
        application.add(panel);
        application.setVisible(true);
    }

}
