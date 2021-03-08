package beans;

public class Order {
	public String orderNo = "";
	public String productName = "";
	public float price = 0;
	public int quantity = 0;
	
	public Order(String orderNo, String productName, float price, int quantity) {
		this.orderNo = orderNo;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
