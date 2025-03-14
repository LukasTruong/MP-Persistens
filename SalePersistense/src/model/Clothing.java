package model;

public class Clothing extends Product{
	private String size;
	private String colour;
	public Clothing(String name, double purchasePrice, double salesPrice ,double rentPrice, String countryOfOrigin, int minStock, int amount, int reservedAmount, int productNo, String productType, String size, String colour) {
		super(name, purchasePrice, salesPrice ,rentPrice, countryOfOrigin, minStock, amount, reservedAmount, productNo, productType);
		this.size = size;
		this.colour = colour;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Clothing [size=" + size + ", colour=" + colour + " , " + super.toString() + "]";
	}
	
	
	
	
	
}
