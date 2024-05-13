package controller;

import interfaz.IDAO;
import daos.StudentDAO;
import models.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentController {
    private IDAO<Student> studentDAO;

    public StudentController() {
        studentDAO = new StudentDAO(); // O podrías usar algún mecanismo de inyección de dependencias para asignar esto
    }

    public void createStudent(Student student) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootroot")) {
            studentDAO.create(connection, student);
        }
    }

    public Student readStudent(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootroot")) {
            return studentDAO.read(connection, id);
        }
    }

    public void updateStudent(Student student) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootroot")) {
            studentDAO.update(connection, student);
        }
    }

    public void deleteStudent(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootroot")) {
            studentDAO.delete(connection, id);
        }
    }
    
}