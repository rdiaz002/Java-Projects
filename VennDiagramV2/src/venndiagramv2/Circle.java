//Ronuel Diaz
//SoftWare Design Lab
//Assignment 3
//Circle Class 
package venndiagramv2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Circle extends Shape implements ShapeInterface {

    int radius, x, y;
    Graphics g;

    public Circle(double radius, int x, int y) {
        super(x - (int) (radius), y - (int) (radius), Color.GREEN);
        this.radius = (int) radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public double getArea() {
        return (Math.PI * Math.pow(radius, 2));

    }

    @Override
    public double getPerimeter() {
        return (2 * Math.PI * radius);
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = (int) radius;
    }

    @Override
    public String toString() {
        String figure = String.valueOf(radius) + "," + String.valueOf(getPerimeter()) + "," + String.valueOf(getArea());
        return figure;
    }

    public void Intersection(Circle obj) {
        double x = ((obj.x * obj.x) - (this.x * this.x)) / ((2 * obj.x) - (2 * this.x));

        double c1 = (this.y * this.y) - ((1 - ((((x * x) - (2 * this.x) * x) + (this.x * this.x)) / (radius * radius))) * ((radius) * (radius)));
        double a1 = 1;
        double b1 = 2 * (-this.y);
        double d1 = b1 * b1 - 4 * a1 * c1;
        int root1 = (int) ((-b1 + Math.sqrt(d1)) / (2 * a1));
        int root2 = (int) ((-b1 - Math.sqrt(d1)) / (2 * a1));

        int size = root1 - root2;
        int[] x_path = new int[size * 2];
        int[] y_path = new int[size * 2];
        int count = 0;

        for (double y = root1; y > root2; y--) {
            double part1 = 1 - (((y - this.y) * (y - this.y)) / (this.radius * this.radius));
            double c = (this.x * this.x) - (part1 * (this.radius * this.radius));
            double b = -2 * this.x;
            double a = 1;
            double d = b * b - 4 * a * c;
            double root3 = (int) ((-b + Math.sqrt(d)) / (2 * a)) + 1;

            y_path[count] = (int) y;
            x_path[count++] = (int) root3;

        }
        for (double y = root2; y < root1; y++) {
            double part1 = 1 - (((y - obj.y) * (y - obj.y)) / (obj.radius * obj.radius));
            double c = (obj.x * obj.x) - (part1 * (obj.radius * obj.radius));
            double b = -2 * obj.x;
            double a = 1;
            double d = b * b - 4 * a * c;
            double root4 = (-b - (double) Math.sqrt(d)) / (2 * a) + 1;
            y_path[count] = (int) y;
            x_path[count++] = (int) root4;

        }
        Random rand = new Random();
        float r = rand.nextFloat();
        float gr = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, gr, b);
        setColor(randomColor);
        g.setColor(getColor());
        g.fillPolygon(x_path, y_path, y_path.length);

    }

    @Override
    public void draw(Graphics g) {
        this.g = g;
        if (this.color != null) {
            Random rand = new Random();
            float r = rand.nextFloat();
            float gr = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, gr, b);
            setColor(randomColor);
            g.setColor(getColor());
            g.fillOval(getX(), getY(), radius * 2, radius * 2);
        } else {
            g.setColor(new Color(238, 238, 238));
            g.fillOval(getX(), getY(), radius * 2, radius * 2);
        }

    }
}
