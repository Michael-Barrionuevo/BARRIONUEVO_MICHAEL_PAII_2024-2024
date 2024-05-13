package controller;

import interfaz.IDAO;
import daos.SchedulesDAO;
import models.Schedules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SchedulesController {
    private IDAO<Schedules> schedulesDAO;

    public SchedulesController() {
        schedulesDAO = new SchedulesDAO(); // O podrías usar algún mecanismo de inyección de dependencias para asignar esto
    }

    public void createSchedule(Schedules schedule) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootroot")) {
            schedulesDAO.create(connection, schedule);
        }
    }

    public Schedules readSchedule(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootroot")) {
            return schedulesDAO.read(connection, id);
        }
    }

    public void updateSchedule(Schedules schedule) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootroot")) {
            schedulesDAO.update(connection, schedule);
        }
    }

    public void deleteSchedule(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootroot")) {
            schedulesDAO.delete(connection, id);
        }
    }
}

