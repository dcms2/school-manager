package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import entities.Person;
import entities.Sex;

public class PersonController {

	private static HashMap<Integer, Person> people = new HashMap<Integer, Person>();
	
	public static void save(Person p) {
		if (p.getId() == -1) { // new person
			p.setId(PersonController.getAndIncrementID());
		}
		people.put(p.getId(), p);
	}
	
	public static Person getById(int id) {
		return people.get(id);
	}
	
	public static ArrayList<Person> getAll() {
		return new ArrayList<Person>(people.values());
	}
	
	public static ArrayList<Person> getBySex(Sex sex) {
		ArrayList<Person> result = new ArrayList<Person>();
		for (Person p: people.values()) {
			if (p.getSex().equals(sex)) result.add(p);
		}
		return result;
	}
	
	public static void setData(HashMap<Integer, Person> people) {
		PersonController.people = people;
	}
	
	public static HashMap<Integer, Person> getData() {
		return people;
	}
}
