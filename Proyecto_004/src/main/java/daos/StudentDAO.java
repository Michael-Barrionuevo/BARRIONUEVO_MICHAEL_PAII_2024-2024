package daos;

import interfaz.IDAO;
import models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO implements IDAO<Student> {
    @Override
    public void create(Connection connection, Student student) throws SQLException {
        String query = "INSERT INTO student (id, name, lastname, age) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getLastname());
            statement.setInt(4, student.getAge());
            statement.executeUpdate();
        }
    }

    @Override
    public Student read(Connection connection, int id) throws SQLException {
        String query = "SELECT * FROM student WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Student(
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
    public void update(Connection connection, Student student) throws SQLException {
        String query = "UPDATE student SET name=?, lastname=?, age=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getLastname());
            statement.setInt(3, student.getAge());
            statement.setInt(4, student.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Connection connection, int id) throws SQLException {
        String query = "DELETE FROM student WHERE id=?";
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

