package model;

import java.io.Serializable;

public class Type implements Comparable<Type>,Serializable{
	private static final long serialVersionUID = 1;
	private String name;


	public Type(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void replaceType(Type o) {
		setName(o.getName());
		
	}
	
	@Override
	public int compareTo(Type o) {
		return name.compareTo(o.getName());
	}	
}
