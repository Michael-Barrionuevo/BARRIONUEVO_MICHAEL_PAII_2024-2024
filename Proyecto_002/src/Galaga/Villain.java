// Clase Villain
package Galaga;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import Interfaces.Drawable;
import Interfaces.Movable;
import Interfaces.Shootable;

public class Villain implements Drawable, Movable, Shootable {

    private List<Point> positions;
    private List<Bullet> enemyBullets = new ArrayList<>();
    private int minY, maxY;
    private boolean dead;
    private int direction = 1;
    private int width = 25;
    private int height = 25;
    private int damage = 10;

    public Villain(int numEnemies, int minX, int maxX, int minY, int maxY) {
        positions = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numEnemies; i++) {
            int x = random.nextInt(maxX - 50 - minX) + minX;
            int y = minY + (i * 50);
            positions.add(new Point(x, y));
        }

        this.minY = minY;
        this.maxY = maxY;
    }

    @Override
    public void draw(Graphics g) {
        for (Point position : positions) {
            g.setColor(Color.GREEN);
            g.fillRect((int) position.getX(), (int) position.getY(), width, height);
        }
    }

    @Override
    public void move(String direction) {
        // No se utiliza en esta clase
    }

    @Override
    public void moveVertical() {
        for (Point position : positions) {
            position.setLocation(position.getX(), position.getY() + direction);
        }
    }


    public Point getPosition() {
        return positions.get(0);
    }

    public List<Bullet> getEnemyBullets() {
        return enemyBullets;
    }

    public Rectangle getBounds() {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (Point position : positions) {
            minX = Math.min(minX, (int) position.getX());
            minY = Math.min(minY, (int) position.getY());
            maxX = Math.max(maxX, (int) position.getX() + width);
            maxY = Math.max(maxY, (int) position.getY() + height);
        }

        return new Rectangle(minX, minY, maxX - minX, maxY - minY);
    }

    public int checkCollision(List<Bullet> bullets) {
        int collisions = 0;
        Iterator<Bullet> iterator = bullets.iterator();
        while (iterator.hasNext()) {
            Bullet bullet = iterator.next();
            for (Point position : positions) {
                Rectangle enemyBounds = new Rectangle(position.x, position.y, width, height);
                if (enemyBounds.intersects(bullet.getBounds())) {
                    iterator.remove(); // Elimina la bala
                    collisions++;
                }
            }
        }
        return collisions;
    }

    public void removeDeadEnemies() {
        positions.removeIf(position -> !positions.contains(position));
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isDead() {
        return dead;
    }

    @Override
    public void shoot() {
        // Implementación del método shoot
    }
}
