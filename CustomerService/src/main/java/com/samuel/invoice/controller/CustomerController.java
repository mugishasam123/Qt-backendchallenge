package com.samuel.invoice.controller;

import com.samuel.invoice.service.CustomerService;
import com.samuel.invoice.service.UserService;
import com.samuel.invoice.CustomerModel.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.samuel.invoice.repository.CustomerRepository;
import com.samuel.invoice.CustomerModel.Customer;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	    private CustomerService customerService;
	    private UserService userService;

	    @Autowired
	    public CustomerController(CustomerService customerService, UserService userService) {
	        this.customerService = customerService;
	        this.userService=userService;
	    }

	// create Task API

	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer, @RequestHeader("Authorization") String jwt)
			throws Exception {
		
		 if(jwt==null){
	            throw new Exception("jwt required...");
	        }
		UserDTO user = userService.getUserProfileHandler(jwt);
		Customer createdCustomer = customerService.create(customer, user.getRole());

		return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable String id, @RequestHeader("Authorization") String jwt)
			throws Exception {
		 if(jwt==null){
	            throw new Exception("jwt required...");
	        }
		
		//UserDTO user = userService.getUserProfile(jwt);
		Optional<Customer>  customer = customerService.getCustomerById(id);

		//return new ResponseEntity<>(task, HttpStatus.OK);
		return customer != null ? new ResponseEntity<>(customer, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}


	 @GetMapping
	    public ResponseEntity<List<Customer>> getAllCustomers( @RequestHeader("Authorization") String jwt ) throws Exception {
	        if(jwt==null){
	            throw new Exception("jwt required...");
	        }
	        List<Customer> customers = customerService.getAllCustomers();
	        return new ResponseEntity<>(customers, HttpStatus.OK);
	    }
	 

	    @PutMapping("/{id}")
	    public ResponseEntity<Customer> updateCustomer(
	            @PathVariable String id,
	            @RequestBody Customer req,
	            @RequestHeader("Authorization") String jwt
	    ) throws Exception {
	        if(jwt==null){
	            throw new Exception("jwt required...");
	        }
	        UserDTO user=userService.getUserProfileHandler(jwt);
	        Customer customer = customerService.updateCustomer(id, req, user.getId());
	        return customer != null ? new ResponseEntity<>(customer, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
	        try {
				customerService.deleteCustomer(id);
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	   
}
