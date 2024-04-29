package Galaga;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Interfaces.Drawable;
import Interfaces.Movable;

public class Bullet implements Drawable, Movable {
    private int x, y; 
    private int width;
    private int height;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 7; // Ancho de la bala
        this.height = 13; // Alto de la bala
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(x, y, 7, 13);     
        g.drawOval(x, y, 7, 13);
    }

    @Override
    public void move(String direction) {
        y -= 10;
        if (y <= 0 - 15) {
            y = 0 - 15;
        }
    }

    @Override
    public void moveVertical() {
        // Método no utilizado en esta clase
    }

    public int getY() {
        return y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
