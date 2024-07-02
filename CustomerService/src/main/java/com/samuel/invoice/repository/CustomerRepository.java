package com.samuel.invoice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.samuel.invoice.CustomerModel.Customer;

import java.util.List;
import java.util.Optional;

@Repository

public interface CustomerRepository extends MongoRepository<Customer,String> {
  
	public List<Customer> findAll();
	public Optional<Customer> findById(String id);
	public Customer save(Customer customer);
	public void deleteById(String id);

}
