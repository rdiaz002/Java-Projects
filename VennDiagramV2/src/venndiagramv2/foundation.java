//Ronuel Diaz
//SoftWare Design Lab
//Assignment 3
//File in Charge of Painting the Component onto the Jpanel 
package venndiagramv2;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class foundation extends JPanel implements ActionListener {

    JButton a, b, c, d, e, f, g;
    int ID = 1;

    @Override
    public void actionPerformed(ActionEvent e) {
        int num = e.getSource().toString().indexOf("text=");
        ID = Character.getNumericValue(e.getSource().toString().charAt(num + 5));
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (ID) {

            case 1:
                Circle cir1 = new Circle(getWidth() / 5, getWidth() - (getWidth() / 3), getHeight()/2);
                Circle cir2 = new Circle(getWidth() / 5, getWidth() / 3, getHeight()/2);
                g.setColor(Color.BLACK);
                g.drawString("B", cir1.getX() + (getWidth() / 5), cir1.getY() - 25);
                g.drawString("A", cir2.getX() + (getWidth() / 5), cir2.getY() - 25);
                cir1.draw(g);
                cir2.draw(g);
                cir2.Intersection(cir1);
                break;
            case 2:
                Circle cir5 = new Circle(getWidth() / 5, getWidth() - (getWidth() / 3),getHeight()/2);
                Circle cir6 = new Circle(getWidth() / 5, getWidth() / 3, getHeight()/2);
                g.drawString("A-B", cir6.getX() + (getWidth() / 5), cir6.getY() - 25);
                cir6.draw(g);
                cir5.setColor(null);
                cir5.draw(g);
                break;
            case 3:
                Circle cir3 = new Circle(getWidth() / 5, getWidth() - (getWidth() / 3),getHeight()/2);
                Circle cir4 = new Circle(getWidth() / 5, getWidth() / 3, getHeight()/2);
                g.drawString("B-A", cir3.getX() + (getWidth() / 5), cir3.getY() - 25);
                cir3.draw(g);
                cir4.setColor(null);
                cir4.draw(g);
                break;
            case 4:
                Circle cir7 = new Circle(getWidth() / 5, getWidth() / 2, getHeight()/2);
                g.drawString("A=B", cir7.getX() + (getWidth() / 5), cir7.getY() - 25);
                cir7.draw(g);
                break;
            case 5:
                Circle cir8 = new Circle(getWidth() / 5, getWidth() - (getWidth() / 3), getHeight()/2);
                Circle cir9 = new Circle(getWidth() / 5, getWidth() / 5, getHeight()/2);
                g.drawString("A", cir8.getX() + (getWidth() / 5), cir8.getY() - 25);
                g.drawString("B", cir9.getX() + (getWidth() / 5), cir9.getY() - 25);
                cir8.draw(g);
                cir9.draw(g);
                break;
            case 6:
                Circle cir10 = new Circle(getWidth() / 5, getWidth() - (getWidth() / 3), getHeight()/2);
                Circle cir11 = new Circle(getWidth() / 5, getWidth() / 3, getHeight()/2);
                g.drawString("AnB", getWidth() / 2, cir10.getY() - 25);
                cir11.setColor(null);
                cir11.draw(g);
                cir11.Intersection(cir10);
                break;
            case 7:
                Circle cir12 = new Circle(getWidth() / 5, getWidth() - (getWidth() / 3), getHeight()/2);
                Circle cir13 = new Circle(getWidth() / 5, getWidth() / 3, getHeight()/2);
                g.drawString("A-B=A n Bc", cir13.getX() + (getWidth() / 5), cir13.getY() - 25);
                cir13.draw(g);
                cir12.setColor(null);
                cir12.draw(g);
                break;
            default:
                System.out.println("default");
        }

    }

}
