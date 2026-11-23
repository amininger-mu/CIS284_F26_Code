import java.util.ArrayList;

public class ShapeSet {
    private ArrayList<Shape> shapes;

    public ShapeSet() {
        shapes = new ArrayList<Shape>();
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public void draw() {
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).draw();
        }
    }
}
