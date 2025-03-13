package model;

public class Clothing extends Product{
	private int size;
	private String colour;
	
	public Clothing(int size, String colour, double purchasePrice, double rentPrice, String countryOfOrigin, int minStock, String name) {
		super(purchasePrice, rentPrice, countryOfOrigin, minStock, name);
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
	
	
	
}
