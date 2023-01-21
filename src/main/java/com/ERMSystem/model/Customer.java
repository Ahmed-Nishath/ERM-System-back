package com.ERMSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer") 
public class Customer {
	
	//@Column(name = "nic", nullable = false, length = 10)
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nic;
	private String cname;
	private String address;
	private String email;
	private String phone;
	
	public Customer() {
		
	}

	public Customer(String nic, String name, String address, String email, String phone) {
		super();
		this.nic = nic;
		this.cname = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String name) {
		this.cname = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
