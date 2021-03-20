package model;

import java.util.ArrayList;

public class Product {
	private BaseProduct baseProduct;
	private Size productSize;
	private int amountOrdered;
	private ArrayList<Date> datesOrdered;
	private String name;
	private double productPrice;
	
	public Product(BaseProduct baseProduct, Size productSize, double productPrice) {
		this.setBaseProduct(baseProduct);
		this.setProductSize(productSize);
		this.amountOrdered =0;
		this.setProductPrice(productPrice);
		setName(baseProduct.getName() +"  "+ productSize.getName());
		ArrayList<Date> datesOrdered = new ArrayList<Date>();
	}
	
	public String getBaseProductName() {
		return baseProduct.getName()
;	}
	
	public String getSizeName() {
		return productSize.getName();
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public int getAmountOrdered() {
		return amountOrdered;
	}

	public void setAmountOrdered(int amountOrdered) {
		this.amountOrdered = amountOrdered;
	}

	public void plusOrdered(Date newDate) {
		datesOrdered.add(newDate);
		amountOrdered = datesOrdered.size();
	}
	
	public void setProductsDate(ArrayList<Date> x) {
		datesOrdered = x;
		amountOrdered = x.size();
	}

	public ArrayList<Date> getDates(){
		return datesOrdered;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
