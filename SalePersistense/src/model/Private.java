package model;

public class Private extends Customer{
	
	private int customerNo;
	
	public Private(int customerNo, String name, String street, int houseNo, String floor, String zipCode, String city, String country, String email, int phone) {
	
		super(name, street, houseNo, floor, zipCode, city, country, email, phone);
		this.customerNo = customerNo;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;

	}
}