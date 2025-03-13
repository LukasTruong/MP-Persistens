package model;

public class OrderLine {
		private int quantity; // Quantity of the product in the order
		private Product product; // The product associated with this order line
		private double salePrice;

		/**
		 * Constructs an OrderLine object with the specified quantity.
		 * 
		 * @param quantity The quantity of the product. Must be greater than 0.
		 */
		public OrderLine(int quantity) {
			this.quantity = quantity;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}
		public double getSalePrice() {
			return salePrice;
		}
		
		public void setSalePrice(double salePrice) {
			this.salePrice = salePrice;
		}
	}
