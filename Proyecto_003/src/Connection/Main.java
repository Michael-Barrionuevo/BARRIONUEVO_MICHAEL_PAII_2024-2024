package Connection;

import java.sql.SQLException;

import Class.Schedules;
import Class.Student;
import Class.Subjects;
import Class.Teacher;

public class Main {

	public static void main(String[] args) throws SQLException {

		
		// Creamos un nuevo estudiante
		Student person1 = new Student(5, "Miguel", "Rivera", 22);
		
        //Creamos una  tabla
		 person1.createTable(DBConnection.getConnection());
		
		//Creamos un estudiante en la db
		person1.create(DBConnection.getConnection(), person1);
		
		// person1.update(Conexion.getConnection(),person2, person2.getId());
		// person1.delete(Conexion.getConnection(), 1);
		// person1.read(Conexion.getConnection(), person1,1);

		// Creamos un nuevo profesor
		Teacher p1 = new Teacher(3, "Pedro", "Miranda", 34);
		
		// Creamos una tabla
		 p1.createTable(DBConnection.getConnection());
		
		//Creamos un profesor en la db
		p1.create(DBConnection.getConnection(), p1);

		// Creamos una materia
		Subjects subject = new Subjects(10, "Historia", "Materia de la rama de  Estudios Sociales", 4);
		
		//Metodo para crear la tabla
		 subject.createTable(DBConnection.getConnection());
		
		//Creamos una materia en la db
		subject.create(DBConnection.getConnection(), subject);
		
		//Creamos un nuevo horario
		Schedules sche = new Schedules(subject.getId(), person1.getId(), p1.getId(), "7", "9", "Viernes");
		sche.createTable(DBConnection.getConnection());
		sche.create(DBConnection.getConnection(), sche);

	}

}
