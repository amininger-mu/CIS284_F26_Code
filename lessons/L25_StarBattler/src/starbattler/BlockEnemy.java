package starbattler;

import java.awt.Color;

import edu.textbook.StdDraw;
import starbattler.geom.Point;
import starbattler.geom.Vector;

public class BlockEnemy extends Enemy {
    private final static double RADIUS = 20;
    private final static double HEALTH = 4;
    private final static double V_SPEED = 50;

    private Color color;

    public BlockEnemy(Point pos, Vector vel, double health, Color color) {
        super(pos, health, RADIUS, vel);
        this.color = color;
    }

    // Spawn a random Block enemy
    public static BlockEnemy spawn() {
        Point pos = new Point(50 + Math.random() * (GameSettings.SCREEN_WIDTH - 50), GameSettings.SCREEN_HEIGHT);
        Vector vel = new Vector(20 * (Math.random() - 0.5), -V_SPEED); // -10 to 10
        return new BlockEnemy(pos, vel, HEALTH, Color.orange);
    }

    @Override
    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledSquare(pos.x(), pos.y(), radius);
    }
}
