package comp001;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * @author veykerbarrionuevo
 * Titulo: Contenedores JAVA
 */


public class main extends JFrame implements ActionListener {

	private JButton btnTriangulo, btnCuadrado, btnCirculo;
    private JPanel panelDibujo;
    private int figuraSeleccionada = -1; // 0: Triángulo, 1: Cuadrado, 2: Círculo

    public  main() {
        setTitle("Dibujar Figuras");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 1));

        btnTriangulo = new JButton("Triángulo");
        btnCuadrado = new JButton("Cuadrado");
        btnCirculo = new JButton("Círculo");

        btnTriangulo.addActionListener(this);
        btnCuadrado.addActionListener(this);
        btnCirculo.addActionListener(this);

        panelBotones.add(btnTriangulo);
        panelBotones.add(btnCuadrado);
        panelBotones.add(btnCirculo);

        // Panel para el dibujo
        panelDibujo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (figuraSeleccionada == 0) { // Triángulo
                    g.setColor(Color.BLUE);
                    int[] xPoints = {50, 100, 150};
                    int[] yPoints = {150, 50, 150};
                    g.fillPolygon(xPoints, yPoints, 3);
                } else if (figuraSeleccionada == 1) { // Cuadrado
                    g.setColor(Color.RED);
                    g.fillRect(50, 50, 100, 100);
                } else if (figuraSeleccionada == 2) { // Círculo
                    g.setColor(Color.GREEN);
                    g.fillOval(50, 50, 100, 100);
                }
            }
        };

        // Layout del frame
        setLayout(new BorderLayout());
        add(panelBotones, BorderLayout.WEST);
        add(panelDibujo, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTriangulo) {
            figuraSeleccionada = 0;
        } else if (e.getSource() == btnCuadrado) {
            figuraSeleccionada = 1;
        } else if (e.getSource() == btnCirculo) {
            figuraSeleccionada = 2;
        }
        panelDibujo.repaint(); // Vuelve a dibujar el panel con la nueva figura seleccionada
    }
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                main frame = new main();
                frame.setVisible(true);
            }
        });
		
	}

}
