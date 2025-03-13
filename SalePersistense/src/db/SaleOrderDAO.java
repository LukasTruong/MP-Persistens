package db;

import model.SaleOrder;

public interface SaleOrderDAO {

	public SaleOrder confirmOrder(SaleOrder saleOrder) throws DataAccessException;

}
