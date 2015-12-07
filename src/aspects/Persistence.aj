package aspects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import entities.Person;
import entities.Student;
import entities.Teacher;
import controllers.PersonController;
import controllers.StudentController;
import controllers.TeacherController;
import main.Main;

public privileged aspect Persistence {

	private String STUDENT_FILENAME = "students.ser";

	private String PERSON_FILENAME = "people.ser";
	
	private String TEACHER_FILENAME = "teachers.ser";

	pointcut create():
		execution(static * (PersonController || StudentController || TeacherController).save(Person || Student || Teacher));

	pointcut program_starting():
		execution(* Main.main(*));

	after(Person p) returning: create() && args(p) {
		try {
			if (p instanceof Student) {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STUDENT_FILENAME));
				oos.writeObject(StudentController.getData());
				oos.close();
			} else if (p instanceof Teacher) {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TEACHER_FILENAME));
				oos.writeObject(TeacherController.getData());
				oos.close();
			} else {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PERSON_FILENAME));
				oos.writeObject(PersonController.getData());
				oos.close();
			}			
		} catch (IOException e) {
			System.err.println("Erro ao persistir dados.");
		}
	}

	@SuppressWarnings("unchecked")
	before(): program_starting() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(STUDENT_FILENAME));
			StudentController.save((HashMap<Integer, Student>) ois.readObject());
			ois.close();
			
			StudentController.setNextID(StudentController.maxKeyValue() + 1);
			
			ois = new ObjectInputStream(new FileInputStream(TEACHER_FILENAME));
			TeacherController.save((HashMap<Integer, Teacher>) ois.readObject());
			ois.close();
			
			TeacherController.setNextID(TeacherController.maxKeyValue() + 1);

			ois = new ObjectInputStream(new FileInputStream(PERSON_FILENAME));
			PersonController.save((HashMap<Integer, Person>) ois.readObject());
			ois.close();
			
			PersonController.setNextID(PersonController.maxKeyValue() + 1);
		} catch (ClassNotFoundException e) {
			System.err.println("Erro ao ler dados.");
		} catch (FileNotFoundException e) {
			System.err.println("file not found");
		} catch (IOException e) {
			System.err.println("Erro ao ler dados.");
		}
	}
}
