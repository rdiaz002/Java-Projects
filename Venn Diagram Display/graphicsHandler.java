//Ronuel Diaz 
//Software Design Lab Assignment 1
package assignment1;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class graphicsHandler extends JPanel {

    boolean firstime = false;
    int[] x_path;
    int[] y_path;
    Object choice;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (firstime == false) {
            JDialog.setDefaultLookAndFeelDecorated(true);
            String[] PossibleValues = {"Intersection", "No Intersection", "Overlapping", "Far Apart"};
            String initialValue = "No Intersection";
            choice = JOptionPane.showInputDialog(null, "what would you like to be shown?", "Venn Diagram", JOptionPane.QUESTION_MESSAGE, null, PossibleValues, initialValue);
            firstime = true;
        }

        switch ((String) choice) {

            case "Intersection":
                //draws ovals
                g.clearRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.red);
                g.fillOval(40, 0, getWidth() / 2, getHeight());
                g.drawOval(40, 0, getWidth() / 2, getHeight());
                g.setColor(Color.green);
                g.fillOval(getWidth() / 2 - 100, 0, getWidth() / 2, getHeight());
                g.drawOval(getWidth() / 2 - 100, 0, getWidth() / 2, getHeight());
                g.setColor(Color.black);
                double center2x = getWidth() / 2 - 100 + getWidth() / 4;
                double center2y = getHeight() / 2;
                g.drawString("Set B", (int) center2x - 10, (int) center2y - 10);
                double center1x = (getWidth() / 4) + 40;
                double center1y = getHeight() / 2;
                g.drawString("Set A", (int) center1x - 10, (int) center1y - 10);

                //retrieves intersection points
                double[] info = intersections(center1x, center1y, getHeight() / 2, getWidth() / 4, center2x, center2y);
                int x = (int) info[0];
                int y1 = (int) info[1];
                int y2 = (int) info[2];
                polypath(y1, y2, getHeight() / 2, center1y, center1x, getWidth() / 4, getHeight() / 2, center2y, center2x, getWidth() / 4);

                //draws intersection 
                g.drawPolygon(x_path, y_path, y_path.length);
                g.setColor(Color.cyan);
                g.fillPolygon(x_path, y_path, y_path.length);
                g.setColor(Color.black);
                g.drawString("Set A_union_B", (getWidth() / 2) - 78, (getHeight() / 2) - 10);
                break;

            case "No Intersection":
                g.clearRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.red);
                g.fillOval(0, 0, getWidth() / 2, getHeight());
                g.drawOval(0, 0, getWidth() / 2, getHeight());
                g.setColor(Color.green);
                g.fillOval(getWidth() / 2, 0, getWidth() / 2, getHeight());
                g.drawOval(getWidth() / 2, 0, getWidth() / 2, getHeight());
                g.setColor(Color.BLACK);
                g.drawString("Set A", getWidth() / 4, getHeight() / 2);
                g.drawString("Set B", getWidth() - getWidth() / 4, getHeight() / 2);
                break;
            case "Overlapping":
                g.clearRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.blue);
                g.fillOval(getWidth() / 4, 0, getWidth() / 2, getHeight());
                g.drawOval(getWidth() / 4, 0, getWidth() / 2, getHeight());
                g.setColor(Color.white);
                g.drawString("Set A=B", (getWidth() / 2) - 5, (getHeight() / 2) - 5);

            case "Far Apart":
                g.clearRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.red);
                g.fillOval(0, 0, (getWidth() / 2) - 10, getHeight() - 10);
                g.drawOval(0, 0, (getWidth() / 2) - 10, getHeight() - 10);
                g.setColor(Color.green);
                g.fillOval(getWidth() / 2, 0, (getWidth() / 2) - 10, getHeight() - 10);
                g.drawOval(getWidth() / 2, 0, (getWidth() / 2) - 10, getHeight() - 10);
                g.setColor(Color.BLACK);
                g.drawString("Set A", (getWidth() / 4) - 10, (getHeight() / 2) - 10);
                g.drawString("Set B", (getWidth() - getWidth() / 4) - 10, (getHeight() / 2) - 10);
                break;
            default:
                break;

        }
    }

    //aslong as both ovals have the same y coordinate for their centers this function will work.
    public double[] intersections(double x1, double y1, double yradius, double xradius, double x2, double y2) {

        double[] values = new double[4];

        double x = ((x2 * x2) - (x1 * x1)) / ((2 * x2) - (2 * x1));

        double c = (y1 * y1) - ((1 - ((((x * x) - (2 * x1) * x) + (x1 * x1)) / (xradius * xradius))) * ((yradius) * (yradius)));
        double a = 1;
        double b = 2 * (-y1);
        double d = b * b - 4 * a * c;
        double root1 = (-b + Math.sqrt(d)) / (2 * a);
        double root2 = (-b - Math.sqrt(d)) / (2 * a);
        values[0] = x;
        values[1] = root1;
        values[2] = root2;

        return values;
    }

    //retrieves points that outline the intersection set.
    public void polypath(double y_start, double y_end, double y1_radius, double y1center, double x1center,
            double x1radius, double y2radius, double y2center, double x2center, double x2radius) {
        int size = (int) y_start - (int) y_end;
        x_path = new int[size * 2];
        y_path = new int[size * 2];
        int count = 0;

        for (double y = y_start; y > y_end; y--) {
            double part1 = 1 - (((y - y1center) * (y - y1center)) / (y1_radius * y1_radius));
            double c = (x1center * x1center) - (part1 * (x1radius * x1radius));
            double b = -2 * x1center;
            double a = 1;
            double d = b * b - 4 * a * c;
            double root1 = (-b + Math.sqrt(d)) / (2 * a);
            y_path[count] = (int) y;
            x_path[count++] = (int) root1;

        }
        for (double y = y_end; y < y_start; y++) {
            double part1 = 1 - (((y - y2center) * (y - y2center)) / (y2radius * y2radius));
            double c = (x2center * x2center) - (part1 * (x2radius * x2radius));
            double b = -2 * x2center;
            double a = 1;
            double d = b * b - 4 * a * c;
            double root2 = (-b - (double) Math.sqrt(d)) / (2 * a);
            y_path[count] = (int) y;
            x_path[count++] = (int) root2;

        }

    }

}
