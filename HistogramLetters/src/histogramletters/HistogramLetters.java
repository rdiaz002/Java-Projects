/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package histogramletters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import histogramletters.drawpie;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronny
 */
public class HistogramLetters {

    letters[] counter = new letters[26];
    int totalcount = 0;

    public HistogramLetters() {

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        List<Character> file = new ArrayList<Character>();
        try {
            Scanner sc = new Scanner(new File("src\\xWords.txt"));
            while (sc.hasNext()) {
                String buffer = sc.next();
                buffer = buffer.replaceAll("[^a-z]", "");

                for (int k = 0; k < buffer.toCharArray().length; k++) {
                    file.add(buffer.toCharArray()[k]);
                }

            }

            for (int i = 0; i < alphabet.length; i++) {
                counter[i] = new letters(alphabet[i]);
                for (int j = 0; j < file.size(); j++) {

                    if (file.get(j) == alphabet[i]) {
                        counter[i].setcount();
                        totalcount++;

                    }
                }
              

            }
            System.out.println(totalcount);
            
        } catch (FileNotFoundException e) {

        }
        Arrays.sort(counter);
        
        drawPieChart();

    }

    public void drawPieChart() {
        JFrame application = new JFrame();
        drawpie pie = new drawpie();
        pie.counter_array = counter;
        
        pie.number_of_letters =Integer.parseInt(JOptionPane.showInputDialog(application, "Whats the highest number of letters in the pie chart?(has to be less than 27)"));
        
        pie.total_number = totalcount;
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(800, 800);
        application.add(pie);
        application.setVisible(true);

    }

}
