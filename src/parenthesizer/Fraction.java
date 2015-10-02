
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

    /**
     * The gcd() method takes two integer parameters and
     * finds the greatest common divisor of them.
     *
     * @param a Numerator of the input fraction.
     * @param b Denominator of the input fraction.
     * @return  Summation of a mod b plus the denominator parameter.
     */
    private static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            int c = b;
            b = a % b;
            a = c;
        }
        return a + b;
    }

    /**
     * The reduce() method reduces the final fraction by dividing
     * the numerator and denominator by the GCD.
     *
     * @param a Numerator of the input fraction.
     * @param b Denominator of the input fraction.
     * @return  The newly reduced fraction.
     */
    private static Fraction reduce(int a, int b) {
        int gcd = gcd(a, b);

        int rNum = a/gcd;
        int rDenom = b/gcd;

        return new Fraction(rNum, rDenom);
    }

    /**
     * The add() method adds two fractions together and returns
     * the reduced version.
     *
     * @param otherFraction The input fraction that is being added
     *                      to another outside fraction.
     * @return              The reduced summation of the fraction.
     */
    public Fraction add(Fraction otherFraction) {
        int newNum = (num*otherFraction.denom + denom*otherFraction.num);
        int newDenom = denom*otherFraction.denom;

        int gcd = gcd(newNum, newDenom);

        Fraction newFract = reduce(newNum, newDenom);

        return newFract;
    }

    /**
     * The sub() method finds the difference of two fractions
     * and returns the reduced version.
     *
     * @param otherFraction The input fraction that is being subtracted
     *                      from another outside fraction.
     * @return              The reduced difference of the two fractions.
     */
    public Fraction sub(Fraction otherFraction) {
        int newNum = (num*otherFraction.denom - denom*otherFraction.num);
        int newDenom = denom*otherFraction.denom;

        int gcd = gcd(newNum, newDenom);

        Fraction newFract = reduce(newNum, newDenom);

        return newFract;
    }

    /**
     * The mult() method multiplies two fractions togehter and
     * returns the reduced version.
     *
     * @param otherFraction The input fraction that is being multiplied
     *                      to another outside fraction.
     * @return              The reduced product of the two fractions.
     */
    public Fraction mult(Fraction otherFraction) {
        int newNum = num*otherFraction.num;
        int newDenom = denom*otherFraction.denom;

        int gcd = gcd(newNum, newDenom);

        Fraction newFract = reduce(newNum, newDenom);

        return newFract;
    }

    /**
     * The div() method divides one fraction by the
     * other and returns the reduced version.
     *
     * @param otherFraction The input fraction that is dividing
     *                      the other outside fraction.
     * @return              The reduced version of the divided fraction.
     */
    public Fraction div(Fraction otherFraction){
        int newNum = num*otherFraction.denom;
        int newDenom = denom*otherFraction.num;

        int gcd = gcd(newNum, newDenom);

        Fraction newFract = reduce(newNum, newDenom);

        if(newDenom == 0) {
            throw new ArithmeticException();
        }
        return newFract;
    }

    /**
     * The toString() method that has been overwritten
     * to format the fraction string for output.
     *
     * @return The formatted string of the fraction.
     */
    @Override
    public String toString() {
        return num + "/" + denom;
    }

    /**
     * The equals() method that has been overwritten
     * to return true or false depending on if the
     * two fractions are equal or unequal.
     *
     * @param obj The object to be compared.
     * @return    True if both the numerators and denominators are equal,
     *            false if they are not equal.
     */
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