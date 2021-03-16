package model;

import java.io.Serializable;

public class Client implements Serializable{
	private static final long serialVersionUID = 1;
	private String name;
	private String lastName;
	private String id;
	private String address;
	private String phoneNumber;
	private String footNote;
	private User originUser;
	private User lastModifiedUser;
	
	public Client(String name, String lastName,String id, String addres, String phoneNumber, String footNotes, User originUser) {
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.address = addres;
		this.phoneNumber = phoneNumber;
		this.footNote = footNotes;
		this.originUser = originUser;
		this.lastModifiedUser = originUser;
		
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String addres) {
		this.address = addres;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFootNote() {
		return footNote;
	}

	public void setFootNote(String footNotes) {
		this.footNote = footNotes;
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
	
	public void updateInfo(String name, String lastName, String Id, String addres, String phoneNumber, String footNotes, User originUser, User lastModifiedUser) {
		setName(name);
		setLastName(lastName);
		setId(Id);
		setAddress(addres);
		setPhoneNumber(phoneNumber);
		setFootNote(footNotes);
		setOriginUser(originUser);
		setLastModifiedUser(lastModifiedUser);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
