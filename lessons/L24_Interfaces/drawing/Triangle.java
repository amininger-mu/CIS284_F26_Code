import java.awt.Color;
import edu.textbook.StdDraw;

public class Triangle implements Shape {
    private final double[] vx;
    private final double[] vy;
    private final Color color;

    public Triangle(Point p1, Point p2, Point p3, Color color) {
        this.vx = new double[]{ p1.x(), p2.x(), p3.x() };
        this.vy = new double[]{ p1.y(), p2.y(), p3.y() };
        this.color = color;
    }

    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledPolygon(vx, vy);
    }
}
