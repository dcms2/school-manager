package entities;

import java.util.Date;

public class Student{
	

	private Class classe;
	
	private Person father;
	
	private Person mother;


	
	public Student(Person student, Person father, Person mother){
		super.setPerson(student);
		this.father = father;
		this.mother = mother;
	}
	
	public Student(String name, Date birthdate, Sex sex, Address address, String email, Class classe,
			Person father, Person mother, int id) {
		super(name, birthdate, sex, address, email, id);
		this.classe = classe;
		this.father = father;
		this.mother = mother;
		
	}

	public Class getClasse() {
		return classe;
	}

	public void setClasse(Class classe) {
		this.classe = classe;
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
	
}
