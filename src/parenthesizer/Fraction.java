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
public class Fraction {
    
    private int num, denom;
    
    public Fraction(int num, int denom) {
        if(denom == 0) {
            throw new ArithmeticException();
        }
        
        this.num = num;
        this.denom = denom;
    
    }
    
    private static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            int c = b;
            b = a % b;
            a = c;
        }
            
            return a + b;
    }
    
    public Fraction add(Fraction otherFraction) {
        int newNum = (num*otherFraction.denom + denom*otherFraction.num);
        int newDenom = denom*otherFraction.denom;
        
        int gcd = gcd(newNum, newDenom);
        
        int rNum = newNum/gcd;
        int rDenom = newDenom/gcd;
        
        return new Fraction(rNum, rDenom);
        
    }
    
    public Fraction sub(Fraction otherFraction) {
        int newNum = (num*otherFraction.denom - denom*otherFraction.num);
        int newDenom = denom*otherFraction.denom;
        
        int gcd = gcd(newNum, newDenom);
        
        System.out.println(gcd);
        
        int rNum = newNum/gcd;
        int rDenom = newDenom/gcd;
        
        System.out.println(rNum);
        System.out.println(rDenom);
        return new Fraction(rNum, rDenom);
    }
    
    public Fraction mult(Fraction otherFraction) {
        
        return null;
    }
    
    public Fraction div(Fraction otherFraction){
        
        if(rDenom == 0) {
            throw new ArithmeticException();
        }
    }
    
    @Override
    public String toString() {
        return num + "/" + denom;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fraction) {
            boolean num1 = ((Fraction) obj).num == num;
            boolean denom1 = ((Fraction) obj).denom == denom;
            
            return num1 && denom1;
        }
        return false;
    }
    
}
