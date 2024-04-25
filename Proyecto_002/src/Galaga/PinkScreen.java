package Galaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinkScreen extends JPanel implements ActionListener {
    private int playerX = 375;
    private int playerY = 500;
    private int[] enemyX = {100, 200, 300, 400, 500, 600, 700};
    private int[] enemyY = {05, 50, 25, 50, 25, 50, 05};
    private int enemySpeed = 1; // Velocidad de descenso de los enemigos ajustada a 1
    private int bulletX = -10;
    private int bulletY = -10;
    private int bulletSpeed = 10;
    private boolean shooting = false;
    private Timer timer;

    public PinkScreen() {
        // Establecer el tamaño del panel
        setPreferredSize(new Dimension(800, 600));
        setFocusable(true);

        // Manejador de teclado para mover y disparar
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) {
                    if (playerX > 0) playerX -= 5;
                } else if (key == KeyEvent.VK_RIGHT) {
                    if (playerX < getWidth() - 30) playerX += 5;
                } else if (key == KeyEvent.VK_SPACE) {
                    if (!shooting) {
                        shooting = true;
                        bulletX = playerX + 10;
                        bulletY = playerY - 10;
                    }
                }
            }
        });

        // Iniciar el temporizador para el movimiento de los enemigos y las balas
        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar el fondo
        int height = getHeight();
        int width = getWidth();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height * 2 / 3); // Fondo negro (66%)
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, height * 2 / 3, width, height / 3); // Fondo gris claro (33%)

        // Dibujar la nave del jugador (triángulo blanco)
        int[] xPoints = {playerX, playerX + 45, playerX - 45};
        int[] yPoints = {playerY, playerY + 90, playerY + 90};
        g.setColor(Color.WHITE);
        g.fillPolygon(xPoints, yPoints, 3);

        // Dibujar los enemigos (rectángulos verdes)
        g.setColor(Color.GREEN);
        for (int i = 0; i < enemyX.length; i++) {
            g.fillRect(enemyX[i], enemyY[i], 30, 30);
        }

        // Dibujar la bala (círculo amarillo)
        if (shooting) {
            g.setColor(Color.YELLOW);
            g.fillOval(bulletX, bulletY, 10, 10);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Actualizar la posición de los enemigos
        for (int i = 0; i < enemyY.length; i++) {
            enemyY[i] += enemySpeed;
        }

        // Actualizar la posición de la bala si se está disparando
        if (shooting) {
            bulletY -= bulletSpeed;
            // Detectar colisión con los enemigos
            for (int i = 0; i < enemyX.length; i++) {
                if (bulletX >= enemyX[i] && bulletX <= enemyX[i] + 30 &&
                        bulletY >= enemyY[i] && bulletY <= enemyY[i] + 30) {
                    // Destruir al enemigo
                    enemyX[i] = -100;
                    enemyY[i] = -100;
                    shooting = false;
                    break;
                }
            }
            // Detener la bala si sale de la pantalla
            if (bulletY < 0) {
                shooting = false;
            }
        }

        // Detectar colisión de los enemigos con la parte gris del fondo
        for (int y : enemyY) {
            if (y >= getHeight() * 2 / 3) {
                // Detener el temporizador
                timer.stop();

                // Mostrar "Game Over" con la opción de jugar otra vez
                int option = JOptionPane.showConfirmDialog(this, "Game Over. ¿Quieres jugar otra vez?", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    // Reiniciar el juego
                    resetGame();
                    timer.start();
                } else {
                    // Salir del juego
                    System.exit(0);
                }
                return;
            }
        }

        // Volver a dibujar
        repaint();
    }

    private void resetGame() {
        // Reiniciar la posición de la nave del jugador y los enemigos
        playerX = 375;
        playerY = 500;
        enemyX = new int[]{100, 200, 300, 400, 500, 600, 700};
        enemyY = new int[]{100, 50, 25, 100, 50, 25, 100};
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Pink Screen");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            PinkScreen pinkScreen = new PinkScreen();
            frame.getContentPane().add(pinkScreen);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
