package starbattler;

import starbattler.geom.Point;
import starbattler.geom.Vector;

import edu.textbook.StdDraw;
import java.awt.Color;

public class Player extends Entity {
    private final static double HW = 25;
    private final static double HH = 30;
    private final static double HEALTH = 100;
    private final static Color color = new Color(100, 100, 255);

    private double fireRate = 0.25;    // seconds per shot
    private double timeToShoot = 0.0; // time remaining until fire
    private double damage = 2.0;

    public Player() {
        super(new Point(GameSettings.SCREEN_WIDTH/2, 40), 20.0, HEALTH);
    }

    private void shoot() {
        Bullet bullet = new Bullet(Bullet.BulletType.PLAYER, new Point(pos.x(), pos.y()+HH), 
            new Vector(0.0, 200.0), damage, Color.yellow);
        StarBattler.instance.addBullet(bullet);
    }

    public void resetHealth() {
        health = HEALTH;
    }

    @Override
    public void update(double dt) {
        timeToShoot -= dt;
        if (timeToShoot < 0) {
            shoot();
            timeToShoot = fireRate;
        }

        double mx = Math.clamp(StdDraw.mouseX(), 0, GameSettings.SCREEN_WIDTH);
        pos = new Point(mx, pos.y());
    }

    public void draw() {
        double[] vx = new double[]{ pos.x() - HW, pos.x(), pos.x() + HW };
        double[] vy = new double[]{ pos.y() - HH, pos.y() + HH, pos.y() - HH };
        StdDraw.setPenColor(color);
        StdDraw.filledPolygon(vx, vy);
    }
}
