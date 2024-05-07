package Connection;

import java.sql.DriverManager;

public class DBConnection {

	public static java.sql.Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/instituto";
        String usuario = "root";
        String password = "rootroot";

        java.sql.Connection connection = null;

        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, usuario, password);
                boolean valida = connection.isValid(50000);
                System.out.println(valida ? "Conexión exitosa" : "Conexión fallida");
            } catch (java.sql.SQLException e) {
                System.out.println("Error sql:" + e.getErrorCode());
            }
        }
        return connection;
    }
}
