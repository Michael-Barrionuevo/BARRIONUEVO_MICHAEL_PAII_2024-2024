package controller;

import interfaz.IDAO;
import daos.TeacherDAO;
import models.Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TeacherController {
    private IDAO<Teacher> teacherDAO;

    public TeacherController() {
        teacherDAO = new TeacherDAO(); // O podrías usar algún mecanismo de inyección de dependencias para asignar esto
    }

    public void createTeacher(Teacher teacher) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootroot")) {
            teacherDAO.create(connection, teacher);
        }
    }

    public Teacher readTeacher(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootroot")) {
            return teacherDAO.read(connection, id);
        }
    }

    public void updateTeacher(Teacher teacher) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootroot")) {
            teacherDAO.update(connection, teacher);
        }
    }

    public void deleteTeacher(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootroot")) {
            teacherDAO.delete(connection, id);
        }
    }
}

