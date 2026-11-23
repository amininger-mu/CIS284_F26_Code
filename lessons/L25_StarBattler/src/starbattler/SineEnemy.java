package starbattler;

import java.awt.Color;

import edu.textbook.StdDraw;
import starbattler.geom.Point;
import starbattler.geom.Vector;

public class SineEnemy extends Enemy {
    private final static double RADIUS = 20;
    private final static double HEALTH = 8;
    private final static double V_SPEED = 100;
    private final static double H_SPREAD = 50;
    private final static double ANGULAR_VEL = Math.PI;

    private Color color;
    private double x;
    private double theta;


    public SineEnemy(Point pos, Vector vel, double health, Color color) {
        super(pos, health, RADIUS, vel);
        this.color = color;
        this.x = pos.x();
        this.theta = 0;
    }

    // Spawn a random Sine enemy
    public static SineEnemy spawn() {
        Point pos = new Point(50 + Math.random() * (GameSettings.SCREEN_WIDTH - 50), GameSettings.SCREEN_HEIGHT);
        Vector vel = new Vector(0, -V_SPEED); 
        return new SineEnemy(pos, vel, HEALTH, Color.white);
    }

    @Override
    public void update(double dt) {
        theta += dt * ANGULAR_VEL;
        pos = new Point(x + H_SPREAD * Math.sin(theta), pos.y() + vel.y() * dt);
    }

    @Override
    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(pos.x(), pos.y(), radius);
    }
}
