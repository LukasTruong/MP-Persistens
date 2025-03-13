package db;

import model.SaleOrder;

public interface SaleOrderDAO {

	public SaleOrder confirmOrder() throws DataAccessException;

}
