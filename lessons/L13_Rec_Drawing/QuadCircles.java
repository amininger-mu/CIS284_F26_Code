import java.awt.Color;

public class QuadCircles {

    // Draws a circle at (x, y) with radius r
    // Then recursively draws 4 circles at x-r, x+r, y-r, y+r at half the radius
    public static void draw(int depth, double x, double y, double r) {
        if (depth == 0) {
            return;
        }

        // Draw outline
        StdDraw.setPenRadius(0.002*depth);
        StdDraw.circle(x, y, r);

        draw(depth-1, x-r,   y, r/2);
        draw(depth-1, x+r,   y, r/2);
        draw(depth-1,   x, y-r, r/2);
        draw(depth-1,   x, y+r, r/2);
    }

    public static void main(String[] args) {
		int depth = 5;
		if (args.length > 0) {
			depth = Integer.parseInt(args[0]);
		}

        StdDraw.setCanvasSize(1000, 1000);
        StdDraw.enableDoubleBuffering();

        StdDraw.setPenColor(Color.BLUE);
        StdDraw.setPenRadius(0.01);
        draw(depth, 0.5, 0.5, 0.25);

        StdDraw.show();
    }
}
