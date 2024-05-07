package Galaga;

import javax.swing.JFrame;

public class Main extends JFrame {

    public Main() {
        setTitle("---GALAGA---");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(270, 100);
        setSize(800, 600);

        Panel myPanel = new Panel();
        add(myPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
