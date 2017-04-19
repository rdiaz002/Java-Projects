//Ronuel Diaz
//SoftWare Design Lab
//Assignment 3

//Circle Class 
package main;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
int radius,x,y;
    public Circle(int radius,int x,int y) {
        super(x-(radius),y-(radius),Color.GREEN);
        this.radius=radius;
        this.x=x;
        this.y=y;
    }
   public float getArea(){
        return (float)(Math.PI*Math.pow(radius, 2));
        
    }
    public float getPerimeter(){
        return (float)(2*Math.PI*radius);
    }
    public float getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
     public String toString(){
       String figure = String.valueOf(radius)+","+ String.valueOf(getPerimeter())+","+ String.valueOf(getArea());
       return figure;
    }
     
     @Override
    public void draw(Graphics g){
        g.setColor(getColor());
        g.fillOval(getX(), getY(), radius*2, radius*2);
        
    }
}
