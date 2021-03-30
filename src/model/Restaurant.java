package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private final Size XLSIZE = new Size("XL");
	private final Size LSIZE = new Size("L");
	private final Size MSIZE = new Size("M");
	private final Size SSIZE = new Size("S");
	private final Size XSSIZE = new Size("XS");
	
	private final String SEPARATOR = ",";
	
	private ArrayList<Employee> employees;
	private ArrayList<User> users;
	private ArrayList<Client> clients;
	private ArrayList<Order> orders;
	private ArrayList<Ingredient> ingredients;
	private ArrayList<BaseProduct> baseProducts;
	private ArrayList<Product> products;
	private ArrayList<Type> types;
	private ArrayList<Size> sizes;
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
		setSizes(new ArrayList<Size>());
	}

	public ArrayList<BaseProduct> getBaseProducts() {
		return baseProducts;
	}
	
	public void addBaseProduct(String name, ArrayList<Ingredient> ingList,Type type) {
		baseProducts.add(new BaseProduct(name, ingList, type));
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
	
	public void addEmployee(String names, String lastNames, String ID) {
		employees.add(new Employee(names,lastNames,ID));
		
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
	
	public void updateEmployee(int index,String name,String lastNames, String ID) {
		employees.get(index).updateInfo(name,lastNames,ID);
		
	}
	
	public void addUser(String username, String password, String names, String lastNames, String ID) {
		users.add(new User(username, password, names, lastNames, ID));
		
		addEmployee(names, lastNames, ID);
	}
	
	public void deleteUser(int index) {
		users.remove(index);
		
		deleteEmployee(index);
		
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
	
	public void updateClient(int index, String name, String lastName, String id, String addres, String phoneNumber, String footNotes, User lastModifiedUser) {
		clients.get(index).updateInfo(name, lastName, id, addres, phoneNumber, footNotes, lastModifiedUser);
		
	}
	
	public void addOrder(int code, String footNote,DateClass originDate,List<Product> products,List<Integer> productsQuantity,Client originClient,Employee originEmployee) {
		orders.add(new Order(code, footNote,originDate,products,productsQuantity,originClient,originEmployee));
		
	}
	
	public void deleteOrder(int index) {
		orders.remove(index);
		
	}
	
	public void updateOrder(int index,List<Product> products,List<Integer> productsQuantity,Client client,Employee emp) {
		orders.get(index).updateInfo(products, productsQuantity, client, emp);
		
	}
	
	public void updateStatusOrder(int index) {
		orders.get(index).updateState();
		
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


	    oos = new ObjectOutputStream(new FileOutputStream(BPRO_NAME_FILE));
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

	public List<Size> getSizes() {
		return sizes;
	}

	public void setSizes(ArrayList<Size> sizes) {
		this.sizes = sizes;
		
		sizes.add(XLSIZE);
		sizes.add(LSIZE);
		sizes.add(MSIZE);
		sizes.add(SSIZE);
		sizes.add(XSSIZE);
		
	}

	public void addProduct(BaseProduct pr,Size sz,double price) {
		products.add(new Product(pr,sz,price));
		
	}

	public void deleteProduct(int index) {
		products.remove(index);
		
	}

	public void addIngredient(String name) {
		ingredients.add(new Ingredient(name));
		
	}

	public void deleteIngredient(int index) {
		ingredients.remove(index);
		
	}

	public void updateIngredient(int index, String text) {
		ingredients.get(index).setName(text);
		
	}

	public ArrayList<Employee> generateReport(String[] parts1, String[] parts2) {
		String[] fromTime = parts1[0].split(":");
		String[] fromDate = parts1[1].split("/");
		String[] toTime = parts2[0].split(":");
		String[] toDate = parts2[1].split("/");
		ArrayList<Employee> ordersBetween = new ArrayList<Employee>();
		DateClass fromRealDate = new DateClass(Integer.parseInt(fromTime[0]),Integer.parseInt(fromTime[1]),Integer.parseInt(fromDate[0]),Integer.parseInt(fromDate[1]),Integer.parseInt(fromDate[2]));
		DateClass toRealDate = new DateClass(Integer.parseInt(toTime[0]),Integer.parseInt(toTime[1]),Integer.parseInt(toDate[0]),Integer.parseInt(toDate[1]),Integer.parseInt(toDate[2]));
		for(int i=0;i<employees.size();i++) {
			Employee auxEmp = employees.get(i);
			ArrayList<Order> auxOrder = auxEmp.getDeliveredOrder();
			ArrayList<Order> newOrder = new ArrayList<Order>();
			for(int j=0;j<auxOrder.size();j++) {
				if(auxOrder.get(j).getOriginTime().compareTo(toRealDate)<0 && auxOrder.get(j).getOriginTime().compareTo(fromRealDate)>0) {
					newOrder.add(auxOrder.get(j));
				}
			}
			auxEmp.setDeliveredOrder(newOrder);
			ordersBetween.add(auxEmp);
		}
		return ordersBetween;
	}
	
	public void exportData(File f,ArrayList<Employee> reportEmp) throws FileNotFoundException{
	    PrintWriter pw = new PrintWriter(f);
	    pw.write("Names,LastNames,ID,AmountOrdered");
	    for(int i=0;i<reportEmp.size();i++){
	      Employee myEmp = reportEmp.get(i);
	      pw.println(myEmp.getNames()+","+myEmp.getLastNames()+","+myEmp.getId()+","+myEmp.getAmountOrder());
	    }

	    pw.close();
	  }

	public ArrayList<Order> generateOrderReport(String[] parts1, String[] parts2) {
		String[] fromTime = parts1[0].split(":");
		String[] fromDate = parts1[1].split("/");
		String[] toTime = parts2[0].split(":");
		String[] toDate = parts2[1].split("/");
		DateClass fromRealDate = new DateClass(Integer.parseInt(fromTime[0]),Integer.parseInt(fromTime[1]),Integer.parseInt(fromDate[0]),Integer.parseInt(fromDate[1]),Integer.parseInt(fromDate[2]));
		DateClass toRealDate = new DateClass(Integer.parseInt(toTime[0]),Integer.parseInt(toTime[1]),Integer.parseInt(toDate[0]),Integer.parseInt(toDate[1]),Integer.parseInt(toDate[2]));
		ArrayList<Order> auxOrder = new ArrayList<Order>();
		for(int i=0;i<orders.size();i++) {
			if(orders.get(i).getOriginTime().compareTo(toRealDate)<0 && orders.get(i).getOriginTime().compareTo(fromRealDate)>0) {
				auxOrder.add(orders.get(i));
			}
		}
		return auxOrder;
	}

	public void exportOrderData(File f, ArrayList<Order> reportOrd) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(f);
	    pw.write("Nombre del cliente,Direccion,Telefono,Empleado que lo entrega,Estado,Fecha,Observaciones,Productos");
	    for(int i=0;i<reportOrd.size();i++){
	      Order myOrd = reportOrd.get(i);
	      String products = "";
	      for(int j=0;j<myOrd.getProducts().size();j++) {
	    	  products = myOrd.getProducts().get(j).getName() + "," + myOrd.getProductQuantity().get(j) + "," +myOrd.getProducts().get(j).getProductPrice();
	      }
	      pw.println(myOrd.getStringClient()+","+myOrd.getOriginClient().getAddress()+","+myOrd.getOriginClient().getPhoneNumber()+","+myOrd.getStringEmployee()+","+myOrd.getStatus()+","+myOrd.getOriginTime().intoString()+","+myOrd.getFootNote()+products);
	    }

	    pw.close();
	}

	public ArrayList<Product> generateProductsReport(String[] parts1, String[] parts2) {
		String[] fromTime = parts1[0].split(":");
		String[] fromDate = parts1[1].split("/");
		String[] toTime = parts2[0].split(":");
		String[] toDate = parts2[1].split("/");
		DateClass fromRealDate = new DateClass(Integer.parseInt(fromTime[0]),Integer.parseInt(fromTime[1]),Integer.parseInt(fromDate[0]),Integer.parseInt(fromDate[1]),Integer.parseInt(fromDate[2]));
		DateClass toRealDate = new DateClass(Integer.parseInt(toTime[0]),Integer.parseInt(toTime[1]),Integer.parseInt(toDate[0]),Integer.parseInt(toDate[1]),Integer.parseInt(toDate[2]));
		ArrayList<Product> auxPro = new ArrayList<Product>();
		for(int i=0;i<products.size();i++) {
			Product aux = products.get(i);
			ArrayList<DateClass> datesAux = new ArrayList<DateClass>();
			for(int j=0;j<aux.getDates().size();j++) {
				if(aux.getDates().get(j).compareTo(toRealDate)<0 && aux.getDates().get(j).compareTo(fromRealDate)>0) {
					datesAux.add(aux.getDates().get(j));
				}
			}
			aux.setProductsDate(datesAux);
			auxPro.add(aux);
		}
		
		return auxPro;
	}

	public void exportProductsData(File f, ArrayList<Product> reportPro) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(f);
	    pw.write("Nombre del producto,Cantidad,Total");
	    for(int i=0;i<reportPro.size();i++){
	      Product myPro = reportPro.get(i);
	      double total = myPro.getAmountOrdered() * myPro.getProductPrice();
	      pw.println(myPro.getName()+","+myPro.getAmountOrdered()+","+total);
	    }

	    pw.close();
		
	}

	public void deleteBaseProduct(int selectedIndex) {
		baseProducts.remove(selectedIndex);
		
	}

	public void addType(Type type) {
		types.add(type);
		
	}

	public void deleteType(int selectedIndex) {
		types.remove(selectedIndex);
		
	}

	public void updateType(int i, String text) {
		types.get(i).setName(text);
		
	}
	
	public void updateTypeList(ArrayList<Type> o) {
		types = o;
	}
	
	public void importBaseProducts(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		String line = br.readLine();
		
		while(line!=null) {
			String[] parts = line.split(SEPARATOR);
			
			Type t = new Type("");
			ArrayList<Ingredient> ings = new ArrayList<>();
			
			ings.add(new Ingredient(""));
			
			addBaseProduct(parts[0], ings, t);
			
			line = br.readLine();
		}
		
		br.close();
	}
	
	public void exportBaseProducts(String fileName) throws IOException{
		PrintWriter pw = new PrintWriter(fileName);
		
		for (int i = 0; i < baseProducts.size(); i++) {
			BaseProduct aux = baseProducts.get(i);
			
			pw.println(aux.getName() + SEPARATOR);
		}
		
		pw.close();
	}
	
	public void importProducts(String name) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(name));
		
		String line = br.readLine();
		
		while(line!=null) {
			
		}
		
		br.close();
	}
	
	public void exportProducts(String name) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(name);
		
		for (int i = 0; i < baseProducts.size(); i++) {
			
		}
		
		pw.close();
	}
	
	public void importOrders(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		String line = br.readLine();
		
		while(line!=null) {
			
		}
		
		br.close();
	}
	
	public void exportOrders(String fileName) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		
		for (int i = 0; i < baseProducts.size(); i++) {
			
		}
		
		pw.close();
	}
	
}
