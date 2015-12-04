package entities;

import java.util.Date;

public class Student extends Person{
	
	private int id;
	
	private Class classe;
	
	private Person father;
	
	private Person mother;

	public Student(String name, Date birthdate, Sex sex, Address address, String email, int id, Class classe,
			Person father, Person mother) {
		super(name, birthdate, sex, address, email);
		this.id = id;
		this.classe = classe;
		this.father = father;
		this.mother = mother;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
