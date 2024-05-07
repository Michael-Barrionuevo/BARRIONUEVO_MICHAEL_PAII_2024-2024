package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Interfaz.IDAOSchedules;

public class Schedules implements IDAOSchedules{
	
	private int id_subject;
	private int id_student;
	private int id_teacher;
	private String start_time;
	private String end_time;
	private String day;
	private String table = "Schedule";
	private PreparedStatement pre;

	public Schedules(int id_mat, int id_student, int id_teacher, String start_time, String end_time, String day) {
		this.id_subject = id_mat;
		this.id_student = id_student;
		this.id_teacher = id_teacher;
		this.start_time = start_time;
		this.end_time = end_time;
		this.day = day;
	}

	@Override
	public void create(Connection connection, Schedules schedule) throws SQLException {
		pre = connection.prepareStatement("INSERT INTO Schedule (id_student, id_tacher, id_subject, start_time,end_time, day) VALUES (?,?,?,?,?,?)");
		pre.setInt(3, schedule.getId_subject());
		pre.setInt(1, schedule.getId_student());
		pre.setInt(2, schedule.getId_teacher());
		pre.setString(4, schedule.getStart_time());
		pre.setString(5, schedule.getEnd_time());
		pre.setString(6, schedule.getDay());
		pre.execute();
		pre.close();
		
	}

	@Override
	public Schedules read(Connection connection, Schedules schedule, int id_schedule) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Connection connection, Schedules schedule, int id_schedule) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection connection, int id_schedule) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createTable(Connection connection) throws SQLException {
		String query = "CREATE TABLE IF NOT EXISTS Schedule ( " + "id_student INT," + "id_teacher INT,"
				+ "id_subject INT," + "start_time VARCHAR(30)," + "end_time VARCHAR(30)," + "day VARCHAR(30),"
				+ "FOREIGN KEY (id_student) REFERENCES Alumns(id_teacher),"
				+ "FOREIGN KEY (id_teacher) REFERENCES Teacher(id),"
				+ "FOREIGN KEY (id_subject) REFERENCES Subject(id)" + ")";
		connection.createStatement().executeUpdate(query);
		System.out.println("Tabla creada o ya existente.");
		
	}

	public int getId_subject() {
		return id_subject;
	}

	public void setId_subject(int id_subject) {
		this.id_subject = id_subject;
	}

	public int getId_student() {
		return id_student;
	}

	public void setId_student(int id_student) {
		this.id_student = id_student;
	}

	public int getId_teacher() {
		return id_teacher;
	}

	public void setId_teacher(int id_teacher) {
		this.id_teacher = id_teacher;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	
}
