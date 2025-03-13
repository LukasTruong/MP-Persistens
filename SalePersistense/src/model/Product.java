package model;

public class Product {

	private double purchasePrice; 
	private double rentPrice;
	private String countryOfOrigin;
	private int minStock;
	private int amount;
	private int reservedAmount;
	private int productNo;	
	private String name; 
	
	
	public Product(double purchasePrice, double rentPrice, String countryOfOrigin, int minStock, String name) {
		super();
		this.purchasePrice = purchasePrice;
		this.rentPrice = rentPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	public int getMinStock() {
		return minStock;
	}
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getReservedAmount() {
		return reservedAmount;
	}
	public void setReservedAmount(int reservedAmount) {
		this.reservedAmount = reservedAmount;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	
}
