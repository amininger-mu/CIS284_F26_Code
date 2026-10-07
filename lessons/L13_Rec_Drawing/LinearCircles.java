import java.awt.Color;

public class LinearCircles {

    // Draws a circle at (x, 0.5) with radius r
    // Then recursively draws 2 circles at x-r and x+r at half the radius
    public static void draw(int depth, double x, double r) {
        if (depth == 0) {
            return;
        }

        StdDraw.pause(100);

        draw(depth-1, x-r, r/2);

        // Draw outline
        StdDraw.setPenColor(Color.yellow);
        StdDraw.filledCircle(x, 0.5, r);
        StdDraw.setPenColor(Color.blue);
        StdDraw.circle(x, 0.5, r);

        draw(depth-1, x+r, r/2);
    }

    public static void main(String[] args) {
		int depth = 7;
		if (args.length > 0) {
			depth = Integer.parseInt(args[0]);
		}

        StdDraw.setCanvasSize(1800, 900);
        StdDraw.setXscale(0, 2);
        StdDraw.setYscale(0, 1);

        StdDraw.setPenColor(Color.BLUE);
        draw(depth, 1.0, 0.5);
    }
}
