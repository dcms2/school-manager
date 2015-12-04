package controllers;



import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import entities.Address;
import entities.Person;
import entities.Sex;
import entities.Student;

public class StudentController {
	
	
	private static int NEXT_ID = 0 ; 
	
	private static HashMap<Integer, Student> students = new HashMap<Integer, Student>();
	
	private static HashMap<Integer, Person> fathers = new HashMap<Integer, Person>();
	
	private static HashMap<Integer, Person> mothers = new HashMap<Integer, Person>();

	public static int getAndIncrementID(){
		return StudentController.NEXT_ID++;
	}
	
	public static void addFather(Person father){
		fathers.put(father.getId(), father);
	}
	
	public static void addMother(Person mother){
		mothers.put(mother.getId(), mother);
	}	
	
	public static void addStudent(Student student ){
		students.put(student.getId(), student);
	}	
	
	public static ArrayList<Person> getFathers(){
		return new ArrayList<Person>( StudentController.fathers.values() );
	}
	
	public static ArrayList<Person> getMothers(){
		return new ArrayList<Person>( StudentController.mothers.values());
	}
	
	public static ArrayList<Student> getStudents(){
		return new ArrayList<Student>( StudentController.students.values() );
	}	
	
	
	
	
	// testando 
	public static void main(String[] args) {
		Sex x = Sex.Male;
		Date d = new Date(1, 2, 3);
		Address a = new Address("sei la", " s " , " as ");
		
		StudentController.addFather(new Person("duhan", d, x, a, "mras", 2));
		
		System.out.println(StudentController.getFathers());
	}
	
	
	
	
}
