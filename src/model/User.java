package model;

public class User extends Employee{
	private String username;
	private String password;
	
	public User(String username, String password, String names, String lastNames, int id, int amountOrder) {
		super(names, lastNames, id, amountOrder);
		this.username = username;
		this.password = password;
	}
	
	public String getName() {
		return username;
	}
	
	public void setName(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
