package com.samuel.invoice.InvoiceService;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import com.samuel.invoice.repository.InvoiceRepository;
import com.samuel.invoice.InvoiceModel.Invoice;
import com.samuel.invoice.InvoiceService.InvoiceService;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImplementation implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	public InvoiceServiceImplementation(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}

	@Override
	public Invoice create(Invoice invoice, String requestRole) throws Exception {
		if (!requestRole.equals("ROLE_ADMIN")) {
			throw new Exception("Only admin can create Invoice");
		}

		return invoiceRepository.save(invoice);
	}

	@Override
	public Optional<Invoice> getInvoiceById(String id) {
		return invoiceRepository.findById(id);
	}

	public List<Invoice> getAllInvoices() {
		List<Invoice> allInvoices = invoiceRepository.findAll();

		return allInvoices;
	}

	@Override
	public Invoice updateInvoice(String id, Invoice updatedInvoice, String userId) throws Exception {
		Optional<Invoice> optionalExistinggetInvoice = getInvoiceById(id);
		if (!optionalExistinggetInvoice.isPresent()) {
			throw new Exception("Invoice not found");
		}

		Invoice existingInvoice = optionalExistinggetInvoice.get();

		if (updatedInvoice.getCustomerId() != null) {
			existingInvoice.setCustomerId(updatedInvoice.getCustomerId());
		}
		if (updatedInvoice.getAmount() != null) {
			existingInvoice.setAmount(updatedInvoice.getAmount());
		}
		if (updatedInvoice.getInvoiceDate() != null) {
			existingInvoice.setInvoiceDate(updatedInvoice.getInvoiceDate());
		}

		if (updatedInvoice.getStatus() != null) {
			existingInvoice.setStatus(updatedInvoice.getStatus());
		}

		return invoiceRepository.save(existingInvoice);
	}


	@Override
	public void deleteInvoice(String id) throws Exception {

		if (getInvoiceById(id) != null) {
			invoiceRepository.deleteById(id);
		}
	}

}
