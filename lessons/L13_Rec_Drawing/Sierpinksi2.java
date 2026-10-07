import java.awt.Color;

public class Sierpinksi2 {

    static record Point(double x, double y) {} 

    static Point midpoint(Point p1, Point p2) {
        return new Point((p1.x + p2.x)/2, (p1.y + p2.y)/2);
    }

    static void drawTriangle(Point p1, Point p2, Point p3) {
        StdDraw.filledPolygon(
            new double[]{ p1.x, p2.x, p3.x }, 
            new double[]{ p1.y, p2.y, p3.y }
        );
    }

    static void draw(int depth, Point p0, Point p1, Point p2) {
        if (depth == 0) {
            return;
        }

        Point m0 = midpoint(p0, p1);
        Point m1 = midpoint(p1, p2);
        Point m2 = midpoint(p2, p0);

        drawTriangle(m0, m1, m2);

        draw(depth-1, p0, m0, m2);
        draw(depth-1, m0, p1, m1);
        draw(depth-1, m2, m1, p2);
    }

    public static void main(String[] args) {
		int depth = 6;
		if (args.length > 0) {
			depth = Integer.parseInt(args[0]);
		}

        Point p1 = new Point(0.00, 0.0);
        Point p2 = new Point(0.50, 1.0);
        Point p3 = new Point(1.00, 0.0);

        StdDraw.setCanvasSize(1000, 1000);
        StdDraw.enableDoubleBuffering();

        // Draw blue background
        StdDraw.setPenColor(Color.blue);
        drawTriangle(p1, p2, p3);

        // Draw white triangles
        StdDraw.setPenColor(Color.white);
        draw(depth, p1, p2, p3);

        StdDraw.show();
    }
}
