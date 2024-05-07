package DAOS;

import java.sql.DriverManager;

public class Connection {

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/instituto";
		String usuario = "root";
		String password = "rootroot";

		Connection connection = null;

		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, usuario, password);
				boolean valida = connection.isValid(50000);
				System.out.println(valida ? "Conexión realizada" : "Conexión fallida");
			} catch (java.sql.SQLException e) {
				System.out.println("Error sql:" + e.getErrorCode());
			}
		}
		return connection;
	}
}
