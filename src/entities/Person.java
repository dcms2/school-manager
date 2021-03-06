package entities;

import java.io.Serializable;
import java.util.Calendar;

public class Person implements Serializable {

	private static final long serialVersionUID = -84434539764735947L;

	private int id;
	
	private String name;
	
	private Calendar birthdate;
	
	private Sex sex;
	
	private Address address;
	
	private String email;
	
	public Person(){ }
	
	public Person(String name, Calendar birthdate, Sex sex, Address address, String email) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.sex = sex;
		this.address = address;
		this.email = email;
		this.id = -1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setPerson(Person p){
		this.setId(p.getId());
		this.setName(p.getName());
		this.setBirthdate(p.getBirthdate());
		this.setSex(p.getSex());
		this.setAddress(p.getAddress());
		this.setEmail(p.getEmail()); 
	}
	
	@Override
	public String toString() {
		return id + "," + name + ","
				+ birthdate + "," + sex + "," + address
				+ "," + email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Calendar birthdate) {
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
