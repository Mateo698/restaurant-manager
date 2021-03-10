package model;

public class Employee {
	private String names;
	private String lastNames;
	private int id;
	private int amountOrder;
	
	public Employee(String names, String lastNames, int id, int amountOrder) {
		this.names = names;
		this.lastNames = lastNames;
		this.id = id;
		this.amountOrder = amountOrder;
	}

	public void updateInfo(String n, String ln, int id, int ao) {
		setNames(n);
		setLastNames(ln);
		setId(id);
		setAmountOrder(ao);
	}
	
	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastNames() {
		return lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmountOrder() {
		return amountOrder;
	}

	public void setAmountOrder(int amountOrder) {
		this.amountOrder = amountOrder;
	}
	
	public void updateInfoUser(String username, String password, String names, String lastNames, int ID, int amountOrder) {
		
	}
}
