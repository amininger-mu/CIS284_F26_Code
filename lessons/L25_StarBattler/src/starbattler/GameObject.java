package starbattler;

import starbattler.geom.Point;

public abstract class GameObject {

    protected Point pos;
    protected double radius;

    public GameObject(Point pos, double radius) {
        this.pos = pos;
        this.radius = radius;
    }

    // Returns the position of the object
    public Point pos() {
        return pos;
    }    

    // Returns the collision radius of the object
    public double rad() {
        return radius;
    }
    
    // Returns true if the object is off screen
    public boolean isOffscreen() {
        return pos.x() < radius || pos.y() < radius
            || pos.x() - radius > GameSettings.SCREEN_WIDTH
            || pos.y() - radius > GameSettings.SCREEN_HEIGHT;
    }

    // Returns true if the object collides with the given object (circle)
    public boolean collidesWith(GameObject obj) {
        double dx = obj.pos().x() - pos.x();
        double dy = obj.pos().y() - pos.y();
        double d2 = dx*dx + dy*dy;                     // squared distance between centers
        double r2 = Math.pow(radius + obj.radius, 2);  // squared radius sum
        return d2 < r2;
    }

    public abstract void update(double dt);

    public abstract void draw();
}
