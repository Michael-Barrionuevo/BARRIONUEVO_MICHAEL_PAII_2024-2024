package Interfaz;
import java.sql.Connection;
import java.sql.SQLException;

import Class.Schedules;

public interface IDAOSchedules {
	
	public void create(Connection connection, Schedules schedule) throws SQLException;

	public Schedules read(Connection connection, Schedules schedule, int id_schedule) throws SQLException;

	public void update(Connection connection,  Schedules schedule, int id_schedule)throws SQLException;

	public void delete(Connection connection, int id_schedule)throws SQLException;
	
	public void createTable(Connection connection) throws SQLException;

}
