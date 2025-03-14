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
	 private static final String FIND_BY_PRODUCTNO_Q =
		        "SELECT id FROM product WHERE productNo = ?";
	 private static final String FIND_MAX_SALEORDERNO_Q =
		        "SELECT MAX(saleOrderNo) AS maxSaleOrderNo FROM saleOrder";
	private PreparedStatement confirmOrderPS, addOrderLinePS, getCustomerIdPS, findByProductNoPS, findMaxSaleOrderNoPS;
	
	public SaleOrderDB() throws DataAccessException {
        try {
            confirmOrderPS = DBConnection.getInstance().getConnection().prepareStatement(CONFIRM_ORDER_Q, Statement.RETURN_GENERATED_KEYS);
            addOrderLinePS = DBConnection.getInstance().getConnection().prepareStatement(ADD_ORDERLINE_Q);
            getCustomerIdPS = DBConnection.getInstance().getConnection().prepareStatement(GET_CUSTOMER_ID_Q);
            findByProductNoPS = DBConnection.getInstance().getConnection().prepareStatement(FIND_BY_PRODUCTNO_Q);
            findMaxSaleOrderNoPS = DBConnection.getInstance().getConnection().prepareStatement(FIND_MAX_SALEORDERNO_Q);
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
        	Product product = orderLine.getProduct();
        	
        	int fk_productId = getProductIdByProductNo(product.getProductNo());
        	
        	if (fk_productId == -1) {
                throw new DataAccessException(null, "Product not found.");
            }
            addOrderLinePS.setInt(1, orderLine.getQuantity());
            addOrderLinePS.setDouble(2, orderLine.getSalePrice());
            addOrderLinePS.setInt(3, fk_saleOrderId);
            addOrderLinePS.setNull(4, java.sql.Types.INTEGER);
            addOrderLinePS.setInt(5, fk_productId); 
            addOrderLinePS.executeUpdate();
        }

        return saleOrder;
        
		}catch (SQLException e) {
        throw new DataAccessException(e, "Could not confirm sale order");
		}
	}


	private int getProductIdByProductNo(int productNo)throws SQLException, DataAccessException {
		int productId = -1; 
        try {
            findByProductNoPS.setInt(1, productNo);  
            ResultSet rs = findByProductNoPS.executeQuery();
            if (rs.next()) {
                productId = rs.getInt("id");
            }
        } catch (SQLException e) {
            throw new DataAccessException(e, "Could not retrieve product id by productNo");
        }
        return productId;
	}


	@Override
	public int getMaxSaleOrderNo() throws DataAccessException {
		int maxSaleOrderNo = 0; 
        try {
            ResultSet rs = findMaxSaleOrderNoPS.executeQuery();
            if (rs.next()) {
                maxSaleOrderNo = rs.getInt("maxSaleOrderNo");
            }
        } catch (SQLException e) {
            throw new DataAccessException(e, "Could not retrieve max sale order number");
        }
        return maxSaleOrderNo;  
    }
}

