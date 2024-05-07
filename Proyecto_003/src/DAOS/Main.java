package DAOS;

import java.sql.SQLException;

import Class.Schedules;
import Class.Student;
import Class.Subjects;
import Class.Teacher;

public class Main {

	public static void main(String[] args) throws SQLException {

		// Creamos un alumno
		Student person1 = new Student(1, "Pepe", "Nidea", 10);
		
        //Metodo para crear la tabla
		// person1.createTable(Conexion.getConnection());
		
		//Creamos un alumno en la db
		//person1.create(Conexion.getConnection(), person1);
		
		// person1.update(Conexion.getConnection(),person2, person2.getId());
		// person1.delete(Conexion.getConnection(), 1);
		// person1.read(Conexion.getConnection(), person1,1);

		// Creamos un profesor
		Teacher p1 = new Teacher(0, "Marco", "Cedeño", 2);
		
		//Metodo para crear la tabla
		// p1.createTable(Conexion.getConnection());
		
		//Creamos un profesor en la db
		//p1.create(Conexion.getConnection(), p1);

		// Creamos una materia
		Subjects subject = new Subjects(12, "Matematica", "kjsahkbfshibdosihoisdlgjhdjxc", 2);
		
		//Metodo para crear la tabla
		// subject.createTable(Conexion.getConnection());
		
		//Creamos una materia en la db
		//subject.create(Conexion.getConnection(), subject);
		
		Schedules sche = new Schedules(subject.getId(), person1.getId(), p1.getId(), "9", "11", "Lunes");
		sche.createTable(Connection.getConnection());
		sche.create(Connection.getConnection(), sche);

	}

}
