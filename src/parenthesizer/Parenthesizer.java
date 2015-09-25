/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parenthesizer;

/**
 *
 * @author grb23
 */
public class Parenthesizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fraction f1 = new Fraction(5, 6);
        
        Fraction f2 = new Fraction(2, 6);
        
        Fraction f3 = f1.sub(f2);
        
        System.out.println(f3);
    }
    
}
