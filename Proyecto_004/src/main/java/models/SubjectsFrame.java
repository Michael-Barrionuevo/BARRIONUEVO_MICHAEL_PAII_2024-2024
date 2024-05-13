package models;

import controller.SubjectsController;

import javax.security.auth.Subject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class SubjectsFrame extends JFrame {
    private JTextField idField;
    private JTextField nameField;
    private JTextField descriptionField;
    private JTextField levelField;
    private JButton createButton;
    private JButton readButton;
    private JButton updateButton;
    private JButton deleteButton;

    private SubjectsController subjectsController;

    public SubjectsFrame(SubjectsController subjectsController) {
        this.subjectsController = subjectsController;

        setTitle("Gestión de Asignaturas");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear los campos de texto
        idField = new JTextField(10);
        nameField = new JTextField(20);
        descriptionField = new JTextField(20);
        levelField = new JTextField(5);

        // Crear los botones
        createButton = new JButton("Crear");
        readButton = new JButton("Leer");
        updateButton = new JButton("Actualizar");
        deleteButton = new JButton("Eliminar");

        // Agregar acción a los botones
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createSubject();
            }
        });

        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readSubject();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateSubject();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteSubject();
            }
        });

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Nombre:"));
        panel.add(nameField);
        panel.add(new JLabel("Descripción:"));
        panel.add(descriptionField);
        panel.add(new JLabel("Nivel:"));
        panel.add(levelField);
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

    private void createSubject() {
        try {
            // Obtener datos de los campos de texto
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String description = descriptionField.getText();
            int level = Integer.parseInt(levelField.getText());

            // Crear objeto Subject con los datos
            Subjects subject = new Subjects(id, name, description, level);

            // Llamar al controlador para crear la asignatura
            subjectsController.createSubject(subject);
            JOptionPane.showMessageDialog(this, "Asignatura creada con éxito.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: el ID y el nivel deben ser números enteros.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al crear la asignatura: " + ex.getMessage());
        }
    }

    private void readSubject() {
        try {
            int id = Integer.parseInt(idField.getText());
            Subjects subject = subjectsController.readSubject(id);
            if (subject != null) {
                nameField.setText(subject.getName());
                descriptionField.setText(subject.getDescription());
                levelField.setText(String.valueOf(subject.getLevel()));
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ninguna asignatura con el ID proporcionado.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: el ID debe ser un número entero.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al leer la asignatura: " + ex.getMessage());
        }
    }

    
   

    private void updateSubject() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String description = descriptionField.getText();
            int level = Integer.parseInt(levelField.getText());

            Subjects subject = new Subjects(id, name, description, level);
            subjectsController.updateSubject(subject);
            JOptionPane.showMessageDialog(this, "Asignatura actualizada con éxito.");
        } catch (NumberFormatException | SQLException ex) {
            String errorMessage = ex instanceof NumberFormatException ? "Error: el ID y el nivel deben ser números enteros." : "Error al actualizar la asignatura: " + ex.getMessage();
            JOptionPane.showMessageDialog(this, errorMessage);
        }
    }

    private void deleteSubject() {
        try {
            int id = Integer.parseInt(idField.getText());
            subjectsController.deleteSubject(id);
            JOptionPane.showMessageDialog(this, "Asignatura eliminada con éxito.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: el ID debe ser un número entero.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar la asignatura: " + ex.getMessage());
        }
    }


}
