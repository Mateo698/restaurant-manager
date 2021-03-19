package model;

import java.io.Serializable;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1;
	private String names;
	private String lastNames;
	private String id;
	private int amountOrder;
	private boolean status;
	
	public Employee(String names, String lastNames, String id, int amountOrder) {
		this.names = names;
		this.lastNames = lastNames;
		this.id = id;
		this.amountOrder = amountOrder;
		status = true;
	}

	public void updateInfo(String n, String ln, String id, int ao) {
		setNames(n);
		setLastNames(ln);
		setId(id);
		setAmountOrder(ao);
	}
	
	public void setStatus(boolean newStatus) {
		status = newStatus;
	}
	
	public boolean getStatus() {
		return status;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAmountOrder() {
		return amountOrder;
	}

	public void setAmountOrder(int amountOrder) {
		this.amountOrder = amountOrder;
	}
	
	public void updateInfoUser(String username, String password, String names, String lastNames, String ID, int amountOrder) {
		
	}
}
