package Controllers;

import db.CustomerDAO;
import db.CustomerDB;
import model.Customer;

public class CustomerController {
	private CustomerDAO customerDAO;
	private CustomerDB customerDB;
	
	public CustomerController() {
		this.customerDAO = new CustomerDB();
	}

	public Customer findCustomerByPhoneNo(int phoneNo) {
		return customerDAO.findCustomerByPhoneNo(phoneNo);
	}

}
