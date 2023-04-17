package com.ERMSystem.auth;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "system_user") 
public class SystemUser {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String userName;
	private String email;
	private String phone;
	private String feild;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	public SystemUser() {

	}

	public SystemUser(String userName, String email, String phone, String feild, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.feild = feild;
		this.password = password;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getFeild() {
		return feild;
	}

	public void setFeild(String feild) {
		this.feild = feild;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
