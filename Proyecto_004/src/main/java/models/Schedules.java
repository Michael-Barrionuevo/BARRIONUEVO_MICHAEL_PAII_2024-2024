package models;

public class Schedules {
	
	private int id;
	private int id_subject;
	private int id_student;
	private int id_teacher;
	private int start_time;
	private int end_time;
	String day;
	
	public Schedules( int id,int id_subject, int id_student,int id_teacher,int start_time,int end_time,String day) {
		this.id = id;
		this.id_subject = id_subject;
		this.id_student = id_student;
		this.id_teacher = id_teacher;
		this.start_time = start_time;
		this.end_time = end_time;
		this.day = day;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getStart_time() {
		return start_time;
	}

	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}

	public int getEnd_time() {
		return end_time;
	}

	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	

}
