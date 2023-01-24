package com.ERMSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ERMSystem.Service.WorkOrderObject;
import com.ERMSystem.exception.ResourceNotFoundException;
import com.ERMSystem.model.Customer;
import com.ERMSystem.model.Product;
import com.ERMSystem.model.WorkOrder;
import com.ERMSystem.repository.CustomerRepository;
import com.ERMSystem.repository.ProductRepository;
import com.ERMSystem.repository.WorkOrderRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("protech/api/")
public class  WorkOrderController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private WorkOrderRepository workorderRepository;
	
	
	//Get all Work Orders
	@GetMapping("/workorders")
	public List<WorkOrderObject> getAllWorkOrders(){
		
		List<WorkOrder> workorder = workorderRepository.findAll();
		
		List<WorkOrderObject> woObject = new ArrayList<>();
		
		for(WorkOrder wo : workorder) {
			Customer customer = wo.getCustomer();
			Product product = wo.getProduct();
			
			WorkOrderObject woObj=new WorkOrderObject(wo.getId(), wo.getWoNumber(), product.getProductName(), 
					product.getSerialNumber(),product.getSaleDate(), product.getWarrentyStatus(), wo.getAssignTo(), customer.getNic(), customer.getCname(), 
					customer.getAddress(), customer.getEmail(),customer.getPhone());
			woObject.add(woObj);
		}
		return woObject;
	}
	

	//Create Work order
	@PostMapping("/workorders")
	public WorkOrderObject createWorkOrder(@RequestBody WorkOrderObject woObj) {
		Customer customer = new Customer(woObj.getNic(), woObj.getCname(), woObj.getAddress(), woObj.getEmail(), woObj.getPhone());
		Product product = new Product(woObj.getProductName(), woObj.getSerialNumber(), woObj.getSaleDate(), woObj.getWarrentyStatus());
		
		customerRepository.save(customer);
		productRepository.save(product);
		
		WorkOrder wo = new WorkOrder(woObj.getWoNumber(), woObj.getAssignTo(), customer, product);
		workorderRepository.save(wo);
		woObj.setId(wo.getId());
		return woObj;
	}

	
	//Get Work order by Id
	@GetMapping("/workorders/{id}")
	public ResponseEntity<WorkOrderObject> getWorkOrderById(@PathVariable Long id) {
		
		WorkOrder wo = workorderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Work Order not found with id : " + id)) ;
		
		Customer customer = wo.getCustomer();
		Product product = wo.getProduct();
		
		WorkOrderObject woObj=new WorkOrderObject(wo.getId(), wo.getWoNumber(), product.getProductName(), 
				product.getSerialNumber(),product.getSaleDate(), product.getWarrentyStatus(), wo.getAssignTo(), customer.getNic(), customer.getCname(), 
				customer.getAddress(), customer.getEmail(),customer.getPhone());

		return ResponseEntity.ok(woObj);
	}

	
	//Update Work order
	@PutMapping("/workorders/{id}")
	public ResponseEntity<WorkOrderObject> updateWorkOrder(@PathVariable Long id, @RequestBody WorkOrderObject woObj){
		
		WorkOrder wo = workorderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Work Order not found with id : " + id)) ;
		
		wo.setAssignTo(woObj.getAssignTo());
		
		Customer customer = wo.getCustomer();
		Product product = wo.getProduct();
		
		customer.setCname(woObj.getCname());
		customer.setNic(woObj.getNic());
		customer.setAddress(woObj.getAddress());
		customer.setEmail(woObj.getEmail());
		customer.setPhone(woObj.getPhone());
		
		product.setProductName(woObj.getProductName());
		product.setSerialNumber(woObj.getSerialNumber());
		product.setSaleDate(woObj.getSaleDate());
		product.setWarrentyStatus(woObj.getWarrentyStatus());
		
		customerRepository.save(customer);
		productRepository.save(product);
		
		return ResponseEntity.ok(woObj);
	}

	
	//Delete Work order
	@DeleteMapping("/workorders/{id}")
	public ResponseEntity<HttpStatus> deleteWorkOrder(@PathVariable Long id){
		WorkOrder wo = workorderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Work Order not found with id : " + id)) ;
		
		workorderRepository.delete(wo);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}