package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SaleOrder {
	private LocalDate date;
	private String deliveryStatus;
	private String deliveryDate;
	private int saleOrderNo;
	private Customer customer;
	private List<OrderLine> orderLines;

	
public SaleOrder() {
		super();
		deliveryStatus = "Pending";
		deliveryDate = "00-00-0000";
		saleOrderNo = 0;
		this.customer = null;
		date = LocalDate.now();
		orderLines = new ArrayList<>();
	}

public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public String getDeliveryStatus() {
	return deliveryStatus;
}
public void setDeliveryStatus(String deliveryStatus) {
	this.deliveryStatus = deliveryStatus;
}
public String getDeliveryDate() {
	return deliveryDate;
}
public void setDeliveryDate(String deliveryDate) {
	this.deliveryDate = deliveryDate;
}
public int getSaleOrderNo() {
	return saleOrderNo;
}
public void setSaleOrderNo(int saleOrderNo) {
	this.saleOrderNo = saleOrderNo;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public List<OrderLine> getOrderline() {
	return orderLines;
}
public void setOrderline(OrderLine orderline) {
	this.orderLines.add(orderline);
}

public void addOrderToOrderLine(Product currProduct, int quantity) {
	OrderLine newOrderLine = new OrderLine(quantity);
	newOrderLine.setProduct(currProduct);
	this.setOrderline(newOrderLine);
}
}
