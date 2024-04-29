package Galaga;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel {

    private Hero player;
    private List<Villain> villains = new ArrayList<>();
    private final Color BLACK = Color.BLACK;
    private final Color LIGHT_GRAY = new Color(192, 192, 192);

    public Panel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(BLACK);
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_LEFT) {
                    player.move("LEFT");
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    player.move("RIGHT");
                } else if (keyCode == KeyEvent.VK_UP) {
                    player.move("UP");
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    player.move("DOWN");
                } else if (keyCode == KeyEvent.VK_SPACE) {
                    player.shoot();
                }
                repaint();
            }
        });

        villains.add(new Villain(6, 0, 800, 0, 600));
        player = new Hero(390, 440, villains);
        event(player);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(BLACK);
        g.fillRect(0, 0, getWidth(), getHeight() * 2 / 3);

        g.setColor(LIGHT_GRAY);
        g.fillRect(0, getHeight() * 2 / 3, getWidth(), getHeight() * 1 / 3);

        for (Villain villain : villains) {
            villain.draw(g);
        }

        for (Bullet bullet : player.getBullets()) {
            bullet.draw(g);
        }

        player.draw(g);
    }

    public void event(Hero player) {
        Timer timer = new Timer(1000 / 60, e -> {
            updateVillains();
            player.updateBullets();
            repaint();
        });
        timer.start();
    }

    private void updateVillains() {
        for (Villain villain : villains) {
            villain.moveVertical();
        }
    }
}
