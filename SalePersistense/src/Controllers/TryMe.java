package Controllers;

import db.DataAccessException;

public class TryMe {
private static ProductController pCtrl; 
private static CustomerController cCtrl;

public static void main(String[] args) throws DataAccessException {
	try {
        pCtrl = new ProductController();
        cCtrl = new CustomerController();
        System.out.println(pCtrl.findProductByProductNo(7001));
        System.out.println(cCtrl.findCustomerByPhoneNo(12345678));
    } catch (DataAccessException e) {
        System.err.println("Error initializing ProductController: " + e.getMessage());
        e.printStackTrace();
    }
}
}
