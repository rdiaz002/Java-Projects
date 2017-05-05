//Ronuel Diaz
//SoftWare Design Lab
//Assignment 3
//Triangle Class
package venndiagramv2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Triangle extends Shape implements ShapeInterface {

    double sideA, sideB, sideC;

    public Triangle(double sideA, double sideB, double sideC) { // Scalene
        super(0, 0, Color.WHITE);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        if (!isTriangle()) {
            System.out.println("Not A Triangle");
        }
    }

    public Triangle(double sideA, double sideB) { // Isosceles
        super(0, 0, Color.ORANGE);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideB;
        if (!isTriangle()) {
            System.out.println("Not A Triangle");
        }
    }

    public Triangle(double sideA) {//Equilateral 
        super(0, 0, Color.BLUE);
        this.sideA = sideA;
        this.sideB = sideA;
        this.sideC = sideA;
        if (!isTriangle()) {
            System.out.println("Not A Triangle");
        }
    }

    public final boolean isTriangle() {
        return ((sideA + sideB) > sideC) && ((sideA + sideC) > sideB) && ((sideC + sideB) > sideA);
    }

    @Override
    public double getArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt((s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
    
    public String getSides() {
        return (String.valueOf(sideA) + "," + String.valueOf(sideB) + "," + String.valueOf(sideC));

    }

    public double getAngleA() {
        double angleA = Math.acos(((Math.pow(sideA, 2) - Math.pow(sideB, 2) - Math.pow(sideC, 2)) / (-2 * sideB * sideC)));
        return angleA;
    }

    public double getAngleB() {
        double angleB = (double) Math.acos(((Math.pow(sideB, 2) - Math.pow(sideA, 2) - Math.pow(sideC, 2)) / (-2 * sideA * sideC)));
        return angleB;
    }

    public double getAngleC() {
        double angleC = (double) Math.acos(((Math.pow(sideC, 2) - Math.pow(sideB, 2) - Math.pow(sideA, 2)) / (-2 * sideB * sideA)));
        return angleC;
    }

    public String getAngles() {
        return (String.valueOf(Math.toDegrees(getAngleA())) + "," + String.valueOf(Math.toDegrees(getAngleB())) + "," + String.valueOf(Math.toDegrees(getAngleC())));
    }

    @Override
    public String toString() {
        String figure = "(" + getSides() + ")" + " " + "(" + getAngles() + ")" + " " + "(" + String.valueOf(getPerimeter()) + "," + String.valueOf(getArea()) + ")";
        return figure;
    }

    
    @Override
    public void draw(Graphics g) {
        if (!isTriangle()) {
            System.out.println("Not A Triangle");
        } else {
            Random rand = new Random();
            int[] pointsx = new int[3];
            int[] pointsy = new int[3];
            pointsx[0] = getX();
            pointsy[0] = getY();
            double a = getAngleA() + ((Math.PI - getAngleA()) / 2);
            pointsx[1] = (int) (sideC * Math.cos(a) + getX());
            pointsy[1] = (int) (sideC * Math.sin(a) + getY());
            double tempangle = (a - getAngleA());
            pointsx[2] = (int) ((sideB * Math.cos(tempangle)) + getX());
            pointsy[2] = (int) ((sideB * Math.sin(tempangle)) + getY());
            float r = rand.nextFloat();
            float gr = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, gr, b);
            setColor(randomColor);
            g.setColor(getColor());
            g.fillPolygon(pointsx, pointsy, 3);
        }

    }
}
