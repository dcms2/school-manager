package entities;

import java.util.Date;

enum Sex{
	Male, Female;
}

public class Person {
	
	private String name;
	
	private Date birthdate;
	
	private Sex sex;
	
	private Address address;
	
	private String email;

	public Person(String name, Date birthdate, Sex sex, Address address, String email) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.sex = sex;
		this.address = address;
		this.email = email;
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
	
	
	
}
