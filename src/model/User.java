package model;

public class User extends Employee {
	private static final long serialVersionUID = 1;
	private String username;
	private String password;
	
	public User(String username, String password, String names, String lastNames, String id) {
		super(names, lastNames, id);
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
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
	
	@Override
	public void updateInfoUser(String username, String password, String names, String lastNames, String ID, int amountOrder) {
		super.updateInfo(names, lastNames, ID);
		setName(username);
		setPassword(password);
		
	}
}
