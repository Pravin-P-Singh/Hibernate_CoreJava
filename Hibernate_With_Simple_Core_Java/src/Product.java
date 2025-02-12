import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	//fields
	@Id
	private int productId;
	private String productName;
	private int productQuantity;
	private double productPrice;
	private String productManufacturingDate;
	private String productExpiryDate;
	
	public Product(){
		super();
	}

	public Product(int productId, String productName, int productQuantity, double productPrice, String productManufacturingDate, String productExpiryDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.productManufacturingDate = productManufacturingDate;
		this.productExpiryDate = productExpiryDate;
	}

	//getters and setters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductManufacturingDate() {
		return productManufacturingDate;
	}

	public void setProductManufacturingDate(String productManufacturingDate) {
		this.productManufacturingDate = productManufacturingDate;
	}

	public String getProductExpiryDate() {
		return productExpiryDate;
	}

	public void setProductExpiryDate(String productExpiryDate) {
		this.productExpiryDate = productExpiryDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQuantity="
				+ productQuantity + ", productPrice=" + productPrice + ", productManufacturingDate="
				+ productManufacturingDate + ", productExpiryDate=" + productExpiryDate + "]";
	}
}
