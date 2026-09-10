/*************************************
 * PrintSqrt.java
 * @author Dr. Aaron Mininger
 *
 * A simple program that takes 1+ numbers
 *   and prints the square root of each
 ***********************************/
public class PrintSqrt {
    public static void main(String[] args) {
		int i = 0;
        while (i < args.length) {
            double x = Double.parseDouble(args[i]);
            if (x >= 0) {
                System.out.printf("sqrt(%.3f) = %.3f\n", x, Math.sqrt(x));
            }
            i++;
        }
    }
}
