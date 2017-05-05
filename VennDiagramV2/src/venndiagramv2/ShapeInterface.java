//Ronuel Diaz
//SoftWare Design Lab
//Assignment 4
//Shape Interface
package venndiagramv2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Ronny
 */
public interface ShapeInterface {

    public double getArea();

    public double getPerimeter();

    public String toString();

    public void draw(Graphics g);

    public int getX();

    public void setX(int x);

    public int getY();

    public void setY(int y);

    public Color getColor();

    public void setColor(Color color);

    public void moveTo(int x, int y);

}
