package entities;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = -5826243102556490575L;

	private String city;
	
	private String country;
	
	private String street;

	public Address(String city, String country, String street) {
		super();
		this.city = city;
		this.country = country;
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return city + "," + country + ","+ street;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}
