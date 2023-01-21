package com.ERMSystem.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.ERMSystem.model.Customer;
import com.ERMSystem.model.Product;
import com.ERMSystem.model.WorkOrder;
import com.ERMSystem.repository.WorkOrderRepository;

public class WorkOrderServices {
	
//	@Autowired
//	private CustomerRepository customerRepository;
//	
//	@Autowired
//	private ProductRepository productRepository;
	
	@Autowired
	private WorkOrderRepository workorderRepository;
	
	@Bean
	public List<WorkOrderObject> getAllWorkOrderObjects() {
		List<WorkOrder> workorder = workorderRepository.findAll();
		
		List<WorkOrderObject> woObject = new ArrayList<>();
		
		for(WorkOrder wo : workorder) {
			Customer customer = wo.getCustomer();
			Product product = wo.getProduct();
			
			WorkOrderObject woObj=new WorkOrderObject(wo.getId(), product.getProductName(), 
					product.getSerialNumber(),product.getSaleDate(), customer.getNic(), customer.getCname(), 
					customer.getAddress(), customer.getEmail(),customer.getPhone());
			woObject.add(woObj);
			
		}
		return woObject;
	}
}
