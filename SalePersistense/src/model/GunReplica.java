package model;

public class GunReplica extends Product{
private String calibre;
private String material;

public GunReplica(String calibre, String material, double purchasePrice, double rentPrice, String countryOfOrigin, int minStock, String name) {
	super(purchasePrice, rentPrice, countryOfOrigin, minStock, name);
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
