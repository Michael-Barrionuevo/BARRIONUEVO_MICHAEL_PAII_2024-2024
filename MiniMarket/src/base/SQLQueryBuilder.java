package base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLQueryBuilder {
	
	private Connection connection;

    // Constructor
    public SQLQueryBuilder(Connection connection) {
        this.connection = connection;
    }

    // Método para construir y ejecutar una consulta SQL SELECT
    public ResultSet executeQuery(String sql) {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo del error de consulta SQL
        }
        return resultSet;
    }

    // Método para construir y ejecutar una consulta SQL INSERT, UPDATE o DELETE
    public int executeUpdate(String sql) {
        int rowsAffected = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo del error de consulta SQL
        }
        return rowsAffected;
    }

}
