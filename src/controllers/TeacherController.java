package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import entities.Teacher;

public class TeacherController {
	
	private static HashMap<Integer, Teacher> teachers = new HashMap<Integer, Teacher>();
	
	private static int nextId = 0;
	
	public static void save(Teacher t) {
		if (t.getId() == -1) {  // new teacher
			t.setId(TeacherController.nextId++);
		}
		teachers.put(t.getId(), t);
	}
	
	public static ArrayList<Teacher> getAll() {
		return new ArrayList<Teacher>(teachers.values());
	}
	
	public static void save(HashMap<Integer, Teacher> teachers) {
		TeacherController.teachers.putAll(teachers);
	}
	
	public static HashMap<Integer, Teacher> getData() {
		return teachers;
	}
	
	public static void setNextID(int nextId) {
		TeacherController.nextId = nextId;
	}
	
	public static int maxKeyValue() {
		Iterator<Integer> it = teachers.keySet().iterator();
		int ret = 0;
		while (it.hasNext()) {
			ret = Math.max(ret, it.next());
		}
		return ret;
	}
}
