package Controllers;

import db.DataAccessException;
import db.ProductDAO;
import db.ProductDB;
import model.Product;

public class ProductController {
private ProductDAO productDAO;
private ProductDB productDB;

public ProductController() throws DataAccessException {
	this.productDAO = new ProductDB();
}

public Product findProductByProductNo(int productNo)throws DataAccessException {
	return productDAO.findProductByProductNo(productNo);
}

}
