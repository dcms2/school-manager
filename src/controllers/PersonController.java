package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import entities.Person;
import entities.Sex;

public class PersonController {

	private static HashMap<Integer, Person> persons = new HashMap<Integer, Person>();
	
	public static void save(Person p){
		if(p.getId() == -1){ // new person
			p.setId(getAndIncrementID());
		}
		persons.put(p.getId(), p);
	}
	
	public static Person getById(int id){
		return persons.get(id);
	}
	
	public static ArrayList<Person> getAll(){
		return new ArrayList<Person>( persons.values() );
	}
	
	public static ArrayList<Person> getBySex(Sex sex){
		ArrayList<Person> result = new ArrayList<Person>();
		for(Person p: persons.values()){
			if(p.getSex().equals(sex)) result.add(p);
		}
		return result;
	}
	
	
}
