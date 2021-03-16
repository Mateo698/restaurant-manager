package model;

import java.io.Serializable;

public class Ingredient implements Serializable{
	private static final long serialVersionUID = 1;
	private String name;

	public Ingredient(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
