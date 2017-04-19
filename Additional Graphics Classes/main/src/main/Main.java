//Ronuel Diaz
//SoftWare Design Lab
//Assignment 3

//Main 
package main;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main {

    public static void main(String[] args) {
        JFrame application = new JFrame();
        foundation f = new foundation();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(1000, 1000);
        application.add(f);
        application.setVisible(true);
        
        
    }
    
}
