package Galaga;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Interfaces.Deadble;
import Interfaces.Drawable;
import Interfaces.Movable;
import Interfaces.Shootable;

public class Hero implements Drawable, Shootable, Movable, Deadble {

    private int x, y;
    private List<Bullet> bullets = new ArrayList<>();
    private List<Villain> villains;
    private int lives = 100; // Vidas del jugador
    private int score = 0; // Puntaje del jugador
    private int speed = 15; // Velocidad de movimiento de la nave
    private boolean dead;

    public Hero(int x, int y, List<Villain> villains) {
        this.x = x;
        this.y = y;
        this.villains = villains;
    }

    @Override
    public void draw(Graphics g) {
        int[] xPoints = {x, x + 20, x - 20};
        int[] yPoints = {y, y + 40, y + 40};
        g.setColor(Color.WHITE);
        g.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void move(String dir) {
        int horizontalSpeed = 10;
        int verticalSpeed = 15;

        if (dir.equals("LEFT")) {
            x -= horizontalSpeed;
        } else if (dir.equals("RIGHT")) {
            x += horizontalSpeed;
        } else if (dir.equals("UP")) {
            y -= verticalSpeed;
        } else if (dir.equals("DOWN")) {
            y += verticalSpeed;
        }
    }

    @Override
    public void shoot() {
        bullets.add(new Bullet(x - 4, y));
    }
    public Rectangle getBounds() {
        // Ajustar las coordenadas y el tamaño de la hitbox
        return new Rectangle(x - 10, y, 20, 40);
    }
    

    public void updateBullets() {
        Iterator<Bullet> iterator = bullets.iterator();
        while (iterator.hasNext()) {
            Bullet bullet = iterator.next();
            bullet.move("up"); // Mover la bala hacia arriba
            if (bullet.getY() <= 0) {
                iterator.remove(); // Eliminar la bala si sale de la pantalla
            } else {
                // Verificar colisiones entre las balas del jugador y los villanos
                Iterator<Villain> villainIterator = villains.iterator();
                while (villainIterator.hasNext()) {
                    Villain villain = villainIterator.next();
                    if (villain.getBounds().intersects(bullet.getBounds())) {
                        iterator.remove(); // Eliminar la bala
                        villainIterator.remove(); // Eliminar solo al enemigo impactado
                        score += 100; // Incrementar el puntaje
                        System.out.println("Enemigo eliminado. Puntaje actual: " + score);
                        break; // Salir del bucle interno
                    }
                }
            }
        }
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void clearBullets() {
        bullets.clear();
    }

    @Override
    public void moveVertical() {
        // No se utiliza en esta clase
    }

    public void decreaseLife(int damage) {
        if (!dead) {
            lives -= damage;
            if (lives <= 0) {
                dead();
            }
        }
    }

    public void removeInactiveBullets() {
        bullets.removeIf(bullet -> !bullet.isActive());
    }

    @Override
    public void dead() {
        dead = true;
    }

    @Override
    public boolean isDead() {
        return dead;
    }

    public int getLife() {
        return lives;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
