/*************************************
 * PowersOfTwo.java
 * @author Dr. Aaron Mininger
 *
 * A program that takes 1 argument N
 * And prints all powers of 2 up to N
 ***********************************/
public class PowersOfTwo {
    public static void main(String[] args) {
		// Arg 1: n (int) - max power of 2 to print
        int n = Integer.parseInt(args[0]);

		// Version 1 - using while loop
        int power = 1;
        int i = 0;
        while (i <= n) {
            System.out.printf("2^%d = %d\n", i, power);
            power *= 2;
            i++;
        }

		// Version 2 (equivalent to while loop)
		power = 1;
		for (int j = 0; j <= n; j++) {
            System.out.printf("2^%d = %d\n", j, power);
            power *= 2;
		}

		// Version 3 (equivalent to while loop)
		power = 1;
		for (int j = 0; j <= n; power *= 2, j++) {
            System.out.printf("2^%d = %d\n", j, power);
            power *= 2;
		}
    }
}
