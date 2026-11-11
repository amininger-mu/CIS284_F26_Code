import edu.textbook.Picture;
import java.awt.Color;

public class Mandelbrot {
    private static int mand(Complex c, int max) {
        Complex z = new Complex(0, 0);
        // iterate up to 'max' times
        for (int i = 0; i < max; i++) {
            if (z.mag() > 2.0) {
                return i;
            }
            z = z.times(z).plus(c);
        }
        return max;
    }
    public static void main(String[] args) {
        double xc = Double.parseDouble(args[0]);
        double yc = Double.parseDouble(args[1]);
        double scale = Double.parseDouble(args[2]);
        int n = 512;
        Picture picture = new Picture(n, n);
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                double x = xc + (((double)col / n) - 0.5)*scale; // -0.5 to 0.5
                double y = yc + (((double)row / n) - 0.5)*scale; // -0.5 to 0.5
                int res = 255 - mand(new Complex(x, y), 255);
                Color c = new Color(res, res, res);
                picture.set(col, row, c);
            }
        }
        picture.show();
    }

    
}
