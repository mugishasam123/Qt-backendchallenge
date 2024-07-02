package com.samuel.invoice.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import com.samuel.invoice.repository.CustomerRepository;
import com.samuel.invoice.CustomerModel.Customer;
import com.samuel.invoice.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public CustomerServiceImplementation(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer create(Customer customer, String requestRole) throws Exception {
		if (!requestRole.equals("ROLE_ADMIN")) {
			throw new Exception("Only admin can create customers");
		}

		return customerRepository.save(customer);
	}

	@Override
	public Optional<Customer> getCustomerById(String id) {
		return customerRepository.findById(id);
	}

	public List<Customer> getAllCustomers() {
		List<Customer> allCustomers = customerRepository.findAll();

		return allCustomers;
	}

	@Override
	public Customer updateCustomer(String id, Customer updatedCustomer, String userId) throws Exception {
		Optional<Customer> optionalExistingCustomer = getCustomerById(id);
		if (!optionalExistingCustomer.isPresent()) {
			throw new Exception("Customer not found");
		}

		Customer existingCustomer = optionalExistingCustomer.get();

		if (updatedCustomer.getName() != null) {
			existingCustomer.setName(updatedCustomer.getName());
		}
		if (updatedCustomer.getEmail() != null) {
			existingCustomer.setEmail(updatedCustomer.getEmail());
		}
		if (updatedCustomer.getPhoneNumber() != null) {
			existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
		}

		return customerRepository.save(existingCustomer);
	}


	@Override
	public void deleteCustomer(String id) throws Exception {

		if (getCustomerById(id) != null) {
			customerRepository.deleteById(id);
		}
	}

}
