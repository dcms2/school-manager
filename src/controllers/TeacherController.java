package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import entities.Teacher;

public class TeacherController {
	
	private static HashMap<Integer, Teacher> teachers = new HashMap<Integer, Teacher>();
	
	private static int nextId = 0;
	
	public static void save(Teacher t) {
		if (t.getId() == -1) {  // new teacher
			t.setId(nextId++);
		}
		teachers.put(t.getId(), t);
	}
	
	public static ArrayList<Teacher> getAll() {
		return new ArrayList<Teacher>(teachers.values());
	}
	
	public static void setData(HashMap<Integer, Teacher> teachers) {
		TeacherController.teachers = teachers;
	}
	
	public static HashMap<Integer, Teacher> getData() {
		return teachers;
	}
}
