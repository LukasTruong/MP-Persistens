package model;

public class GunReplica extends Product{
private String calibre;
private String material;

public GunReplica(String name, double purchasePrice, double salesPrice ,double rentPrice, String countryOfOrigin, int minStock, int productNo, String productType, String calibre, String material) {
	super(name, purchasePrice, salesPrice ,rentPrice, countryOfOrigin, minStock, productNo, productType);
	this.calibre = calibre;
	this.material = material;
}

public String getCalibre() {
	return calibre;
}

public void setCalibre(String calibre) {
	this.calibre = calibre;
}

public String getMaterial() {
	return material;
}

public void setMaterial(String material) {
	this.material = material;
}


}
