package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
	
	private static DataBaseConnection instance;
    private Connection connection;

    private DataBaseConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  
    public static DataBaseConnection getInstance() {
        if (instance == null) {
            instance = new DataBaseConnection();
        }
        return instance;
    }

  
    public Connection getConnection() {
        return connection;
    }

    // Método para ejecutar una consulta SQL (INSERT, UPDATE, DELETE)
    public void executeUpdate(String sql) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo del error de consulta SQL
        }
    }

    // Método para desconectar la conexión a la base de datos
    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo del error al cerrar la conexión
        }
    }

}
