package model;

import java.io.Serializable;

public class Quantity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private int quantity;
	
	public Quantity(int q) {
		setQuantity(q);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
