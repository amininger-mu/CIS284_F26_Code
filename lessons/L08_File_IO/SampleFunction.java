/******************************************************************************
 *  Compilation:  javac SampleFunction.java
 *  Execution:    java SampleFunction n
 *
 *  This program takes one command-line argument n and produces
 *  n random samples of a function
 *
 ******************************************************************************/

public class SampleFunction {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);    // output this many samples

        int maxX = 10;

        // Min Point
        System.out.println("0 -2");
        // Max Point
        System.out.println("10 2");

        for (int i = 0; i < n; i++) {
            double x = Math.random() * maxX;
            double y = Math.sin(x);
            System.out.println(x + " " + y);
        }
    }
}
