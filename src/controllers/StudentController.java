package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import entities.Person;
import entities.Student;

public class StudentController {
	
	private static HashMap<Integer, Student> students = new HashMap<Integer, Student>();
	
	private static int nextId = 0;
	
	public static void save(Student s) {
		PersonController.save(s.getFather());
		PersonController.save(s.getMother());
		if (s.getId() == -1) { // update
			s.setId(StudentController.nextId++);
		}
		students.put(s.getId(), s);
	}
	
	public static ArrayList<Student> getAll() {
		return new ArrayList<Student>(students.values());
	}
	
	public static void save(HashMap<Integer, Student> students) {
		StudentController.students.putAll(students);
	}
	
	public static HashMap<Integer, Student> getData() {
		return students;
	}
	
	public static void setNextID(int nextId) {
		StudentController.nextId = nextId;
	}
	
	public static int maxKeyValue() {
		Iterator<Integer> it = students.keySet().iterator();
		int ret = 0;
		while (it.hasNext()) {
			ret = Math.max(ret, it.next());
		}
		return ret;
	}
}
