package models;

import controller.StudentController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class StudentFrame extends JFrame {
    private JTextField idField;
    private JTextField nameField;
    private JTextField lastnameField;
    private JTextField ageField;
    private JButton createButton;
    private JButton readButton;
    private JButton updateButton;
    private JButton deleteButton;

    private StudentController studentController;

    public StudentFrame(StudentController studentController) {
        this.studentController = studentController;

        setTitle("Gestión de Estudiantes");
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
                createStudent();
            }
        });

        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readStudent();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
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

    private void createStudent() {
        try {
            // Obtener datos de los campos de texto
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String lastname = lastnameField.getText();
            int age = Integer.parseInt(ageField.getText());

            // Crear objeto Student con los datos
            Student student = new Student(id, name, lastname, age);

            // Llamar al controlador para crear el estudiante
            studentController.createStudent(student);
            JOptionPane.showMessageDialog(this, "Estudiante creado con éxito.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: el ID y la edad deben ser números enteros.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al crear el estudiante: " + ex.getMessage());
        }
    }

    private void readStudent() {
        String idText = idField.getText().trim(); // Eliminar espacios en blanco al inicio y al final
        if (!idText.isEmpty()) { // Verificar si el campo no está vacío
            try {
                int id = Integer.parseInt(idText);
                Student student = studentController.readStudent(id);
                if (student != null) {
                    nameField.setText(student.getName());
                    lastnameField.setText(student.getLastname());
                    ageField.setText(String.valueOf(student.getAge()));
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún estudiante con el ID proporcionado.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: el ID debe ser un número entero.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al leer el estudiante: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error: el campo ID está vacío.");
        }
    }


    private void updateStudent() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String lastname = lastnameField.getText();
            int age = Integer.parseInt(ageField.getText());

            Student student = new Student(id, name, lastname, age);
            studentController.updateStudent(student);
            JOptionPane.showMessageDialog(this, "Estudiante actualizado con éxito.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: el ID y la edad deben ser números enteros.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el estudiante: " + ex.getMessage());
        }
    }

    private void deleteStudent() {
        try {
            int id = Integer.parseInt(idField.getText());
            studentController.deleteStudent(id);
            JOptionPane.showMessageDialog(this, "Estudiante eliminado con éxito.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: el ID debe ser un número entero.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el estudiante: " + ex.getMessage());
        }
    }
}
