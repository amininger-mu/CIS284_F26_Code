
public class BrownianBridge {
    final static double LIMIT = 0.01;

    public static void curve(double x0, double y0, double x1, double y1, double var, double s) {
        if (x1 - x0 < LIMIT) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }

        double xm = (x0 + x1)/2;
        double ym = (y0 + y1)/2;
        ym += StdRandom.gaussian(0, Math.sqrt(var)); // adjust y up/down using gaussian 

        curve(x0, y0, xm, ym, var/s, s);
        curve(xm, ym, x1, y1, var/s, s);
    }

    public static void main(String[] args) {
        StdDraw.setCanvasSize(1000, 1000);
        double hurst = Double.parseDouble(args[0]);
        double s = Math.pow(2, 2*hurst);
        curve(0, 0.5, 1.0, 0.5, 0.01, s);
    }
}
