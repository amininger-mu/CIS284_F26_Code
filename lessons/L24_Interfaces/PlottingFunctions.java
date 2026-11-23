import java.security.GuardedObject;

import edu.textbook.StdStats;

public class PlottingFunctions {
    /****
     * NOTE: In this example, I'm putting everything in the same file
     */

    public static interface Function {
        double evaluate(double x);
    }

    public static class Square implements Function {
        public double evaluate(double x) {
            return x*x;
        }
    }

    public static class GaussianPDF implements Function {
        public double evaluate(double x) {
            return Math.exp(-x*x/2) / Math.sqrt(2*Math.PI);
        }
    }

    public static void plot(Function f, double a, double b, int n) {
        double[] y = new double[n+1];
        double delta = (b - a) / n;
        for (int i = 0; i <= n; i++) {
            double x = a + delta*i;
            y[i] = f.evaluate(x);
        }
        StdStats.plotPoints(y);
        StdStats.plotLines(y);
    }

    public static void main(String[] args) {
        // Function f1 = new Square();
        // plot(f1, -0.6, 0.6, 50);

        Function f2 = new GaussianPDF();
        plot(f2, -4, 4, 50);
        
    }


    
}
