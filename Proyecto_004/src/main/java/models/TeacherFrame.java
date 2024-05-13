package models;

import controller.TeacherController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class TeacherFrame extends JFrame {
    private JTextField idField;
    private JTextField nameField;
    private JTextField lastnameField;
    private JTextField ageField;
    private JButton createButton;
    private JButton readButton;
    private JButton updateButton;
    private JButton deleteButton;

    private TeacherController teacherController;

    public TeacherFrame(TeacherController teacherController) {
        this.teacherController = teacherController;

        setTitle("Gestión de Profesores");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear los campos de texto
        idField = new JTextField(10);
        nameField = new JTextField(20);
        lastnameField = new JTextField(20);
        ageField = new JTextField(5);

        // Crear los botones
        createButton = new JButton("Crear");
        readButton = new JButton("Leer");
        updateButton = new JButton("Actualizar");
        deleteButton = new JButton("Eliminar");

        // Agregar acción a los botones
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createTeacher();
            }
        });

        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readTeacher();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTeacher();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteTeacher();
            }
        });

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Nombre:"));
        panel.add(nameField);
        panel.add(new JLabel("Apellido:"));
        panel.add(lastnameField);
        panel.add(new JLabel("Edad:"));
        panel.add(ageField);
        panel.add(createButton);
        panel.add(readButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void createTeacher() {
        try {
            // Obtener datos de los campos de texto
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String lastname = lastnameField.getText();
            int age = Integer.parseInt(ageField.getText());

            // Crear objeto Teacher con los datos
            Teacher teacher = new Teacher(id, name, lastname, age);

            // Llamar al controlador para crear el profesor
            teacherController.createTeacher(teacher);
            JOptionPane.showMessageDialog(this, "Profesor creado con éxito.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: el ID y la edad deben ser números enteros.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al crear el profesor: " + ex.getMessage());
        }
    }

    private void readTeacher() {
        try {
            // Obtener ID del campo de texto
            int id = Integer.parseInt(idField.getText());

            // Llamar al controlador para leer el profesor
            Teacher teacher = teacherController.readTeacher(id);

            // Mostrar el profesor encontrado en los campos de texto
            if (teacher != null) {
                nameField.setText(teacher.getName());
                lastnameField.setText(teacher.getLastname());
                ageField.setText(String.valueOf(teacher.getAge()));
            } else {
                JOptionPane.showMessageDialog(this, "Profesor no encontrado.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: el ID debe ser un número entero.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al leer el profesor: " + ex.getMessage());
        }
    }

    private void updateTeacher() {
        try {
            // Obtener datos de los campos de texto
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String lastname = lastnameField.getText();
            int age = Integer.parseInt(ageField.getText());

            // Crear objeto Teacher con los datos
            Teacher teacher = new Teacher(id, name, lastname, age);

            // Llamar al controlador para actualizar el profesor
            teacherController.updateTeacher(teacher);
            JOptionPane.showMessageDialog(this, "Profesor actualizado con éxito.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: el ID y la edad deben ser números enteros.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el profesor: " + ex.getMessage());
        }
    }

    private void deleteTeacher() {
        try {
            // Obtener ID del campo de texto
            int id = Integer.parseInt(idField.getText());

            // Llamar al controlador para eliminar el profesor
            teacherController.deleteTeacher(id);
            JOptionPane.showMessageDialog(this, "Profesor eliminado con éxito.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: el ID debe ser un número entero.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el profesor: " + ex.getMessage());
        }
    }
}
