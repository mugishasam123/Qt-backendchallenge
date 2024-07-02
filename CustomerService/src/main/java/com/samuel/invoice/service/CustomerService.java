package com.samuel.invoice.service;

import java.util.List;
import java.util.Optional;


import com.samuel.invoice.CustomerModel.Customer;

public interface CustomerService {
	Customer create(Customer customer, String requestRole) throws Exception;

	Optional<Customer> getCustomerById(String id) throws Exception;
	
	List<Customer> getAllCustomers();
	
	Customer updateCustomer(String id, Customer updatedCustomer, String userId) throws Exception;
	
	void deleteCustomer(String id) throws Exception;
	

}
