package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import entities.Person;
import entities.Student;

public class StudentController {
	
	private static HashMap<Integer, Student> students = new HashMap<Integer, Student>();
	
	private static int nextId = 0;
	
	public static void save(Student s) {
		PersonController.save(s.getFather());
		PersonController.save(s.getMother());
		if (s.getId() == -1) { // update
			s.setId(nextId++);
		}
		students.put(s.getId(), s);
	}
	
	public static ArrayList<Student> getAll() {
		return new ArrayList<Student>(students.values());
	}
	
	public static void setData(HashMap<Integer, Student> students) {
		StudentController.students = students;
	}
	
	public static HashMap<Integer, Student> getData() {
		return students;
	}
}
