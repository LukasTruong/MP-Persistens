package model;

public class Clothing extends Product{
	private int size;
	private String colour;
	public Clothing(String name, double purchasePrice, double salesPrice ,double rentPrice, String countryOfOrigin, int minStock, int productNo, String productType, int size, String colour) {
		super(name, purchasePrice, salesPrice ,rentPrice, countryOfOrigin, minStock, productNo, productType);
		this.size = size;
		this.colour = colour;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
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
