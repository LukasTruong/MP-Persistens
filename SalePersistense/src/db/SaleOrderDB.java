package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.OrderLine;
import model.Product;
import model.SaleOrder;
//INSERT INTO saleOrder (saleOrderNo, deliveryStatus, fk_customerId, fk_invoiceId) VALUES(?, ?, ?, ?),
public class SaleOrderDB implements SaleOrderDAO {
	
	private static final String CONFIRM_ORDER_Q = 
			"INSERT INTO saleOrder (saleOrderNo, deliveryStatus, "
			+ "fk_customerId, fk_invoiceId) VALUES(?, ?, ?, ?)";
	private static final String ADD_ORDERLINE_Q = "INSERT INTO orderLine (quantity,"
			+ " salesPrice, fk_saleOrderId, fk_saleId, fk_productId)"
			+ " VALUES (?, ?, ?, ?, ?)";
	 private static final String GET_CUSTOMER_ID_Q = 
		        "SELECT id FROM customer WHERE phoneNo = ?";
	private PreparedStatement confirmOrderPS, addOrderLinePS, getCustomerIdPS;
	
	public SaleOrderDB() throws DataAccessException {
        try {
            confirmOrderPS = DBConnection.getInstance().getConnection().prepareStatement(CONFIRM_ORDER_Q, Statement.RETURN_GENERATED_KEYS);
            addOrderLinePS = DBConnection.getInstance().getConnection().prepareStatement(ADD_ORDERLINE_Q);
            getCustomerIdPS = DBConnection.getInstance().getConnection().prepareStatement(GET_CUSTOMER_ID_Q);
        } catch (SQLException e) {
            throw new DataAccessException(e, "Could not prepare statement");
        }
    }
	

	@Override
	public SaleOrder confirmOrder(SaleOrder saleOrder)throws DataAccessException {
		try {
		getCustomerIdPS.setInt(1, saleOrder.getCustomer().getPhone());
        ResultSet rsCustomer = getCustomerIdPS.executeQuery();
        int fk_customerId = -1;
        if (rsCustomer.next()) {
            fk_customerId = rsCustomer.getInt("id");
        }else {
			throw new DataAccessException(null, "Could not prepare statement");
		}
		confirmOrderPS.setInt(1, saleOrder.getSaleOrderNo());
        confirmOrderPS.setString(2, saleOrder.getDeliveryStatus());
        confirmOrderPS.setInt(3, fk_customerId);
        confirmOrderPS.setNull(4, java.sql.Types.INTEGER);
        confirmOrderPS.executeUpdate();
        
        ResultSet rsOrder = confirmOrderPS.getGeneratedKeys();
        int fk_saleOrderId = -1;
        if (rsOrder.next()) {
            fk_saleOrderId = rsOrder.getInt(1);
        } else {
            throw new DataAccessException(null, "Failed to retrieve generated saleOrderId.");
        }
        for (OrderLine orderLine : saleOrder.getOrderline()) {
            addOrderLinePS.setInt(1, orderLine.getQuantity());
            addOrderLinePS.setDouble(2, orderLine.getSalePrice());
            addOrderLinePS.setInt(3, fk_saleOrderId);
            addOrderLinePS.setInt(4, orderLine.getProduct().getProductNo()); 
            addOrderLinePS.executeUpdate();
        }

        return saleOrder;
        
		}catch (SQLException e) {
        throw new DataAccessException(e, "Could not confirm sale order");
		}
	}
}
