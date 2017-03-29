/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package histogramletters;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import java.lang.Math;

/**
 *
 * @author Ronny
 */
public class drawpie extends JPanel {

    int total_number;
    int number_of_letters;
    letters[] counter_array;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int centerx = getWidth() / 2;
        int centery = getHeight() / 2;
        int pieHeight = 500;
        int pieWidth = 500;
        double start_angle = 0;
        int[] labelpoints = new int[2];
        double total_left = total_number;
        Random s = new Random();
        for (int i = 0; i < number_of_letters; i++) {
            total_left -= counter_array[i].count;
            double prob = (double) counter_array[i].count / (double) total_number;
            double angle = (prob * (360))+0.7;
            float r = s.nextFloat();
            float ge = s.nextFloat();
            float b = s.nextFloat();
            Color randomColor = new Color(r, ge, b); // generates random color
            labelpoints = find_label_point((start_angle + (angle + start_angle)) / 2, (pieWidth / 2) + 40);
            g.setColor(randomColor);
            g.fillArc((int) centerx - (pieWidth / 2), centery - (pieHeight / 2),
                    pieWidth, pieWidth, (int) start_angle, (int) angle);
            g.drawString((Character.toString(counter_array[i].let).toUpperCase())
                    + "," + (double) (Math.round(prob * 10000.00)) / 10000, labelpoints[0]
                    + (int) (centerx) - 20, (int) (centery) - labelpoints[1] + 18);
            start_angle += (angle)-0.7;
           
        }
        if(number_of_letters!=26){
        g.setColor(new Color(119, 136, 153));
        double prob = (double) total_left / (double) total_number;
        double angle = (prob * (360))+0.912;
        g.fillArc(centerx - (pieWidth / 2), centery - (pieHeight / 2), pieWidth,
            pieHeight, (int) start_angle,(int)angle);

        g.drawString("Other Letters,\n" + (double) (Math.round(prob * 10000.00)) / 10000,
               (int) (centerx)+275, (int) (centery)+9);
        }
    }

    public int[] find_label_point(double angle, int radius) { // finds where to
        //position the label in accordance to the wedge. 
        int[] points = new int[2];
        points[0] = (int) (radius * Math.cos((angle * Math.PI) / 180));
        points[1] = (int) (radius * Math.sin((angle * Math.PI) / 180));

        return points;

    }
}
