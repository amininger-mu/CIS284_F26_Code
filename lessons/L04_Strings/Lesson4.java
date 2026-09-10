/*************************************
 * Lesson4.java
 * @author Dr. Aaron Mininger
 *
 * Various examples involving printf
 ***********************************/
public class Lesson4 {

    public static void main(String[] args) {

		// Print fractions 1/1 -> 1/10 using printf
        int n = 1;
        while (n <= 10) {
            System.out.printf("%.3f\n", 1.0/n);
            n++;
        }

        // Basic printf Example

        String name = "Caroline"; 
        System.out.printf("Your name is %s\n", name);

        int age = 31;
        System.out.printf("Your age is %d\n", age);

        double temp = 97.8;
        System.out.printf("Your temperature is %f\n", temp);

        // Example with width
        name = "Ramesh";

        System.out.printf("| %s |\n", name);     // Prints | Ramesh |
        System.out.printf("| %10s |\n", name);   // Prints |     Ramesh |
        System.out.printf("| %-10s |\n", name);  // Prints | Ramesh     |

        // Example using width

        int x = 10;
        int y = 1234;
        int z = 59932;

        System.out.printf("| %8d |\n", x);  // Prints |       10 |
        System.out.printf("| %8d |\n", y);  // Prints |     1234 |
        System.out.printf("| %8d |\n", z);  // Prints |    59932 |

        // Example using precision

        double d = 2.0;
        System.out.printf("frac = %f\n", d/3); // Prints 'frac = .666667'
        System.out.printf("frac = %.0f\n", d/3); // Prints 'frac = 1'
        System.out.printf("frac = %.3f\n", d/3); // Prints 'frac = .667'
        System.out.printf("frac = %10.5f\n", d/3); // Prints 'frac =    0.66667'

    }
    
}
