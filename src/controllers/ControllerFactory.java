package controllers;

import java.util.HashMap;

import entities.Person;
import entities.Student;
import entities.Teacher;

public class ControllerFactory {
	
	public final static int PERSON = 0;
	
	public final static int STUDENT = 1;
	
	public final static int TEACHER = 2;
	
	@SuppressWarnings("rawtypes")
	private static HashMap<Integer, Controller> instances = new HashMap<Integer, Controller>();
	
	/**
	 * Returns the controller specified by type.
	 * @param type
	 * @return Controller
	 */
	@SuppressWarnings("rawtypes")
	public static Controller getInstance(int type) {
		if (!instances.containsKey(type)) {
			if (type == PERSON) {
				instances.put(type, new Controller<Person>());
			} else if (type == STUDENT) {
				instances.put(type, new Controller<Student>());
			} else if (type == TEACHER) {
				instances.put(type, new Controller<Teacher>());
			} else {
				return null;
			}
		}
		return instances.get(type);
	}
}
