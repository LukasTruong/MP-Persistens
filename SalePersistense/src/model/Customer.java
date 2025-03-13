package model;

public class Customer {
private String name;
private String address;
private String zipCode;
private String city;
private String country;
private String email;

public Customer(String name, String address, String zipCode, String city, String country, String email) {
	super();
	this.name = name;
	this.address = address;
	this.zipCode = zipCode;
	this.city = city;
	this.country = country;
	this.email = email;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getZipCode() {
	return zipCode;
}

public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


}
