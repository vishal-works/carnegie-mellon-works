/**
 * Homework 2 to Compute Check Digit of a 12-Digit UPC Number.
 * @author Vishal Vaidhyanathan (vvaidhya@andrew.cmu.edu)
 */

public class CheckDigit {
    public static void main(String[] args) {
        String inputBarCode = args[0];
        String barCode = inputBarCode;
        long[] d = new long[11];
        long checkDigit = 0;
        for (int i = 0; i < 11; i++) {
            d[i] = Character.getNumericValue(barCode.charAt(i));
        }
        checkDigit = (10 - (3 * (d[0] + d[2] + d[4] + d[6] + d[8] + d[10]) + d[1] + d[3] + d[5] + d[7] + d[9]) % 10) % 10;
        System.out.println(inputBarCode);
        System.out.println(checkDigit);
    }
}
