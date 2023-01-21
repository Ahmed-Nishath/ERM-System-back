package com.ERMSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String productName;
	private String serialNumber;
	private String saleDate;
	private String warrentyStatus;

	public Product() {

	}

	public Product(String productName, String serialNumber, String saleDate, String warrentyStatus) {
		super();
		this.productName = productName;
		this.serialNumber = serialNumber;
		this.saleDate = saleDate;
		this.warrentyStatus = warrentyStatus;
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

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public String getWarrentyStatus() {
		return warrentyStatus;
	}

	public void setWarrentyStatus(String warrentyStatus) {
		this.warrentyStatus = warrentyStatus;
	}

}
