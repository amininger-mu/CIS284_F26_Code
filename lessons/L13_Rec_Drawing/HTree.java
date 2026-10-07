import java.awt.Color;

public class HTree {
    
    public static void draw(int depth, double x, double y, double size) {
        if (depth == 0) {
            return;
        }

        double x0 = x - size/2;
        double x1 = x + size/2;
        double y0 = y - size/2;
        double y1 = y + size/2;

        StdDraw.setPenRadius(0.002*depth);

		if (depth > 3) {
			// brown
			StdDraw.setPenColor(Color.getHSBColor(0.16f, 0.66f, 0.25f));
		} else {
			//green
			StdDraw.setPenColor(new Color(0, 180, 20));
		}

        // Draw horizontal line (x0 - x1 at height y)
        StdDraw.line(x0, y, x1, y);

        // Draw left bar (at x0, from y0-y1)
        StdDraw.line(x0, y0, x0, y1);

        // Draw left bar (at x1, from y0-y1)
        StdDraw.line(x1, y0, x1, y1);

        // Recurse at each of the 4 points
        draw(depth-1, x0, y0, size/2);
        draw(depth-1, x0, y1, size/2);
        draw(depth-1, x1, y0, size/2);
        draw(depth-1, x1, y1, size/2);
    }

    public static void main(String[] args) {
		int depth = 5;
		if (args.length > 0) {
			depth = Integer.parseInt(args[0]);
		}

        StdDraw.setCanvasSize(1000, 1000);
        StdDraw.setPenColor(Color.blue);
        StdDraw.enableDoubleBuffering();

        draw(depth, 0.5, 0.5, 0.5);

        StdDraw.show();
    }
}
