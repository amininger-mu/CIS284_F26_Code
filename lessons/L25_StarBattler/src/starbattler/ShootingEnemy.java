package starbattler;

import java.awt.Color;

import edu.textbook.StdDraw;
import starbattler.geom.Point;
import starbattler.geom.Vector;

public class ShootingEnemy extends Enemy {
    private final static double RADIUS = 20;
    private final static double HEALTH = 8;
    private final static double V_SPEED = 100;
    private final static double DAMAGE = 5;
    private final static double FIRE_RATE = 1.0;

    private Color color;
    private double tts;
    private double fireRate;
    private double damage;

    public ShootingEnemy(Point pos, Vector vel, double health, Color color, double damage, double fireRate) {
        super(pos, health, RADIUS, vel);
        this.color = color;
        this.fireRate = fireRate;
        this.damage = damage;
        this.tts = 0.0;
    }

    // Spawn a random enemy
    public static ShootingEnemy spawn() {
        Point pos = new Point(50 + Math.random() * (GameSettings.SCREEN_WIDTH - 50), GameSettings.SCREEN_HEIGHT);
        Vector vel = new Vector(0, -V_SPEED); 
        return new ShootingEnemy(pos, vel, HEALTH, Color.red, DAMAGE, FIRE_RATE);
    }

    private void shoot() {
        Bullet bullet = new Bullet(Bullet.BulletType.ENEMY, this.pos, new Vector(0, -200), damage, color);
        StarBattler.instance.addBullet(bullet);
    }

    @Override
    public void update(double dt) {
        super.update(dt);
        tts -= dt;
        if (tts <= 0) {
            shoot();
            tts = fireRate;
        }
    }

    @Override
    public void draw() {
        double[] vx = new double[]{ pos.x() - radius*.6, pos.x(), pos.x() + radius*.6 };
        double[] vy = new double[]{ pos.y() + radius, pos.y() - radius, pos.y() + radius };
        StdDraw.setPenColor(color);
        StdDraw.filledPolygon(vx, vy);
    }
}
