package model;

import java.time.LocalDate;

public class SaleOrder {
	private LocalDate date;
	private String deliveryStatus;
	private String deliveryDate;
	private int saleOrderNo;
	private Customer customer;
	private OrderLine orderline;

	
public SaleOrder(String deliveryStatus, String deliveryDate, int saleOrderNo, Customer customer,
			OrderLine orderline, LocalDate date) {
		super();
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.saleOrderNo = saleOrderNo;
		this.customer = customer;
		this.orderline = orderline;
		this.date = date;
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
public OrderLine getOrderline() {
	return orderline;
}
public void setOrderline(OrderLine orderline) {
	this.orderline = orderline;
}
}
