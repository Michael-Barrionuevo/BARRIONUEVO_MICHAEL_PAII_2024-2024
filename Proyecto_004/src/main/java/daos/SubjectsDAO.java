package daos;

import interfaz.IDAO;
import models.Subjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectsDAO implements IDAO<Subjects> {
    @Override
    public void create(Connection connection, Subjects subject) throws SQLException {
        String query = "INSERT INTO subjects (id, name, description, level) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, subject.getId());
            statement.setString(2, subject.getName());
            statement.setString(3, subject.getDescription());
            statement.setInt(4, subject.getLevel());
            statement.executeUpdate();
        }
    }

    @Override
    public Subjects read(Connection connection, int id) throws SQLException {
        String query = "SELECT * FROM subjects WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Subjects(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("description"),
                            resultSet.getInt("level")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public void update(Connection connection, Subjects subject) throws SQLException {
        String query = "UPDATE subjects SET name=?, description=?, level=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, subject.getName());
            statement.setString(2, subject.getDescription());
            statement.setInt(3, subject.getLevel());
            statement.setInt(4, subject.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Connection connection, int id) throws SQLException {
        String query = "DELETE FROM subjects WHERE id=?";
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

