package Controllers;

import db.SaleOrderDAO;
import db.SaleOrderDB;
import model.SaleOrder;

public class OrderController {
	private ProductController productCtrl;
	private CustomerController customerCtrl;
	private SaleOrderDAO saleOrderDAO;
	private SaleOrder saleOrder;
	
	
	public OrderController() {
		this.productCtrl = new ProductController();
		this.customerCtrl = new CustomerController();
		this.saleOrderDAO = new SaleOrderDB();
	}
	
	public SaleOrder createSaleOrder() {
		saleOrder = new SaleOrder();
		return saleOrder;
	}
	
	public Customer addCustomer(int phoneNo) {
		Customer currCustomer = customerCtrl.findCustomerByPhoneNo(phoneNo);
		return currCustomer;
	}
	

}
