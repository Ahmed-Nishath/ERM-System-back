package com.ERMSystem.model;

//import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "workorder")
public class WorkOrder  { //Serializable removed. If problem occur add that interface

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String woNumber;
	
	private String assignTo;

	@OneToOne(optional = false, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Customer customer;

	@OneToOne(optional = false, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Product product;

	public WorkOrder() {

	}
	
	public WorkOrder(String woNumber, String assignTo, Customer customer, Product product) {
		super();
		this.woNumber = woNumber;
		this.assignTo = assignTo;
		this.customer = customer;
		this.product = product;
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
	
	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
