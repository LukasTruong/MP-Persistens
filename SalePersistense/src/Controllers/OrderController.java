package Controllers;

import db.SaleOrderDAO;
import db.SaleOrderDB;
import model.SaleOrder;
import model.Customer;
import model.Product;

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
		return customerCtrl.findCustomerByPhoneNo(phoneNo);
	}
	
	public Product addProduct(int productNo) {
		return productCtrl.findProductByProductNo(productNo);
	}
	
	public SaleOrder confirmOrder() {
		if(saleOrder.getCustomer() != null && saleOrder.getOrderline() != null) {
			saleOrder.confirmOrder();
			return saleOrder;
		}
	}
	
}
