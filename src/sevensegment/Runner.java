/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevensegment;

/**
 *
 * @author ashu
 */
public class Runner {
    public static void main(String[] args) {    
        SevenSegment ss = new SevenSegment();
        String[] numbers = ss.convert("D:\\Audacy\\sample-input.txt");
        for (String number : numbers)     
            System.out.println(number);        
    }
}
