import java.awt.Color;

public class Sierpinksi {

    static void draw(int depth, double x0, double y0, 
        double x1, double y1, double x2, double y2) {

        if (depth == 0) {
            return;
        }

        double m0x = (x0 + x1)/2;
        double m0y = (y0 + y1)/2;
        double m1x = (x1 + x2)/2;
        double m1y = (y1 + y2)/2;
        double m2x = (x2 + x0)/2;
        double m2y = (y2 + y0)/2;

        StdDraw.filledPolygon(new double[] { m0x, m1x, m2x }, 
                              new double[] { m0y, m1y, m2y });

        draw(depth-1, x0, y0, m0x, m0y, m2x, m2y);
        draw(depth-1, m0x, m0y, x1, y1, m1x, m1y);
        draw(depth-1, m2x, m2y, m1x, m1y, x2, y2);
    }

    public static void main(String[] args) {
		int depth = 5;
		if (args.length > 0) {
			depth = Integer.parseInt(args[0]);
		}

        StdDraw.setCanvasSize(1000, 1000);
        StdDraw.enableDoubleBuffering();

        StdDraw.setPenColor(Color.blue);
        StdDraw.filledPolygon(new double[] {0, .5, 1}, new double[]{ 0, 1, 0 });

        StdDraw.setPenColor(Color.white);
        draw(depth, 0.0, 0.0, 0.5, 1.0, 1.0, 0.0);

        StdDraw.show();
    }
    
}
