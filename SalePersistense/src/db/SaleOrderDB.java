package db;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;
import model.SaleOrder;

public class SaleOrderDB implements SaleOrderDAO {

	@Override
	public void confirmOrder() {
		// TODO Auto-generated method stub
		
	}
	
	private SaleOrder buildObject(ResultSet rs) throws SQLException{
		SaleOrder so = new SaleOrder();
		return so;
	}

}
