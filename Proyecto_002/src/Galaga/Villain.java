package Galaga;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Interfaces.Drawable;
import Interfaces.Movable;

public class Villain implements Drawable, Movable {
    private List<Point> positions;
    private int minX, maxX;
    private int direction;
    private int width = 25;
    private int height = 25;

    public Villain(int numEnemies, int minX, int maxX, int minY, int maxY) {
        positions = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numEnemies; i++) {
            int x = random.nextInt(maxX - 50 - minX) + minX;
            int y = minY + (i * 50); // Generar enemigos espaciados verticalmente
            positions.add(new Point(x, y));
        }

        this.minX = minX;
        this.maxX = maxX;
        this.direction = 1; // Empezar moviéndose hacia arriba
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
        // Método no utilizado en esta clase
    }

    @Override
    public void moveVertical() {
        for (Point position : positions) {
            position.setLocation(position.getX(), position.getY() + direction);
        }
    }
    
    public Point getPosition() {
        // Obtener la posición del primer enemigo
        return positions.get(0);
    }

    public void hit() {
        // Implementa lo que sucede cuando un villano es golpeado
        // Por ejemplo, podrías eliminar el villano de la lista de posiciones
    }

    public Rectangle getBounds() {
        // Calcular los límites del villano
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
}
