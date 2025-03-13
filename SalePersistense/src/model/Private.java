package model;

public class Private extends Customer{
	
	private int customerNo;
	
	public Private(int customerNo, String name, String address, String zipCode, String city, String country, String email) {
	
		super(name, address, zipCode, city, country, email);
		this.customerNo = customerNo;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;

	}
}