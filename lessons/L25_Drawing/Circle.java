import java.awt.Color;
import edu.textbook.StdDraw;

public class Circle extends Shape {

    public Circle(Point pos, double scale, Color color) {
        super(pos, scale, color);
    }

    @Override
    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(pos.x(), pos.y(), scale);
    }
}
