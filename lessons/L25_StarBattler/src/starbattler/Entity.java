package starbattler;

import starbattler.geom.Point;

public abstract class Entity extends GameObject {
    protected double health;

    public Entity(Point pos, double radius, double health) {
        super(pos, radius);
        this.health = health;
    }

    public double health() {
        return health;
    }

    public void dealDamage(double damage) {
        this.health -= damage;
    }

    public boolean isDead() {
        return health <= 0;
    }
}
