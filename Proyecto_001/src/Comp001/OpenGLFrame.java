package Comp001;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLJPanel;

public class OpenGLFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private GLJPanel glJPanel;
    private String type = "";

    OpenGLFrame(String title, int width, int height) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);

        JPanel panel = new JPanel();
        JButton triangleButton = new JButton("Triángulo");
        JButton squareButton = new JButton("Cuadrado");
        JButton circleButton = new JButton("Círculo");

        triangleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = "Triangle";
                glJPanel.display();
            }
        });

        squareButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = "Square";
                glJPanel.display();
            }
        });

        circleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = "Circle";
                glJPanel.display();
            }
        });

        panel.add(triangleButton);
        panel.add(squareButton);
        panel.add(circleButton);

        getContentPane().add(panel, BorderLayout.NORTH);

        GLCapabilities capabilities = new GLCapabilities(null);
        glJPanel = new GLJPanel(capabilities);
        glJPanel.addGLEventListener(new MyGLEventListener());

        getContentPane().add(glJPanel, BorderLayout.CENTER);
    }

    class MyGLEventListener implements GLEventListener {

        @Override
        public void init(GLAutoDrawable drawable) {}

        @Override
        public void dispose(GLAutoDrawable drawable) {}

        @Override
        public void display(GLAutoDrawable drawable) {
            GL2 gl = drawable.getGL().getGL2();
            gl.glClear(GL.GL_COLOR_BUFFER_BIT);

            // Dibujar la figura seleccionada
            if (type.equals("Triangle")) {
                gl.glColor3f(1.0f, 0.0f, 0.0f); // Rojo
                gl.glBegin(GL2.GL_TRIANGLES);
                gl.glVertex3f(-0.5f, -0.5f, 0.0f);
                gl.glVertex3f(0.0f, 0.5f, 0.0f);
                gl.glVertex3f(0.5f, -0.5f, 0.0f);
                gl.glEnd();
            } else if (type.equals("Square")) {
                gl.glColor3f(0.0f, 1.0f, 0.0f); // Verde
                gl.glBegin(GL2.GL_QUADS);
                gl.glVertex3f(-0.5f, -0.5f, 0.0f);
                gl.glVertex3f(-0.5f, 0.5f, 0.0f);
                gl.glVertex3f(0.5f, 0.5f, 0.0f);
                gl.glVertex3f(0.5f, -0.5f, 0.0f);
                gl.glEnd();
            } else if (type.equals("Circle")) {
                gl.glColor3f(0.0f, 0.0f, 1.0f); // Azul
                gl.glBegin(GL2.GL_POLYGON);
                int numVertices = 100;
                double radius = 0.25;
                double angleIncrement = 2 * Math.PI / numVertices;
                for (int i = 0; i < numVertices; i++) {
                    double angle = i * angleIncrement;
                    double x = radius * Math.cos(angle);
                    double y = radius * Math.sin(angle);
                    gl.glVertex2d(x, y);
                }
                gl.glEnd();
            }

            gl.glFlush();
        }

        @Override
        public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OpenGLFrame frame = new OpenGLFrame("OpenGL Frame", 800, 600);
            frame.setVisible(true);
        });
    }
}
