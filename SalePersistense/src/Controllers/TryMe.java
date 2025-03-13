package Controllers;

import db.DataAccessException;

public class TryMe {
private static ProductController pCtrl; 

public static void main(String[] args) throws DataAccessException {
	try {
        pCtrl = new ProductController();
        System.out.println(pCtrl.findProductByProductNo(7001));
    } catch (DataAccessException e) {
        System.err.println("Error initializing ProductController: " + e.getMessage());
        e.printStackTrace();
    }
}
}
