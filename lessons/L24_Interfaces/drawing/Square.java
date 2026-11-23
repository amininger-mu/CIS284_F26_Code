import java.awt.Color;
import edu.textbook.StdDraw;

public class Square implements Shape {
    private double x;
    private double y;
    private double r;
    private Color color;

    public Square(double x, double y, double width, Color color) {
        this.x = x;
        this.y = y;
        this.r = width/2;
        this.color = color;
    }

    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledSquare(x, y, r);
    }
}
