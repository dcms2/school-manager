package entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Student implements Serializable {

	private static final long serialVersionUID = 5802615147450164148L;
	
	private Person father;
	
	private Person mother;

	public Student(Person student, Person father, Person mother){
		super.setPerson(student);
		this.father = father;
		this.mother = mother;
	}
	
	public Student(String name, Calendar birthdate, Sex sex, Address address, String email,
			Person father, Person mother, int id) {
		super(name, birthdate, sex, address, email);
		this.father = father;
		this.mother = mother;
		
	}

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public Person getMother() {
		return mother;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}
	
	public String toString() {
		return super.toString() + "," + this.getFather().getId() + "," + this.getMother().getId();
	}
}
