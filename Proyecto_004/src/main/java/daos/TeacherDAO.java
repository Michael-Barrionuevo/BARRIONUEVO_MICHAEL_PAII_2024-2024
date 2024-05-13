package daos;

import interfaz.IDAO;
import models.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDAO implements IDAO<Teacher> {
    @Override
    public void create(Connection connection, Teacher teacher) throws SQLException {
        String query = "INSERT INTO teacher (id, name, lastname, age) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, teacher.getId());
            statement.setString(2, teacher.getName());
            statement.setString(3, teacher.getLastname());
            statement.setInt(4, teacher.getAge());
            statement.executeUpdate();
        }
    }

    @Override
    public Teacher read(Connection connection, int id) throws SQLException {
        String query = "SELECT * FROM teacher WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Teacher(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("lastname"),
                            resultSet.getInt("age")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public void update(Connection connection, Teacher teacher) throws SQLException {
        String query = "UPDATE teacher SET name=?, lastname=?, age=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, teacher.getName());
            statement.setString(2, teacher.getLastname());
            statement.setInt(3, teacher.getAge());
            statement.setInt(4, teacher.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Connection connection, int id) throws SQLException {
        String query = "DELETE FROM teacher WHERE id=?";
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

