package com.capstone.fincrop.service;

import com.capstone.fincrop.dao.InvoiceDao;
import com.capstone.fincrop.dao.InvoiceMapper;
import com.capstone.fincrop.model.*;
import com.capstone.fincrop.repository.ClientDetailsRepository;
import com.capstone.fincrop.repository.InvoiceRepository;
import com.capstone.fincrop.repository.SupplierDetailsRepository;
import com.capstone.fincrop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.ClientResourcesBuilderCustomizer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository;

	@Autowired
	SupplierDetailsRepository supplierDetailsRepository;

	@Autowired
	ClientDetailsRepository clientDetailsRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	InvoiceMapper invoiceMapper;

	public List<Invoice> list(){
		return (List<Invoice>) invoiceRepository.findAll();
	}

	public List<Invoice> listUserId(Long userId){
		Optional<User> user = userRepository.findById(userId);

		Optional<ClientDetails> clientDetails = user.isPresent() ? clientDetailsRepository.findByUser(user.get()) : Optional.empty();
		if(clientDetails.isPresent()) {
			return clientDetails.isPresent() ? (List<Invoice>) invoiceRepository.findByClientDetails(clientDetails.get()) : new ArrayList<>();
		}

		Optional<SupplierDetails> supplierDetails = user.isPresent() ? supplierDetailsRepository.findByUser(user.get()) : Optional.empty();
		if(supplierDetails.isPresent()) {
			return supplierDetails.isPresent() ? (List<Invoice>) invoiceRepository.findBySupplierCode(supplierDetails.get()) : new ArrayList<>();
		}
		return new ArrayList<>();
	}
	
	public Register<InvoiceDao> save(InvoiceDao invoiceDao, Long user) {
		SupplierDetails supplierCode = null;
		ClientDetails clientDetails = null;

		if(invoiceDao.getSupplierCode() != null && this.supplierDetailsRepository.findById(invoiceDao.getSupplierCode()).isPresent()) {
			supplierCode = this.supplierDetailsRepository.findById(invoiceDao.getSupplierCode()).get();
		} else {
			Register<InvoiceDao> register = new Register("500", "supplier code is not available", Optional.of(invoiceDao));
			return register;
		}


		if(user != null) {
			Optional<User> user1 = userRepository.findById(user);
			if(user1.isPresent() && this.clientDetailsRepository.findByUser(user1.get()).isPresent()) {
				clientDetails = this.clientDetailsRepository.findByUser(user1.get()).get();
			}
		} else {
			Register<InvoiceDao> register = new Register("500", "User is invalid/please try to logout, refresh the cache and login", Optional.of(invoiceDao));
			return register;
		}

		Invoice invoice = invoiceMapper.invoiceDaoToInvoice(invoiceDao);
		invoice.setSupplierCode(supplierCode);
		invoice.setClientDetails(clientDetails);
		invoice.setInvoiceStatus("Pending");
		invoice = invoiceRepository.save(invoice);
		if(invoice.getId() != null) {
			Register<InvoiceDao> register = new Register("200", "invoice is created", Optional.of(invoiceMapper.invoiceToInvoiceDao(invoice)));
			return register;
		}
		Register<InvoiceDao> register = new Register("500", "invoice is not created", Optional.of(invoiceDao));
		return register;
	}

}
