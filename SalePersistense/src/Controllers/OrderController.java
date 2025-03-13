package Controllers;

import db.DataAccessException;
import db.SaleOrderDAO;
import db.SaleOrderDB;
import model.SaleOrder;
import model.Customer;
import model.OrderLine;
import model.Product;

public class OrderController {
	private ProductController productCtrl;
	private CustomerController customerCtrl;
	private SaleOrderDAO saleOrderDAO;
	private SaleOrder saleOrder;
	
	
	public OrderController() throws DataAccessException {
		this.productCtrl = new ProductController();
		this.customerCtrl = new CustomerController();
		this.saleOrderDAO = new SaleOrderDB();
	}
	
	public SaleOrder createSaleOrder() {
		saleOrder = new SaleOrder();
		return saleOrder;
	}
	
	public Customer addCustomer(int phoneNo) throws DataAccessException {
		Customer currCustomer = customerCtrl.findCustomerByPhoneNo(phoneNo);
		saleOrder.setCustomer(currCustomer);
		return customerCtrl.findCustomerByPhoneNo(phoneNo);
	}
	
	public Product addProductToOrderLine(int productNo, int quantity) throws DataAccessException {
		Product currProduct = productCtrl.findProductByProductNo(productNo);
		saleOrder.addOrderToOrderLine(currProduct, quantity);
		return currProduct;
	}
	
	
	public SaleOrder confirmOrder() throws DataAccessException {
		if(saleOrder.getCustomer() != null && saleOrder.getOrderline() != null) {
			saleOrderDAO.confirmOrder();
		}
		return saleOrder;
	}
	
}
