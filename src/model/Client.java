package model;

public class Client {
	private String name;
	private String lastName;
	private int date;
	private String addres;
	private int phoneNumber;
	private String footNotes;
	private User originUser;
	private User lastModifiedUser;
	
	public Client(String name, String lastName, int date, String addres, int phoneNumber, String footNotes, User originUser, User lastModifiedUser) {
		this.name = name;
		this.lastName = lastName;
		this.date = date;
		this.addres = addres;
		this.phoneNumber = phoneNumber;
		this.footNotes = footNotes;
		this.originUser = originUser;
		this.lastModifiedUser = lastModifiedUser;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFootNotes() {
		return footNotes;
	}

	public void setFootNotes(String footNotes) {
		this.footNotes = footNotes;
	}

	public User getOriginUser() {
		return originUser;
	}

	public void setOriginUser(User originUser) {
		this.originUser = originUser;
	}

	public User getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(User lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}
	
}
