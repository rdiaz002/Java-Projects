//Ronuel Diaz
//SoftWare Design Lab
//Assignment 4
//Base Shape Class 
package venndiagramv2;

import java.lang.Object;
import java.awt.Graphics;
import java.awt.Color;

public abstract class Shape extends Object {

    private int x, y;
    public Color color = null;

    public Shape(int x, int y, Color color) { // Constructor
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void moveTo(int x, int y) { // moves shape to different location on the Panel
        this.x = x;
        this.y = y;
    }

    @Override
    abstract public String toString();

    abstract public void draw(Graphics g);

}
