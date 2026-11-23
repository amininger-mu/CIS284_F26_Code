package starbattler;

import edu.textbook.StdDraw;
import starbattler.Bullet.BulletType;
import starbattler.geom.Point;
import starbattler.geom.Vector;

import java.awt.Color;
import java.util.ArrayList;

public class StarBattler {
    public static StarBattler instance;

    private Player player;
    private ArrayList<Bullet> bullets;
    private ArrayList<Enemy> enemies;

    public StarBattler() {
        player = new Player();
        bullets = new ArrayList<Bullet>();
        enemies = new ArrayList<Enemy>();
    }

    public void addBullet(Bullet bullet) {
        bullets.add(bullet);
    }

    private void updateBullets(double dt) {
        ArrayList<Bullet> newList = new ArrayList<Bullet>();
        for (Bullet bullet : bullets) {
            boolean keep = true;

            bullet.update(dt);
            if (bullet.isOffscreen()) keep = false;

            // Check enemy bullets against player
            if (bullet.type() == BulletType.ENEMY) {
                if (player.collidesWith(bullet)) {
                    player.dealDamage(bullet.damage());
                    keep = false;
                }
            }

            // Check player bullets against enemies
            if (bullet.type() == BulletType.PLAYER) {
                for (Enemy enemy : enemies) {
                    if (enemy.collidesWith(bullet)) {
                        enemy.dealDamage(bullet.damage());
                        keep = false;
                    }
                }
            }

            // If the bullet did not collid with anything, keep it
            if (keep) {
                newList.add(bullet);
            }
        }
        bullets = newList;
    }
    private void updateEnemies(double dt) {
        ArrayList<Enemy> alive = new ArrayList<Enemy>();
        
        for (Enemy enemy : enemies) {
            enemy.update(dt);
            if (enemy.isDead() || enemy.isOffscreen()) {
                continue;
            }
            if (player.collidesWith(enemy)) {
                player.dealDamage(10);
                continue;
            }
            alive.add(enemy);
        }

        enemies = alive;

        spawnEnemies();
    }

    private void spawnEnemies() {
        if (Math.random() < 0.02) {
            enemies.add(BlockEnemy.spawn());
        } else if (Math.random() < 0.01) {
            enemies.add(SineEnemy.spawn());
        } else if (Math.random() < 0.01) {
            enemies.add(ShootingEnemy.spawn());
        }
    }

    public void update(double dt) {
        player.update(dt);
        updateBullets(dt);
        updateEnemies(dt);
        if (player.isDead()) {
            startOver();
        }
    }

    private void startOver() {
        player.resetHealth();
        bullets.clear();
        enemies.clear();
    }

    public void draw() {
        player.draw();
        for (Bullet bullet : bullets) bullet.draw();
        for (Enemy enemy : enemies) enemy.draw();
        // Health Bar
        StdDraw.setPenColor(Color.green);
        StdDraw.filledRectangle(player.health(), GameSettings.SCREEN_HEIGHT - 20, player.health()*2, 10);
    }


    public static void main(String[] args) {

        StdDraw.setCanvasSize(GameSettings.SCREEN_WIDTH, GameSettings.SCREEN_HEIGHT);
        StdDraw.setXscale(0, GameSettings.SCREEN_WIDTH);
        StdDraw.setYscale(0, GameSettings.SCREEN_HEIGHT);
        StdDraw.enableDoubleBuffering();

        StarBattler game = new StarBattler();
        StarBattler.instance = game;

        double time = System.currentTimeMillis();
        while(true) {
            // dt = change in time since last update
            double dt = (System.currentTimeMillis() - time) / 1000.0;
            time = System.currentTimeMillis();

            // UPDATE
            game.update(dt);

            // DRAW
            StdDraw.clear(Color.black);
            game.draw();
            StdDraw.show();

            // SLEEP
            StdDraw.pause(25); 
        }
    }
}
