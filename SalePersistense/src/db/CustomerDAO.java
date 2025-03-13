package db;

import model.Customer;

public interface CustomerDAO {

	Customer findCustomerByPhoneNo(int phoneNo);

}
