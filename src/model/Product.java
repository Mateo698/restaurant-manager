package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private String name;
	private String size;
	private int price;
	private int amountOrdered;
	private List<Ingredient> ingredients;
	private Type type;
	
	public Product(String name, String size, int price, int amountOrdered, Type type) {
		this.name = name;
		this.size = size;
		this.price = price;
		this.amountOrdered = amountOrdered;
		this.type=type;
		
		ingredients = new ArrayList<Ingredient>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmountOrdered() {
		return amountOrdered;
	}

	public void setAmountOrdered(int amountOrdered) {
		this.amountOrdered = amountOrdered;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	
}
