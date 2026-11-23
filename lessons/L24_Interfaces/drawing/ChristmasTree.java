import java.awt.Color;
import edu.textbook.StdDraw;

public class ChristmasTree {

    public static void main(String[] args) {
        StdDraw.setCanvasSize(400, 600);
        StdDraw.setYscale(0, 1.5);
        StdDraw.clear(new Color(220, 220, 255));

        ShapeSet shapes = new ShapeSet();
        // Tree 
        shapes.add(new Triangle(new Point(0.2, 0.2), 
                    new Point(0.5, 1.2), 
                    new Point(0.8, 0.2), 
                    new Color(0, 150, 25)));

        // Trunk
        shapes.add(new Square(0.5, 0.15, 0.1, 
                    new Color(50, 70, 10)));
        
        // Bobbles
        shapes.add(new Circle(0.45, 0.8, 0.05, Color.yellow));
        shapes.add(new Circle(0.65, 0.5, 0.05, Color.white));
        shapes.add(new Circle(0.40, 0.35, 0.05, Color.red));

        // Star
        shapes.add(new Star(0.5, 1.2, 0.1, Color.yellow));

        shapes.draw();
    }

    
}
