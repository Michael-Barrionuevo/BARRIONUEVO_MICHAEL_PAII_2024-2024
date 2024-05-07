package Interfaz;

import java.sql.Connection;
import java.sql.SQLException;

import Class.Person;

public interface IDAOPerson {
	
	public void create(Connection connection, Person person) throws SQLException;

	public Person read(Connection connection, Person person, int id_person) throws SQLException;

	public void update(Connection connection,  Person person, int id_person)throws SQLException;

	public void delete(Connection connection, int id_person)throws SQLException;
	
	public void createTable(Connection connection) throws SQLException;

}
