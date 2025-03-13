package db;

import model.Product;

public interface ProductDAO {

	Product findProductByProductNo(int productNo)throws DataAccessException;

}
