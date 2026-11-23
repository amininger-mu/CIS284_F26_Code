package starbattler;

import starbattler.geom.Point;
import starbattler.geom.Vector;

public abstract class Enemy extends Entity {
    protected Vector vel;

    public Enemy(Point pos, double health, double radius, Vector vel) {
        super(pos, radius, health);
        this.vel = vel;
    }

    @Override
    public void update(double dt) {
        pos = pos.add(vel.mul(dt));
    }

}