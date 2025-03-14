package Controllers;

import db.DataAccessException;

public class TryMe {
private static ProductController pCtrl; 
private static CustomerController cCtrl;
private static OrderController oCtrl;

public static void main(String[] args) throws DataAccessException {
	try {
        pCtrl = new ProductController();
        cCtrl = new CustomerController();
        oCtrl = new OrderController();
        System.out.println(pCtrl.findProductByProductNo(7001));
        System.out.println(cCtrl.findCustomerByPhoneNo(12345678));
        
        
        oCtrl.createSaleOrder();
        oCtrl.addCustomer(12345678);
        oCtrl.addProductToOrderLine(7001, 2);
        oCtrl.confirmOrder();
        
    } catch (DataAccessException e) {
        System.err.println("Error initializing ProductController: " + e.getMessage());
        e.printStackTrace();
    }
}
}
