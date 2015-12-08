package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import entities.Person;
import entities.Sex;
import entities.Student;

public class Controller<T extends Person> {

	private int nextID;
	
	private HashMap<Integer, T> data;
	
	public Controller() {
		this.nextID = 0;
		this.data = new HashMap<Integer, T>();
	}
	
	public void save(T t) {
		if (t instanceof Student) {
			@SuppressWarnings("unchecked")
			Controller<Person> controller = ControllerFactory.getInstance(ControllerFactory.PERSON);
			controller.save(((Student) t).getFather());
			controller.save(((Student) t).getMother());
		}
		if (t.getId() == -1) {
			t.setId(this.nextID++);
		}
		this.data.put(t.getId(), t);
	}
	
	public void save(HashMap<Integer, T> data) {
		this.data.putAll(data);
	}
	
	public T getByID(int id) {
		return this.data.get(id);
	}
	
	public ArrayList<Person> getBySex(Sex sex) {
		ArrayList<Person> result = new ArrayList<Person>();
		for (Person p: this.data.values()) {
			if (p.getSex().equals(sex)) result.add(p);
		}
		return result;
	}
	
	public ArrayList<T> getAll() {
		return new ArrayList<T>(this.data.values());
	}
	
	public final HashMap<Integer, T> getData() {
		return this.data;
	}
	
	public void setNextID(int nextID) {
		this.nextID = nextID;
	}
	
	public int maxKeyValue() {
		Iterator<Integer> it = this.data.keySet().iterator();
		int ret = 0;
		while (it.hasNext()) {
			ret = Math.max(ret, it.next());
		}
		return ret;
	}
}
