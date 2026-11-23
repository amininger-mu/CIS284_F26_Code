import java.awt.Color;
import edu.textbook.StdDraw;

public class Circle implements Shape {
    private double x;
    private double y;
    private double r;
    private Color color;

    public Circle(double x, double y, double r, Color color) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = color;
    }

    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, r);
    }
}
