/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package histogramletters;

/**
 *
 * @author Ronny
 */
public class letters implements Comparable<letters> {

    char let;
    int count;

    public letters(char a) {
        let = a;
        count = 0;
    }

    public void setcount() {
        count++;
    }

    @Override
    public int compareTo(letters o) {
        int counter = o.count;
        return counter - this.count;
    }

}
