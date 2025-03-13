package model;

public class Product {

	private double purchasePrice; 
	private double salesPrice;
	private double rentPrice;
	private String countryOfOrigin;
	private int minStock;
	private int amount;
	private int reservedAmount;
	private int productNo;	
	private String name; 
	private String productType;
	
	public Product(String name, double purchasePrice, double salesPrice ,double rentPrice, String countryOfOrigin, int minStock, int productNo, String productType) {
		super();
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.rentPrice = rentPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
		this.amount = 0;
		this.reservedAmount = 0;
		this.productNo = 0;
		this.productType = productType;
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
	public double getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	@Override
	public String toString() {
		return "Product [purchasePrice=" + purchasePrice + ", salesPrice=" + salesPrice + ", rentPrice=" + rentPrice
				+ ", countryOfOrigin=" + countryOfOrigin + ", minStock=" + minStock + ", amount=" + amount
				+ ", reservedAmount=" + reservedAmount + ", productNo=" + productNo + ", name=" + name
				+ ", productType=" + productType + "]";
	}
	
	
}
