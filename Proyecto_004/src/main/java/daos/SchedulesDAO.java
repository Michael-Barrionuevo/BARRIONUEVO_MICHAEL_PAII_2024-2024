package daos;

import interfaz.IDAO;
import models.Schedules;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SchedulesDAO implements IDAO<Schedules> {
    @Override
    public void create(Connection connection, Schedules schedule) throws SQLException {
        String query = "INSERT INTO schedules (id, id_subject, id_student, id_teacher, start_time, end_time, day) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, schedule.getId());
            statement.setInt(2, schedule.getId_subject());
            statement.setInt(3, schedule.getId_student());
            statement.setInt(4, schedule.getId_teacher());
            statement.setInt(5, schedule.getStart_time());
            statement.setInt(6, schedule.getEnd_time());
            statement.setString(7, schedule.getDay());
            statement.executeUpdate();
        }
    }

    @Override
    public Schedules read(Connection connection, int id) throws SQLException {
        String query = "SELECT * FROM schedules WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Schedules(
                            resultSet.getInt("id"),
                            resultSet.getInt("id_subject"),
                            resultSet.getInt("id_student"),
                            resultSet.getInt("id_teacher"),
                            resultSet.getInt("start_time"),
                            resultSet.getInt("end_time"),
                            resultSet.getString("day")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public void update(Connection connection, Schedules schedule) throws SQLException {
        String query = "UPDATE schedules SET id_subject=?, id_student=?, id_teacher=?, start_time=?, end_time=?, day=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, schedule.getId_subject());
            statement.setInt(2, schedule.getId_student());
            statement.setInt(3, schedule.getId_teacher());
            statement.setInt(4, schedule.getStart_time());
            statement.setInt(5, schedule.getEnd_time());
            statement.setString(6, schedule.getDay());
            statement.setInt(7, schedule.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Connection connection, int id) throws SQLException {
        String query = "DELETE FROM schedules WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

	@Override
	public void createTable(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}

