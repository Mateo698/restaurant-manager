package model;

import java.util.ArrayList;

public class Restaurant {
	private ArrayList<Employee> employees;
	private ArrayList<User> users;
	private ArrayList<Client> clients;
	private ArrayList<Order> orders;
	
	public Restaurant() {
		setEmployees(new ArrayList<Employee>());
		setUsers(new ArrayList<User>());
		setClients(new ArrayList<Client>());
		setOrders(new ArrayList<Order>());
		
	}
	
	

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
		
	}
	
	public void addEmployee(String names, String lastNames, int ID, int amountOrder) {
		employees.add(new Employee(names,lastNames,ID,amountOrder));
		
	}
	
	public void deleteEmployee(int index) {
		employees.remove(index);
		
	}
	
	public void updateEmployee(int index,String name,String lastNames, int ID, int amountOrder) {
		employees.get(index).updateInfo(name,lastNames,ID,amountOrder);
		
	}
	
	public void addUser(String username, String password, String names, String lastNames, int ID, int amountOrder) {
		users.add(new User(username, password, names, lastNames, ID, amountOrder));
		
	}
	
	public void deleteUser(int index) {
		users.remove(index);
		
	}
	
	public void updateUser(int index, String username, String password, String names, String lastNames, int ID, int amountOrder) {
		users.get(index).updateInfoUser(username,password,names, lastNames, ID, amountOrder);
		
	}
	
	public void addClient(String name, String lastName, int date, String addres, int phoneNumber, String footNotes, User originUser, User lastModifiedUser) {
		clients.add(new Client(name,lastName,date,addres,phoneNumber,footNotes,originUser,lastModifiedUser));
		
	}
	
	public void deleteClient(int index) {
		clients.remove(index);
		
	}
	
	public void updateClient(int index, String name, String lastName, int date, String addres, int phoneNumber, String footNotes, User originUser, User lastModifiedUser) {
		clients.get(index).updateInfo(name, lastName, date, addres, phoneNumber, footNotes, originUser, lastModifiedUser);
		
	}
	
	public void addOrder(int code, String status, String footNote) {
		orders.add(new Order(code,status,footNote));
		
	}
	
	public void deleteOrder(int index) {
		orders.remove(index);
		
	}
	
	public void updateOrder(int index, int code, String status, String footNote) {
		orders.get(index).updateInfo(code, status, footNote);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
