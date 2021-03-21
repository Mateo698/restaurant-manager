package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1;
	private String names;
	private String lastNames;
	private String id;
	private int amountOrder;
	private boolean status;
	private ArrayList<Order> deliveredOrders;
	
	public Employee(String names, String lastNames, String id) {
		this.names = names;
		this.lastNames = lastNames;
		this.id = id;
		this.amountOrder = 0;
		status = true;
		deliveredOrders = new ArrayList<Order>();
	}
	
	public void addOrder(Order newOrder) {
		deliveredOrders.add(newOrder);
		amountOrder = deliveredOrders.size();
	}
	
	public ArrayList<Order> getDeliveredOrder() {
		return deliveredOrders;
	}
	
	public int getAmountDeliveredOrders() {
		return deliveredOrders.size();
	}
	
	public void setDeliveredOrder(ArrayList<Order> x) {
		deliveredOrders = x;
		amountOrder = x.size();
	}

	public void updateInfo(String n, String ln, String id) {
		setNames(n);
		setLastNames(ln);
		setId(id);
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
