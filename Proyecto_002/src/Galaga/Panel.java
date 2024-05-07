package Galaga;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel {

    private Hero player;
    private List<Villain> villains = new ArrayList<>();
    private boolean gameActive;
    private int score;
    private final Color BLACK = Color.BLACK;
    private final Color LIGHT_GRAY = new Color(192, 192, 192);

    public Panel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(BLACK);
        setFocusable(true);

        villains.add(new Villain(6, 0, 800, 0, 600));
        player = new Hero(390, 440, villains);
        event(player);

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
    }

    public void decreaseLife(int damage) {
        player.decreaseLife(damage);
        if (player.getLife() <= 0) {
            player.dead();
            gameActive = false;
            showGameOverDialog();
        }
    }

    public void increaseScore(int points) {
        score += points;
    }

    public void drawScore(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score: " + score, getWidth() - 150, 30);
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
        drawScore(g); // Dibujar puntaje
    }

    public void actionPerformed(ActionEvent e) {
        if (gameActive) {
            // Mover las balas automáticamente
            for (Bullet bullet : player.getBullets()) {
                bullet.move("UP");
            }

            // Mover los villanos
            for (Villain villain : villains) {
                villain.moveVertical();
                System.out.println("Villano movido verticalmente");
            }

            // Verificar colisión de balas con enemigos y aumentar el puntaje
            int totalScoreIncrease = 0;
            for (Iterator<Bullet> bulletIterator = player.getBullets().iterator(); bulletIterator.hasNext();) {
                Bullet bullet = bulletIterator.next();
                for (Iterator<Villain> villainIterator = villains.iterator(); villainIterator.hasNext();) {
                    Villain villain = villainIterator.next();
                    if (villain.getBounds().intersects(bullet.getBounds())) {
                        totalScoreIncrease += 100;
                        villainIterator.remove(); // Eliminar al enemigo
                        bulletIterator.remove(); // Eliminar la bala
                    }
                }
            }
            increaseScore(totalScoreIncrease);

            // Verificar colisión de la nave del jugador con los enemigos
            for (Villain villain : villains) {
                if (villain.getBounds().intersects(player.getBounds())) {
                    decreaseLife(35);
                    break; // Solo reducir la vida una vez
                }
            }

            // Verificar colisión de balas del enemigo con la nave
            for (Villain villain : villains) {
                for (Bullet bullet : villain.getEnemyBullets()) {
                    Rectangle bulletBounds = bullet.getBounds();
                    Rectangle shipBounds = new Rectangle(player.getX(), player.getY(), 40, 40);
                    if (shipBounds.intersects(bulletBounds)) {
                        decreaseLife(1);
                        bullet.setActive(false);
                    }
                }
            }
        }

        repaint();
    }

    public void event(Hero player) {
        Timer timer = new Timer(1000 / 60, e -> {
            player.updateBullets();
            repaint();
        });
        timer.start();
    }

    private void showGameOverDialog() {
        JButton yesButton = new JButton("Sí");
        JButton noButton = new JButton("No");

        yesButton.addActionListener(e -> restartGame());
        noButton.addActionListener(e -> System.exit(0));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(yesButton);
        buttonsPanel.add(noButton);

        JOptionPane.showOptionDialog(
                null,
                "Game Over! ¿Quieres jugar de nuevo?",
                "Game Over",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{buttonsPanel},
                null);
    }

    private void restartGame() {
        player = new Hero(390, 440, villains);
        score = 0;
        gameActive = true;
        requestFocusInWindow();
    }
}
