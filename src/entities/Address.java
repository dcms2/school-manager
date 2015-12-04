package entities;

public class Address {
	
	private String street;
	
	private String neighborhood;
	
	private String zipcode;
	
	private String state;
	
	private String city;

	public Address(String street, String neighborhood, String zipcode, String state, String city) {
		super();
		this.street = street;
		this.neighborhood = neighborhood;
		this.zipcode = zipcode;
		this.state = state;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
