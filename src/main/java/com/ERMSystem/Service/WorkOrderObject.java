package com.ERMSystem.Service;

import java.sql.Date;

import javax.persistence.Id;

public class WorkOrderObject {
	@Id
	private long id;
	private String woNumber;
	private String assignTo;
	private String status;
	private double cost;
	private Date estimatedCompletionDate;
	
	private String productName;
	private String serialNumber;
	private Date saleDate;
	private String warrentyStatus;
	
	private String nic;
	private String cname;
	private String address;
	private String email;
	private String phone;

	public WorkOrderObject(long id, String woNumber, String productName, String serialNumber, Date saleDate, String warrentyStatus, 
			String assignTo, String nic, String cname, String address, String email, String phone, String status, double cost, Date estimateDate) {
		super();
		this.id = id;
		this.woNumber = woNumber;
		this.productName = productName;
		this.serialNumber = serialNumber;
		this.saleDate = saleDate;
		this.warrentyStatus = warrentyStatus;
		this.assignTo = assignTo;
		this.nic = nic;
		this.cname = cname;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.cost = cost;
		this.estimatedCompletionDate = estimateDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWoNumber() {
		return woNumber;
	}

	public void setWoNumber(String woNumber) {
		this.woNumber = woNumber;
	}

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

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public String getWarrentyStatus() {
		return warrentyStatus;
	}

	public void setWarrentyStatus(String warrentyStatus) {
		this.warrentyStatus = warrentyStatus;
	}

	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
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
	
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String st) {
		this.status = st;
	}
	
	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public Date getEstimatedCompletionDate() {
		return estimatedCompletionDate;
	}

	public void setEstimatedCompletionDate(Date estimateDate) {
		this.estimatedCompletionDate = estimateDate;
	}
}
