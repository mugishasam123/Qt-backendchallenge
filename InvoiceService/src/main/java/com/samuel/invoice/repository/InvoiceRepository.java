package com.samuel.invoice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.samuel.invoice.InvoiceModel.Invoice;

import java.util.List;
import java.util.Optional;

@Repository

public interface InvoiceRepository extends MongoRepository<Invoice,String> {
  
	public List<Invoice> findAll();
	public Optional<Invoice> findById(String id);
	public Invoice save(Invoice invoice);
	public void deleteById(String id);

}
