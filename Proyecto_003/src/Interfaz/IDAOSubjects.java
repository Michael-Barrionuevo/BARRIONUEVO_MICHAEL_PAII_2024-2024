package Interfaz;

import java.sql.Connection;
import java.sql.SQLException;

import Class.Subjects;



public interface IDAOSubjects {
	
	public void create(Connection connection, Subjects subject) throws SQLException;

	public Subjects read(Connection connection, Subjects subject, int id_subject) throws SQLException;

	public void update(Connection connection,  Subjects subject, int id_subject)throws SQLException;

	public void delete(Connection connection, int id_subject)throws SQLException;
	
	public void createTable(Connection connection) throws SQLException;
	

}
