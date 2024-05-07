package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Interfaz.IDAOSubjects;

public class Subjects implements IDAOSubjects {

	private int id;
	private String name;
	private String description;
	private int level;
	
	private PreparedStatement pre;
	private String table = "Subject";
	
	public Subjects(int id, String name, String description, int level) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.level = level;
	}
	
	@Override
	public void create(Connection connection, Subjects subject) throws SQLException {
		pre = connection.prepareStatement("INSERT INTO " + table + " (id, name, description, level) VALUES (?,?,?,?)");
		pre.setInt(1, subject.getId());
		pre.setString(2, subject.getName());
		pre.setString(3, subject.getDescription());
		pre.setInt(4, subject.getLevel());
		pre.execute();
		pre.close();
		
	}

	@Override
	public Subjects read(Connection connection, Subjects subject, int id_subject) throws SQLException {
		ResultSet resultados = null;
		String sql = null;
		subject = new Subjects(0, "", "", 0);

		pre = connection.prepareStatement("SELECT * FROM \" + table + \" WHERE id = ?");
		pre.setInt(1, id_subject);
		resultados = pre.executeQuery();

		if (resultados.next()) {
			subject.setId(resultados.getInt(1));
			subject.setName(resultados.getString(2));
			subject.setDescription(resultados.getString(3));
			subject.setLevel(resultados.getInt(4));

			System.out.println(subject.toString());
		}
		pre.close();
		pre.close();
		return subject;
	}

	@Override
	public void update(Connection connection, Subjects subject, int id_subject) throws SQLException {
		pre = connection.prepareStatement("UPDATE " + table + " SET name=?, lastname=?, age=? WHERE id=?");
		pre.setString(1, subject.getName());
		pre.setString(2, subject.getDescription());
		pre.setInt(3, subject.getLevel());
		pre.setInt(4, id_subject);
		pre.execute();
		pre.close();

		
	}

	@Override
	public void delete(Connection connection, int id_subject) throws SQLException {
		pre = connection.prepareStatement("DELETE FROM " + table + " WHERE id=?");
		pre.setInt(1, id_subject);
		pre.execute();
		pre.close();
		
	}

	@Override
	public void createTable(Connection connection) throws SQLException {
		String query = "CREATE TABLE IF NOT EXISTS " + table + " ( " + "id INT PRIMARY KEY," + "name VARCHAR(35),"
				+ "description VARCHAR(150)," + "level INT" + ")";
		connection.createStatement().executeUpdate(query);
		System.out.println("Tabla creada o ya existente.");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}


	

	
}
