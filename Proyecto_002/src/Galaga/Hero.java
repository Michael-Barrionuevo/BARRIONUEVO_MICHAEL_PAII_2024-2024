package Galaga;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Interfaces.Deadble;
import Interfaces.Drawable;
import Interfaces.Movable;
import Interfaces.Shootable;

public class Hero implements Drawable, Shootable, Movable {

    private int x, y;
    private List<Bullet> bullets = new ArrayList<>();
    private List<Villain> villains;
    private int lives = 3; // Vidas del jugador
    private int score = 0; // Puntaje del jugador
    private int speed = 15; // Velocidad de movimiento de la nave

    public Hero(int x, int y, List<Villain> villains) {
        this.x = x;
        this.y = y;
        this.villains = villains;
    }

    @Override
    public void draw(Graphics g) {
        // Dibujar la nave del jugador
        int[] xPoints = {x, x + 20, x - 20};
        int[] yPoints = {y, y + 40, y + 40};
        g.setColor(Color.WHITE);
        g.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void move(String dir) {
        int horizontalSpeed = 10; // Velocidad de movimiento horizontal
        int verticalSpeed = 15; // Velocidad de movimiento vertical

        if (dir.equals("LEFT")) {
            x -= horizontalSpeed; // Mover hacia la izquierda
        } else if (dir.equals("RIGHT")) {
            x += horizontalSpeed; // Mover hacia la derecha
        } else if (dir.equals("UP")) {
            y -= verticalSpeed; // Mover hacia arriba
        } else if (dir.equals("DOWN")) {
            y += verticalSpeed; // Mover hacia abajo
        }
    }

    @Override
    public void shoot() {
        // Disparar una bala desde la posición actual de la nave del jugador
        bullets.add(new Bullet(x - 4, y));
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
                        villainIterator.remove(); // Eliminar el villano golpeado
                        score += 100; // Incrementar el puntaje
                        break; // Salir del bucle interno
                    }
                }
            }
        }
    }



    public List<Bullet> getBullets() {
        return bullets;
    }

    @Override
    public void moveVertical() {
        // Método no utilizado en esta clase
    }
}
