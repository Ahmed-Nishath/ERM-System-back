package com.ERMSystem.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "workorder")
public class WorkOrder implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(optional = false, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Customer customer;

	@OneToOne(optional = false, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Product product;

	public WorkOrder() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public WorkOrder(Customer customer, Product product) {
		super();
		this.customer = customer;
		this.product = product;
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
