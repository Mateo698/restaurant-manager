package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseProduct implements Serializable{
	private static final long serialVersionUID = 1;
	private String name;
	private List<Ingredient> ingredients;
	private Type type;
	
	public BaseProduct(String name, ArrayList<Ingredient> ingList, Type type) {
		this.name = name;
		this.type=type;
		
		this.ingredients = ingList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public String getIngredientString() {
		String x = "";
		for(int i=0;i<ingredients.size();i++) {
			if(i==ingredients.size()-1) {
				x += ingredients.get(i).getName();
			}
			else {
				x += ingredients.get(i).getName() + ", ";
			}
		}
		return x;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Type getType() {
		return type;
	}
	
	public String getTypeString() {
		return type.getName();
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	
}
