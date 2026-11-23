import java.awt.Color;

public abstract class Shape {

    protected Point pos;
    protected double scale;
    protected Color color;

    public Shape(Point pos, double scale, Color color) {
        this.pos = pos;
        this.scale = scale;
        this.color = color;
    }
    
    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public abstract void draw();
}
