package com.ERMSystem.Service;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class WorkOrderObject {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
//	private String woNumber;
	private String productName;
	private String serialNumber;
	private String saleDate;
//	private String warrentyStatus;
	private String nic;
	private String cname;
	private String address;
	private String email;
	private String phone;

	public WorkOrderObject(long id, String productName, String serialNumber, String saleDate,
			String nic, String cname, String address, String email, String phone) {
		super();
		this.id = id;
//		this.woNumber = woNumber;
		this.productName = productName;
		this.serialNumber = serialNumber;
		this.saleDate = saleDate;
//		this.warrentyStatus = warrentyStatus;
		this.nic = nic;
		this.cname = cname;
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

//	public String getWoNumber() {
//		return woNumber;
//	}
//
//	public void setWoNumber(String woNumber) {
//		this.woNumber = woNumber;
//	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

//	public String getWarrentyStatus() {
//		return warrentyStatus;
//	}
//
//	public void setWarrentyStatus(String warrentyStatus) {
//		this.warrentyStatus = warrentyStatus;
//	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
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
