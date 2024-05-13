package controller;

import interfaz.IDAO;
import daos.SubjectsDAO;
import models.Subjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SubjectsController {
    private IDAO<Subjects> subjectsDAO;

    public SubjectsController() {
        subjectsDAO = new SubjectsDAO(); // O podrías usar algún mecanismo de inyección de dependencias para asignar esto
    }

    public void createSubject(Subjects subject) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootroot")) {
            subjectsDAO.create(connection, subject);
        }
    }

    public Subjects readSubject(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootroot")) {
            return subjectsDAO.read(connection, id);
        }
    }

    public void updateSubject(Subjects subject) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootroot")) {
            subjectsDAO.update(connection, subject);
        }
    }

    public void deleteSubject(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootroot")) {
            subjectsDAO.delete(connection, id);
        }
    }
}

