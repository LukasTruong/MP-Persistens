package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Clothing;
import model.Equipment;
import model.GunReplica;
import model.Product;


public class ProductDB implements ProductDAO{
	private static final String FIND_ALL_Q =
		    "SELECT p.name, p.purchasePrice, p.salesPrice, p.rentPrice, p.countryOfOrigin, p.minStock, p.amount, p.reservedAmount, p.productNo, "
		    + "       p.productType, c.size, c.colour, e.type, e.description, g.calibre, g.material "
		    + "FROM product p "
		    + "LEFT JOIN clothing c ON p.id = c.fk_productId "
		    + "LEFT JOIN equipment e ON p.id = e.fk_productId "
		    + "LEFT JOIN gunReplica g ON p.id = g.fk_productId ";
	private static final String FIND_BY_PRODUCTNO_Q =
			FIND_ALL_Q + "where productNo = ?";
	private PreparedStatement findAllPS, findByProductNoPS;
	
	public ProductDB() throws DataAccessException{
		try {
		findByProductNoPS = DBConnection.getInstance().getConnection()
				.prepareStatement(FIND_BY_PRODUCTNO_Q);
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement");
		}
	}
			

	@Override
	public Product findProductByProductNo(int productNo) throws DataAccessException {
		try {
			findByProductNoPS.setInt(1, productNo);
			ResultSet rs = findByProductNoPS.executeQuery();
			Product p = null;
			if(rs.next()) {
				p = buildObject(rs);
			}
			return p;
		} catch(SQLException e) {
			throw new DataAccessException(e, "Could not find Product by ProductNo = " + productNo);
		}
		//Statement.RETURN_GENERATED_KEYS;
	}
	
	private Product buildObject(ResultSet rs) throws SQLException{
		Product p = new Product(
				rs.getString("name"),
				rs.getDouble("purchasePrice"),
				rs.getDouble("salesPrice"),
				rs.getDouble("rentPrice"),
				rs.getString("countryOfOrigin"),
				rs.getInt("minStock"),
				rs.getInt("amount"),
				rs.getInt("reservedAmount"),
				rs.getInt("productNo"),
				rs.getString("productType")
				);
		
		if(rs.getObject("productType").equals("Equipment")) {
			p = new Equipment(
					rs.getString("name"),
					rs.getDouble("purchasePrice"),
					rs.getDouble("salesPrice"),
					rs.getDouble("rentPrice"),
					rs.getString("countryOfOrigin"),
					rs.getInt("minStock"),
					rs.getInt("amount"),
					rs.getInt("reservedAmount"),
					rs.getInt("productNo"),
					rs.getString("productType"),
					rs.getString("type"),
					rs.getString("description")
					);
		}else if(rs.getObject("productType") != null && rs.getObject("productType").equals("Clothing")) {
			p = new Clothing(
					rs.getString("name"),
					rs.getDouble("purchasePrice"),
					rs.getDouble("salesPrice"),
					rs.getDouble("rentPrice"),
					rs.getString("countryOfOrigin"),
					rs.getInt("minStock"),
					rs.getInt("amount"),
					rs.getInt("reservedAmount"),
					rs.getInt("productNo"),
					rs.getString("productType"),
					rs.getString("size"),
					rs.getString("colour")
					);
		}else if(rs.getObject("productType").equals("Gun Replica")) {
			p = new GunReplica(
					rs.getString("name"),
					rs.getDouble("purchasePrice"),
					rs.getDouble("salesPrice"),
					rs.getDouble("rentPrice"),
					rs.getString("countryOfOrigin"),
					rs.getInt("minStock"),
					rs.getInt("amount"),
					rs.getInt("reservedAmount"),
					rs.getInt("productNo"),
					rs.getString("productType"),
					rs.getString("calibre"),
					rs.getString("material")
					);
		}
		return p;
	}

}
