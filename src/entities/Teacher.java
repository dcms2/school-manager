package entities;

import java.util.Date;

public class Teacher extends Person {

	private double salary;
	
	public Teacher(String name, Date birthdate, Sex sex, Address address, String email, double salary, int id) {
		super(name, birthdate, sex, address, email);
		this.salary = salary;
	
	}
	
	public void setSalary(double newSalary) {
		this.salary = newSalary;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
}
