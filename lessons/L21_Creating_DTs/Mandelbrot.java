import edu.textbook.Picture;
import java.awt.Color;

public class Mandelbrot {
    // Determines how quickly the given complex number c diverges
    //   under iteration of z' = z^2 + c
    // Given a limit max, keeps iterating up to max times
    //    - If it diverges (|z| > 2), return the # of iterations
    //    - If it doesn't diverge after 'max' iterations, return max
    private static int mand(Complex c, int max) {
        Complex z = new Complex(0, 0);
        // iterate up to 'max' times
        for (int i = 0; i < max; i++) {
            // If |z| > 2, we know for sure it diverges
            if (z.mag() > 2.0) {
                return i;
            }
            // Iterate z^2 + c
            z = z.times(z).plus(c);
        }
        return max;
    }
    public static void main(String[] args) {
        double xc = Double.parseDouble(args[0]);      // x center of image
        double yc = Double.parseDouble(args[1]);      // y center of image
        double scale = Double.parseDouble(args[2]);   // scale of image (zoom level)

        // Create a 512x512 image
        int n = 1024;
        Picture picture = new Picture(n, n);

        // The 'width' of a single pixel
        double pixelScale = scale / n;

        // Iterate over each pixel
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                double x = xc + (col - n/2)*pixelScale;
                double y = yc + (row - n/2)*pixelScale;
                int res = 255 - mand(new Complex(x, y), 255);
                Color c = new Color(res, res, res);
                picture.set(col, row, c);
            }
        }
        picture.show();
    }
}
