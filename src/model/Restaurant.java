package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Restaurant {
	private ArrayList<Employee> employees;
	private ArrayList<User> users;
	private ArrayList<Client> clients;
	private ArrayList<Order> orders;
	private ArrayList<Ingredient> ingredients;
	private ArrayList<BaseProduct> baseProducts;
<<<<<<< Updated upstream
=======
	private ArrayList<Product> products;
>>>>>>> Stashed changes
	private ArrayList<Type> types;
	private String EMP_NAME_FILE = "data/employeees.lol";
	private String USERS_NAME_FILE = "data/user.lol";
	private String CLIENTS_NAME_FILE = "data/clients.lol";
	private String ORDERS_NAME_FILE = "data/orders.lol";
	private String ING_NAME_FILE = "data/ingredients.lol";
	private String BPRO_NAME_FILE = "data/baseproducts.lol";
	private String TYPES_NAME_FILE = "data/types.lol";
	
	public Restaurant() {
		setEmployees(new ArrayList<Employee>());
		setUsers(new ArrayList<User>());
		setClients(new ArrayList<Client>());
		setOrders(new ArrayList<Order>());
		setIngredients(new ArrayList<Ingredient>());
		setBaseProducts(new ArrayList<BaseProduct>());
		setTypes(new ArrayList<Type>());
		setProducts(new ArrayList<Product>());
	}
	
//Updated upstream
	

	public ArrayList<BaseProduct> getBaseProducts() {
		return baseProducts;
	}



	public void setBaseProducts(ArrayList<BaseProduct> products) {
		this.baseProducts = products;
	}



	public ArrayList<Type> getTypes() {
		return types;
	}



	public void setTypes(ArrayList<Type> types) {
		this.types = types;
	}



	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}



	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
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
	
	public void addEmployee(String names, String lastNames, String ID, int amountOrder) {
		employees.add(new Employee(names,lastNames,ID,amountOrder));
		
	}
	
	public void deleteEmployee(int index) {
		employees.remove(index);
		
	}
	
	public void disableEmployee(int index) {
		employees.get(index).setStatus(false);
	}
	
	public void enableEmployee(int index) {
		employees.get(index).setStatus(true);
	}
	
	public void updateEmployee(int index,String name,String lastNames, String ID, int amountOrder) {
		employees.get(index).updateInfo(name,lastNames,ID,amountOrder);
		
	}
	
	public void addUser(String username, String password, String names, String lastNames, String ID, int amountOrder) {
		users.add(new User(username, password, names, lastNames, ID, amountOrder));
		
	}
	
	public void deleteUser(int index) {
		users.remove(index);
		
	}
	
	public void updateUser(int index, String username, String password, String names, String lastNames, String ID, int amountOrder) {
		users.get(index).updateInfoUser(username,password,names, lastNames, ID, amountOrder);
		
	}
	
	public void addClient(String name, String lastName, String id, String addres, String phoneNumber, String footNotes, User originUser, User lastModifiedUser) {
		boolean added = false;
		if(clients.size()==0) {
			clients.add(new Client(name,lastName,id,addres,phoneNumber,footNotes,originUser));
			added = true;
		}
		else {		
			Client c = new Client(name,lastName,id,addres,phoneNumber,footNotes,originUser);
			for(int i=0;i<clients.size() && !added;i++) {
				int compare = clients.get(i).compareTo(c);
				if(compare>0) {
					clients.add(i, c);
					added = true;
				}
			}
		}
		if(!added) {
			clients.add(new Client(name,lastName,id,addres,phoneNumber,footNotes,originUser));
		}
		
	}
	
	public void deleteClient(int index) {
		clients.remove(index);
		
	}
	
	public void updateClient(int index, String name, String lastName, String id, String addres, String phoneNumber, String footNotes, User originUser, User lastModifiedUser) {
		clients.get(index).updateInfo(name, lastName, id, addres, phoneNumber, footNotes, originUser, lastModifiedUser);
		
	}
	
	public void addOrder(int code, String status, String footNote) {
		orders.add(new Order(code,footNote));
		
	}
	
	public void deleteOrder(int index) {
		orders.remove(index);
		
	}
	
	public void updateOrder(int index, int code, String status, String footNote) {
		orders.get(index).updateInfo(code, status, footNote);
		
	}
	
	public void saveData() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(EMP_NAME_FILE));
	    oos.writeObject(employees);
	    oos.close();

	    oos = new ObjectOutputStream(new FileOutputStream(USERS_NAME_FILE));
	    oos.writeObject(users);
	    oos.close();

	    oos = new ObjectOutputStream(new FileOutputStream(CLIENTS_NAME_FILE));
	    oos.writeObject(clients);
	    oos.close();

	    oos = new ObjectOutputStream(new FileOutputStream(ORDERS_NAME_FILE));
	    oos.writeObject(orders);
	    oos.close();

	    oos = new ObjectOutputStream(new FileOutputStream(ING_NAME_FILE));
	    oos.writeObject(ingredients);
	    oos.close();

<<<<<<< Updated upstream
	    oos = new ObjectOutputStream(new FileOutputStream(PRO_NAME_FILE));
=======
	    oos = new ObjectOutputStream(new FileOutputStream(BPRO_NAME_FILE));
>>>>>>> Stashed changes
	    oos.writeObject(baseProducts);
	    oos.close();

	    oos = new ObjectOutputStream(new FileOutputStream(TYPES_NAME_FILE));
	    oos.writeObject(types);
	    oos.close();
	    
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
	public void loadData() throws FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File(EMP_NAME_FILE);
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			employees = (ArrayList)ois.readObject();
			ois = null;
			f = null;
		}
		f = new File(USERS_NAME_FILE);
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			users = (ArrayList)ois.readObject();
			ois = null;
			f = null;
		}
		f = new File(CLIENTS_NAME_FILE);
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			clients = (ArrayList)ois.readObject();
			ois = null;
			f = null;
		}
		f = new File(ING_NAME_FILE);
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			ingredients = (ArrayList)ois.readObject();
			ois = null;
			f = null;
		}
		f = new File(ORDERS_NAME_FILE);
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			orders = (ArrayList)ois.readObject();
			ois = null;
			f = null;
		}
		f = new File(TYPES_NAME_FILE);
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			types = (ArrayList)ois.readObject();
			ois = null;
			f = null;
		}
		f = new File(BPRO_NAME_FILE);
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			baseProducts = (ArrayList)ois.readObject();
			ois.close();
		}
		
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
}
