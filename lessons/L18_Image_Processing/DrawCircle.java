import java.awt.Color;
import edu.textbook.StdDraw;   // Need to import StdDraw

public class DrawCircle {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(400, 400);
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.filledCircle(0.5, 0.5, 0.3);
    }
}

