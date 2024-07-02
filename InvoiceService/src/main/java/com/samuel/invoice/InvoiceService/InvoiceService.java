package com.samuel.invoice.InvoiceService;

import java.util.List;
import java.util.Optional;


import com.samuel.invoice.InvoiceModel.Invoice;

public interface InvoiceService {
	Invoice create(Invoice invoice, String requestRole) throws Exception;

	Optional<Invoice> getInvoiceById(String id) throws Exception;
	
	List<Invoice> getAllInvoices();

	Invoice updateInvoice(String id, Invoice updatedInvoice, String userId) throws Exception;
	
	void deleteInvoice(String id) throws Exception;
	

}
