package entities;

import java.util.Calendar;

public class Teacher extends Person {

    private static final long serialVersionUID = 3684000220172464325L;
    
    private double salary;
	
	public Teacher(String name, Calendar birthdate, Sex sex, Address address, String email, double salary, int id) {
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
