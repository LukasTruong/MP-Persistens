package model;

public class Customer {
private String name;
private String street;
private int houseNo;
private String floor;
private String zipCode;
private String city;
private String country;
private String email;
private int phone;

public Customer(String name, String street, int houseNo, String floor, String zipCode, String city, String country, String email, int phone) {
	super();
	this.name = name;
	this.street = street;
	this.houseNo = houseNo;
	this.floor = floor;
	this.zipCode = zipCode;
	this.city = city;
	this.country = country;
	this.email = email;
	this.phone = phone;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public int getHouseNo() {
	return houseNo;
}

public void setHouseNo(int houseNo) {
	this.houseNo = houseNo;
}

public String getFloor() {
	return floor;
}

public void setFloor(String floor) {
	this.floor = floor;
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

public int getPhone() {
	return phone;
}

public void setPhone(int phone) {
	this.phone = phone;
}

@Override
public String toString() {
	return "Customer [name=" + name + ", street=" + street + ", houseNo=" + houseNo + ", floor=" + floor + ", zipCode="
			+ zipCode + ", city=" + city + ", country=" + country + ", email=" + email + ", phone=" + phone + "]";
}






}
