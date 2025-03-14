package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Club;
import model.Customer;
import model.Private;

public class CustomerDB implements CustomerDAO {
	private static final String FIND_ALL_Q = "select c.name, c.phoneNo, c.email, c.clubNo, c.customerNo,"
			+ "		a.street, a.no, a.floor,"
			+ "		z.city, z.zipCode,"
			+ "		co.country"
			+ "		from customer c"
			+ "		join address a on c.fk_addressId = a.addressId"
			+ "		join zipCity z on a.fk_zip = z.zipCode"
			+ "		join country co on z.fk_countryCode = co.countryCode";
	private static final String FIND_BY_PHONENO_Q =
			FIND_ALL_Q + " where phoneNo = ?" ;
	
	private PreparedStatement findByPhoneNoPS;
	
	public CustomerDB() throws DataAccessException{
		try {
			findByPhoneNoPS = DBConnection.getInstance().getConnection()
					.prepareStatement(FIND_BY_PHONENO_Q);
			} catch (SQLException e) {
				throw new DataAccessException(e, "Could not prepare statement");
			}

		}
	
	@Override
	public Customer findCustomerByPhoneNo(int phoneNo)  throws DataAccessException{
		try {
			findByPhoneNoPS.setInt(1, phoneNo);
			ResultSet rs = findByPhoneNoPS.executeQuery();
			Customer c = null;
			if(rs.next()) {
				c = buildObject(rs);
			}
			return c;
		}catch(SQLException e) {
			throw new DataAccessException(e, "Could not find customer by phone No = " + phoneNo);
		}
		
	}
	private Customer buildObject(ResultSet rs) throws SQLException{
		Customer c = new Customer(
				rs.getString("name"),
				rs.getString("street"),
				rs.getInt("no"),
				rs.getString("floor"),
				rs.getString("zipCode"),
				rs.getString("city"),
				rs.getString("country"),
				rs.getString("email"),
				rs.getInt("phoneNo")
				);
		
		
		if (rs.getObject("clubNo") != null) {
			c = new Club(
					rs.getInt("clubNo"),
					rs.getString("name"),
					rs.getString("street"),
					rs.getInt("no"),
					rs.getString("floor"),
					rs.getString("zipCode"),
					rs.getString("city"),
					rs.getString("country"),
					rs.getString("email"),
					rs.getInt("phoneNo")
					);
		} else if(rs.getObject("customerNo") != null) {
			c = new Private(
					rs.getInt("customerNo"),
					rs.getString("name"),
					rs.getString("street"),
					rs.getInt("no"),
					rs.getString("floor"),
					rs.getString("zipCode"),
					rs.getString("city"),
					rs.getString("country"),
					rs.getString("email"),
					rs.getInt("phoneNo")
					);
		}
		
		return c;
	}

}
