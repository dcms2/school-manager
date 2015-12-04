package controllers;



import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import entities.Person;
import entities.Sex;
import entities.Student;

public class StudentController {
	
	private static HashMap<Integer, Student> students;
	
	private static HashMap<Integer, Person> fathers;
	
	private static HashMap<Integer, Person> mothers;

	
	static void addFather(Person father){
		fathers.put(father.getId(), father);
	}
	
	static String listFathers(){
		String result = "";
		
		for( Person father : fathers.values() ){
			result += "["+ father.getId() + "]: " + father.getName() + "\n"; 
		}
		return result;
		
	}
	
	
	
	public static void main(String[] args) {
		Sex x = Sex.Male;
		//StudentController.addFather(new Person("Tomer", new Date(1, 1, 1), Sex.male, address, email))
		
		
	}
	
	
	
	
}
