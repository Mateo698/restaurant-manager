package model;

import java.util.ArrayList;
import java.util.List;

public class Order {	
	private int code;
	private String status;
	private String footNote;
	private List<Product> products;
	
	public Order(int code, String status, String footNote) {
		this.code = code;
		this.status = status;
		this.footNote = footNote;
		products = new ArrayList<Product>();
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFootNote() {
		return footNote;
	}

	public void setFootNote(String footNote) {
		this.footNote = footNote;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		products.add(product);
		
	}
	
	public void updateInfo(int code, String status, String footNote) {
		setCode(code);
		setStatus(status);
		setFootNote(footNote);
		
	}
	
}
