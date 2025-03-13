package Controllers;

public class TryMe {
private static ProductController pCtrl = new ProductController();


public static void main(String[] args) {
	System.out.println(pCtrl.findProductByProductNo(7001));
}


}
