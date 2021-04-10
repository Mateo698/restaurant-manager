package model;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable{
	private static final String REQUESTED = "REQUESTED";
	private static final String INPROGRESS = "IN PROGRESS";
	private static final String SENT = "SENT";
	private static final String DELIVERED = "DELIVERED";
	private static final long serialVersionUID = 1;
	private String code;
	private DateClass originTime;
	private String status;
	private String footNote;
	private List<Product> products;
	private List<Integer> productQuantity;
	private Client originClient;
	private Employee originEmployee;
	
	public Order(String code, String footNote,DateClass originDate,List<Product> products,List<Integer> productsQuantity,Client originClient,Employee originEmployee) {
		this.code = code;
		this.status = REQUESTED;
		this.footNote = footNote;
		this.products = products;
		this.productQuantity = productsQuantity;
		this.originTime = originDate;
		this.setOriginClient(originClient);
		this.setOriginEmployee(originEmployee);
	}

	public String getCode() {
		return code;
	}
	
	public String getStringCode() {
		String strCode = code + "";
		
		return strCode;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFootnote() {
		return footNote;
	}

	public void setFootNote(String footNote) {
		this.footNote = footNote;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public String getStringProducts() {
		String strProducts = "";
		
		for (int i = 0; i < products.size(); i++) {
			strProducts += products.get(i).getName() + ";";
		}
		
		return strProducts;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		products.add(product);
		
	}
	
	public void updateState() {
		
		if(status.equals(REQUESTED)) {
			status = INPROGRESS;
		}
		else if(status.equals(INPROGRESS)){
			status = SENT;
		}
		else {
			status = DELIVERED;
		}
	}
	
	public void updateInfo(List<Product> products,List<Integer> productsQuantity,Client client,Employee emp) {
		setProducts(products);
		setProductQuantity(productsQuantity);
		setOriginClient(client);
		setOriginEmployee(emp);
		
	}

	public DateClass getOriginTime() {
		return originTime;
	}
	
	public String getStringTime() {
		String time = "";
		time = originTime.getDay() + "/" + originTime.getMonth() + "/" + originTime.getYear() + " " + originTime.getHour()+":"+originTime.getMinutes();
		return time;
	}

	public void setOriginTime(DateClass originTime) {
		this.originTime = originTime;
	}

	public List<Integer> getProductQuantity() {
		return productQuantity;
	}
	
	public String getStringProductQuantity() {
		String strProdQuantity = "";
		
		for (int i = 0; i < productQuantity.size(); i++) {
			strProdQuantity += productQuantity.get(i) + ";";
		}
		
		return strProdQuantity;
	}

	public void setProductQuantity(List<Integer> productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Client getOriginClient() {
		return originClient;
	}
	
	public String getStringClient() {
		return originClient.getName();
	}

	public void setOriginClient(Client originClient) {
		this.originClient = originClient;
	}

	public Employee getOriginEmployee() {
		return originEmployee;
	}
	
	public String getStringEmployee() {
		return originEmployee.getNames();
	}

	public void setOriginEmployee(Employee originEmployee) {
		this.originEmployee = originEmployee;
	}
	
}
