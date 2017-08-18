package mqshop.beans;

public class ORDER_DETAILS {
	public int orderID;
	public int productID;
	public int quantity;
	public double price;
	
	public ORDER_DETAILS() {
	}
	
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getProductID() {
		return productID;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
}
