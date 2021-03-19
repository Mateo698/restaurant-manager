package model;

import java.io.Serializable;

public class Size implements Serializable{

	private static final long serialVersionUID = 1;
	String name;
	
	public Size(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
