package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable{
	
	private static final long serialVersionUID = 1;
	private BaseProduct baseProduct;
	private Size productSize;
	private int amountOrdered;
	private ArrayList<DateClass> datesOrdered;
	private String name;
	private double productPrice;
	
	public Product(BaseProduct baseProduct, Size productSize, double productPrice) {
		this.setBaseProduct(baseProduct);
		this.setProductSize(productSize);
		this.amountOrdered =0;
		this.setPrice(productPrice);
		setName(baseProduct.getName() +"  "+ productSize.getName());
		@SuppressWarnings("unused")
		ArrayList<DateClass> datesOrdered = new ArrayList<DateClass>();
	}
	
	public String getBaseProductName() {
		return baseProduct.getName()
;	}
	
	public String getSizeName() {
		return productSize.getName();
	}

	public double getPrice() {
		return productPrice;
	}

	public void setPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public int getAmountOrdered() {
		return amountOrdered;
	}

	public void setAmountOrdered(int amountOrdered) {
		this.amountOrdered = amountOrdered;
	}

	public void plusOrdered(DateClass newDate) {
		datesOrdered.add(newDate);
		amountOrdered = datesOrdered.size();
	}
	
	public void setProductsDate(ArrayList<DateClass> x) {
		datesOrdered = x;
		amountOrdered = x.size();
	}

	public ArrayList<DateClass> getDates(){
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
	
	public String getBaseProductStr() {
		String strProduct = baseProduct.getName();
		return strProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
