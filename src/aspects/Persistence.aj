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
import controllers.Controller;
import controllers.ControllerFactory;
import main.Main;

public privileged aspect Persistence {

	private String STUDENT_FILENAME = "students.ser";

	private String PERSON_FILENAME = "people.ser";

	private String TEACHER_FILENAME = "teachers.ser";

	pointcut create():
		execution(* Controller.save(Person || Teacher || Student));

	pointcut program_starting():
		execution(* Main.main(*));

	after(Person p) returning: create() && args(p) {
		try {
			Controller controller;
			String filename;
			if (p instanceof Student) {
				controller = ControllerFactory.getInstance(ControllerFactory.STUDENT);
				filename = STUDENT_FILENAME;
			} else if (p instanceof Teacher) {
				controller = ControllerFactory.getInstance(ControllerFactory.TEACHER);
				filename = TEACHER_FILENAME;
			} else {
				controller = ControllerFactory.getInstance(ControllerFactory.PERSON);
				filename = PERSON_FILENAME;
			}
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
			oos.writeObject(controller.getData());
			oos.close();
		} catch (IOException e) {
			System.err.println("Erro ao persistir dados.");
		}
	}

	@SuppressWarnings("unchecked")
	before(): program_starting() {
		String filenames[] = new String[]{STUDENT_FILENAME, TEACHER_FILENAME, PERSON_FILENAME};
		Controller controllers[] = new Controller[]{ControllerFactory.getInstance(ControllerFactory.STUDENT), ControllerFactory.getInstance(ControllerFactory.TEACHER), ControllerFactory.getInstance(ControllerFactory.PERSON)};

		for (int i = 0; i < filenames.length; ++i) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filenames[i]));
				if (i == 0) {
					controllers[i].save((HashMap<Integer, Student>)ois.readObject());
				} else if (i == 1) {
					controllers[i].save((HashMap<Integer, Teacher>)ois.readObject());
				} else if (i == 2) {
					controllers[i].save((HashMap<Integer, Person>)ois.readObject());
				}
				ois.close();

				controllers[i].setNextID(controllers[i].maxKeyValue() + 1);
			} catch (ClassNotFoundException e) {
				System.err.println("Erro ao ler dados.");
			} catch (FileNotFoundException e) {
				System.err.println("file not found");
			} catch (IOException e) {
				System.err.println("Erro ao ler dados.");
			}
		}
	}
}
