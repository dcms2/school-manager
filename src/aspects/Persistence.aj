package aspects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import entities.Person;
import entities.Student;

import controllers.PersonController;
import controllers.StudentController;
import main.Main;

public aspect Persistence {

	private static String STUDENT_FILENAME = "students.ser";

	private static String PERSON_FILENAME = "people.ser";

	pointcut create():
		execution(static * (PersonController || StudentController).save(Person||Student));

	pointcut program_starting():
		execution(* Main.main(*));

	after(Person p) returning: create() && args(p) {
		try {
			if (p instanceof Student) {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STUDENT_FILENAME));
				oos.writeObject(StudentController.getData());
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
			StudentController.setData((HashMap<Integer, Student>) ois.readObject());
			ois.close();

			ois = new ObjectInputStream(new FileInputStream(PERSON_FILENAME));
			PersonController.setData((HashMap<Integer, Person>) ois.readObject());
			ois.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Erro ao ler dados.");
		} catch (IOException e) {
			System.err.println("Erro ao ler dados.");
		}
	}	
}
