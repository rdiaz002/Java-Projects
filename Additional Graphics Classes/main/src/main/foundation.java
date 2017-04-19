//Ronuel Diaz
//SoftWare Design Lab
//Assignment 3

//File in Charge of Painting the Component onto the Jpanel 
package main;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class foundation extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Triangle tri = new Triangle(100,90);
        Triangle tri2 = new Triangle(100,100,100*Math.sqrt(2));
        Triangle tri3 = new Triangle(100);
        
        Circle cir = new Circle(100, getWidth()/2, getHeight()/2);
        Circle cir2 = new Circle(200, getWidth()/2, getHeight()/2);
        Circle cir3 = new Circle(300, getWidth()/2, getHeight()/2);
        
        g.drawLine(0, 0, getWidth(), getHeight());
        
        tri.setX(100);
        tri.setY(100);
        
        tri2.setX(200);
        tri2.setY(200);
        
        tri3.setX(650);
        tri3.setY(635); 
        
        cir3.setColor(Color.LIGHT_GRAY);
        cir3.draw(g);
        
        cir2.setColor(Color.DARK_GRAY);
        cir2.draw(g);
        
        cir.setColor(Color.WHITE);
        cir.draw(g);
        
        tri.draw(g);
        tri2.draw(g);
        tri3.draw(g);
        
        g.setColor(Color.MAGENTA);
        g.drawString(tri.toString(),100,100);
        g.drawString(tri2.toString(),200,200);
        g.drawString(tri3.toString(),650,635);
       
        
    }
    
    
}
