package com.samuel.invoice.controller;

import com.samuel.invoice.InvoiceService.InvoiceService;
import com.samuel.invoice.InvoiceService.UserService;
import com.samuel.invoice.InvoiceModel.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.samuel.invoice.repository.InvoiceRepository;
import com.samuel.invoice.InvoiceModel.Invoice;
import com.samuel.invoice.InvoiceModel.Invoice;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

	    private InvoiceService invoiceService;
	    private UserService userService;

	    @Autowired
	    public InvoiceController(InvoiceService invoiceService, UserService userService) {
	        this.invoiceService = invoiceService;
	        this.userService=userService;
	    }


	@PostMapping
	public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice, @RequestHeader("Authorization") String jwt)
			throws Exception {
		
		 if(jwt==null){
	            throw new Exception("jwt required...");
	        }
		UserDTO user = userService.getUserProfileHandler(jwt);
		Invoice createdInvoice = invoiceService.create(invoice, user.getRole());

		return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Invoice>> getInvoiceById(@PathVariable String id, @RequestHeader("Authorization") String jwt)
			throws Exception {
		 if(jwt==null){
	            throw new Exception("jwt required...");
	        }
		
		//UserDTO user = userService.getUserProfile(jwt);
		Optional<Invoice>  invoice = invoiceService.getInvoiceById(id);

		//return new ResponseEntity<>(task, HttpStatus.OK);
		return invoice != null ? new ResponseEntity<>(invoice, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}


	 @GetMapping
	    public ResponseEntity<List<Invoice>> getAllInvoices( @RequestHeader("Authorization") String jwt ) throws Exception {
	        if(jwt==null){
	            throw new Exception("jwt required...");
	        }
	        List<Invoice> invoices = invoiceService.getAllInvoices();
	        return new ResponseEntity<>(invoices, HttpStatus.OK);
	    }
	 

	    @PutMapping("/{id}")
	    public ResponseEntity<Invoice> updateInvoice(
	            @PathVariable String id,
	            @RequestBody Invoice req,
	            @RequestHeader("Authorization") String jwt
	    ) throws Exception {
	        if(jwt==null){
	            throw new Exception("jwt required...");
	        }
	        UserDTO user=userService.getUserProfileHandler(jwt);
			Invoice invoice = invoiceService.updateInvoice(id, req, user.getId());
	        return invoice != null ? new ResponseEntity<>(invoice, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteInvoice(@PathVariable String id) {
	        try {
				invoiceService.deleteInvoice(id);
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	   
}
