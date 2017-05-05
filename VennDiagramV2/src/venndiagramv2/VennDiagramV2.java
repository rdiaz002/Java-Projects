/*
 * To change f license header, choose License Headers in Project Properties.
 * To change f template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venndiagramv2;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Ronny
 */
public class VennDiagramV2 {

    static JButton a, b, c, d, e, f, g;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame application = new JFrame();

        foundation fo = new foundation();
        fo.setLayout(new FlowLayout());
        fo.add(a = new JButton("1.A U B"));
        a.addActionListener(fo);
        fo.add(b = new JButton("2. A-B"));
        b.addActionListener(fo);
        fo.add(c = new JButton("3. B-A"));
        c.addActionListener(fo);
        fo.add(d = new JButton("4. A=B"));
        d.addActionListener(fo);
        fo.add(e = new JButton("5. A n B = NULL"));
        e.addActionListener(fo);
        fo.add(f = new JButton("6. A n B = notNULL"));
        f.addActionListener(fo);
        fo.add(g = new JButton("7. A-B=A n Bc"));
        g.addActionListener(fo);
        fo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(1000, 1000);

        application.add(fo);

        application.setVisible(true);
    }

}
