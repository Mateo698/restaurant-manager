package model;

public class Product {
	private BaseProduct baseProduct;
	private Size productSize;
	private String name;
	private double productPrice;
	
	public Product(BaseProduct baseProduct, Size productSize, double productPrice) {
		this.setBaseProduct(baseProduct);
		this.setProductSize(productSize);
		this.setProductPrice(productPrice);
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Size getProductSize() {
		return productSize;
	}

	public void setProductSize(Size productSize) {
		this.productSize = productSize;
	}

	public BaseProduct getBaseProduct() {
		return baseProduct;
	}

	public void setBaseProduct(BaseProduct baseProduct) {
		this.baseProduct = baseProduct;
	}

	
	
}
