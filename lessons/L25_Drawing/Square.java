import java.awt.Color;
import edu.textbook.StdDraw;

public class Square extends Shape {

    public Square(Point pos, double width, Color color) {
        super(pos, width/2, color);
    }

    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledSquare(pos.x(), pos.y(), scale);
    }
}
