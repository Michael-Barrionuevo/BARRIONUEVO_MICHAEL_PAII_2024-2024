package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Interfaz.IDAOPerson;

public class Student extends Person implements IDAOPerson {
	
	private PreparedStatement pre;
	private String table = "student";

	public Student(int id, String name, String lastName, int age) {
		super(id, name, lastName, age);
	}

	@Override
	public void create(Connection connection, Person person) throws SQLException {
		pre = connection.prepareStatement("INSERT INTO " + table + " (id, name, lastname, age) VALUES (?,?,?,?)");
		pre.setInt(1, person.getId());
		pre.setString(2, person.getName());
		pre.setString(3, person.getLastName());
		pre.setInt(4, person.getAge());
		pre.execute();
		pre.close();

	}

	@Override
	public Person read(Connection connection, Person person, int id_person) throws SQLException {
		ResultSet resultados = null;
		String sql = null;
		person = new Person(0, "", "", 0);

		try {
			sql = "SELECT * FROM " + table + " WHERE id = ?";
			pre = connection.prepareStatement(sql);
			pre.setInt(1, id_person);
			resultados = pre.executeQuery();

			if (resultados.next()) {
				person.setId(resultados.getInt(1));
				person.setName(resultados.getString(2));
				person.setLastName(resultados.getString(3));
				person.setAge(resultados.getInt(4));
			}

			System.out.println(person.toString());
			;

			pre.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
	}

	@Override
	public void update(Connection connection, Person person, int id_person) throws SQLException {
		pre = connection.prepareStatement("UPDATE " + table + " SET name=?, lastname=?, age=? WHERE id=?");
		pre.setString(1, person.getName());
		pre.setString(2, person.getLastName());
		pre.setInt(3, person.getAge());
		pre.setInt(4, id_person);
		pre.execute();
		pre.close();

	}

	@Override
	public void delete(Connection connection, int id_person) throws SQLException {
		pre = connection.prepareStatement("DELETE FROM " + table + " WHERE id=?");
		pre.setInt(1, id_person);
		pre.execute();
		pre.close();

	}

	@Override
	public void createTable(Connection connection) throws SQLException {
		String query = "CREATE TABLE IF NOT EXISTS " + table + " ( " + "id INT PRIMARY KEY," + "name VARCHAR(35),"
				+ "lastname VARCHAR(30)," + "age INT" + ")";
		connection.createStatement().executeUpdate(query);
		System.out.println("Tabla creada o ya existente.");
	}

}