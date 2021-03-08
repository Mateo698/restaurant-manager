package model;

import java.util.ArrayList;

public class Restaurant {
	private ArrayList<Employee> employees;
	private ArrayList<User> users;
	private ArrayList<Client> clients;
	
	public Restaurant() {
		setEmployees(new ArrayList<Employee>());
		setUsers(new ArrayList<User>());
		setClients(new ArrayList<Client>());
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
	
	
	
}
