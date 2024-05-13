package ec.edu.uce.Proyecto_004;

import controller.StudentController;
import controller.TeacherController;
import controller.SubjectsController;
import controller.SchedulesController;
import models.StudentFrame;
import models.TeacherFrame;
import models.SubjectsFrame;
import models.SchedulesFrame;

import javax.swing.*;

import controller.StudentController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton studentButton;
    private JButton teacherButton;
    private JButton subjectButton;
    private JButton scheduleButton;

    private StudentController studentController;
    private TeacherController teacherController;
    private SubjectsController subjectsController;
    private SchedulesController schedulesController;

    public MainFrame() {
        studentController = new StudentController();
        teacherController = new TeacherController();
        subjectsController = new SubjectsController();
        schedulesController = new SchedulesController();

        setTitle("Gestión de Instituto");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        studentButton = new JButton("Estudiante");
        teacherButton = new JButton("Profesor");
        subjectButton = new JButton("Asignatura");
        scheduleButton = new JButton("Horario");

        studentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentFrame studentFrame = new StudentFrame(studentController);
                studentFrame.setVisible(true);
            }
        });

        teacherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TeacherFrame teacherFrame = new TeacherFrame(teacherController);
                teacherFrame.setVisible(true);
            }
        });
        
        subjectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SubjectsFrame subjectFrame = new SubjectsFrame(subjectsController);
                subjectFrame.setVisible(true);
            }
        });
        
        scheduleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SchedulesFrame scheduleFrame = new SchedulesFrame(schedulesController);
                scheduleFrame.setVisible(true);
            }
        });

        setLayout(new GridLayout(4, 1));
        add(studentButton);
        add(teacherButton);
        add(subjectButton);
        add(scheduleButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
        });
    }
}
