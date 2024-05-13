package view_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame {
	private JPanel contentPane;

	private static final long serialVersionUID = 1L;

	public Window(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY); 
		setContentPane(contentPane);
		this.setLayout(new GridLayout(3,1)); 
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JLabel lbl1 = new JLabel();
		lbl1.setForeground(Color.red);
		lbl1.setText("Escoja la opcion con la que quiere trabajar");
		contentPane.add(lbl1,BorderLayout.CENTER);
		
		JButton btn1 = new JButton("ESTUDIANTE"); 
		contentPane.add(btn1);
		JButton btn2 = new JButton("PROFESOR");
		contentPane.add(btn2);
		JButton btn3 = new JButton("MATERIA"); 
		contentPane.add(btn3);
				
	}
}
