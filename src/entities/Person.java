package entities;

import java.util.Date;


public class Person {


	private int id;
	
	private String name;
	
	private Date birthdate;
	
	private Sex sex;
	
	private Address address;
	
	private String email;

	public Person(String name, Date birthdate, Sex sex, Address address, String email, int id) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.sex = sex;
		this.address = address;
		this.email = email;
		this.id =  id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public static void main(String[] args) {
		
	}
}
