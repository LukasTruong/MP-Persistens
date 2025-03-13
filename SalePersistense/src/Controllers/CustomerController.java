package Controllers;

import db.CustomerDAO;
import db.CustomerDB;
import db.DataAccessException;
import model.Customer;

public class CustomerController {
	private CustomerDAO customerDAO;
	private CustomerDB customerDB;
	
	public CustomerController()throws DataAccessException {
		this.customerDAO = new CustomerDB();
	}

	public Customer findCustomerByPhoneNo(int phoneNo)throws DataAccessException {
		return customerDAO.findCustomerByPhoneNo(phoneNo);
	}

}
