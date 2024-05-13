package models;

import controller.SchedulesController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class SchedulesFrame extends JFrame {
    private JTextField idField;
    private JTextField idSubjectField;
    private JTextField idStudentField;
    private JTextField idTeacherField;
    private JTextField startTimeField;
    private JTextField endTimeField;
    private JTextField dayField;
    private JButton createButton;
    private JButton readButton;
    private JButton updateButton;
    private JButton deleteButton;

    private SchedulesController schedulesController;

    public SchedulesFrame(SchedulesController schedulesController) {
        this.schedulesController = schedulesController;

        setTitle("Gestión de Horarios");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear los campos de texto
        idField = new JTextField(10);
        idSubjectField = new JTextField(10);
        idStudentField = new JTextField(10);
        idTeacherField = new JTextField(10);
        startTimeField = new JTextField(10);
        endTimeField = new JTextField(10);
        dayField = new JTextField(10);

        // Crear los botones
        createButton = new JButton("Crear");
        readButton = new JButton("Leer");
        updateButton = new JButton("Actualizar");
        deleteButton = new JButton("Eliminar");

        // Agregar acción a los botones
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createSchedule();
            }
        });

        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readSchedules();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateSchedule();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteSchedule();
            }
        });

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("ID Asignatura:"));
        panel.add(idSubjectField);
        panel.add(new JLabel("ID Estudiante:"));
        panel.add(idStudentField);
        panel.add(new JLabel("ID Profesor:"));
        panel.add(idTeacherField);
        panel.add(new JLabel("Hora Inicio:"));
        panel.add(startTimeField);
        panel.add(new JLabel("Hora Fin:"));
        panel.add(endTimeField);
        panel.add(new JLabel("Día:"));
        panel.add(dayField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(createButton);
        buttonPanel.add(readButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void createSchedule() {
    	try {
            int id = Integer.parseInt(idField.getText());
            int idSubject = Integer.parseInt(idSubjectField.getText());
            int idStudent = Integer.parseInt(idStudentField.getText());
            int idTeacher = Integer.parseInt(idTeacherField.getText());
            int startTime = Integer.parseInt(startTimeField.getText());
            int endTime = Integer.parseInt(endTimeField.getText());
            String day = dayField.getText();

            // Crear objeto Schedule con los datos
            Schedules schedule = new Schedules(id, idSubject, idStudent, idTeacher, startTime, endTime, day);

            // Llamar al controlador para crear el horario
            schedulesController.createSchedule(schedule);
            JOptionPane.showMessageDialog(this, "Horario creado con éxito.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: los IDs y las horas deben ser números enteros.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al crear el horario: " + ex.getMessage());
        }
    }

    private void readSchedules() {
        try {
            int id = Integer.parseInt(idField.getText());
            Schedules schedule = schedulesController.readSchedule(id);
            if (schedule != null) {
                idSubjectField.setText(String.valueOf(schedule.getId_subject()));
                idStudentField.setText(String.valueOf(schedule.getId_student()));
                idTeacherField.setText(String.valueOf(schedule.getId_teacher()));
                startTimeField.setText(String.valueOf(schedule.getEnd_time()));
                endTimeField.setText(String.valueOf(schedule.getEnd_time()));
                dayField.setText(schedule.getDay());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún horario con el ID proporcionado.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: el ID debe ser un número entero.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al leer el horario: " + ex.getMessage());
        }
    }



    private void updateSchedule() {
        try {
            int id = Integer.parseInt(idField.getText());
            int idSubject = Integer.parseInt(idSubjectField.getText());
            int idStudent = Integer.parseInt(idStudentField.getText());
            int idTeacher = Integer.parseInt(idTeacherField.getText());
            int startTime = Integer.parseInt(startTimeField.getText());
            int endTime = Integer.parseInt(endTimeField.getText());
            String day = dayField.getText();

            // Crear objeto Schedule con los datos
            Schedules schedule = new Schedules(id, idSubject, idStudent, idTeacher, startTime, endTime, day);

            // Llamar al controlador para actualizar el horario
            schedulesController.updateSchedule(schedule);
            JOptionPane.showMessageDialog(this, "Horario actualizado con éxito.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: los IDs y las horas deben ser números enteros.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el horario: " + ex.getMessage());
        }
    }

    private void deleteSchedule() {
        try {
            int id = Integer.parseInt(idField.getText());
            // Llamar al controlador para eliminar el horario
            schedulesController.deleteSchedule(id);
            JOptionPane.showMessageDialog(this, "Horario eliminado con éxito.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: el ID debe ser un número entero.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el horario: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Aquí se inicializa el controlador y se pasa a la ventana como parámetro
                SchedulesController schedulesController = new SchedulesController();
                SchedulesFrame frame = new SchedulesFrame(schedulesController);
                frame.setVisible(true);
            }
        });
    }
}
