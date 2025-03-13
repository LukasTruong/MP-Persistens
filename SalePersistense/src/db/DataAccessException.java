package db;

import java.sql.SQLException;

public class DataAccessException extends Exception {

	public DataAccessException(Exception e, String msg) {
		super(msg + " " + e.getMessage(), e);
	}

}
