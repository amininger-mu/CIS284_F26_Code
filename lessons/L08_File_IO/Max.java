import java.util.Scanner;

public class Max {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double max = Double.NEGATIVE_INFINITY;
        while (scanner.hasNextDouble()) {
            double x = scanner.nextDouble();
            max = Math.max(max, x);
        }
        System.out.println("The maximum value is: " + max);

        scanner.close();
    }
}
