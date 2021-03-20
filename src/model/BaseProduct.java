package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseProduct implements Serializable{
	private static final long serialVersionUID = 1;
	private String name;

	private int price;
	private int amountOrdered;
	private List<Ingredient> ingredients;
	private Type type;
	
	public BaseProduct(String name, int price, ArrayList<Ingredient> ingList, Type type) {
		this.name = name;
		this.price = price;
		this.amountOrdered =0;
		this.type=type;
		
		this.ingredients = ingList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
