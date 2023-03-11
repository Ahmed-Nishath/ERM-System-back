package com.ERMSystem.model;

import java.sql.Date;

//import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "workorder")
public class WorkOrder  { // Serializable removed. If problem occur add that interface

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String woNumber;
	
	private String assignTo;

	@OneToOne(optional = false, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Customer customer;

	@OneToOne(optional = false, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Product product;
	
	@Column(length = 999)
	private String comment;
	
	private String status;
	
	private double cost;
	
	@DateTimeFormat(pattern = "mm-dd-yyyy")
	private Date estimatedCompletionDate;

	public WorkOrder() {

	}
	
	public WorkOrder(String woNumber, String assignTo, String status, Customer customer, Product product) {
		super();
		this.woNumber = woNumber;
		this.assignTo = assignTo;
		this.status = status;
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
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
