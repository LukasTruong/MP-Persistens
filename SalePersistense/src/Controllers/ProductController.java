package Controllers;

import db.ProductDAO;
import db.ProductDB;
import model.Product;

public class ProductController {
private ProductDAO productDAO;
private ProductDB productDB;

public ProductController() {
	this.productDAO = new ProductDB();
}

public Product findProductByProductNo(int productNo) {
	return productDAO.findProductByProductNo(productNo);
}

}
