package starbattler;
import starbattler.geom.Point;
import starbattler.geom.Vector;

import edu.textbook.StdDraw;
import java.awt.Color;

public class Bullet extends GameObject {
    public enum BulletType {
        PLAYER, ENEMY
    }

    private final Vector vel;
    private final double damage;
    private final Color color;
    private final BulletType type;

    public Bullet(BulletType type, Point pos, Vector vel, double damage, Color color) {
        super(pos, 2);
        this.type = type;
        this.vel = vel;
        this.damage = damage;
        this.color = color;
    }

    public BulletType type() {
        return type;
    }

    public double damage() {
        return damage;
    }

    @Override
    public void update(double dt) {
        pos = pos.add(vel.mul(dt));
    }

    @Override 
    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(pos.x(), pos.y(), radius);
    }
}